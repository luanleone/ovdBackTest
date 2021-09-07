package com.ovd.projetoteste.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "permanencia")
public class Permanencia implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ")
    @SequenceGenerator(name = "SEQ", sequenceName = "GEN_PERMANENCIA_ID", allocationSize = 1)
    private Integer id;
    private String permanencia;
    private String categ;
    private String entrada;
    private String nome;
    private Double valorUnitario;

    @JoinColumn(name = "veuculo_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Veiculo veiculo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermanencia() {
        return permanencia;
    }

    public void setPermanencia(String permanencia) {
        this.permanencia = permanencia;
    }

    public String getCateg() {
        return categ;
    }

    public void setCateg(String categ) {
        this.categ = categ;
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
}
