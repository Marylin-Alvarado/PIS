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
public class datoIncorrectoException extends Exception{

    /**
     * 
     * @param msg 
     */
    public datoIncorrectoException(String msg) {
        super(msg);
    }
    
    /**
     * 
     * @param limite 
     */
    public datoIncorrectoException(Integer limite) {
        super("Datos incorrectos \n"
                + "Número de intentos disponibles: " + limite);
    }
}
