
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Utilidades;


import controlador.DAO.CandidatoDao;
import controlador.DAO.DignidadDao;
import controlador.DAO.PartidoPoliticoDao;
import controlador.ed.listas.ListaEnlazada;
import controlador.ed.listas.exception.ListaNullException;
import controlador.ed.listas.exception.PosicionNoEncontradaException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComboBox;
import modelo.Candidato;
import modelo.Dignidad;
import modelo.PartidoPolitico;
import modelo.Partido_Politico;
import modelo.Persona;
import modelo.enums.TipoVoto;
import modelo.enums.Generos;
import modelo.enums.TipoIdentificacion;

/**
 *
 * @author Marylin
 */
public class Utilidades {
    
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
    
    public static void cargarPartido(JComboBox cbx , PartidoPoliticoDao pd) throws ListaNullException, PosicionNoEncontradaException{
        cbx.removeAllItems();
        ListaEnlazada<Partido_Politico> lista = pd.ordenarNombre(pd.listar(), 0);
        for (int i = 0; i < lista.size(); i++) {
            cbx.addItem(lista.obtener(i).getNombre_partido_politico());
        }
    }
    
    public static void cargarCandidato(JComboBox cbx , CandidatoDao pd) throws ListaNullException, PosicionNoEncontradaException{
        cbx.removeAllItems();
        ListaEnlazada<Candidato> lista = pd.ordenarNombre(pd.listar(), 0);
        for (int i = 0; i < lista.size(); i++) {
            cbx.addItem(lista.obtener(i).getNombre_candidato());
        }
    }
    
    public static void cargarDignidad(JComboBox cbx , DignidadDao dd) throws ListaNullException, PosicionNoEncontradaException, PosicionNoEncontradaException, PosicionNoEncontradaException, PosicionNoEncontradaException, PosicionNoEncontradaException, PosicionNoEncontradaException, PosicionNoEncontradaException, PosicionNoEncontradaException{
        cbx.removeAllItems();
        ListaEnlazada<Dignidad> lista = dd.ordenarCategoria(dd.listar());
        for (int i = 0; i < lista.size(); i++) {
            cbx.addItem(lista.obtener(i).getTipo());
        }
    }

    

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
   

}
