package com.example.stepikcourse.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.servlet.Filter;
import lombok.Data;
import org.springframework.security.config.annotation.SecurityBuilder;

@Data
@Entity
public class User implements SecurityBuilder<Filter> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String login;
    private String password;

    @Override
    public Filter build() throws Exception {
        return null;
    }
}
