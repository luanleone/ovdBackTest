package com.ovd.projetoteste.service;

import com.ovd.projetoteste.domain.Permanencia;
import com.ovd.projetoteste.domain.Veiculo;
import com.ovd.projetoteste.dto.PermanenciaDto;
import com.ovd.projetoteste.persistence.JpaPermanenciaDao;

import java.util.ArrayList;
import java.util.List;

public class PermanenciaService {

    public void inserirPermanencia(PermanenciaDto permanenciaDto, Veiculo veiculo) {
        JpaPermanenciaDao permanenciaDao = new JpaPermanenciaDao();

        Permanencia permanencia = new Permanencia();
        permanencia.setVeiculo(veiculo);

        permanencia.setId(permanenciaDto.getId());
        permanencia.setCateg(permanenciaDto.getCateg());
        permanencia.setEntrada(permanenciaDto.getEntrada());
        permanencia.setNome(permanenciaDto.getNome());
        permanencia.setPermanencia(permanenciaDto.getPermanencia());
        permanencia.setValorUnitario(permanenciaDto.getValorUnitario());

        if(permanencia.getId() == null) {
            permanencia.setId(permanenciaDao.inserirPermanencia(permanencia));
        }

    }
}
