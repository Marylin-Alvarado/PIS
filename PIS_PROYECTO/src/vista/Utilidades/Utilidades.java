/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Utilidades;


import controlador.DAO.PartidoPoliticoDao;
import controlador.ed.listas.ListaEnlazada;
import controlador.ed.listas.exception.ListaNullException;
import controlador.ed.listas.exception.PosicionNoEncontradaException;
import javax.swing.JComboBox;
import modelo.Candidato;
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
    /**
     * Retorn el Partido Politico al cual pertenece el Candidato
     * @param candidato
     * @return PartidoPolitico
     * @throws PosicionNoEncontradaException
     * @throws ListaNullException 
     */
    public static PartidoPolitico retornarPartidoCandidato(Candidato candidato) throws PosicionNoEncontradaException, ListaNullException{
        PartidoPoliticoDao ppd = new PartidoPoliticoDao();
        ListaEnlazada<PartidoPolitico> lista = ppd.listar();
        PartidoPolitico pp = null;
        for (int i = 0; i < lista.size(); i++) {
            PartidoPolitico aux = lista.obtener(i);
            for (int j = 0; j < aux.getCandidato().size(); j++) {
                Candidato auxCandidato = aux.getCandidato().obtener(j);
                if (auxCandidato == candidato) {
                    pp = aux;
                    break;
                }
            }
        }
        return pp;
    }

}
