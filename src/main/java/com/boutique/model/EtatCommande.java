package com.boutique.model;


import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum EtatCommande {
	EN_ATTENTE("en attente"),TERMINÉ("terminé"),EN_COURS("en cours"),LIVRÉ("livré");
	private String value;

	private EtatCommande(String value) {
		this.value = value;
	}

	@Override
	@JsonValue
	public String toString() {
		return super.toString();
	}

	@JsonCreator
	public static EtatCommande fromValue(String value) {
		for (EtatCommande category : values()) {
			if (category.value.equalsIgnoreCase(value)) {
				return category;
			}
		}
		throw new IllegalArgumentException(
				"Unknown enum type " + value + ", Allowed values are " + Arrays.toString(values()));
	}
}

