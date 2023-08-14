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
public class intentoExcedidoException extends Exception{

    /**
     * 
     * @param msg 
     */
    public intentoExcedidoException(String msg) {
        super(msg);
    }
    
    /**
     * 
     */
    public intentoExcedidoException() {
        super("El intento de ingresar se ha excedido");
    }
}
