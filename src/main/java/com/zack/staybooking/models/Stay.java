package com.zack.staybooking.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="world_cities")
@JsonDeserialize(builder = Stay.Builder.class)
public class Stay implements Serializable {

    @Id
    private Long id;
    private String city;
    private String cityAscii;
    private double lat;
    private double lng;
    private String country;
    private String adminName;

//    @JsonProperty("guest_number")
//    private int guestNumber;

    private Stay(Builder builder) {
        this.id = builder.id;
        this.city = builder.city;
        this.cityAscii = builder.cityAscii;
        this.lat = builder.lat;
        this.lng = builder.lng;
        this.country = builder.country;
        this.adminName = builder.adminName;

    }

    public Stay() {

    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getCityAscii() {
        return cityAscii;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

    public String getCountry() {
        return country;
    }

    public String getAdminName() {
        return adminName;
    }

    // Builder patter - Class
    public static class Builder {
        @JsonProperty("id")
        private Long id;

        @JsonProperty("city")
        private String city;

        @JsonProperty("city_ascii")
        private String cityAscii;

        @JsonProperty("lat")
        private double lat;

        @JsonProperty("lng")
        private double lng;

        @JsonProperty("country")
        private String country;

        @JsonProperty("admin_name")
        private String adminName;


        // ==================== Setters

        // Setters

    }
}
