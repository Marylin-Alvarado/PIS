/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Utilidades;


import controlador.DAO.AdaptadorDAO;
import controlador.DAO.PartidoPoliticoDao;
import controlador.ed.listas.ListaEnlazada;
import controlador.ed.listas.exception.ListaNullException;
import controlador.ed.listas.exception.PosicionNoEncontradaException;
import javax.swing.JComboBox;
import modelo.PartidoPolitico;
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

<<<<<<< HEAD
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

    
    public static void cargarPartido(JComboBox cbx , PartidoPoliticoDao pd) throws ListaNullException, PosicionNoEncontradaException{
        cbx.removeAllItems();
        ListaEnlazada<PartidoPolitico> lista = pd.ordenarNombre(pd.listar(), 0);
        for (int i = 0; i < lista.size(); i++) {
            cbx.addItem(lista.obtener(i).getNombre_partidoPolitico());
        }
    }
    /**
     * Este metodo me permite generar la fecha 
     */

    /**
     * Este metodo me permite generar la fecha
     * @return
     */
    public String generarFechaActual(){
     Date fechaHoraActual = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        String fechaActual = formatoFecha.format(fechaHoraActual);
       
return fechaActual ;
=======
    /**
     * Este metodo me permite generar la fecha 
     */
    
     public static JComboBox cargarComboTipoVoto(JComboBox cbx) {
        cbx.removeAllItems();
        for (TipoVoto tipo: TipoVoto.values()) {
            cbx.addItem(tipo);
        }
        return cbx;
>>>>>>> Wilson-Gonzales
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
