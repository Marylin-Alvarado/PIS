/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Utilidades;

import controlador.DAO.DignidadDao;
import controlador.DAO.PartidoPoliticoDao;
import controlador.ed.listas.ListaEnlazada;
import controlador.ed.listas.exception.ListaNullException;
import controlador.ed.listas.exception.PosicionNoEncontradaException;
import javax.swing.JComboBox;

/**
 *
 * @author Marylin
 */
public class Utilidades {

        cbx.removeAllItems();
        ListaEnlazada<Partido_Politico> lista = pd.ordenarNombre(pd.listar(), 0);
        for (int i = 0; i < lista.size(); i++) {
            cbx.addItem(lista.obtener(i).getNombre_partido_politico());
        }
    }

    
    public static void cargarDignidad(JComboBox cbx , DignidadDao dd) throws ListaNullException, PosicionNoEncontradaException{
        cbx.removeAllItems();
        ListaEnlazada<Dignidad> lista = dd.ordenarCategoria(dd.listar());
        for (int i = 0; i < lista.size(); i++) {
            cbx.addItem(lista.obtener(i).getTipo());
        }
    }

    }
     
     public static TipoVoto getComboTipoVoto(JComboBox cbx) {
        return  (TipoVoto) cbx.getSelectedItem();
    }
     

     
    public Date generarFechaActual(){
     Date fechaHoraActual = new Date();
        System.out.println(fechaHoraActual);
     return fechaHoraActual ;  
    }
    
    public static String cambiarFechaActualString(Date date){
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
     return formatoFecha.format(date); 
    }
    
}
