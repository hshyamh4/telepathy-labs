package com.telepathylabs.domain;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Plan implements Comparable<Plan> {
	@NotBlank(message = "Name is mandatory")
	private String name;
	
	@Valid
	private Feature[] features;
	
	@NotNull
	@Min(1)
	private Double cost;

	public Feature[] getFeatures() {
		return features;
	}
	
	public void setFeatures(Feature[] features) {
		this.features = features;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double price) {
		this.cost = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public int compareTo(Plan o) {
		return this.getCost().compareTo(o.getCost());
	}

}
