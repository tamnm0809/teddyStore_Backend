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
@Table(name = "[transactions]")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transactions implements Serializable{

	private static final long serialVersionUID = -7519287649507701260L;

	@Id
	private String id;
	
	@Column(name="status")
	private String status;
	
	@Column(name="method_payment")
	private String method_payment;
	
	@Column(name="timestamp")
	private String timestamp;

	@Column(name="amount")
	private String amount;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_acc")
	private Account account;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_ord")
	private Order order;
}
