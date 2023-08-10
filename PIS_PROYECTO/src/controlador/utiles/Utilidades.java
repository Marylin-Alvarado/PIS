/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.utiles;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Marylin
 */
public class Utilidades {
    
    public static Boolean isNumber(Class clase) {
        return clase.getSuperclass().getSimpleName().equalsIgnoreCase("Number");
    }

    public static Boolean isString(Class clase) {
        return clase.getSimpleName().equalsIgnoreCase("String");
    }

    public static Boolean isCharacter(Class clase) {
        return clase.getSimpleName().equalsIgnoreCase("Character");
    }

    public static Boolean isBoolean(Class clase) {
        return clase.getSimpleName().equalsIgnoreCase("Boolean");
    }

    public static Boolean isDate(Class clase) {
        return clase.getSimpleName().equalsIgnoreCase("Date");
    }

    public static Boolean isPrimitive(Class clase) {
        return clase.isPrimitive();
    }

    public static Boolean isObject(Class clase) {
        return (!isPrimitive(clase) && !isBoolean(clase) && !isCharacter(clase) && !isNumber(clase) && !isString(clase) && !isDate(clase));
    }

    public static Field obtenerAtributo(Class clase, String nombre) { //Devuelve que tipo de dato es el atributo enviado
        Field atributo = null;
        for (Field aux : clase.getDeclaredFields()) {
            if (nombre.equalsIgnoreCase(aux.getName())) {
                atributo = aux;
                break;
            }
        }
        return atributo;
    }

    public static String capitalizar(String nombre) {
        char[] aux = nombre.toCharArray();
        aux[0] = Character.toUpperCase(aux[0]);
        return new String(aux);
    }

    public static Object transformarDato(Field atributo, String dato) {
        Object transformar = null;
        if (atributo.getType().getSuperclass().getSimpleName().equalsIgnoreCase("Number")) {
            if (atributo.getType().getSimpleName().equals("Integer")) {
                transformar = Integer.parseInt(dato);
            }
        } else if (atributo.getType().isEnum()) {
            Enum enumeracion = Enum.valueOf((Class) atributo.getType(), dato.toString());
            transformar = enumeracion;

        } else if (atributo.getType().getSimpleName().equalsIgnoreCase("Boolean")) {
            transformar = Boolean.parseBoolean(dato);
        } else {
            transformar = dato;
        }
        return transformar;

    }

    //***************************************************************************************************\\
    public static String encriptar(String dato) {
        return Base64.getEncoder().encodeToString(dato.getBytes());
    }

    public static String desencriptar(String dato) {
        return new String(Base64.getDecoder().decode(dato));
    }

    //*********************************************************************\\
    public static SecretKeySpec crearClave(String clave) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        byte[] claveEncription = clave.getBytes("UTF-8");

        claveEncription = Arrays.copyOf(claveEncription, 16);
        SecretKeySpec keySpec = new SecretKeySpec(claveEncription, "AES");
        return keySpec;
    }

    public static String encriptarClave(final String datos, final String claveSecreta) throws InvalidKeyException, NoSuchPaddingException, UnsupportedEncodingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException {
        byte[] decodeKey = Base64.getDecoder().decode(claveSecreta);
        SecretKey secretKeySpec = crearClave(new String(decodeKey));
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

        byte[] bytesEncriptados = cipher.doFinal(datos.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(bytesEncriptados);
    }

    public static String desencriptarClave(final String datos, final String claveSecreta) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException {
        byte[] decodeKey = Base64.getDecoder().decode(claveSecreta);
        SecretKey secretKeySpec = crearClave(new String(decodeKey));
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);

        byte[] bytesEncriptados = Base64.getDecoder().decode(datos);
        byte[] datosDesencriptados = cipher.doFinal(bytesEncriptados);
        return new String(datosDesencriptados);

    } 
    
    public static String encriptarContrasenia(String dato) {
        if (dato != null) {
            return Base64.getEncoder().encodeToString(dato.getBytes());
        }
        return "";
    }

    /**
     * Permiute desencriptar la contrasenia
     * @param dato
     * @return contrasenia desencriptada
     */
    public static String desEncriptarContrasenia(String dato) {
        if (dato != null) {
            return new String(Base64.getDecoder().decode(dato));
        }
        return "";
    }

    

}
