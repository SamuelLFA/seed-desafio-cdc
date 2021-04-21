package com.samuellfa.casadocodigo.newpayment;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewPaymentController {

    @Autowired
    private StateBelongsToCountryValidator stateBelongsToCountryValidator;

    @Autowired
    private TotalOrderValidator totalValidator;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(stateBelongsToCountryValidator, totalValidator);
    }
    
    @PostMapping("/purchase")
    public String create(@RequestBody @Valid NewPaymentRequest request) {
        return request.toString();
    }
}
