package com.cognizant.springlearn;

import com.cognizant.springlearn.security.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class JwtAuthenticationTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void authenticateReturnsAToken() throws Exception {
        mvc.perform(get("/authenticate").with(httpBasic("user", "pwd")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").exists());
    }

    @Test
    void authenticateWithWrongPasswordIsUnauthorized() throws Exception {
        mvc.perform(get("/authenticate").with(httpBasic("user", "wrongpwd")))
                .andExpect(status().isUnauthorized());
    }

    // full round trip - call /authenticate to get a real token the same way a
    // client would, then use that exact token as a bearer to reach a service that
    // requires authentication but has no role restriction of its own
    @Test
    void tokenFromAuthenticateWorksAsABearerToken() throws Exception {
        MvcResult authResult = mvc.perform(get("/authenticate").with(httpBasic("user", "pwd")))
                .andExpect(status().isOk())
                .andReturn();

        String responseBody = authResult.getResponse().getContentAsString();
        String token = new ObjectMapper().readTree(responseBody).get("token").asText();

        mvc.perform(get("/countries").header("Authorization", "Bearer " + token))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(4));
    }

    @Test
    void garbageBearerTokenIsUnauthorized() throws Exception {
        mvc.perform(get("/countries").header("Authorization", "Bearer not-a-real-token"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    void tokenGeneratedDirectlyThroughJwtUtilAlsoWorks() throws Exception {
        String token = JwtUtil.generateToken("user");

        mvc.perform(get("/employees").header("Authorization", "Bearer " + token))
                .andExpect(status().isOk());
    }

    @Test
    void jwtUtilRoundTripsTheSubject() {
        String token = JwtUtil.generateToken("admin");
        assertEquals("admin", JwtUtil.getUser(token));
    }
}
