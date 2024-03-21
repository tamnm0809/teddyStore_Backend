package com.backend.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "[details_service]")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DetailsService implements Serializable {

	private static final long serialVersionUID = 9031219985713142049L;

	@Id
	private String id;

	@Column(name = "size")
	private String size;

	@Column(name = "about_price")
	private String about_price;

	@Column(name = "active")
	private Boolean active;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_ser")
	private Service service;
}
