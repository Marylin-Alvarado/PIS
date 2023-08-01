/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.ModeloTabla;

import controlador.ed.listas.ListaEnlazada;
import javax.swing.table.AbstractTableModel;
import modelo.Administrador;
import modelo.Persona;

/**
 *
 * @author Marylin
 */
public class ModeloTablaAdministrador extends AbstractTableModel {

    private ListaEnlazada<Persona> lista = new ListaEnlazada<>();
    private ListaEnlazada<Administrador> administrador = new ListaEnlazada<>();
    
    /**
     * Metodo getLista de Persona
     * @return 
     */
    public ListaEnlazada<Persona> getLista() {
        return lista;
    }

    /**
     * Metodo de setLista de Persona
     * @param lista 
     */
    public void setLista(ListaEnlazada<Persona> lista) {
        this.lista = lista;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public int getRowCount() {
        return lista.getSize();
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Nro";
            case 1:
                return "Usuario";
            case 2:
                return "Nombre";
            case 3:
                return "Identificiacion";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Persona p = null;
        try {
            p = lista.obtener(rowIndex);
        } catch (Exception e) {
        }
        switch (columnIndex) {
            case 0:
                return (rowIndex + 1);
            case 1:
                return (p != null) ? p.getCuenta().toString() : "NO DEFINIDO";
            case 2:
                return (p != null) ? p.getNombres().toString() : "NO DEFINIDO";
            case 3:
                return (p != null) ? p.getIdentificacion().toString() : "NO DEFINIDO";
            default:

                return null;
        }
    }

}
