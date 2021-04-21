package com.samuellfa.casadocodigo.newpayment;

import java.math.BigDecimal;

import com.samuellfa.casadocodigo.newbook.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class TotalOrderValidator implements Validator {

	@Autowired
	private BookRepository bookRepository;

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
		var order = request.getOrder();
		var total = order.getTotal();
		var totalByItems = order
			.getItems()
			.stream()
			.map(item -> {
				var bookOptional = bookRepository.findById(item.getIdBook());
				if (bookOptional.isPresent()) {
					return bookOptional.get().getPrice().multiply(new BigDecimal(item.getQuantity()));
				}
				return new BigDecimal("0.00");
			})
			.reduce(new BigDecimal("0.00"), BigDecimal::add);
		
		if (!total.equals(totalByItems)) {
			errors.rejectValue("order", null, "The total value of the order must be equal to the sum of the items");
		}
	}
}
