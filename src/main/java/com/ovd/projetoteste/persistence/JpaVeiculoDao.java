package com.ovd.projetoteste.persistence;

import com.ovd.projetoteste.domain.Veiculo;

import javax.transaction.Transactional;
import java.util.List;

public class JpaVeiculoDao extends JpaDao {

    @SuppressWarnings("unchecked")
    public List<Veiculo> listarVeiculos() {
        return getEntityManager().createQuery("from Veiculo").getResultList();
    }

    @Transactional
    public int inserirVeiculo(Veiculo veiculo) {
        getEntityManager().getTransaction().begin();
        getEntityManager().persist(veiculo);
        getEntityManager().flush();
        getEntityManager().getTransaction().commit();
        if (veiculo.getId() != null) {
            return veiculo.getId();
        }
        return lastId();
    }

    public int lastId() {
        List<Veiculo> lista = getEntityManager().createQuery("from Veiculo order by id desc")
                .setMaxResults(1).getResultList();
        if (lista.isEmpty()) {
            return 0;
        }
        return lista.get(0).getId();
    }
}
