package com.samuellfa.casadocodigo.newpayment;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.samuellfa.casadocodigo.newcountry.Country;
import com.samuellfa.casadocodigo.newstate.State;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String name;
    private String lastName;
    private String document;
    private String complement;
    private String city;
    @ManyToOne
    private Country country;
    @ManyToOne
    private State state;
    private String phone;
    private String cep;
    @OneToOne(mappedBy = "payment", cascade = CascadeType.PERSIST)
    private PaymentOrder order;

    public Payment() {}

    public Payment(String email, String name, String lastName, String document, String complement, String city,
            Country country, State state, String phone, String cep, PaymentOrder order) {
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.document = document;
        this.complement = complement;
        this.city = city;
        this.country = country;
        this.state = state;
        this.phone = phone;
        this.cep = cep;
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public PaymentOrder getOrder() {
        return order;
    }

    public void setOrder(PaymentOrder order) {
        this.order = order;
    }
}
