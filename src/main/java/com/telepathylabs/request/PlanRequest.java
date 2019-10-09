package com.telepathylabs.request;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import com.telepathylabs.domain.Feature;
import com.telepathylabs.domain.Plan;

public class PlanRequest {
	@Valid
	@Size(min = 1, message = "should be present in the request")
	private Plan[] allPlans;

	@Valid
	@Size(min = 1, message = "should be present in the request")
	private Feature[] selectedFeatures;

	/**
	 * @return the allPlans
	 */
	public Plan[] getAllPlans() {
		return allPlans;
	}

	/**
	 * @param allPlans
	 *            the allPlans to set
	 */
	public void setAllPlans(Plan[] allPlans) {
		this.allPlans = allPlans;
	}

	/**
	 * @return the selectedFeatures
	 */
	public Feature[] getSelectedFeatures() {
		return selectedFeatures;
	}

	/**
	 * @param selectedFeatures
	 *            the selectedFeatures to set
	 */
	public void setSelectedFeatures(Feature[] selectedFeatures) {
		this.selectedFeatures = selectedFeatures;
	}

}
