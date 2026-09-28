package com.app.arnab;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "emptab")
public class Employee {

	@Id
	@Column(name = "eid")
	private Integer empId;

	@Column(name = "ename")
	private String empName;

	@Column
	private Double empSal;

}
