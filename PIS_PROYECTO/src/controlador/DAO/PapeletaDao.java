/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.DAO;

import controlador.ed.listas.ListaEnlazada;
import controlador.ed.listas.exception.ListaNullException;
import controlador.ed.listas.exception.PosicionNoEncontradaException;
import java.io.IOException;
import modelo.Papeleta;

public class PapeletaDao extends AdaptadorDAO<Papeleta>{
    
    private Papeleta papeleta;
    
    public PapeletaDao(){
        super(Papeleta.class);
    }

    public Papeleta getPapeleta() {
        if(this.papeleta == null){
            this.papeleta = new Papeleta();
        }
        return papeleta;
    }

    public void setPapeleta(Papeleta papeleta) {
        this.papeleta = papeleta;
    }
    
    public void guardar() throws IOException{
        papeleta.setId_papeleta(generateID());
        this.guardar(papeleta);
    }
    
    public void modificar(Integer pos) throws ListaNullException, PosicionNoEncontradaException, IOException{
        this.modificar(papeleta, pos);
    }
    
    private Integer generateID(){
        return listar().size() + 1;
    }
    
    public Papeleta buscarPorID(Integer id) throws PosicionNoEncontradaException, ListaNullException{
        Papeleta res = null;
        ListaEnlazada<Papeleta> lista = listar();
        for (int i = 0; i < lista.size(); i++) {
            Papeleta aux = lista.obtener(i);
            if (aux.getId_papeleta().intValue() == id.intValue()) {
                res = aux;
                break;
            }
        }
        return res;
    }
    
}
