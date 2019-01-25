package com.boutique.model;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ProprieteMesure {
	COU("cou"),BRAS("bras");

	private String value;
	private ProprieteMesure(String value) {
		this.value = value;
	}

@JsonValue
@Override
	public String toString() {
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
