/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uda.sessionbean;

import com.uda.model.Universidad;
import com.uda.model.Facultad;
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
public class FacultadFacade extends AbstractFacade<Facultad> {

    @PersistenceContext(unitName = "com.uda_ProyectoFinal_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FacultadFacade() {
        super(Facultad.class);
    }
    
        public List<Facultad> findByUniversidadId(Universidad UNIVERSIDAD_ID){
        Query query=em.createNamedQuery("Universidad.findByUniversidadId");
        query.setParameter("UNIVERSIDAD_ID", UNIVERSIDAD_ID);
        return query.getResultList();
    }  
    
}
