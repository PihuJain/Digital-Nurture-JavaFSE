package com.cognizant.springlearn.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// plain pojo this time, no @Entity, this one gets built by spring reading the xml bean
// definition not by hibernate. logging inside the constructor and accessors was in the
// handout to prove exactly when spring is constructing vs reusing the bean
public class Country {

    private static final Logger LOGGER = LoggerFactory.getLogger(Country.class);

    private String code;

    private String name;

    public Country() {
        LOGGER.debug("inside country constructor");
    }

    public String getCode() {
        LOGGER.debug("getCode called");
        return code;
    }

    public void setCode(String code) {
        LOGGER.debug("setCode called with {}", code);
        this.code = code;
    }

    public String getName() {
        LOGGER.debug("getName called");
        return name;
    }

    public void setName(String name) {
        LOGGER.debug("setName called with {}", name);
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country{code='" + code + "', name='" + name + "'}";
    }
}
