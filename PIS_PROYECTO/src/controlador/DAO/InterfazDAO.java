/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.DAO;

import controlador.ed.listas.ListaEnlazada;
import controlador.ed.listas.exception.ListaNullException;
import controlador.ed.listas.exception.PosicionNoEncontradaException;
import java.io.IOException;

/**
 *
 * @author cobos
 */
public interface InterfazDAO <T>{
    /**
     * Metodo que permite realizar el guardaddo
     * @param obj Objeto del modelo
     * @return El id generado producto del guardado
     */
    public Integer guardar(T obj) throws Exception;
    /**
     * Permite modificar los datos en un repositorio de datos
     * @param obj Objeto a modificar     
     */
    public void modificar(T obj) throws Exception;
    /**
     * LIstado de objetos en la BD
     * @return Una ListaEnlazada
     */
    public ListaEnlazada<T> listar();
    public T obtener(Integer id);
      
}