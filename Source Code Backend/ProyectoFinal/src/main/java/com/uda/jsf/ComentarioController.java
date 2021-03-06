package com.uda.jsf;

import com.uda.model.Comentario;
import com.uda.jsf.util.JsfUtil;
import com.uda.jsf.util.JsfUtil.PersistAction;
import com.uda.model.Materia;
import com.uda.model.Usuario;
import com.uda.sessionbean.ComentarioFacade;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("comentarioController")
@SessionScoped
public class ComentarioController implements Serializable {

    @EJB
    private com.uda.sessionbean.ComentarioFacade ejbFacade;
    private List<Comentario> items = null;
    private Comentario selected;

    public ComentarioController() {
    }

    public Comentario getSelected() {
        return selected;
    }

    public void setSelected(Comentario selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ComentarioFacade getFacade() {
        return ejbFacade;
    }

    public Comentario prepareCreate() {
        selected = new Comentario();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {      
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ComentarioCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ComentarioUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ComentarioDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Comentario> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Comentario getComentario(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<Comentario> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Comentario> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Comentario.class)
    public static class ComentarioControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ComentarioController controller = (ComentarioController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "comentarioController");
            return controller.getComentario(getKey(value));
        }

        java.lang.Long getKey(String value) {
            java.lang.Long key;
            key = Long.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Long value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Comentario) {
                Comentario o = (Comentario) object;
                return getStringKey(o.getComentarioId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Comentario.class.getName()});
                return null;
            }
        }
       
    }
    
    public void createCommentario(String id_materia, String id_usuario){
        Date date = new Date();
        selected.setFechaCommentario(date);
        
        System.out.println(id_materia);
        System.out.println(id_usuario);
       
        selected.setMateriaId(id_materia);
        selected.setNombreUsuario(id_usuario);
        this.create();
    }

}
