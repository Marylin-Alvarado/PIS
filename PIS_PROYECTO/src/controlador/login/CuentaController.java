/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.login;

import controlador.utiles.*;
import controlador.DAO.CuentaDAO;
import controlador.ed.listas.exception.ListaVaciaException;
import controlador.ed.listas.exception.PosicionNoEncontradaException;
import controlador.login.exceptions.datoIncorrectoException;
import controlador.login.exceptions.intentoExcedidoException;
import controlador.login.exceptions.usuarioNoExisteException;
import modelo.Cuenta;

/**
 *
 * @author Edison
 */
public class CuentaController {
    
    private static CuentaDAO cuentadao = new CuentaDAO();
    protected Integer limite = 5;

    public CuentaController() {
    }

    public static CuentaDAO getCuentadao() {
        return cuentadao;
    }

    public static void setCuentadao(CuentaDAO cuentadao) {
        CuentaController.cuentadao = cuentadao;
    }
    
    public static Cuenta obtener(String usuario) throws ListaVaciaException, PosicionNoEncontradaException, IllegalArgumentException, IllegalAccessException, Exception {
        return cuentadao.obtener(usuario);
    }
    
    public Boolean autentificar(String usuario, String contrasenia) throws ListaVaciaException, PosicionNoEncontradaException, intentoExcedidoException, datoIncorrectoException, usuarioNoExisteException, IllegalArgumentException, IllegalAccessException, Exception {
        Boolean autentificacion = false;
        if (getCuentadao().getCuent().estaVacia()) {
            throw new ListaVaciaException();
        } else {

            if (obtener(usuario)!=null) {
//                get(usuario) != null
                Cuenta cuentaConsulta = obtener(usuario);
                if (cuentaConsulta.getUsuario().equals(usuario)
                        && Utilidades.desencriptar(cuentaConsulta.getContrasenia()).equals(contrasenia)) {
                    autentificacion = true;
                    limite = 5;
                    return autentificacion;
                } else if (limite > 1) {
                    throw new datoIncorrectoException(--limite);
                } else {
                    System.exit(0);
                    throw new intentoExcedidoException();
                }
            } else {
                throw new usuarioNoExisteException();
            }

        }
    }


    
}
