package com.cognizant.springlearn;

import com.cognizant.springlearn.model.Country;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertNotSame;

// not a @SpringBootTest here on purpose, these are plain ClassPathXmlApplicationContext
// beans, no need to spin up the whole boot context just to check xml wiring
class SpringLearnApplicationTests {

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
}
