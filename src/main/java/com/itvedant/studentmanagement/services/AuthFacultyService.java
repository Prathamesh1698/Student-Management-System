package com.itvedant.studentmanagement.services;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.itvedant.studentmanagement.entities.RegisteredFaculty;
import com.itvedant.studentmanagement.repository.RegisteredFacultyRepository;

import jakarta.transaction.Transactional;

@Service
public class AuthFacultyService implements UserDetailsService {

    @Autowired
    private RegisteredFacultyRepository repository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       
        RegisteredFaculty foundFaculty = this.repository.findByEmail(username);
        if(foundFaculty == null){
            throw new UsernameNotFoundException("User with this name does not exist.");
        }
        else{
            Collection<GrantedAuthority> authorities = new ArrayList<>();

            for(String role : foundFaculty.getRoles()){
                authorities.add(new SimpleGrantedAuthority(role));
            }

            RegisteredFaculty faculty = new RegisteredFaculty (foundFaculty.getEmail(),foundFaculty.getPassword(),authorities);

            return faculty;
        }
    }
    
}
