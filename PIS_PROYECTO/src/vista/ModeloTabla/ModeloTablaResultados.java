/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.ModeloTabla;

import controlador.ed.listas.ListaEnlazada;
import javax.swing.event.EventListenerList;
import javax.swing.table.AbstractTableModel;
import modelo.Candidato;
import modelo.Resultados;
import vista.Utilidades.Utilidades;

/**
 *
 * @author Marylin
 */
public class ModeloTablaResultados extends AbstractTableModel {

    private ListaEnlazada<Resultados> resultado = new ListaEnlazada<>();
    private ListaEnlazada<Candidato> candidato = new ListaEnlazada<>();

    public ListaEnlazada<Candidato> getCandidato() {
        return candidato;
    }

    public void setCandidato(ListaEnlazada<Candidato> candidato) {
        this.candidato = candidato;
    }

    public EventListenerList getListenerList() {
        return listenerList;
    }

    public void setListenerList(EventListenerList listenerList) {
        this.listenerList = listenerList;
    }

    public ListaEnlazada<Resultados> getResultado() {
        return resultado;
    }

    public void setResultado(ListaEnlazada<Resultados> resultado) {
        this.resultado = resultado;
    }

    @Override
    public int getRowCount() {
        return resultado.getSize();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Nombre Candidato";
            case 2:
                return "Voto";
            
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Resultados r = null;
        try {
            r = resultado.obtener(rowIndex);
        } catch (Exception e) {
        }
        switch (columnIndex) {
            case 0:
                return r.getId();
            case 1:
                return r.getId_candidato();
            case 2:
                return r.getId_voto();
            
            default:
                return null;
        }

    }

}
