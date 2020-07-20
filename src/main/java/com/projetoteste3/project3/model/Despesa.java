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
@Table(name = "despesa")
public class Despesa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "valor_despesa")
	private BigDecimal valorDespesa;

	@Column(name = "data_despesa")
	private java.sql.Timestamp dataDespesa = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());

	@Column(name = "categoria_despesa_id")
	private Integer categoriaDespesaId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getValorDespesa() {
		return valorDespesa;
	}

	public void setValorDespesa(BigDecimal valorDespesa) {
		this.valorDespesa = valorDespesa;
	}

	public Timestamp getDataReceita() {
		return dataDespesa;
	}

	public void setDataReceita(Timestamp dataDespesa) {
		this.dataDespesa = dataDespesa;
	}

	public Integer getCategoriaReceitaId() {
		return categoriaDespesaId;
	}

	public void setCategoriaReceitaId(Integer categoriaDespesaId) {
		this.categoriaDespesaId = categoriaDespesaId;
	}

}
