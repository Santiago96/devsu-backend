package com.devsu.bank.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "account")
@Getter
@Setter
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "number_account")
    private Long numberAccount;

    @Column(name = "balance", nullable = false)
    private BigDecimal balance;

    @Column(name = "state", length = 50)
    private boolean state;

    @Column(name = "type", length = 50)
    private String type;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

}