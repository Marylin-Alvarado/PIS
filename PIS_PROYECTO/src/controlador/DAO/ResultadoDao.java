/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.DAO;

import controlador.ed.listas.ListaEnlazada;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;
import modelo.Candidato;
import modelo.Resultados;

/**
 *
 * @author Marylin
 */
public class ResultadoDao extends AdaptadorDAO<Resultados> {

    /**
     * Atributo de resultado
     */
    private Resultados resultado;

    /**
     * Constructor de resultado dao
     */
    public ResultadoDao() {
        super(Resultados.class);
    }

    /**
     * Metodo de get de resultados
     * @return 
     */
    public Resultados getResultados() {
        if (resultado == null) {
            resultado = new Resultados();
        }
        return resultado;
    }
    /**
     * Metodo de modificar
     * @return
     * @throws Exception 
     */
    public boolean modificar() throws Exception {
        this.modificar(resultado);
        return true;
    }
    /**
     * Metodo de set de resultados
     * @param papeleta 
     */

    public void setResultados(Resultados papeleta) {
        this.resultado = papeleta;
    }

    /**
     * Metodo de guardar resultados
     * @param resultados
     * @throws Exception 
     */
    public void guardarResultados(Integer resultados) throws Exception {
        getResultados().setId(resultados);
        guardar(resultado);
    }
    /**
     * Metodo de guardar
     * @return
     * @throws Exception 
     */
    public Integer guardar() throws Exception {
       
        return this.guardar(resultado);
    }

    

   

}
