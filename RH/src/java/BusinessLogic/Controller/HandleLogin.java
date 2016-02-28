/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic.Controller;

import DataAccess.DAO.UserDAO;
import DataAccess.Entity.User;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author Alejandro
 */
public class HandleLogin {

    public String doLogin(String user, String password) {

        UserDAO userDAO = new UserDAO();
        User userObject = userDAO.searchByUsername(user);
        if (userObject != null) {
            if (!userObject.getPassword().equals(password)) {
                return "La contraseña digitada NO es la de el usuario " + userObject.getName();
            } else {
                try {
                    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
                    ec.getSessionMap().put("user", userObject.getName() + " " + userObject.getLastname());
                    ec.getSessionMap().put("role", userObject.getFkroleID().getName());
                    String url = "";
                    if (userObject.getFkroleID().getName().equals("Administrator")) {
                        url = ec.encodeActionURL(
                                FacesContext.getCurrentInstance().getApplication().getViewHandler().getActionURL(FacesContext.getCurrentInstance(), "/administration/adminPanel.xhtml"));
                                
                    } else {
                        url = ec.encodeActionURL(
                                FacesContext.getCurrentInstance().getApplication().getViewHandler().getActionURL(FacesContext.getCurrentInstance(), "/empleado/empleadoPanel.xhtml"));
                    }
                    ec.redirect(url);
                    return "Logueando...";
                } catch (IOException ex) {
                    return "Error en redireccionamiento";
                }
            }
        } else {
            return "El usuario no existe";
        }
    }

    public void doLogout() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            ExternalContext extContext = context.getExternalContext();
            extContext.getSessionMap().remove("user");
            extContext.getSessionMap().remove("role");
            extContext.redirect(extContext.getRequestContextPath());
        } catch (IOException ex) {
            Logger.getLogger(HandleLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
