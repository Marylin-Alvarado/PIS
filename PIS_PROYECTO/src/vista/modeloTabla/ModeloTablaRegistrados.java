/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.modeloTabla;

import controlador.ed.listas.ListaEnlazada;
import javax.swing.table.AbstractTableModel;
import modelo.Cuenta;
import modelo.Persona;

/**
 *
 * @author Edison
 */
public class ModeloTablaRegistrados extends AbstractTableModel{

    private ListaEnlazada<Persona> lista = new ListaEnlazada<>();    

    public ListaEnlazada<Persona> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada<Persona> lista) {
        this.lista = lista;
    }
    
    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public String getColumnName(int i) {
        
        switch(i) {
            case 0: return"id";
            case 1: return "Nombres Completos";   
            case 2: return "Correo Electronico";
            case 3: return "Codigo Dactilar";
            case 4: return "Numero de Cedula";
            case 5: return "Fecha de nacimiento";
            default: return null;

        }
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Persona s = null;
        try {
            s = lista.obtener(i);
        } catch (Exception e) {
        }
        switch(i1) {
            
            case 0: return (s != null)? s.getId():"-";
            case 1: return (s != null)? s.getNombres_completos():"NO DEFINIDO";
            case 2: return (s != null)? s.getCorreo():"NO DEFINIDO";
            case 3: return (s != null)? s.getCodigoDac():"NO DEFINIDO";
            case 4: return (s != null)? s.getIdentificacion():"NO DEFINIDO";
            case 5: return (s != null)? s.getFechaNacimiento():"NO DEFINIDO";
            
   
            default: return null;
        }
    }
    
}
