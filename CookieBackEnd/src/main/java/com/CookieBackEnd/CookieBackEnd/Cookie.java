package com.CookieBackEnd.CookieBackEnd;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
class Cookie {
    @Id
    @GeneratedValue
    private Long id;
    private String brand;
    private double calories;
    private String image;

    public Cookie() {
    }

    public Cookie(String brand, double calories, String image) {
        this.brand = brand;
        this.calories = calories;
        this.image = image;
    }
}