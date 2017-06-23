/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uda.sessionbean;

import com.uda.model.Carrera;
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
public class CarreraFacade extends AbstractFacade<Carrera> {

    @PersistenceContext(unitName = "com.uda_ProyectoFinal_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    } 

    public CarreraFacade() {
        super(Carrera.class);
    }
    
    public List<Carrera> findByFacultyId(Facultad facultadId){
        Query query=em.createNamedQuery("Carrera.findByFacultyId");
        query.setParameter("facultadId", facultadId);
        return query.getResultList();
    }
}
