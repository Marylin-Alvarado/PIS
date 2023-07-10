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
    
    public static void cargarPartido(JComboBox cbx , PartidoPoliticoDao pd) throws ListaNullException, PosicionNoEncontradaException{
        cbx.removeAllItems();
        ListaEnlazada<PartidoPolitico> lista = pd.ordenarNombre(pd.listar(), AdaptadorDAO.ASCENDENTE);
        for (int i = 0; i < lista.size(); i++) {
            cbx.addItem(lista.obtener(i).getNombre_partido());
        }
    }

}
