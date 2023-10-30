package com.itvedant.studentmanagement.entities;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "studaddr", types = { Student.class })
public interface StudentWithAddress {

    @Value("#{target.firstName}")
    String getFName();

    @Value("#{target.lastName}")
    String getLName();

    @Value("#{target.firstName + ' ' + target.lastName}")
    String getFullName();

    @Value("#{target.address.city}")
    String getCity();

    @Value("#{target.address.state}")
    String getState();

    @Value("#{target.address.country}")
    String getCountry();
}
