package com.backend.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class ProductDTO {
	@Id
	private String id;
	private String name;
	private String img_url;
}
  