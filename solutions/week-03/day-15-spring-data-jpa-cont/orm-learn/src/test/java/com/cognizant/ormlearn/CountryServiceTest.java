package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

// full @SpringBootTest here instead of @DataJpaTest since we're going through
// the service layer, not just the repository
@SpringBootTest
@Transactional
class CountryServiceTest {

    @Autowired
    private CountryService countryService;

    @Test
    void addsAndFindsCountryByCode() throws CountryNotFoundException {
        countryService.addCountry(new Country("FR", "France"));

        Country found = countryService.findCountryByCode("FR");
        assertEquals("France", found.getName());
    }

    @Test
    void throwsWhenCodeDoesNotExist() {
        assertThrows(CountryNotFoundException.class, () -> countryService.findCountryByCode("ZZ"));
    }

    @Test
    void updatesCountryName() throws CountryNotFoundException {
        countryService.addCountry(new Country("DE", "Deutschland"));
        countryService.updateCountry("DE", "Germany");

        assertEquals("Germany", countryService.findCountryByCode("DE").getName());
    }

    @Test
    void findsByPartialNameCaseInsensitive() {
        countryService.addCountry(new Country("IN", "India"));
        countryService.addCountry(new Country("ID", "Indonesia"));
        countryService.addCountry(new Country("US", "United States"));

        List<Country> matches = countryService.findCountriesByPartialName("IND");
        assertEquals(2, matches.size());
    }
}
