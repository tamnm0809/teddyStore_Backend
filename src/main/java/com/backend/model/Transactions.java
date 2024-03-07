package com.backend.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "[transactions]")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transactions implements Serializable{

	private static final long serialVersionUID = -7519287649507701260L;

	@Id
	private String id;
	
	@Column(name="vnp_amount")
	private String vnp_amount;
	
	@Column(name="vnp_bankTranNo")
	private String vnp_bankTranNo;

	@Column(name="vnp_cardType")
	private String vnp_cardType;

	@Column(name="vnp_orderInfor")
	private String vnp_orderInfor;

	@Column(name="vnp_payDate")
	private String vnp_payDate;

	@Column(name="vnp_responseCode")
	private String vnp_responseCode;

	@Column(name="vpn_tmnCode")
	private String vnp_tmnCode;

	@Column(name="vnp_transactionNo")
	private String vnp_transactionNo;

	@Column(name="vnp_transactionStatus")
	private String vnp_transactionStatus;

	@Column(name="vnp_txnRef")
	private String vnp_txnRef;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_ord")
	private Order order;
}
