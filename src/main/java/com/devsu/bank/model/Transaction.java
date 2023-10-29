package com.devsu.bank.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "transactions")
@Getter
@Setter
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Long transactionId;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "type", length = 50)
    private String type;

    @Column(name = "state", length = 50)
    private boolean state;

    @Column(name = "balance_initial", nullable = false)
    private BigDecimal balanceInitial;

    @Column(name = "balance_transaction", nullable = false)
    private BigDecimal balanceTransaction;

    @Column(name = "movement", length = 50)
    private String movement;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "account_number")
    private Account account;

}