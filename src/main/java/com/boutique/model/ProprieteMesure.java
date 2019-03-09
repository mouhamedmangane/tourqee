package com.boutique.model;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ProprieteMesure {
	COU("cou"),BRAS("bras"),
	EPAULE("epaule"),
	POITRINE("poitrine"),
	TAILLE("taille "),
	MANCHES( "manches"),
	TOUR_DE_MANCHES("tour de manche"),
	CEINTURE("ceinture"),
	POIGNET("poignet"),
	FESSES("fesses"),
	CUISSES("cuisses"),
	GENOU("genou"),
	LONGUEUR_BOUBOU("Longueur boubou"),
	LONGUEUR_PANTALON("Longueur pantalon"),
	BAS("bas"),
	HANCHE("hanche")
	;

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
