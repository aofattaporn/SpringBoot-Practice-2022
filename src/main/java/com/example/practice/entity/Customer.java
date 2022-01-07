package com.example.practice.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

@Entity
@Table
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Customer {

    @Id
    private Long id;

    //    @NotBlank(message = "ddsfds")
    private String name;

    private String surname;


    //    @NotBlank(message = "")
    @JsonProperty(access = JsonProperty.Access.AUTO)
    private String password;

    @Email
    private String email;

    @JsonProperty("customerId")
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @JsonProperty
    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
