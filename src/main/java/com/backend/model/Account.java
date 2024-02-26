package com.backend.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "[account]")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account implements Serializable {

	private static final long serialVersionUID = 2216095496718599412L;

	@Id
	private String id;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "role")
	private Boolean role;

	@Column(name = "date_create")
	private Date date_create;

	@Column(name = "active")
	private Boolean active;

	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
	private Set<AccountInfor> accountInfors;

	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
	private Set<Cart> cart;

	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
	private Set<Order> order;

	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
	private Set<Transactions> transactions;

	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
	private Set<Rate> rate;
}
