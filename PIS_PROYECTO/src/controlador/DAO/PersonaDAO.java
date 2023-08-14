/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.DAO;

import controlador.ed.listas.ListaEnlazada;
import controlador.ed.listas.exception.ListaNullException;
import controlador.ed.listas.exception.ListaVaciaException;
import controlador.ed.listas.exception.PosicionNoEncontradaException;
import java.io.IOException;
import modelo.Persona;
import modelo.Persona;

/**
 *
 * @author Edison
 */
public class PersonaDAO extends AdaptadorDAO<Persona> {

    /**
     * Atributo de persona
     */
    private Persona persona;
    /**
     * ListaEnlazada de persona
     */
    private ListaEnlazada<Persona> person = new ListaEnlazada<>();

    /**
     * Constructor de persona Dao
     */
    public PersonaDAO() {
        super(Persona.class);
    }

    /**
     * Metodo get de persona
     *
     * @return
     */
    public Persona getPersona() {
        if (this.persona == null) {
            this.persona = new Persona();
        }
        return persona;
    }

    /**
     * Metodo de set de persona
     *
     * @param persona
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    /**
     * Metodo de guardar un integer
     *
     * @return
     * @throws Exception
     */
    public Integer guardar() throws Exception {
        return this.guardar(persona);
    }

    /**
     * Metodo de modificar
     *
     * @param pos
     * @return
     * @throws Exception
     */
    public boolean modificar(Integer pos) throws Exception {
        this.modificar(persona);
        return true;
    }

    /**
     * Metodo de generate de id
     *
     * @return
     */
    private Integer generateID() {
        return listar().size() + 1;
    }

    /**
     * Metodo de obtener el string de usuario
     *
     * @param usuario
     * @return
     * @throws ListaVaciaException
     * @throws PosicionNoEncontradaException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @throws Exception
     */
    public Persona obtener(String usuario) throws ListaVaciaException, PosicionNoEncontradaException, IllegalArgumentException, IllegalAccessException, Exception {
        try {
            // Asegurarse de que la lista esté ordenada por nombre de usuario
            ListaEnlazada<Persona> listaOrdenada = quicksortAs(person);

            // Realizar la búsqueda binaria en la lista ordenada
            ListaEnlazada<Persona> resultadoBusqueda = busBinaria(listaOrdenada, usuario);

            // Si se enpersonra una persona, devolverla
            if (!resultadoBusqueda.estaVacia()) {
                return resultadoBusqueda.obtener(0);
            }

            // Si no se enpersonra, intentar la búsqueda secuencial
            int indicePersona = buscar(usuario);
            if (indicePersona != -1) {
                return person.obtener(indicePersona);
            }
        } catch (Exception e) {
            // Manejar cualquier excepción aquí si es necesario
        }

        return null;
    }

    /**
     *
     * @param usuario
     * @return
     * @throws ListaVaciaException
     * @throws PosicionNoEncontradaException
     * @throws ListaNullException
     */
    // Este método busca una persona en la lista enlazada por su nombre de usuario.
    public int buscar(String usuario) throws ListaVaciaException, PosicionNoEncontradaException, ListaNullException {
        int n = -1; // Inicializar el índice en -1 (no se encontró)
        for (int i = 0; i < person.getSize(); i++) {
            // Compara el nombre de usuario de la persona en la posición i con el usuario proporcionado.
            if (person.obtener(i).getNombres_completos().equals(usuario)) {
                n = i; // Asigna el índice donde se encontró la persona
                break; // Sale del bucle, ya que se encontró la persona
            }
        }
        return n; // Devuelve el índice encontrado o -1 si no se encontró
    }

    /**
     *
     * @param lista
     * @param dato
     * @return
     */
    //Este método realiza una búsqueda binaria en una lista enlazada de personas para encontrar una coincidencia con un nombre de usuario.
    public ListaEnlazada<Persona> busBinaria(ListaEnlazada<Persona> lista, String dato) {
        Persona[] arreglo = lista.toArray(); // Convierte la lista en un arreglo
        int inicio = 0;
        int fin = arreglo.length - 1;
        int pos;

        while (inicio <= fin) {
            pos = (inicio + fin) / 2; // Calcula la posición media
            if (arreglo[pos].getNombres_completos().toLowerCase().equals(dato.toLowerCase())) {
                // Si se encuentra una coincidencia, crea una nueva lista con la persona y la devuelve
                ListaEnlazada<Persona> res = new ListaEnlazada<>();
                res.insertar(arreglo[pos]);
                return res;
            }
            if (arreglo[pos].getNombres_completos().compareToIgnoreCase(dato) < 0) {
                inicio = pos + 1; // Ajusta los límites según la búsqueda binaria
            } else {
                fin = pos - 1;
            }
        }
        return lista; // Devuelve la lista original si no se encuentra una coincidencia
    }

    /**
     *
     * @param dato
     * @return
     */
    // Este método busca un nombre de cliente en la lista enlazada.
    public ListaEnlazada<Persona> buscarNombreCliente(String dato) {
        ListaEnlazada<Persona> lista = listar(); // Obtiene la lista completa de personas
        quicksortAs(lista); // Ordena la lista utilizando quicksortAs()
        lista.imprimir(); // Imprime la lista (posiblemente para depuración)
        return busBinaria(lista, dato); // Realiza una búsqueda binaria y devuelve la lista con la coincidencia (si se encuentra)
    }

    /**
     *
     * @param user
     * @return
     * @throws Exception
     */
    // Este método busca una persona en la lista por su nombre de usuario.
    // Devuelve la instancia de Persona correspondiente o null si no se encuentra.
    public Persona buscarUsaurio(String user) throws Exception {
        Persona c = null;
        ListaEnlazada<Persona> lista = listar();
        for (int i = 0; i < lista.size(); i++) {
            Persona aux = lista.obtener(i);
            if (user.equals(aux.getNombres_completos())) {
                c = aux; // Asigna la persona encontrada a "c"
                break;
            }
        }
        return c; // Devuelve la persona encontrada o null si no se encontró
    }

    /**
     *
     * @param user
     * @param clave
     * @return
     * @throws Exception
     */
// Este método intenta iniciar sesión utilizando el nombre de usuario y la clave (identificación).
    public Persona inicioSesion(String user, Integer clave) throws Exception {
        Persona c = buscarUsaurio(user); // Busca la persona por el nombre de usuario
        if (c != null) {
            if (!c.getIdentificacion().equals(clave)) { // Compara la identificación
                c = null; // Si no coincide, establece "c" en null
            }
        }
        return c; // Devuelve la persona si la identificación coincide, de lo contrario, devuelve null
    }

    /**
     *
     * @param user
     * @return
     * @throws Exception
     */
    public int buscarUsuarioid(String user) throws Exception {
        int ubicacion = -1;  // Valor por defecto en caso de no encontrar al usuario
        ListaEnlazada<Persona> lista = listar();
        for (int i = 0; i < lista.size(); i++) {
            Persona aux = lista.obtener(i);
            if (user.equals(aux.getNombres_completos())) {
                ubicacion = i + 1;  // Actualizar la ubicación si se encuentra al usuario
                break;
            }
        }
        return ubicacion;
    }

    

// Este método implementa el algoritmo de ordenamiento rápido ascendente.
    /**
     *
     * @param user
     * @param clave
     * @return
     * @throws Exception
     */
    public int buscarinicioSesion(String user, Integer clave) throws Exception {
        int ubicacion = buscarUsuarioid(user);
        ListaEnlazada<Persona> lista = listar();
        if (ubicacion != -1) {
            Persona c = lista.obtener(ubicacion - 1);
            if (!c.getIdentificacion().equals(clave)) {
                ubicacion = -1;  // Si la clave no coincide, resetear la ubicación
            }
        }
        return ubicacion;
    }

    /**
     *
     * @param lista
     * @return
     */
// Este método implementa el algoritmo de ordenamiento rápido ascendente.
    public ListaEnlazada<Persona> quicksortAs(ListaEnlazada<Persona> lista) {
        if (lista == null || lista.size() == 0) {
            return lista; // Devuelve la lista si está vacía o nula
        }
        Persona[] arreglo = lista.toArray(); // Convierte la lista en un arreglo
        ordenarAs(arreglo, 0, arreglo.length - 1); // Ordena el arreglo
        return lista.toList(arreglo); // Reconstruye la lista a partir del arreglo ordenado
    }

    /**
     *
     * @param lista
     * @param bajo
     * @param alto
     */
// Estos son métodos auxiliares para el algoritmo de ordenamiento rápido.
// Particiona el arreglo y realiza las llamadas recursivas de ordenamiento.
    private static void ordenarAs(Persona[] lista, int bajo, int alto) {
        if (bajo < alto) {
            int particionIndex = particionAs(lista, bajo, alto);
            ordenarAs(lista, bajo, particionIndex - 1);
            ordenarAs(lista, particionIndex + 1, alto);
        }
    }

    /**
     *
     * @param lista
     * @param alto
     * @param bajo
     * @return
     */
    private static int particionAs(Persona[] lista, int alto, int bajo) {
        Persona pivot = lista[alto];
        int i = bajo - 1;
        for (int j = bajo; j < alto; j++) {
            if (lista[j].getNombres_completos().toLowerCase().compareToIgnoreCase(pivot.getNombres_completos().toLowerCase()) < 0) {
                i++;
                swapAs(lista, i, j);
            }
        }
        swapAs(lista, i + 1, alto);
        return i + 1;
    }

    /**
     *
     * @param lista
     * @param i
     * @param j
     */
    private static void swapAs(Persona[] lista, int i, int j) {
        Persona temp = lista[i];
        lista[i] = lista[j];
        lista[j] = temp;
    }

}
