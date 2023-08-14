/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.ed.listas.exception;

/**
 *
 * @author Marylin
 */
public class ListaNullException extends Exception {

    /**
     * 
     * @param msg 
     */
    public ListaNullException(String msg) {
        super(msg);
    }

    /**
     * 
     */
    public ListaNullException() {
        super("La lista esta vacia");
    }

}
