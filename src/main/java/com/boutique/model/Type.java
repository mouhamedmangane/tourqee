package com.boutique.model;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Type {
	ENTIER("entier"),DOUBLE("double"),CHAINE("String");
	private String value;

	private Type(String value) {
		this.value = value;
	}

	@Override
	@JsonValue
	public String toString() {
		return super.toString();
	}

	@JsonCreator
	public static Type fromValue(String value) {
		for (Type category : values()) {
			if (category.value.equalsIgnoreCase(value)) {
				return category;
			}
		}
		throw new IllegalArgumentException(
				"Unknown enum type " + value + ", Allowed values are " + Arrays.toString(values()));
	}
}
