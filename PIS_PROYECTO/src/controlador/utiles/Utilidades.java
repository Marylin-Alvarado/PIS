
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.utiles;


import controlador.DAO.PapeletaDao;
import controlador.ed.listas.ListaEnlazada;
import controlador.ed.listas.exception.ListaNullException;
import controlador.ed.listas.exception.PosicionNoEncontradaException;
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
import modelo.Eleccion;
import modelo.Papeleta;
import modelo.Persona;

/**
 *
 * @author Marylin
 */
public class Utilidades {
    
    /**
     * 
     * @param clase
     * @return 
     */
    public static Boolean isNumber(Class clase) {
        return clase.getSuperclass().getSimpleName().equalsIgnoreCase("Number");
    }

    /**
     * 
     * @param clase
     * @return 
     */
    public static Boolean isString(Class clase) {
        return clase.getSimpleName().equalsIgnoreCase("String");
    }

    /**
     * 
     * @param clase
     * @return 
     */
    public static Boolean isCharacter(Class clase) {
        return clase.getSimpleName().equalsIgnoreCase("Character");
    }

    /**
     * 
     * @param clase
     * @return 
     */
    public static Boolean isBoolean(Class clase) {
        return clase.getSimpleName().equalsIgnoreCase("Boolean");
    }

    /**
     * 
     * @param clase
     * @return 
     */
    public static Boolean isDate(Class clase) {
        return clase.getSimpleName().equalsIgnoreCase("Date");
    }

    /**
     * 
     * @param clase
     * @return 
     */
    public static Boolean isPrimitive(Class clase) {
        return clase.isPrimitive();
    }

    /**
     * 
     * @param clase
     * @return 
     */
    public static Boolean isObject(Class clase) {
        return (!isPrimitive(clase) && !isBoolean(clase) && !isCharacter(clase) && !isNumber(clase) && !isString(clase) && !isDate(clase));
    }

    /**
     * Metodo de obtener atributo
     * @param clase
     * @param nombre
     * @return 
     */
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

    /**
     * Metodo de capitalizar
     * @param nombre
     * @return 
     */
    public static String capitalizar(String nombre) {
        char[] aux = nombre.toCharArray();
        aux[0] = Character.toUpperCase(aux[0]);
        return new String(aux);
    }

    /**
     * Metodo de transformarDato
     * @param atributo
     * @param dato
     * @return 
     */
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

    /**
     * Metodo de enceiptar
     * @param dato
     * @return 
     */
    //***************************************************************************************************\\
    public static String encriptar(String dato) {
        return Base64.getEncoder().encodeToString(dato.getBytes());
    }

    /**
     * Metodo de desencriptar
     * @param dato
     * @return 
     */
    public static String desencriptar(String dato) {
        return new String(Base64.getDecoder().decode(dato));
    }

    /**
     * metodo de crear clave 
     * @param clave
     * @return
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException 
     */
    //*********************************************************************\\
    public static SecretKeySpec crearClave(String clave) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        byte[] claveEncription = clave.getBytes("UTF-8");

        claveEncription = Arrays.copyOf(claveEncription, 16);
        SecretKeySpec keySpec = new SecretKeySpec(claveEncription, "AES");
        return keySpec;
    }

    /**
     * Metodo de encriptar clave
     * @param datos
     * @param claveSecreta
     * @return
     * @throws InvalidKeyException
     * @throws NoSuchPaddingException
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException 
     */
    public static String encriptarClave(final String datos, final String claveSecreta) throws InvalidKeyException, NoSuchPaddingException, UnsupportedEncodingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException {
        byte[] decodeKey = Base64.getDecoder().decode(claveSecreta);
        SecretKey secretKeySpec = crearClave(new String(decodeKey));
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

        byte[] bytesEncriptados = cipher.doFinal(datos.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(bytesEncriptados);
    }

    /**
     * Metodo de desencriptar clave
     * @param datos
     * @param claveSecreta
     * @return
     * @throws InvalidKeyException
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     * @throws UnsupportedEncodingException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException 
     */
    public static String desencriptarClave(final String datos, final String claveSecreta) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException {
        byte[] decodeKey = Base64.getDecoder().decode(claveSecreta);
        SecretKey secretKeySpec = crearClave(new String(decodeKey));
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);

        byte[] bytesEncriptados = Base64.getDecoder().decode(datos);
        byte[] datosDesencriptados = cipher.doFinal(bytesEncriptados);
        return new String(datosDesencriptados);

    }

    /**
     * Metodo de validar la cedula
     * @param cedula
     * @return 
     */
    public static boolean validadorDeCedula(String cedula) {
        boolean cedulaCorrecta = false;
        cedula = (cedula.length() == 13) ? cedula.substring(0, 10) : cedula;

        try {

            if (cedula.length() == 10) // ConstantesApp.LongitudCedula
            {
                int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
                if (tercerDigito < 6) {
                    // Coeficientes de validación cédula
                    // El decimo digito se lo considera dígito verificador
                    int[] coefValCedula = {2, 1, 2, 1, 2, 1, 2, 1, 2};
                    int verificador = Integer.parseInt(cedula.substring(9, 10));
                    int suma = 0;
                    int digito = 0;
                    for (int i = 0; i < (cedula.length() - 1); i++) {
                        digito = Integer.parseInt(cedula.substring(i, i + 1)) * coefValCedula[i];
                        suma += ((digito % 10) + (digito / 10));
                    }

                    if ((suma % 10 == 0) && (suma % 10 == verificador)) {
                        cedulaCorrecta = true;
                    } else if ((10 - (suma % 10)) == verificador) {
                        cedulaCorrecta = true;
                    } else {
                        cedulaCorrecta = false;
                    }
                } else {
                    cedulaCorrecta = false;
                }
            } else {
                cedulaCorrecta = false;
            }
        } catch (NumberFormatException nfe) {
            cedulaCorrecta = false;
        } catch (Exception err) {
            System.out.println("Una excepcion ocurrio en el proceso de validadcion");
            cedulaCorrecta = false;
        }

        if (!cedulaCorrecta) {
            System.out.println("La Cédula ingresada es Incorrecta");
        }
        return cedulaCorrecta;
    }
    
    
    /**
     * main
     * @param args 
     */

    public static void main(String[] args) {

//        try {
//            String claveSecreta = "XABC345";
//            String dato = "IShowSpeed";
//            System.out.println(Utilidades.encriptarClave(dato, claveSecreta));
//            System.out.println(Utilidades.desencriptarClave("rWw5G4J6Iz9tllr1vOvUdQ==", "XABC345"));
//            //77+9Tu+/ve+/vQkHJu+/vTTvv71W77+9byk=
//        } catch (Exception e) {
//            System.out.println(e);
//            e.printStackTrace();
//        }
        String aux = "4999929999001";
        String ced = aux.substring(0, 10);
        String baj = aux.substring(10, 13);
        System.out.println(ced + " " + baj);
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