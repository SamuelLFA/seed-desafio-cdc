package com.samuellfa.casadocodigo.newpayment;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.samuellfa.casadocodigo.newcountry.Country;
import com.samuellfa.casadocodigo.newstate.State;
import com.samuellfa.casadocodigo.shared.ExistsId;

public class NewPaymentRequest {

    @NotBlank @Email
    private String email;
    @NotBlank
    private String name;
    @NotBlank
    private String lastName;
    @CPFCNPJ(message = "{payment.document.valid}")
    @NotBlank
    private String document;
    @NotBlank
    private String complement;
    @NotBlank
    private String city;
    @NotNull
    @ExistsId(domainClass = Country.class, fieldName = "id")
    private Long idCountry;
    @NotNull
    @ExistsId(domainClass = State.class, fieldName = "id")
    private Long idState;
    @NotBlank
    private String phone;
    @NotBlank
    private String cep;

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
    public Long getIdCountry() {
        return idCountry;
    }
    public void setIdCountry(Long idCountry) {
        this.idCountry = idCountry;
    }
    public Long getIdState() {
        return idState;
    }
    public void setIdState(Long idState) {
        this.idState = idState;
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

    @Override
    public String toString() {
        return "NewPaymentRequest [cep=" + cep + ", city=" + city + ", complement=" + complement + ", document="
                + document + ", email=" + email + ", idCountry=" + idCountry + ", idState=" + idState + ", lastName="
                + lastName + ", name=" + name + ", phone=" + phone + "]";
    }
}
