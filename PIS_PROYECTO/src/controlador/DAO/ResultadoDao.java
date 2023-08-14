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

    private Resultados resultado;

    public ResultadoDao() {
        super(Resultados.class);
    }

    public Resultados getResultados() {
        if (resultado == null) {
            resultado = new Resultados();
        }
        return resultado;
    }
    public boolean modificar() throws Exception {
        this.modificar(resultado);
        return true;
    }

    public void setResultados(Resultados papeleta) {
        this.resultado = papeleta;
    }

    public void guardarResultados(Integer resultados) throws Exception {
        getResultados().setId(resultados);
        guardar(resultado);
    }
    public Integer guardar() throws Exception {
       
        return this.guardar(resultado);
    }

    

   

}
