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
                    String queueUrl = annotation.queueUrl();

                    handlerMap.computeIfAbsent(queueUrl, k -> new ArrayList<>())
                            .add(new HandlerMethod(handler, method));

                    log.info("Registered handler: queueUrl={}, method={}", queueUrl, method.getName());
                }
            }
        }
    }

    public void process(String messageBody, String currentQueueUrl) {
        try {
            List<HandlerMethod> handlers = handlerMap.get(currentQueueUrl);

            if (handlers != null) {
                for (HandlerMethod handlerMethod : handlers) {
                    log.info("Executing handler on queueUrl={}", currentQueueUrl);
                    handlerMethod.method.invoke(handlerMethod.instance, messageBody);
                }
            } else {
                log.warn("No handlers for queueUrl: {}", currentQueueUrl);
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
