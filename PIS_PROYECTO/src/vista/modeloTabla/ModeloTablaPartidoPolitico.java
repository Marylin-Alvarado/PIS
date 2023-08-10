/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.modeloTabla;

import controlador.DAO.CandidatoDao;
import controlador.ed.listas.ListaEnlazada;
import javax.swing.table.AbstractTableModel;
import modelo.Candidato;
import modelo.PartidoPolitico;

/**
 *
 * @author cobos
 */
public class ModeloTablaPartidoPolitico extends AbstractTableModel{
    
    private ListaEnlazada<PartidoPolitico> datos = new ListaEnlazada<>();

    public ListaEnlazada<PartidoPolitico> getDatos() {
        return datos;
    }

    public void setDatos(ListaEnlazada<PartidoPolitico> datos) {
        this.datos = datos;
    }
    
    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int arg0, int arg1) {
        PartidoPolitico p = null;
        try {
            p = datos.obtener(arg0);
        } catch (Exception e) {
        }
        switch(arg1){
            case 0: return p.getId_partidoPolitico()+1;
            case 1: return p.getNombre_partidoPolitico();
            case 2: return p.getNumero_candidatos();
            default: return null;
        }
        
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:return "ID";
            case 1:return "Nombre Partido";
            case 2:return "Numero Candidatos";
            default: return null;
        }
    }
    
    
    
}
