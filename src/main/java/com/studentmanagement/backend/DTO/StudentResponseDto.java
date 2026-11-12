
package com.studentmanagement.backend.dto;

public class StudentResponseDto {

    private Long id;
    private String name;
    private String email;
    private Integer age;

    // Constructor
    public StudentResponseDto(Long id, String name, String email, Integer age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Integer getAge() {
        return age;
    }
}
