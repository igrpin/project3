package com.projetoteste3.project3.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "receita")
public class Receita {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "valor_receita")
	private BigDecimal valorReceita;

	@Column(name = "data_receita")
	private java.sql.Timestamp dataReceita = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());

	@Column(name = "categoria_receita_id")
	private Integer categoriaReceitaId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getValorReceita() {
		return valorReceita;
	}

	public void setValorReceita(BigDecimal valorReceita) {
		this.valorReceita = valorReceita;
	}

	public Timestamp getDataReceita() {
		return dataReceita;
	}

	public void setDataReceita(Timestamp dataReceita) {
		this.dataReceita = dataReceita;
	}

	public Integer getCategoriaReceitaId() {
		return categoriaReceitaId;
	}

	public void setCategoriaReceitaId(Integer categoriaReceitaId) {
		this.categoriaReceitaId = categoriaReceitaId;
	}

}
