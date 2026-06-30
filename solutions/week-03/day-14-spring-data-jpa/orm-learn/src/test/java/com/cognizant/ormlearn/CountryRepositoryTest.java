package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

// @DataJpaTest spins up just the jpa slice against the in-memory h2, no full app boot needed
// save and findById come from JpaRepository, i never wrote either one
@DataJpaTest
class CountryRepositoryTest {

    @Autowired
    private CountryRepository countryRepository;

    @Test
    void saveAndFindCountry() {
        countryRepository.save(new Country("IN", "India"));

        Optional<Country> found = countryRepository.findById("IN");
        assertTrue(found.isPresent());
        assertEquals("India", found.get().getName());
    }
}
