package com.rapifuzz.assignment.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Getter
@Setter
@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(length = 15,nullable = false)
    private String userType;

    @Column(nullable = false,length = 25)
    private String firstName;

    @Column(nullable = false,length = 25)
    private String lastName;

    @Column(nullable = false, unique = true,length = 50)
    private String emailAddress;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false,length = 15)
    private String country;

    @Column(nullable = false,length = 15)
    private String state;

    @Column(nullable = false,length = 15)
    private String city;

    @Column(nullable = false,length = 10)
    private String pincode;

    @Column(nullable = false,length = 6)
    private String countryCode;

    @Column(nullable = false,length = 10)
    private String mobileNo;

    @Column(length = 25)
    private String fax;

    @Column(length = 25)
    private String phone;

    @Column(nullable = false,length = 25)
    private String password;

    @CreationTimestamp
    @Column(nullable = false,updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Column
    private Date updatedAt;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void setUserType(UserType userType) {
        this.userType = userType.name();
    }
}
