/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.ModeloTabla;

import controlador.ed.listas.ListaEnlazada;
import javax.swing.table.AbstractTableModel;

import modelo.Voto;
/**
 *
 * @author Gonzalez G
 */
public class ModeloTablaVoto  extends AbstractTableModel {
    private ListaEnlazada<Voto> lista = new ListaEnlazada<>();

    public ListaEnlazada<Voto> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada<Voto> lista) {
        this.lista = lista;
    }
    
    @Override
    public int getRowCount() {
       return lista.getSize();
    }

    @Override
    public int getColumnCount() {
        return 5 ;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
Voto  v= null;
        try {
            v = lista.obtener(rowIndex);
        } catch (Exception e) {
        }
        switch (columnIndex) {
            case 0: return v.getId();
            case 1 : return v.getTipoVoto();
            case 2 : return v.getEstado();
            case 3 : return v.getFechadeEmision();
            default:
                return null;
        }

    }
    
    @Override
    public String  getColumnName (int column){
    switch (column) {
            case 0: return"ID";
            case 1 :return "TIPO";
            case 2 : return"ESTADO";
            case 3 :return "FECHA  HORA";
            default:return null;
        }
    }
}


