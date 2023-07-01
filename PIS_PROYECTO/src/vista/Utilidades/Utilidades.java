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

/**
 *
 * @author Marylin
 */
public class Utilidades {

    private static Integer posicionAdministrador;

    public static void generarUsuario(Persona persona) {
        persona.getCuenta().setUsuario(persona.getNombres() + "." + persona.getApellidos());
    }

    public static void generarContrasenia(Persona persona) {
        persona.getCuenta().setContrasenia(persona.getIdentificacion());
    }

    // Aqui se van a implementar los metodos de guardar y listar
    /**
     * Metodo para cargar los generos que se encuentran en un enum dentro de un
     * JComboBox
     *
     * @param cbx
     * @return
     */
    public static JComboBox cargarComboGenero(JComboBox cbx) {
        cbx.removeAllItems();
        for (Generos genero : Generos.values()) {
            cbx.addItem(genero);
        }
        return cbx;
    }

    public static Generos getComboGenero(JComboBox cbx) {
        return (Generos) cbx.getSelectedItem();
    }

    public static JComboBox cargarTipoIdentificacion(JComboBox cbx) {
        cbx.removeAllItems();
        for (TipoIdentificacion identifiacion : TipoIdentificacion.values()) {
            cbx.addItem(identifiacion);
        }
        return cbx;
    }
    
    public String generarFechaActual(){
     Date fechaHoraActual = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        String fechaActual = formatoFecha.format(fechaHoraActual);
         SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
        String horaActual = formatoHora.format(fechaHoraActual);
      
     return fechaActual +" " + horaActual ;  
    }

}
