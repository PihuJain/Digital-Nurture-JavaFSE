package com.cognizant.springlearn.service;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);

    // loading country.xml once in the constructor instead of on every call - first
    // attempt had this inside getCountry() itself and it was rebuilding the whole
    // xml context (and re-logging every constructor call) on every single request
    private final ApplicationContext countryContext = new ClassPathXmlApplicationContext("country.xml");

    public Country getIndia() {
        return countryContext.getBean("country", Country.class);
    }

    @SuppressWarnings("unchecked")
    public List<Country> getAllCountries() {
        return (List<Country>) countryContext.getBean("countryList");
    }

    // code comes in from a @PathVariable so case can be anything, matching with
    // equalsIgnoreCase instead of assuming the caller sends it uppercase
    public Country getCountry(String code) throws CountryNotFoundException {
        LOGGER.info("start");
        List<Country> countries = getAllCountries();

        for (Country country : countries) {
            if (country.getCode().equalsIgnoreCase(code)) {
                LOGGER.info("end");
                return country;
            }
        }

        throw new CountryNotFoundException("country not found for code " + code);
    }
}
