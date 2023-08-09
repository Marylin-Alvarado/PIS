/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Utilidades;


import javax.swing.JComboBox;
import modelo.Persona;
import modelo.enums.Generos;
import modelo.enums.TipoIdentificacion;
import java.util.Date;
import java.text.SimpleDateFormat;
import modelo.TipoVoto;

/**
 *
 * @author Marylin
 */
public class Utilidades {

    /**
     * Este metodo me permite generar la fecha 
     */
    
     public static JComboBox cargarComboTipoVoto(JComboBox cbx) {
        cbx.removeAllItems();
        for (TipoVoto tipo: TipoVoto.values()) {
            cbx.addItem(tipo);
        }
        return cbx;
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
