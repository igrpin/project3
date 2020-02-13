package com.projetoteste3.project3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="receita")
public class Receita {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="valor_receita")
	private float valorReceita;
	
	// @Column(name="data_receita")
	// @Temporal(javax.persistence.TemporalType.DATE)
	// private Instant dataReceita;
	
	@Column(name="categoria_receita_id")
	private Integer categoriaReceitaId;

	
	
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public float getValorReceita() {
		return valorReceita;
	}

	public void setValorReceita(float valorReceita) {
		this.valorReceita = valorReceita;
	}

//	public Instant getDataReceita() {
//		return dataReceita;
//	}
//
//	public void setDataReceita(Instant dataReceita) {
//		this.dataReceita = dataReceita;
//	}

	public Integer getCategoriaReceitaId() {
		return categoriaReceitaId;
	}

	public void setCategoriaReceitaId(Integer categoriaReceitaId) {
		this.categoriaReceitaId = categoriaReceitaId;
	}
	
}
