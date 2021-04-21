package com.samuellfa.casadocodigo.newpayment;

import java.time.LocalDate;

import com.samuellfa.casadocodigo.newticket.TicketRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class TicketValidator implements Validator {

    @Autowired
    private TicketRepository ticketRepository;

    @Override
	public boolean supports(Class<?> clazz) {
		return NewPaymentRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}
	
		var request = (NewPaymentRequest) object;
		var ticketCode = request.getTicketCode();

        if (StringUtils.hasText(ticketCode)) {
            var ticketOptional = ticketRepository.findByCode(ticketCode);

            if (ticketOptional.isEmpty()) {
                errors.rejectValue("ticketCode", null, "The code is invalid");
            }
            
            if (ticketOptional.get().getValidDate().isBefore(LocalDate.now())) {
                errors.rejectValue("order", null, "The code is expired");
            }
        }
	}
}
