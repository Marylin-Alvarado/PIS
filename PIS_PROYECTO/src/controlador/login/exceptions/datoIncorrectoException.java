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

    public datoIncorrectoException(String msg) {
        super(msg);
    }
    
    public datoIncorrectoException(Integer limite) {
        super("Datos incorrectos \n"
                + "Número de intentos disponibles: " + limite);
    }
}
