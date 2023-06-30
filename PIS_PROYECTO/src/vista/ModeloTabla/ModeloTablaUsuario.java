/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.ModeloTabla;

import controlador.Utilidades.listas.ListaEnlazada;
import javax.swing.table.AbstractTableModel;
import modelo.Cuenta;

/**
 *
 * @author Marylin
 */
public class ModeloTablaUsuario extends AbstractTableModel {

    private ListaEnlazada<Cuenta> cuenta = new ListaEnlazada<>();

    public ListaEnlazada<Cuenta> getCuenta() {
        return cuenta;
    }

    public void setCuenta(ListaEnlazada<Cuenta> cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public int getRowCount() {
        return cuenta.getSize();
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Nro";
            case 1:
                return "Usuario";
            case 2:
                return "Correo";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cuenta c = null;
        try {
            c = cuenta.obtener(rowIndex);
        } catch (Exception e) {
        }
//        switch (columnIndex) {
//            case 0:
//                return (rowIndex + 1);
//            case 1:
//                return (c != null) ? c.getUsuario().toString() : "NO DEFINIDO";
//            case 2:
//                return (c != null) ? c.getCorreo() : "NO DEFINIDO";
//            
//            default:
//            
        return null;
//        }
    }

}
