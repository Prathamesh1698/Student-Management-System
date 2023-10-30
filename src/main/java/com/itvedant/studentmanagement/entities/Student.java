package com.itvedant.studentmanagement.entities;

import java.time.Instant;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

// import com.itvedant.studentmanagement.repository.AddressRepository;
import com.itvedant.studentmanagement.validator.Mobile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull(message = "First name should not be empty")
    @NotEmpty
    @Column(name = "fname")
    private String firstName;

    @NotNull(message = "Last name should not be empty")
    @NotEmpty
    @Column(name = "lname", nullable = false)
    private String lastName;

    @Mobile
    private String mobile;

    @Email
    @NotNull(message = "Please enter email")
    @NotEmpty(message = "Email should not be empty")
    @Column(unique = true)
    private String email;

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

    private String assignmentUrl;
}
