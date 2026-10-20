package com.app.arnab.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.OrderColumn;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "prodtab")
public class Product {

	@Id
	@Column(name = "pid")
	private Integer prodId;

	@Column(name = "pcode")
	private String prodCode;

//	@ElementCollection
//	@CollectionTable( //
//			name = "product_colors", //
//			joinColumns = @JoinColumn(name = "pidFk")//
//	)
//
//	@OrderColumn(name = "pos") // index col
//	@Column(name = "data")
	private List<String> colors;

	@ElementCollection
	@CollectionTable(//
			name = "product_model", //
			joinColumns = @JoinColumn(name = "pidFk") //
	)
	@Column(name = "model")
	private Set<String> models;

	@ElementCollection // must
	@CollectionTable(//
			name = "product_details", // table name
			joinColumns = @JoinColumn(name = "pidFk") // fk column
	)
	@MapKeyColumn(name="code") // index
	@Column(name = "detail") // element col
	private Map<String, String> details;
}
