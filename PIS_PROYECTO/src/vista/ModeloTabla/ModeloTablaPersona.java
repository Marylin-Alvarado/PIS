/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.ModeloTabla;

import controlador.Utilidades.listas.ListaEnlazada;
import javax.swing.table.AbstractTableModel;
import modelo.Persona;

/**
 *
 * @author Marylin
 */
public class ModeloTablaPersona extends AbstractTableModel {

    private ListaEnlazada<Persona> persona = new ListaEnlazada<>();

    public ListaEnlazada<Persona> getPersona() {
        return persona;
    }

    public void setPersona(ListaEnlazada<Persona> persona) {
        this.persona = persona;
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public int getRowCount() {
        return persona.getSize();
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Nro";
            case 1:
                return "Tipo Identificacion";
            case 2:
                return "Identificacion";
            case 3:
                return "Nombre";
            case 4:
                return "Direccion";
            case 5:
                return "Correo";
            case 6:
                return "Rol";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Persona p = null;
        try {
            p = persona.obtener(rowIndex);
        } catch (Exception e) {
        }
        switch (columnIndex) {
            case 0:
                return (rowIndex + 1);
            case 1:
                return (p != null) ? p.getTipoIdentificacion().toString() : "NO DEFINIDO";
            case 2:
                return (p != null) ? p.getIdentificacion().toString() : "NO DEFINIDO";
            case 3:
                return (p != null) ? (p.getApellidos() + " " + p.getNombres()) : "NO DEFINIDO";
            case 4:
                return (p != null) ? p.getDireccion() : "NO DEFINIDO";
            case 5:
                return (p != null) ? p.getCorreo() : "NO DEFINIDO";
            default:

                return null;
        }
    }

}
