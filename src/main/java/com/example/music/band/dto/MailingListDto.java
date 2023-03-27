package com.example.music.band.dto;

import jakarta.validation.constraints.NotNull;

public class MailingListDto {

    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String country;

    @NotNull
    private String email;

    public MailingListDto() {
    }

    public MailingListDto(Long id, String name, String country, String email) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
