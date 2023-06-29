/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador.Utilidades.listas.ListaEnlazada;
import modelo.Administrador;

/**
 *
 * @author Marylin
 */
public class AdministradorController {

    ListaEnlazada<Administrador> administradorList = new ListaEnlazada<>();

    Administrador administrador = new Administrador();

    public ListaEnlazada<Administrador> getAdministradorList() {
        return administradorList;
    }

    public void setAdministradorList(ListaEnlazada<Administrador> administradorList) {
        this.administradorList = administradorList;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAlumno(Administrador administrador) {
        this.administrador = administrador;
    }

    public void generarUsuario() {
        
       // getAdministrador().getCuenta().setUsuario(getAdministrador().getNombre() + "." + getAdministrador().getApellido());
    }

    public void generarContrasenia() {
       // getAdministrador().getCuenta().setContrasenia(getAdministrador().getNombre() + "-" + getAdministrador().getApellido() + "password");
    }

    public void setAdministrador(Administrador obtener) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
