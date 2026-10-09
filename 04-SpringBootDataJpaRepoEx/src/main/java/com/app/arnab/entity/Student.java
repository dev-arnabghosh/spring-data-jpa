package com.app.arnab.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//import jakarta.persistence.Temporal;
//import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "stdtab")
public class Student {

	@Id
	@Column(name = "sid")
//	@GeneratedValue(strategy = GenerationType.IDENTITY) // mysql (auto increment)
	@GeneratedValue(strategy = GenerationType.SEQUENCE) // oracle
	//@GeneratedValue(strategy = GenerationType.TABLE) // temp table to store next PK val
	private Integer stdId;

	@Column(name = "sname")
	private String stdName;

	@Column(name = "sfee")
	private Double stdFee;

	@Column(name = "sobj")
	//@Temporal(TemporalType.DATE) // stores only date
	//@Temporal(TemporalType.TIME) // stores only time
	//@Temporal(TemporalType.TIMESTAMP) // stores only date and time (default)
	private LocalDate stdDoj;
	
	private LocalDateTime loginTime; // stores data and time
}
