/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uda.sessionbean;

import com.uda.model.Archivo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Anticlutch
 */
@Stateless
public class ArchivoFacade extends AbstractFacade<Archivo> {

    @PersistenceContext(unitName = "com.uda_ProyectoFinal_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ArchivoFacade() {
        super(Archivo.class);
    }
    
}
