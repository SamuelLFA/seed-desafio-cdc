package com.samuellfa.casadocodigo.newticket;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket, Long> {
    
    public Optional<Ticket> findByCode(String code);
}
