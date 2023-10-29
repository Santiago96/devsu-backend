package com.devsu.bank.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@Getter
@Setter
public class Client extends Person {


    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Column(name = "state", length = 50)
    private String state;

    public Client() {

    }

    public Client(Long id) {
        super(id);
    }

    public Client(String password, String state) {
        this.password = password;
        this.state = state;
    }

    public Client(Long id, String name, String gender, Date dateOfBirth, String address, String phone, String password, String state) {
        super(id, name, gender, dateOfBirth, address, phone);
        this.password = password;
        this.state = state;
    }
}