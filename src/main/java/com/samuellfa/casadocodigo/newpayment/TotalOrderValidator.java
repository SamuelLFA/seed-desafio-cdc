package com.samuellfa.casadocodigo.newpayment;

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
		var orderModel = request.getOrder().toModel(bookRepository);
		var total = order.getTotal();
		var totalByItems = orderModel.total();
		
		if (!total.equals(totalByItems)) {
			errors.rejectValue("order", null, "The total value of the order must be equal to the sum of the items");
		}
	}
}
