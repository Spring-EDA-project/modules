package com.eda.global.common;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.eda.global.common.error.GlobalExceptionHandler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest({TestController.class, GlobalExceptionHandler.class})
public class GlobalExceptionHandlerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testBadRequest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/test/bad-request"))
            .andExpect(status().isBadRequest());
    }

    @Test
    public void testConflictException() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/test/conflict"))
            .andExpect(status().isConflict());
    }
    @Test
    public void testEntityNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/test/entity-not-found"))
            .andExpect(status().isNotFound());
    }
    @Test
    public void testForbidden() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/test/forbidden"))
            .andExpect(status().isForbidden());
    }
    @Test
    public void testInternalServerError() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/test/internal-server-error"))
            .andExpect(status().isInternalServerError());
    }
    @Test
    public void testInvalidInputValue() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/test/invalid-input-value"))
            .andExpect(status().isBadRequest());
    }
    @Test
    public void testMethodNotAllowed() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/test/method-not-allowed"))
            .andExpect(status().isMethodNotAllowed());
    }
    @Test
    public void testUnauthorized() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/test/unauthorized"))
            .andExpect(status().isUnauthorized());
    }
}
