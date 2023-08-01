/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.DAO;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import controlador.ed.listas.ListaEnlazada;
import controlador.ed.listas.exception.ListaNullException;
import controlador.ed.listas.exception.ListaVaciaException;
import controlador.ed.listas.exception.PosicionNoEncontradaException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import modelo.PartidoPolitico;


/**
 *
 * @author Marylin
 */
public class RegistroPartidoPoliticoDao extends AdaptadorDAO<PartidoPolitico> {

    private PartidoPolitico cargo;

    public RegistroPartidoPoliticoDao() {
        super(PartidoPolitico.class);
    }

    public PartidoPolitico getCargo() {
        if (this.cargo == null) {
            this.cargo = new PartidoPolitico();
        }
        return cargo;
    }

    public void setLibro(PartidoPolitico cargo) {
        this.cargo = cargo;
    }

    public void guardar() throws IOException {
        cargo.setId_partidoPolitico(generateID());
        this.guardar(cargo);
    }

    public void modificar(Integer pos) throws ListaVaciaException, PosicionNoEncontradaException, IOException, ListaNullException {
        this.modificar(cargo, pos);
    }

    private Integer generateID() {
        return listar().size() + 1;
    }
    
    

}
