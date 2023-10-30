package com.itvedant.studentmanagement.entities;

import java.time.Instant;
import java.util.List;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String course;

    @CreatedDate
    @Column(updatable = false, nullable = false)
    private Instant creationTime;

    @LastModifiedDate
    private Instant updationTime;

    @ManyToMany
    @JoinTable (name = "Course_Details",
                joinColumns = @JoinColumn(name = "Course_id"),
                inverseJoinColumns = @JoinColumn(name = "Module_id"))
    private List<Module> modules;

}
