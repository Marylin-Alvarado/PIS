/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Utilidades;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import controlador.Utilidades.listas.ListaEnlazada;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Type;
import javax.swing.JComboBox;
import modelo.Cuenta;
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

    public static ListaEnlazada<Cuenta> listarCuentas() {
        ListaEnlazada<Cuenta> lista = new ListaEnlazada<>();
        String json = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("cuentas.json"));
            String linea;
            while ((linea = br.readLine()) != null) {
                json += linea;
            }
            br.close();
//            Persona[] arrayLista = new Gson().fromJson(json, Persona[].class);
            Type tipoLista = new TypeToken<ListaEnlazada<Cuenta>>() {
            }.getType();
//            System.out.println("Tipolist " + tipoLista);
//            List a = stringToArray(json, Persona[].class);
            lista = new Gson().fromJson(json, tipoLista);

        } catch (Exception e) {
            System.out.println("Error en utilidades del metodo listar: " + e);
        }
        return lista;
    }
}
