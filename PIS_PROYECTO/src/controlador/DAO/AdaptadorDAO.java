/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.DAO;

import controlador.ed.listas.ListaEnlazada;
import controlador.ed.listas.exception.ListaNullException;
import controlador.ed.listas.exception.PosicionNoEncontradaException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author cobos
 */
public class AdaptadorDAO<T> implements InterfazDAO<T> {
    /**
     * Obejto Conexion
     */
    private ConexionB conexion;
    /**
     * Class del modelo a usar
     */
    private Class clazz;
<<<<<<< HEAD

=======
    
    /**
     * Constructor de la clase
     * @param clazz El objeto de la clase del modelo Ejemplo: Persona.class
     */
>>>>>>> fd33ec33b29cc81818ccab2f478f796de9e9761b
    public AdaptadorDAO(Class clazz) {
        this.conexion = new ConexionB();
        this.clazz = clazz;
<<<<<<< HEAD

=======
>>>>>>> fd33ec33b29cc81818ccab2f478f796de9e9761b
    }
    /**
     * Metodo que permite guardar
     * @param obj El objeto del modelo lleno
     * @return La llave primaria generada por el motor de base de datos (se sugiere construir la tabla de base de datos con la generacion de id auto incementable) 
     * @throws Exception Cuando no se puede guardar en la base de datos
     */
    @Override
    public Integer guardar(T obj) throws Exception {
<<<<<<< HEAD
        String query = queryInsert(obj);
        Integer idGenerado = -1;
        PreparedStatement statement
                = conexion.getConnection().prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
=======
        //INSERT INTO <TABLA> (..) value (...)
        String query = queryInsert(obj);
        Integer idGenerado = -1;
        PreparedStatement statement
                = conexion.getConnection().prepareStatement(query,
                        Statement.RETURN_GENERATED_KEYS);
>>>>>>> fd33ec33b29cc81818ccab2f478f796de9e9761b
        statement.executeUpdate();
        ResultSet generatedKeys = statement.getGeneratedKeys();
        if (generatedKeys.next()) {
            idGenerado = generatedKeys.getInt(1);
        }
<<<<<<< HEAD

        conexion.getConnection().close();
        conexion.setConnection(null);
        return idGenerado;
    }
=======
>>>>>>> fd33ec33b29cc81818ccab2f478f796de9e9761b

        conexion.getConnection().close();
        conexion.setConnection(null);
        return idGenerado;
    }
    /**
     * Metodo que permite modificar un registro en la base de datos, para modificar se debe primero consultar el Objeto haciendo uso del metodo Obtener
     * @param obj El objeto del modelo a modificar
     * @throws Exception Alguna Excepcion si no modifica
     */
    @Override
<<<<<<< HEAD
<<<<<<< HEAD
    public void modificar(T obj, Integer pos) throws ListaNullException, PosicionNoEncontradaException, IOException {
        ListaEnlazada<T> lista = listar();
        lista.modificar(pos, obj);
        //lista.update(obj, pos);
        conexion.getXstream().alias(lista.getClass().getName(), ListaEnlazada.class);
        conexion.getXstream().toXML(lista, new FileWriter(url));
=======
=======
>>>>>>> fd33ec33b29cc81818ccab2f478f796de9e9761b
    public void modificar(T obj) throws Exception {
        String query = queryUpdate(obj);
        Statement st = conexion.getConnection().createStatement();
        st.executeUpdate(query);
        conexion.getConnection().close();
        conexion.setConnection(null);
<<<<<<< HEAD
>>>>>>> Wilson-Gonzales
=======
>>>>>>> fd33ec33b29cc81818ccab2f478f796de9e9761b
    }
    /**
     * Metodo que permite sacar los datos de la base de datos
     * @return Un Objeto de la ListaEnlazada con los datos llenos
     */
    @Override
    public ListaEnlazada<T> listar() {

        ListaEnlazada<T> lista = new ListaEnlazada<>();
        try {
            Statement stmt = conexion.getConnection().createStatement();
            String query = "SELECT * FROM " + clazz.getSimpleName().toLowerCase();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                lista.insertar(llenarObjeto(rs));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return lista;
    }
    /**
     * Permite obtener un objeto de la base de datos a travez del Id
     * @param id El id a buscar en la base de datos
     * @return El objeto buscado, es null si no esxiste el objeto
     */
    @Override
    public T obtener(Integer id) {
        T data = null;
        try {
            Statement stmt = conexion.getConnection().createStatement();
            String query = "select * from " + clazz.getSimpleName().toLowerCase() + " where id = " + id;
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                data = llenarObjeto(rs);
            }
        } catch (Exception e) {
        }
        return data;
    }

<<<<<<< HEAD
=======
    //--------------ESTO ES DEL CRUD NO MODIFICAR AL MENOS QUE LO AMERITE------
    
>>>>>>> fd33ec33b29cc81818ccab2f478f796de9e9761b
    private T llenarObjeto(ResultSet rs) {
        T data = null;
        try {
            data = (T) clazz.getDeclaredConstructor().newInstance();
            for (Field f : clazz.getDeclaredFields()) {
                String atributo = f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1);
                fijarDatos(f, rs, data, atributo);
            }
            for (Field f : clazz.getSuperclass().getDeclaredFields()) {
                String atributo = f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1);
                fijarDatos(f, rs, data, atributo);
            }

        } catch (Exception e) {
            System.out.println("error " + e);
        }
        return data;
    }

    private void fijarDatos(Field f, ResultSet rs, T data, String atributo) {
        try {
            Method m = null;

            if (f.getType().getSimpleName().equalsIgnoreCase("String")) {
                m = clazz.getMethod("set" + atributo, String.class);
                m.invoke(data, rs.getString(atributo));
            }

            if (f.getType().getSimpleName().equalsIgnoreCase("Integer")) {
                m = clazz.getMethod("set" + atributo, Integer.class);
                m.invoke(data, rs.getInt(atributo));
            }

            if (f.getType().getSimpleName().equalsIgnoreCase("Double")) {
                m = clazz.getMethod("set" + atributo, Double.class);
                m.invoke(data, rs.getDouble(atributo));
            }

            if (f.getType().getSimpleName().equalsIgnoreCase("Boolean")) {
                m = clazz.getMethod("set" + atributo, Boolean.class);
                m.invoke(data, rs.getBoolean(atributo));
            }

            if (f.getType().getSimpleName().equalsIgnoreCase("Date")) {
                m = clazz.getMethod("set" + atributo, Date.class);
                m.invoke(data, rs.getDate(atributo));
            }

            if (f.getType().isEnum()) {

                m = clazz.getMethod("set" + atributo, (Class<Enum>) f.getType());
                m.invoke(data, Enum.valueOf((Class<Enum>) f.getType(), rs.getString(atributo)));
            }
        } catch (Exception e) {
            System.out.println("chiqui error " + e);
        }
    }

    private HashMap<String, Object> obtenerObjeto(T obj) {
        HashMap<String, Object> mapa = new HashMap<>();
        try {
            for (Field f : clazz.getDeclaredFields()) {
                Method m = null;
                String atributo = f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1);
                m = clazz.getMethod("get" + atributo);
                Object aux = m.invoke(obj);
                if (aux != null) {
                    mapa.put(atributo.toLowerCase(), aux);
                }
            }

            for (Field f : clazz.getSuperclass().getDeclaredFields()) {
                Method m = null;
                String atributo = f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1);
                m = clazz.getMethod("get" + atributo);
                Object aux = m.invoke(obj);
                if (aux != null) {
                    mapa.put(atributo.toLowerCase(), aux);
                }
<<<<<<< HEAD

=======
               
>>>>>>> fd33ec33b29cc81818ccab2f478f796de9e9761b
            }
        } catch (Exception e) {
            System.out.println("No se pudo tener dato");
        }
        return mapa;
    }

    private String queryInsert(T obj) {
        HashMap<String, Object> mapa = obtenerObjeto(obj);
        String query = "INSERT INTO " + clazz.getSimpleName().toLowerCase() + " (";
        for (Map.Entry<String, Object> entry : mapa.entrySet()) {
            query += entry.getKey() + ",";

        }
        query = query.substring(0, query.length() - 1);
        query += ") VALUES (";
        for (Map.Entry<String, Object> entry : mapa.entrySet()) {

            if (entry.getValue().getClass().getSuperclass().getSimpleName().equalsIgnoreCase("Number") || entry.getValue().getClass().getSimpleName().equalsIgnoreCase("Boolean")) {
                query += entry.getValue() + ", ";
            }
            if (entry.getValue().getClass().getSimpleName().equalsIgnoreCase("Date")) {
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                query += '"' + formato.format(entry.getValue()) + '"' + ", ";
            }
            if (entry.getValue().getClass().isEnum() || entry.getValue().getClass().getSimpleName().equalsIgnoreCase("String")) {
                query += '"' + entry.getValue().toString() + '"' + ", ";
            }
        }
        query = query.substring(0, query.length() - 2);
        query += ")";
<<<<<<< HEAD
        System.out.println(query);
=======
>>>>>>> fd33ec33b29cc81818ccab2f478f796de9e9761b
        return query;
    }

    private String queryUpdate(T obj) {
        HashMap<String, Object> mapa = obtenerObjeto(obj);
        String query = "UPDATE " + clazz.getSimpleName().toLowerCase() + " SET ";
        Integer id = 0;
        for (Map.Entry<String, Object> entry : mapa.entrySet()) {
            if (entry.getKey().toString().equalsIgnoreCase("id")) {
                id = (Integer) entry.getValue();
            } else {
                query += entry.getKey() + " = ";
                if (entry.getValue().getClass().getSuperclass().getSimpleName().equalsIgnoreCase("Number") || entry.getValue().getClass().getSimpleName().equalsIgnoreCase("Boolean")) {
                    query += entry.getValue() + ", ";
                }
                if (entry.getValue().getClass().getSimpleName().equalsIgnoreCase("Date")) {
                    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                    query += '"' + formato.format(entry.getValue()) + '"' + ", ";
                }
                if (entry.getValue().getClass().isEnum() || entry.getValue().getClass().getSimpleName().equalsIgnoreCase("String")) {
                    query += '"' + entry.getValue().toString() + '"' + ", ";
                }
            }

        }

        query += "";

        query = query.substring(0, query.length() - 2);
        query += " WHERE id = " + id;
        return query;
    }

}
