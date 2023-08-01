/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.ModeloTabla;

import controlador.ed.listas.ListaEnlazada;
import controlador.ed.listas.exception.ListaVaciaException;
import javax.swing.table.AbstractTableModel;
import modelo.PartidoPolitico;

/**
 *
 * @author Marylin
 */
public class ModeloTablaRegistroPartido extends AbstractTableModel {

    ListaEnlazada<PartidoPolitico> cargo = new ListaEnlazada();

    public ListaEnlazada<PartidoPolitico> getCargo() {
        return cargo;
    }

    public void setLista(ListaEnlazada<PartidoPolitico> cargo) {
        this.cargo = cargo;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public int getRowCount() {
        return cargo.size();
    }

    @Override
    public String getColumnName(int i) {

        switch (i) {
            case 0:
                return "Id";
            case 1:
                return "NombrePartido";
            case 2:
                return "Lista";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int i, int i1) {
        PartidoPolitico lb = null;
        try {
             lb = cargo.obtener(i);
            
        } catch (Exception e) {
            System.out.println(e);
        }
        switch (i1) {
            case 0:
                return (lb != null) ? lb.getId_partidoPolitico() : "NO DEFINIDO";
            case 1:
                return (lb != null) ? lb.getNombre_partidoPolitico(): "NO DEFINIDO";
            case 2:
                return (lb != null) ? lb.getNumero_Lista(): "NO DEFINIDO";
           
            default:
                return null;
        }

    }
    
}
