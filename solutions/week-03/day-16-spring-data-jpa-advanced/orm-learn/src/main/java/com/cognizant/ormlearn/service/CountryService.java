package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);

    @Autowired
    private CountryRepository countryRepository;

    // findById gives back an Optional, spent a bit figuring out isPresent() vs get()
    // before realising you just check present first then unwrap it
    @Transactional
    public Country findCountryByCode(String countryCode) throws CountryNotFoundException {
        LOGGER.info("start");
        Optional<Country> result = countryRepository.findById(countryCode);

        if (!result.isPresent()) {
            throw new CountryNotFoundException("country not found for code " + countryCode);
        }

        Country country = result.get();
        LOGGER.debug("country={}", country);
        LOGGER.info("end");
        return country;
    }

    @Transactional
    public void addCountry(Country country) {
        LOGGER.info("start");
        countryRepository.save(country);
        LOGGER.info("end");
    }

    // used the same save() for update too, jpa figures out insert vs update by
    // whether the id already exists in the table
    @Transactional
    public void updateCountry(String code, String name) throws CountryNotFoundException {
        Country country = findCountryByCode(code);
        country.setName(name);
        countryRepository.save(country);
    }

    @Transactional
    public void deleteCountry(String code) {
        countryRepository.deleteById(code);
    }

    // derived query method living on the repository, this just calls through.
    // matches on partial name, case insensitive, sorted a-z
    @Transactional
    public List<Country> findCountriesByPartialName(String partialName) {
        return countryRepository.findByNameContainingIgnoreCaseOrderByNameAsc(partialName);
    }
}
