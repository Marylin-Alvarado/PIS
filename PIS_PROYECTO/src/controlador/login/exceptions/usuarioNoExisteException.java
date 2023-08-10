/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.login.exceptions;

/**
 *
 * @author Edison
 */
public class UsuarioNoExisteException extends Exception{

    public UsuarioNoExisteException(String msg) {
        super(msg);
    }
    
    public UsuarioNoExisteException() {
        super("No existe el usuario");
    }
    
}
