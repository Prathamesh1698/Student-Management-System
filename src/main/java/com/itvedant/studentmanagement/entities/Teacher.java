package com.itvedant.studentmanagement.entities;

import java.time.Instant;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.itvedant.studentmanagement.validator.Mobile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull(message = "Firstname is required")
    @NotEmpty(message = "Please enter first name")
    @Column(name = "FirstName", nullable = false)
    private String firstName;

    @NotNull(message = "Lastname is required")
    @NotEmpty(message = "Please enter last name")
    @Column(name = "LastName", nullable = false)
    private String lastName;

    @Email
    @NotNull(message = "Email is required")
    @NotEmpty
    @Column(unique = true)
    private String email;

    @Mobile
    private String mobile;

    private String password;

    private String confirmPassword;

    @CreatedDate
    @Column(updatable = false)
    private Instant creationTime;

    @LastModifiedDate
    private Instant updationTime;

    @JoinColumn(name = "addr_id")
    @OneToOne
    private Address address;

    @ManyToOne
    @JoinColumn(name = "Department_id")
    private Department dept;

    // @ManyToMany
    // private List<Course> courses;

}
