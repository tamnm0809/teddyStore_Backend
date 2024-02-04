package com.backend.model;

import java.io.Serializable;
import java.util.Date;

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
@Data
@Table(name = "[Infor_account]")
@AllArgsConstructor
@NoArgsConstructor
public class AccountInfor implements Serializable {

	private static final long serialVersionUID = -5994131652998960364L;

	@Id
	private String id;

	@Column(name = "avatar")
	private String avatar;

	@Column(name = "name")
	private String name;

	@Column(name = "gender")
	private Boolean gender;

	@Column(name = "birthday")
	private Date birthday;

	@Column(name = "address")
	private String address;

	@Column(name = "email")
	private String email;

	@Column(name = "phone_contact")
	private Integer phone_contact;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_acc")
    private Account account;

}
