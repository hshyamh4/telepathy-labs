package com.telepathylabs.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.telepathylabs.domain.Feature;
import com.telepathylabs.domain.Plan;
import com.telepathylabs.request.PlanRequest;
import com.telepathylabs.response.PlanResponse;
import com.telepathylabs.service.PlanSolutionSerivce;

@RestController
@RequestMapping("/question1/solution")
public class PlanSolutionController {

	@Autowired
	private PlanSolutionSerivce solutionSerivce;

	@PostMapping
	public PlanResponse getMatchingPlans(@Valid @RequestBody PlanRequest planRequest, Errors errors) {

		checkValidationErrorIfAny(errors);

		Plan[] allPlans = planRequest.getAllPlans();
		Feature[] selectedFeatures = planRequest.getSelectedFeatures();

		Plan[] plans = solutionSerivce.getPlansByFeatures(allPlans, selectedFeatures);
		if (plans.length == 0) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Plan Not Found");
		}

		PlanResponse planResponse = new PlanResponse();
		planResponse.setFinalisedPlans(plans);

		return planResponse;

	}

	private void checkValidationErrorIfAny(Errors errors) {
		if (errors.hasErrors()) {
			List<ConstraintViolation<?>> violationsList = new ArrayList<>();
			for (ObjectError e : errors.getAllErrors()) {
				violationsList.add(e.unwrap(ConstraintViolation.class));
			}
			String exceptionMessage = "";
			for (ConstraintViolation<?> violation : violationsList) {
				exceptionMessage += violation.getPropertyPath() + " " + violation.getMessage() + System.lineSeparator();
			}
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exceptionMessage);
		}
	}
}
