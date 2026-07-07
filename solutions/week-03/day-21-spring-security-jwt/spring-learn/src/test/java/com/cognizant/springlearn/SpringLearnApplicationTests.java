package com.cognizant.springlearn;

import com.cognizant.springlearn.controller.CountryController;
import com.cognizant.springlearn.model.Country;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SpringLearnApplicationTests {

    @Autowired
    private CountryController countryController;

    @Autowired
    private MockMvc mvc;

    @Test
    void contextLoads() {
        assertNotNull(countryController);
    }

    // these three are carried over from day 18, still checking the raw xml wiring
    // straight through ClassPathXmlApplicationContext, no controller and no security
    // filter chain involved at all
    @Test
    void loadsCountryFromXml() {
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country country = context.getBean("country", Country.class);

        assertEquals("IN", country.getCode());
        assertEquals("India", country.getName());
    }

    @Test
    void singletonBeanReturnsSameInstance() {
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

        Country first = context.getBean("country", Country.class);
        Country second = context.getBean("country", Country.class);
        assertSame(first, second);
    }

    @Test
    void prototypeBeanReturnsNewInstanceEveryTime() {
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

        Country first = context.getBean("countryPrototype", Country.class);
        Country second = context.getBean("countryPrototype", Country.class);
        assertNotSame(first, second);
    }

    // every mockmvc call below now needs credentials, since day 21 locked the whole
    // app down with .anyRequest().authenticated(). used httpBasic() here rather than
    // going through the full jwt flow, keeps these tests focused on the country
    // controller instead of re-proving auth works on every single one
    @Test
    void getCountryReturnsIndia() throws Exception {
        ResultActions actions = mvc.perform(get("/country").with(httpBasic("user", "pwd")));
        actions.andExpect(status().isOk());
        actions.andExpect(jsonPath("$.code").value("IN"));
        actions.andExpect(jsonPath("$.name").value("India"));
    }

    @Test
    void getCountryByCodeIsCaseInsensitive() throws Exception {
        mvc.perform(get("/countries/in").with(httpBasic("user", "pwd"))).andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("India"));
    }

    @Test
    void getCountryByUnknownCodeReturns404() throws Exception {
        ResultActions actions = mvc.perform(get("/countries/zz").with(httpBasic("user", "pwd")));
        actions.andExpect(status().isNotFound());
        actions.andExpect(status().reason("Country not found"));
    }

    @Test
    void getAllCountriesReturnsFour() throws Exception {
        mvc.perform(get("/countries").with(httpBasic("user", "pwd"))).andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(4));
    }

    @Test
    void getCountriesWithNoCredentialsIsUnauthorized() throws Exception {
        mvc.perform(get("/countries")).andExpect(status().isUnauthorized());
    }
}
