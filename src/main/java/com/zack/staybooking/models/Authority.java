package com.zack.staybooking.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="authority")
public class Authority implements Serializable {
    private static final long serialVersionUid = 1L;
    @Id
    private String userName;
    private String authority;

    public Authority() {

    }

    public Authority(String userName, String authority) {
        this.userName = userName;
        this.authority = authority;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
