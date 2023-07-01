/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.DAO;

import controlador.ed.listas.ListaEnlazada;
import controlador.ed.listas.exception.ListaNullException;
import controlador.ed.listas.exception.PosicionNoEncontradaException;
import java.io.IOException;
import modelo.Candidato;

/**
 *
 * @author cobos
 */
public class CandidatoDao extends AdaptadorDAO<Candidato>{
    
    private Candidato datos;

    public CandidatoDao() {
        super(Candidato.class);
    }

    public Candidato getDatos() {
        if (this.datos == null) {
            this.datos = new Candidato();
        }
        return datos;
    }

    public void setDatos(Candidato datos) {
        this.datos = datos;
    }

    public void guardar() throws IOException {
        datos.setId_candidato(generateID());
        this.guardar(datos);
    }

    public void modificar(Integer pos) throws ListaNullException, PosicionNoEncontradaException, IOException {
        this.modificar(datos, pos);
    }

    private Integer generateID() {
        return listar().size() + 1;
    }
        
    public Candidato buscarPorNombre(String dato) throws ListaNullException, PosicionNoEncontradaException{
        Candidato resultado = null;
        ListaEnlazada<Candidato> lista = listar();
        for (int i = 0; i < lista.size(); i++) {
            Candidato aux = lista.obtener(i);
            if (aux.getNombre_candidato().toLowerCase().equals(dato.toLowerCase())) {
                resultado = aux;
                break;
            }
        }
        return resultado;
    }
}
