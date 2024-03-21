package com.backend.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "[service]")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Service implements Serializable {

	private static final long serialVersionUID = 8872242168065395449L;

	@Id
	private String id;

	@Column(name = "name")
	private String name;

	@Column(name = "image")
	private String decription;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_cate")
	@JsonBackReference
	private Category category;
}
