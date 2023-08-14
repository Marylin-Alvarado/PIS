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
import modelo.Partido_Politico;
import modelo.Persona;
import modelo.Persona;

/**
 *
 * @author Edison
 */
public class PersonaDAO extends AdaptadorDAO<Persona> {
    private Persona persona;
    
    public PersonaDAO() {
        super(Persona.class);
    }

    public Persona getPersona() {
        if (this.persona == null) {
            this.persona = new Persona();
        }
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Integer guardar() throws Exception {
        return this.guardar(persona);   
    }

    public boolean modificar() throws Exception {
         this.modificar(persona);
         return true;
    }

    public Persona buscarPorNombre(Integer dato) throws ListaNullException, PosicionNoEncontradaException {
        Persona resultado = null;
        ListaEnlazada<Persona> lista = listar();
        for (int i = 0; i < lista.size(); i++) {
            Persona aux = lista.obtener(i);
            if (aux.getIdentificacion().equals(dato)) {
                resultado = aux;
                break;
            }
        }
        return resultado;
    }
    
     public ListaEnlazada<Persona> ordenarIdentificacion(ListaEnlazada<Persona> lista, Integer tipo) {
        try {
            Persona[] matriz = lista.toArray();
            for (int i = 1; i < lista.size(); i++) {
                Persona key = matriz[i];
                int j = i - 1;
                switch (tipo) {
                    case 0:

                }
                while (j >= 0 && (matriz[j].getIdentificacion() > key.getIdentificacion())) {
                    //lista.update(j+1, lista.get(j));
                    matriz[j + 1] = matriz[j];
                    j = j - 1;
                }
                //lista.update(j+1, key);
                matriz[j + 1] = key;
            }
            lista.toList(matriz);
        } catch (Exception e) {
        }
        return lista;
    }
}
