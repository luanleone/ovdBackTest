package com.ovd.projetoteste.dto;

import com.ovd.projetoteste.domain.Veiculo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class VeiculoDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String placa;
    private String marca;
    private String cor;
    private List<PermanenciaDto> permanencias;

    public VeiculoDto() {
    }

    public VeiculoDto(Veiculo veiculo) {
        this.id = veiculo.getId();
        this.placa = veiculo.getPlaca();
        this.marca = veiculo.getMarca();
        this.cor = veiculo.getCor();
        if (veiculo.getPermanencias() != null) {
            this.permanencias = new ArrayList<>();
            veiculo.getPermanencias().forEach(permanencia -> this.permanencias.add(new PermanenciaDto(permanencia)));
        }
    }

    public VeiculoDto(Integer id, String placa, String marca, String cor, List<PermanenciaDto> permanencias) {
        this.id = id;
        this.placa = placa;
        this.marca = marca;
        this.cor = cor;
        this.permanencias = permanencias;
    }

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

    public List<PermanenciaDto> getPermanencias() {
        return permanencias;
    }

    public void setPermanencias(List<PermanenciaDto> permanencias) {
        this.permanencias = permanencias;
    }
}
