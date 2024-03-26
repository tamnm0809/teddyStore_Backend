package com.backend.model;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "[color]")
@NoArgsConstructor
@AllArgsConstructor
public class Color implements Serializable {

	private static final long serialVersionUID = 1128002585646130548L;

	@Id
	private String id;

	@Column(name = "color")
	private String color;

	@OneToMany(mappedBy = "color", cascade = CascadeType.ALL)
	@JsonBackReference
	private Set<DetailsProduct> detailsProduct;
}
