/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.DAO;

import controlador.ed.listas.exception.ListaNullException;
import controlador.ed.listas.exception.PosicionNoEncontradaException;
import java.io.IOException;
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

    private Integer generateID() {
        return listar().size() + 1;
    }
    
}
