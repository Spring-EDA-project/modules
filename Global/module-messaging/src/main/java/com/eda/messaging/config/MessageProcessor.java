package com.eda.messaging.config;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;
import java.util.*;

@Slf4j
public class MessageProcessor {
    private final Map<String, List<HandlerMethod>> handlerMap = new HashMap<>();

    public MessageProcessor(List<Object> handlerInstances) {
        for (Object handler : handlerInstances) {
            for (Method method : handler.getClass().getDeclaredMethods()) {
                if (method.isAnnotationPresent(MessageHandler.class)) {
                    MessageHandler annotation = method.getAnnotation(MessageHandler.class);
                    String name = annotation.name();

                    handlerMap.computeIfAbsent(name, k -> new ArrayList<>())
                            .add(new HandlerMethod(handler, method));

                    log.info("✅ Registered handler: queue name={}, method={}", name, method.getName());
                }
            }
        }
    }

    public void process(String messageBody, String queueName) {
        try {
            List<HandlerMethod> handlers = handlerMap.get(queueName);

            if (handlers != null) {
                for (HandlerMethod handlerMethod : handlers) {
                    handlerMethod.method.invoke(handlerMethod.instance, messageBody);
                }
            } else {
                log.warn("No handlers for queue: {}", queueName);
            }
        } catch (Exception e) {
            log.error("Failed to process message", e);
        }
    }

    public Set<String> getAllQueueUrls() {
        return handlerMap.keySet();
    }

    private static class HandlerMethod {
        private final Object instance;
        private final Method method;

        public HandlerMethod(Object instance, Method method) {
            this.instance = instance;
            this.method = method;
        }
    }
}
