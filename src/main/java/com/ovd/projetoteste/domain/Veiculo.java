package com.ovd.projetoteste.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "veiculo")
public class Veiculo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ")
	@SequenceGenerator(name = "SEQ", sequenceName = "GEN_VEICULO_ID", allocationSize = 1)
	private Integer id;
	private String placa;
	private String marca;
	private String cor;

	@OneToMany(mappedBy = "veiculo", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Permanencia> permanencias;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public List<Permanencia> getPermanencias() {
		return permanencias;
	}

	public void setPermanencias(List<Permanencia> permanencias) {
		this.permanencias = permanencias;
	}
}
