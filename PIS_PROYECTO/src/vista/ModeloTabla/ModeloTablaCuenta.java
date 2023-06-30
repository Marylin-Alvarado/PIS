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
public class ModeloTablaCuenta extends AbstractTableModel {

    ListaEnlazada<Cuenta> cuentas = new ListaEnlazada<>();

    @Override
    public int getRowCount() {
        return cuentas.getSize();
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
                return "Usuario";
            case 2:
                return "Tipo de Cuenta";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cuenta c = null;
        try {
            c = cuentas.obtener(rowIndex);
        } catch (Exception e) {
            System.out.println("Error en getValueAt : " + e);
        }
        switch (columnIndex) {
            case 0:
                return (rowIndex + 1);
            case 1:
                return (c != null) ? c.getUsuario() : "No definido";
            case 2:
                return (c != null) ? c.getTipoUser() : "No definido";
            default:
                return null;
        }
    }

    public ListaEnlazada<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(ListaEnlazada<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

}
