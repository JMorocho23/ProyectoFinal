/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uda.sessionbean;

import com.uda.model.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Anticlutch
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "com.uda_ProyectoFinal_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
  public boolean loginControl(String nombreUsuario, String password){
        
      try{           
           // Usuario L = em.createNamedQuery("Usuario.control",Usuario.class).setParameter("nombreUsuario", nombreUsuario).setParameter("password", password).getSingleResult();
            Query query = em.createNamedQuery("Usuario.loginControl");
            query.setParameter("nombreUsuario", nombreUsuario).setParameter("password", password);
            
            //System.out.println(query.getSingleResult());
            
            if(query.getSingleResult() != null){
                return true;
            }else{
                return false;
            }

        }catch(Exception e){
            return false;
        }
    }
}
