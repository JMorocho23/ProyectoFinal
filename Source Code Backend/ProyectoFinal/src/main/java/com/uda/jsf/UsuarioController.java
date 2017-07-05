package com.uda.jsf;

import com.uda.model.Usuario;
import com.uda.jsf.util.JsfUtil;
import com.uda.jsf.util.JsfUtil.PersistAction;
import com.uda.jsf.util.SessionUtils;
import com.uda.sessionbean.UsuarioFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;

@Named("usuarioController")
@ManagedBean(name="usuarioController")
@SessionScoped
public class UsuarioController implements Serializable {

    @EJB
    private com.uda.sessionbean.UsuarioFacade ejbFacade;
    private List<Usuario> items = null;
    private Usuario selected;
    private String cnombreUsuario;
    private String cpassword;
    private String cusuario;

    public String getCusuario() {
        return cusuario;
    }

    private UsuarioFacade query= new UsuarioFacade();


    public String getCnombreUsuario() {
        return cnombreUsuario;
    }

    public void setCnombreUsuario(String cnombreUsuario) {
        this.cnombreUsuario = cnombreUsuario;
    }

    public String getCpassword() {
        return cpassword;
    }

    public void setCpassword(String cpassword) {
        this.cpassword = cpassword;
    }
    
    public UsuarioController() {
    }

    public Usuario getSelected() {
        return selected;
    }

    public void setSelected(Usuario selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private UsuarioFacade getFacade() {
        return ejbFacade;
    }

    public Usuario prepareCreate() {
        selected = new Usuario();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("UsuarioCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query          
        }
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("swal('Usuario creado!','Bienvenido a AprendeFacil.','success')");  
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("UsuarioUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("UsuarioDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Usuario> getItems() {
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

    public Usuario getUsuario(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<Usuario> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Usuario> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Usuario.class)
    public static class UsuarioControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            UsuarioController controller = (UsuarioController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "usuarioController");
            return controller.getUsuario(getKey(value));
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
            if (object instanceof Usuario) {
                Usuario o = (Usuario) object;
                return getStringKey(o.getUsuarioId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Usuario.class.getName()});
                return null;
            }
        }
    }
    
    public String login(){
        RequestContext context = RequestContext.getCurrentInstance();
    
        boolean resu = getFacade().loginControl(cnombreUsuario, cpassword); 
        
        if(resu){
          //  System.out.println("if resu");
            cusuario=cnombreUsuario;
            
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("nombreUsuario", cnombreUsuario);
       
            context.execute("swal('Login exitoso!','Bienvenido! usted esta conectado','success')");
            return "Home.xhtml?faces-redirect=true";            
        }
        else{   
          //  System.out.println("else resu");
            context.execute("swal('Login fallido','El nombre de usuario y/o la contraseña que especificaste es incorrecto','error')");
        }
        
        if( cnombreUsuario.isEmpty() || cpassword.isEmpty()){
          if(cnombreUsuario.isEmpty()){
            context.execute ("swal('Login fallido','Por favor ingrese una usuario','warning')");
          }
          else{
            context.execute ("swal('Login fallido','Por favor ingrese un contraseña','warning')");
          }
        }
         
//        System.out.println(cnombreUsuario);
//        System.out.println(cpassword);
//        System.out.println("No paso");
        return "";            
    }
    
    public boolean isLoggedIn() {
        //System.out.println(cusuario);
        boolean is;

        if(cusuario == null){
            is=false;
        }
        else{
            is=true;
        }
        
        return is;
    }
    
    public String logout() {    
        HttpSession session = SessionUtils.getSession();
        session.invalidate();        
        //FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "Home.xhtml?faces-redirect=true";
    }
    
    
}
