package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    private CountryService countryService;

    // hardcoded to india specifically per the handout, /countries below is the
    // one that returns all four
    @GetMapping("/country")
    public Country getCountryIndia() {
        LOGGER.info("start");
        Country india = countryService.getIndia();
        LOGGER.info("end");
        return india;
    }

    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        LOGGER.info("start");
        List<Country> countries = countryService.getAllCountries();
        LOGGER.info("end");
        return countries;
    }

    // throws clause here is what lets CountryNotFoundException's @ResponseStatus
    // actually kick in, spring converts it to the 404 response automatically
    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code) throws CountryNotFoundException {
        LOGGER.info("start");
        Country country = countryService.getCountry(code);
        LOGGER.info("end");
        return country;
    }

    // this project has no database so theres nothing to actually persist, just
    // echoing the country back proves the request body got parsed and validated.
    // @Valid is what routes bad payloads to GlobalExceptionHandler instead of here
    @PostMapping("/countries")
    public Country addCountry(@RequestBody @Valid Country country) {
        LOGGER.info("start");
        LOGGER.debug("country={}", country);
        LOGGER.info("end");
        return country;
    }
}
