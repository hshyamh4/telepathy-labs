package com.telepathylabs.domain;

import javax.validation.constraints.NotBlank;

public class Feature {

	@NotBlank(message = "Name is mandatory")
	private String name;

	public Feature() {
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
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		} else if (o == this) {
			return true;
		} else if (!(o instanceof Feature)) {
			return false;
		} else {
			Feature anotherFeature = (Feature) o;
			return this.getName().equals(anotherFeature.getName());
		}
	}

}
