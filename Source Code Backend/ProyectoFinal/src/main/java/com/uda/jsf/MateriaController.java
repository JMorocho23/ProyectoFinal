package com.uda.jsf;

import com.uda.model.Materia;
import com.uda.jsf.util.JsfUtil;
import com.uda.jsf.util.JsfUtil.PersistAction;
import com.uda.model.Carrera;
import com.uda.sessionbean.MateriaFacade;

import java.io.Serializable;
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

@Named("materiaController")
@SessionScoped
public class MateriaController implements Serializable {

    @EJB
    private com.uda.sessionbean.MateriaFacade ejbFacade;
    private List<Materia> items = null;
    private Materia selected;

    public MateriaController() {
    }

    public Materia getSelected() {
        return selected;
    }

    public void setSelected(Materia selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
        selected.setMateriaPK(new com.uda.model.MateriaPK());
    }

    private MateriaFacade getFacade() {
        return ejbFacade;
    }

    public Materia prepareCreate() {
        selected = new Materia();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("MateriaCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("MateriaUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("MateriaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Materia> getItems() {
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

    public Materia getMateria(com.uda.model.MateriaPK id) {
        return getFacade().find(id);
    }

    public List<Materia> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Materia> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Materia.class)
    public static class MateriaControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            MateriaController controller = (MateriaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "materiaController");
            return controller.getMateria(getKey(value));
        }

        com.uda.model.MateriaPK getKey(String value) {
            com.uda.model.MateriaPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new com.uda.model.MateriaPK();
            key.setMateriaId(values[0]);
            //key.setCarreraId(Long.parseLong(values[1]));
            return key;
        }

        String getStringKey(com.uda.model.MateriaPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getMateriaId());
            sb.append(SEPARATOR);
            //sb.append(value.getCarreraId());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Materia) {
                Materia o = (Materia) object;
                return getStringKey(o.getMateriaPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Materia.class.getName()});
                return null;
            }
        }

    }
    
    public List<Materia> getItemsByCarrera(Carrera c) {
        return getFacade().findByCarreraId(c);
    }   

    public String showMateria(Materia m){
       setSelected(m);
       return "Materia.xhtml";
    }

}
