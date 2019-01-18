package com.boutique.model;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ProprieteMesure {
	COU("cou"),LONGUEUR("longeur");

	private String value;
	private ProprieteMesure(String value) {
		this.value = value;
	}

@JsonValue
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

 @JsonCreator
	public static ProprieteMesure fromValue(String value) {
		for (ProprieteMesure category : values()) {
			if (category.value.equalsIgnoreCase(value)) {
				return category;
			}
		}
		throw new IllegalArgumentException(
				"Unknown enum ProprieteMesure " + value + ", Allowed values are " + Arrays.toString(values()));
	}
}
