package com.learning.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.learning.constants.Role;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String name;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;


    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @ElementCollection
    @CollectionTable(name = "user_courses",joinColumns = @JoinColumn(name = "user_id"))
    @Builder.Default
    @Column(name = "course_id")
    private List<Long> courses = new ArrayList<>();

    @Builder.Default
    @ElementCollection
    @CollectionTable(name = "user_assessments", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "assessment_id")
    private List<Long> assessments = new ArrayList<>();

    @PrePersist
    public void onCreate() {
        createdAt = LocalDateTime.now();
    } 

}
