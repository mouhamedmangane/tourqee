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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.boutique.mesImages.PathImage;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Tissu implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long idTissu;
	
	private String nom;
	
	@ManyToOne
	@JoinColumn(name="id_type_tissu",insertable=true,updatable=false)
	private TypeTissu typeTissu;
	

	
	@ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            },
            mappedBy = "tissus")
	private List<Produit> produits;
	
	@OneToOne(cascade=CascadeType.REMOVE,fetch=FetchType.LAZY)
	private DescriptionTissu description;
	
	@Transient
	private String image;
	
	public Tissu() {
		super();
	}
	public long getIdTissu() {
		return idTissu;
	}
	public void setIdTissu(long idTissu) {
		this.idTissu = idTissu;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public TypeTissu getTypeTissu() {
		return typeTissu;
	}
	public void setTypeTissu(TypeTissu typeTissu) {
		this.typeTissu = typeTissu;
	}
	public DescriptionTissu getDescription() {
		return description;
	}
	public void setDescription(DescriptionTissu description) {
		this.description = description;
	}
	public List<Produit> getProduits() {
		return produits;
	}
	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
	@JsonIgnore
	public String getImage() {
		String f="uploads";
		Path p = Paths.get(f)
                .toAbsolutePath().normalize();

		if(Files.exists(p.resolve(PathImage.TISSU.toString())
				.resolve(this.nameImage())
				, new LinkOption[]{ LinkOption.NOFOLLOW_LINKS}))
			return "downloadFile"+"/"+PathImage.TISSU.toString()+"/"+this.nameImage();
		else
			 return "downloadFile"+"/"+PathImage.TISSU.toString()+"/vide.jpg";
	}
	@JsonIgnore
	public String nameImage() {
		return this.idTissu+".jpg";
	}
}
