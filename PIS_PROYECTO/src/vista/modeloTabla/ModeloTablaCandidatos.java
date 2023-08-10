/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.modeloTabla;

import controlador.ed.listas.ListaEnlazada;
import controlador.ed.listas.exception.ListaNullException;
import controlador.ed.listas.exception.PosicionNoEncontradaException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import modelo.Candidato;
import vista.Utilidades.Utilidades;

public class ModeloTablaCandidatos extends AbstractTableModel{
    private ListaEnlazada<Candidato> candidatos = new ListaEnlazada<>();
   
    public ListaEnlazada<Candidato> getCandidatos() {
        return candidatos;
    }

    public void setCandidatos(ListaEnlazada<Candidato> candidatos) {
        this.candidatos = candidatos;
    }
    
    @Override
    public int getRowCount() {
        return candidatos.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "ID";
            case 1: return "Nombre";
            case 2: return "Partido Político";
            default: return null;
        }
    }

    @Override
    public Object getValueAt(int arg0, int arg1) {
        Candidato c = null;
        try {
            c = candidatos.obtener(arg0);
        } catch (Exception e) {
            System.out.println(e);
        }
        switch(arg1){
            case 0: 
                return arg0 + 1;
            case 1:
                return (c != null) ? c.getNombre_candidato() : "No definido";
            case 2:
            {
                try {
                    return (c != null) ? Utilidades.retornarPartidoCandidato(c) : "No definido";
                } catch (PosicionNoEncontradaException ex) {
                    Logger.getLogger(ModeloTablaCandidatos.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ListaNullException ex) {
                    Logger.getLogger(ModeloTablaCandidatos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            default: return null;
        }
        
    }
}
