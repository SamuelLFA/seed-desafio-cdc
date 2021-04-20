package com.samuellfa.casadocodigo.newpayment;

import com.samuellfa.casadocodigo.newcountry.CountryRepository;
import com.samuellfa.casadocodigo.newstate.StateRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class StateBelongsToCountryValidator implements Validator {

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private StateRepository stateRepository;

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
		var countryOptional = countryRepository.findById(request.getIdCountry());
		var stateOptional = stateRepository.findById(request.getIdState());

		if (countryOptional.isEmpty()) {
			throw new IllegalArgumentException("This country does not exist");
		}

		if (stateOptional.isEmpty()) {
			throw new IllegalArgumentException("This state does not exist");
		}

		var country = countryOptional.get();
		var state = stateOptional.get();

		if (state.getCountry().getId() != country.getId()) {
			errors.rejectValue("idState", null, "This state does not belongs to the country");
		}
	}
}
