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
public class PosicionNoEncontradaException extends Exception {

    /**
     * 
     * @param msg 
     */
    public PosicionNoEncontradaException(String msg) {
        super(msg);
    }

    /**
     * 
     */
    public PosicionNoEncontradaException() {
        super("La posicion esta fuera de los limites");
    }

}
