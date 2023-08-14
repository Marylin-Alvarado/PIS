/* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.DAO;

import java.io.IOException;
import controlador.ed.listas.ListaEnlazada;
import java.lang.reflect.Field;
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
    
    //Atributo de tipo Conexion de conexion
    private Conexion conexion;
    //Atributo de tipo Class de clazz
    private Class clazz;

    //Constructor del adaptador Dao de los atributos 
    public AdaptadorDAO(Class clazz) {
        this.conexion = new Conexion();
        this.clazz = clazz;

    }

    /**
     * Metodo de guardar 
     * @param obj
     * @return
     * @throws Exception 
     */
    
    @Override
    public Integer guardar(T obj) throws Exception {
        String query = queryInsert(obj);
        Integer idGenerado = -1;
        PreparedStatement statement
                = conexion.getConnection().prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
        statement.executeUpdate();
        ResultSet generatedKeys = statement.getGeneratedKeys();
        if (generatedKeys.next()) {
            idGenerado = generatedKeys.getInt(1);
        }

        conexion.getConnection().close();
        conexion.setConnection(null);
        return idGenerado;
    }

    /**
     * Metodo de modificar
     * @param obj
     * @throws Exception 
     */
    
    @Override
    public void modificar(T obj) throws Exception {
        String query = queryUpdate(obj);
        Statement st = conexion.getConnection().createStatement();
        st.executeUpdate(query);
        conexion.getConnection().close();
        conexion.setConnection(null);
    }
    
    /**
     * Metodo de listar
     * @return 
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
     * Metodo de obtener
     * @param id
     * @return 
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
    
    /**
     * Metodo de llenar un objeto
     * @param rs
     * @return 
     */    

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

    /**
     * Metodo para fijar los datos tipo string, integer, double y date
     * @param f
     * @param rs
     * @param data
     * @param atributo 
     */
    
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

    /**
     * Metodo de obtener el objeto
     * @param obj
     * @return 
     */
   
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

            }
        } catch (Exception e) {
            System.out.println("No se pudo tener dato");
        }
        return mapa;
    }

    /**
     * Metodo de querryinsert de objeto de insert into
     * @param obj
     * @return 
     */
    
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
        System.out.println(query);
        return query;
    }

    /**
     * Metodo de queryUpdate de objeto de update
     * @param obj
     * @return 
     */
    
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
