package com.backend.model;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "[product]")
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {

	private static final long serialVersionUID = 8044571157231803032L;

	@Id
	private String id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	private Boolean active;

	@ManyToOne
	@JoinColumn(name = "id_cate")
	@JsonBackReference
	private Category category;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	@JsonBackReference
	private Set<ProductImage> productImages;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	@JsonBackReference
	private Set<DetailsProduct> detailsProduct;
}
