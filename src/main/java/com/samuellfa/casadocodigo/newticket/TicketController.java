package com.samuellfa.casadocodigo.newticket;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class TicketController {

    @Autowired
    private TicketRepository ticketRepository;
    
    @PostMapping("/tickets")
    public ResponseEntity<Ticket> create(@RequestBody @Valid NewTicketRequest request, UriComponentsBuilder uriBuilder) {
        var ticket = request.toModel();
        ticketRepository.save(ticket);

        var uri = uriBuilder.path("/tickets/{id}").buildAndExpand(ticket.getId()).toUri();
        return ResponseEntity.created(uri).body(ticket);
    }
}
