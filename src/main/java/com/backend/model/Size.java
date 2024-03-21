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
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "[size]")
@NoArgsConstructor
@AllArgsConstructor
public class Size implements Serializable {

	private static final long serialVersionUID = 1128002585646130548L;

	@Id
	private String id;

	@Column(name = "size_no")
	private String size_no;

	@OneToMany(mappedBy = "size", cascade = CascadeType.ALL)
	@JsonBackReference		// Ngãn ch?n t?nh tr?ng v?ng l?p ð? quy vô h?n
	private Set<DetailsProduct> detailsProduct;

}
