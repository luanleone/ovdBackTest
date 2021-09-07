package com.ovd.projetoteste.persistence;

import com.ovd.projetoteste.domain.Permanencia;

import java.util.List;

public class JpaPermanenciaDao extends JpaDao {

    public int inserirPermanencia(Permanencia permanencia) {
        getEntityManager().getTransaction().begin();
        getEntityManager().persist(permanencia);
        getEntityManager().getTransaction().commit();
        if (permanencia.getId() != null) {
            return permanencia.getId();
        }
        return ((Permanencia) getEntityManager().createQuery("from permanencia order by id desc")
                .setMaxResults(1).getResultList().get(0)).getId();
    }
}
