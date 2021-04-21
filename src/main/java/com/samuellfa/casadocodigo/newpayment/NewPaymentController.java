package com.samuellfa.casadocodigo.newpayment;

import javax.validation.Valid;

import com.samuellfa.casadocodigo.newbook.BookRepository;
import com.samuellfa.casadocodigo.newcountry.CountryRepository;
import com.samuellfa.casadocodigo.newstate.StateRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class NewPaymentController {

    @Autowired
    private StateBelongsToCountryValidator stateBelongsToCountryValidator;

    @Autowired
    private TotalOrderValidator totalValidator;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private BookRepository bookRepository;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(stateBelongsToCountryValidator, totalValidator);
    }
    
    @PostMapping("/purchase")
    public ResponseEntity<Payment> create(@RequestBody @Valid NewPaymentRequest request, UriComponentsBuilder uriBuilder) {
        var payment = request.toModel(countryRepository, stateRepository, bookRepository);
        paymentRepository.save(payment);

        var uri = uriBuilder.path("/payments/{id}").buildAndExpand(payment.getId()).toUri();

        return ResponseEntity.created(uri).body(payment);
    }
}
