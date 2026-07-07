package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.security.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    // spring reads the Authorization header off the request and hands it straight
    // to this parameter, dont need HttpServletRequest at all for this
    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        LOGGER.info("start");
        LOGGER.debug("authHeader={}", authHeader);

        String user = getUser(authHeader);
        String token = JwtUtil.generateToken(user);

        Map<String, String> map = new HashMap<>();
        map.put("token", token);

        LOGGER.info("end");
        return map;
    }

    // http basic sends "Basic <base64 of user:pwd>", this strips the prefix,
    // decodes it and pulls out everything before the colon
    private String getUser(String authHeader) {
        String encodedCredentials = authHeader.replace("Basic ", "");
        byte[] decodedBytes = Base64.getDecoder().decode(encodedCredentials);
        String credentials = new String(decodedBytes);

        String user = credentials.substring(0, credentials.indexOf(":"));
        LOGGER.debug("user={}", user);
        return user;
    }
}
