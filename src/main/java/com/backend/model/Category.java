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
@Table(name = "[category]")
@AllArgsConstructor
@NoArgsConstructor
public class Category implements Serializable {

	private static final long serialVersionUID = 8812640670616514748L;

	@Id
	private String id;

	@Column(name = "name")
	private String name;

	@Column(name = "active")
	private Boolean active;

	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	@JsonBackReference
	private Set<Product> product;

	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	@JsonBackReference
	private Set<Service> service;
}
