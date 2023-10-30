package com.itvedant.studentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.itvedant.studentmanagement.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

    
}
