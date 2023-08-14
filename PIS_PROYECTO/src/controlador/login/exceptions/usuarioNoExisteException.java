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
public class usuarioNoExisteException extends Exception{

    public usuarioNoExisteException(String msg) {
        super(msg);
    }
    
    public usuarioNoExisteException() {
        super("No existe el usuario");
    }
    
}
