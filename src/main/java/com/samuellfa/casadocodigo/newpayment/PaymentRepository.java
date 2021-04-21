package com.samuellfa.casadocodigo.newpayment;

import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Long> {
    
}
