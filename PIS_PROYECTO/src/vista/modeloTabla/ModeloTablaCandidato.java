/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.modeloTabla;

import controlador.DAO.PartidoPoliticoDao;
import controlador.ed.listas.ListaEnlazada;
import javax.swing.table.AbstractTableModel;
import modelo.Candidato;

/**
 *
 * @author cobos
 */
public class ModeloTablaCandidato extends AbstractTableModel{

    private ListaEnlazada<Candidato> datos = new ListaEnlazada<>();

    public ListaEnlazada<Candidato> getDatos() {
        return datos;
    }

    public void setDatos(ListaEnlazada<Candidato> datos) {
        this.datos = datos;
    }
    
    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int arg0, int arg1) {
        Candidato c = null;
        try {
            c = datos.obtener(arg0);
        } catch (Exception e) {
        }
        switch(arg1){
            case 0: return(arg0+1);
            case 1: return c.getNombre_candidato();
            case 2: return c.getPreparacion_candidato();
            case 3: return new PartidoPoliticoDao().obtener(c.getId_partido());
            default: return null;
        }
        
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "ID";
            case 1: return "Nombre Candidato";
            case 2: return "Preparacion Candidato";
            case 3: return "Partido Politico";
            default: return null;
        }
    }
    
}
