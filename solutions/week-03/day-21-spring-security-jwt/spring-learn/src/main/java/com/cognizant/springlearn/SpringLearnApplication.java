package com.cognizant.springlearn;

import com.cognizant.springlearn.model.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringLearnApplication.class, args);
        LOGGER.info("inside main");

        displayCountry();
        displaySingletonVsPrototype();
        displayDate();
        displayCountries();
    }

    // loads country.xml as its own lightweight context, separate from the boot
    // application context - this is the plain spring core way of doing it, no
    // @Component or component scanning involved at all
    private static void displayCountry() {
        LOGGER.info("start");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country country = context.getBean("country", Country.class);
        LOGGER.debug("country : {}", country);
        LOGGER.info("end");
    }

    // gets the same bean id twice from a singleton bean and once each from the
    // prototype bean, watch the constructor log line count in the console to see
    // the difference - singleton logs the constructor once, prototype logs it twice
    private static void displaySingletonVsPrototype() {
        LOGGER.info("start");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

        Country singleton1 = context.getBean("country", Country.class);
        Country singleton2 = context.getBean("country", Country.class);
        LOGGER.debug("singleton same instance: {}", singleton1 == singleton2);

        Country prototype1 = context.getBean("countryPrototype", Country.class);
        Country prototype2 = context.getBean("countryPrototype", Country.class);
        LOGGER.debug("prototype same instance: {}", prototype1 == prototype2);
        LOGGER.info("end");
    }

    private static void displayDate() {
        LOGGER.info("start");
        ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
        SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
        try {
            Date parsed = format.parse("31/12/2018");
            LOGGER.debug("parsed date: {}", parsed);
        } catch (ParseException e) {
            // shouldnt happen with a hardcoded valid date string but the compiler
            // wants it handled either way
            LOGGER.debug("could not parse date", e);
        }
        LOGGER.info("end");
    }

    @SuppressWarnings("unchecked")
    private static void displayCountries() {
        LOGGER.info("start");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        List<Country> countries = (List<Country>) context.getBean("countryList");
        LOGGER.debug("countries : {}", countries);
        LOGGER.info("end");
    }
}
