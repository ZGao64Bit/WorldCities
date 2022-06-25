package com.zack.staybooking.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="stay_image")
public class StayImage implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String url;

    @ManyToOne
    @JoinColumn(name = "stay_id")
    @JsonIgnore
    private Stay stay;

    public StayImage() {

    }

    // ======================= Constructor
    public StayImage(String url, Stay stay) {
        this.url = url;
        this.stay = stay;
    }

    // ======================= Getters / Setters
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Stay getStay() {
        return stay;
    }

    public void setStay(Stay stay) {
        this.stay = stay;
    }
}
