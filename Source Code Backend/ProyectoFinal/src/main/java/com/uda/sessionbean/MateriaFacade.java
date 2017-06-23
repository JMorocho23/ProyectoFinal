/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uda.sessionbean;

import com.uda.model.Carrera;
import com.uda.model.Materia;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Anticlutch
 */
@Stateless
public class MateriaFacade extends AbstractFacade<Materia> {

    @PersistenceContext(unitName = "com.uda_ProyectoFinal_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MateriaFacade() {
        super(Materia.class);
    }
    
    public List<Materia> findByCarreraId(Carrera carreraId){
        Query query=em.createNamedQuery("Materia.findByCarreraId");
        query.setParameter("carreraId", carreraId);
        return query.getResultList();
    }    
}
