package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// this is the bit that sold me on spring data jpa - you just extend JpaRepository and you
// get save / findById / findAll / deleteById for free. no implementation to write at all,
// spring data generates it at runtime
@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
}
