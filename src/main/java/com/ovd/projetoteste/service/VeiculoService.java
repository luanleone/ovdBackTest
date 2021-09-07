package com.ovd.projetoteste.service;

import com.ovd.projetoteste.domain.Veiculo;
import com.ovd.projetoteste.dto.VeiculoDto;
import com.ovd.projetoteste.persistence.JpaVeiculoDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VeiculoService {


    public List<VeiculoDto> listarVeiculosDto() {
        JpaVeiculoDao veiculoDao = new JpaVeiculoDao();
        List<Veiculo> lista = veiculoDao.listarVeiculos();
        Map<String, VeiculoDto> mapVeiculo = new HashMap<>();
        lista.forEach((veiculo) -> {
            VeiculoDto veiculoDto = new VeiculoDto(veiculo);
            VeiculoDto veiculoAdd = new VeiculoDto(veiculo);
            veiculoAdd.setPermanencias(new ArrayList<>());
            if (veiculoDto.getPermanencias() != null) {
                veiculoDto.getPermanencias().forEach(permanenciaDto -> {
                    String key = veiculoDto.getPlaca() + "-" + permanenciaDto.getNome();
                    mapVeiculo.putIfAbsent(key, veiculoAdd);
                    mapVeiculo.get(key).getPermanencias().add(permanenciaDto);
                });
            }
        });
        return new ArrayList<>(mapVeiculo.values());
    }

    public void inserirVeiculo(VeiculoDto veiculoDto) {
        JpaVeiculoDao veiculoDao = new JpaVeiculoDao();

        Veiculo veiculo = new Veiculo();
        veiculo.setPlaca(veiculoDto.getPlaca());
        veiculo.setMarca(veiculoDto.getMarca());
        veiculo.setCor(veiculoDto.getCor());
        if(veiculoDto.getId() == null) {
            veiculo.setId(veiculoDao.inserirVeiculo(veiculo));
        } else {
            veiculo.setId(veiculoDto.getId());
        }

        if (veiculoDto.getPermanencias() != null) {
            veiculoDto.getPermanencias().forEach((per) -> new PermanenciaService().inserirPermanencia(per, veiculo));
        }
    }

    public void inserirVeiculoLista(List<VeiculoDto> lista) {
        if (lista != null) {
            lista.forEach((this::inserirVeiculo));
        }
    }
}
