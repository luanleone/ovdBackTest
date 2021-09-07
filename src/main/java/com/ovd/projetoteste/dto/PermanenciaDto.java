package com.ovd.projetoteste.dto;

import com.ovd.projetoteste.domain.Permanencia;

import java.io.Serializable;

public class PermanenciaDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String permanencia;
    private String categ;
    private String entrada;
    private String nome;
    private Double valorUnitario;

    public PermanenciaDto() {
    }

    public PermanenciaDto(Permanencia permanencia) {
        this.id = permanencia.getId();
        this.permanencia = permanencia.getPermanencia();
        this.categ = permanencia.getCateg();
        this.entrada = permanencia.getEntrada();
        this.nome = permanencia.getNome();
        this.valorUnitario = permanencia.getValorUnitario();
    }

    public PermanenciaDto(Integer id, String permanencia, String categ, String entrada, String nome, Double valorUnitario) {
        this.id = id;
        this.permanencia = permanencia;
        this.categ = categ;
        this.entrada = entrada;
        this.nome = nome;
        this.valorUnitario = valorUnitario;
    }

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

}
