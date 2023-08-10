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
public class IntentoExcedidoException extends Exception{

    public IntentoExcedidoException(String msg) {
        super(msg);
    }
    
    public IntentoExcedidoException() {
        super("El intento de ingresar se ha excedido");
    }
}
