package com.inn.cafe.POJO;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;


@Entity  // Classe persistida
@Table(name = "user") //  Nomeia a entidade
@Data  // Elimina a criação de GETs e SETs e Construtors
@NamedQuery(name = "User.findByEmailId", query = "SELECT u FROM User u WHERE u.email = :email") //Query personalizada
@DynamicUpdate
@DynamicInsert
public class User implements Serializable  {

	private static final long serialVersionUID = 1L;

	/* Atributos */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // -> autro incremento de IDs
	private Integer id;
	private String name;
	private String contactNumber;
	private String email;
	private String password;
	private String status;
	private String role;
}
