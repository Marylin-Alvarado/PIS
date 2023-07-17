/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.ModeloTabla;

import controlador.ed.listas.ListaEnlazada;
import javax.swing.table.AbstractTableModel;
import modelo.Dignidad;

import modelo.Voto;
/**
 *
 * @author Gonzalez G
 */
public class ModeloTablaDignidad  extends AbstractTableModel {
    private ListaEnlazada<Dignidad> lista = new ListaEnlazada<>();

    public ListaEnlazada<Dignidad> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada<Dignidad> lista) {
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
Dignidad  v= null;
        try {
            v = lista.obtener(rowIndex);
        } catch (Exception e) {
        }
        switch (columnIndex) {
            case 0: return v.getId();
            case 1 : return v.getTipo();
            case 2: return v.getCategorias();
            case 3 : return v.getNrocupos();
            default:
                return null;
        }

    }
    
    @Override
    public String  getColumnName (int column){
    switch (column) {
            case 0: return"ID";
            case 1 :return "Categorias";
            case 2: return"tipo";
            case 3 : return"Nro Cupos";
            case 4 :return "Partido Politico";
            default:return null;
        }
    }
}


