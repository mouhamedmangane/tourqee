package com.boutique.model;

import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import com.boutique.mesImages.PathImage;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(
        name="propriete", 
        uniqueConstraints= @UniqueConstraint(columnNames={"valeur", "id_preference"})
        )
public class Propriete implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long idPropriete;
	
	private String valeur;
	
	@ManyToOne
	@JoinColumn(name="id_preference")
	private Preference preference;
	
	@OneToMany(mappedBy="propriete")
	private List<LignePropriete> ligneProprietes;
	
	@ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST
                },mappedBy="proprietes")
	private List<Modele> models;
	
	@Transient
	private String image;

	public Propriete() {
		super();
	}

	public long getIdPropriete() {
		return idPropriete;
	}

	public void setIdPropriete(long idPropriete) {
		this.idPropriete = idPropriete;
	}

	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}

	public Preference getPreference() {
		return preference;
	}

	public void setPreference(Preference preference) {
		this.preference = preference;
	}

	public List<LignePropriete> getLigneProprietes() {
		return ligneProprietes;
	}

	public void setLigneProprietes(List<LignePropriete> produits) {
		this.ligneProprietes = produits;
	}
	@JsonIgnore
	public String getImage() {
		String f="uploads";
		Path p = Paths.get(f)
                .toAbsolutePath().normalize();

		if(Files.exists(p.resolve(PathImage.Propriete.toString())
				.resolve(this.nameImage())
				, new LinkOption[]{ LinkOption.NOFOLLOW_LINKS}))
			return "downloadFile"+"/"+PathImage.Propriete.toString()+"/"+this.nameImage();
		else
			 return "downloadFile"+"/"+PathImage.Propriete.toString()+"/vide.jpg";
	}
	@JsonIgnore
	public String nameImage() {
		return idPropriete+".jpg";
	}
	public void setImage(String image) {
		this.image = image;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Modele> getModels() {
		return models;
	}

	public void setModels(List<Modele> models) {
		this.models = models;
	}


	
	
	
}
