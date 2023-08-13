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

    private Persona persona;
    private ListaEnlazada<Persona> person = new ListaEnlazada<>();

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

    public boolean modificar(Integer pos) throws Exception {
        this.modificar(persona);
        return true;
    }

    private Integer generateID() {
        return listar().size() + 1;
    }

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

    // Este método busca un nombre de cliente en la lista enlazada.
    public ListaEnlazada<Persona> buscarNombreCliente(String dato) {
        ListaEnlazada<Persona> lista = listar(); // Obtiene la lista completa de personas
        quicksortAs(lista); // Ordena la lista utilizando quicksortAs()
        lista.imprimir(); // Imprime la lista (posiblemente para depuración)
        return busBinaria(lista, dato); // Realiza una búsqueda binaria y devuelve la lista con la coincidencia (si se encuentra)
    }

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

// Este método implementa el algoritmo de ordenamiento rápido ascendente.

    public ListaEnlazada<Persona> quicksortAs(ListaEnlazada<Persona> lista) {
        if (lista == null || lista.size() == 0) {
            return lista; // Devuelve la lista si está vacía o nula
        }
        Persona[] arreglo = lista.toArray(); // Convierte la lista en un arreglo
        ordenarAs(arreglo, 0, arreglo.length - 1); // Ordena el arreglo
        return lista.toList(arreglo); // Reconstruye la lista a partir del arreglo ordenado
    }

// Estos son métodos auxiliares para el algoritmo de ordenamiento rápido.
// Particiona el arreglo y realiza las llamadas recursivas de ordenamiento.
    private static void ordenarAs(Persona[] lista, int bajo, int alto) {
        if (bajo < alto) {
            int particionIndex = particionAs(lista, bajo, alto);
            ordenarAs(lista, bajo, particionIndex - 1);
            ordenarAs(lista, particionIndex + 1, alto);
        }
    }

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

    private static void swapAs(Persona[] lista, int i, int j) {
        Persona temp = lista[i];
        lista[i] = lista[j];
        lista[j] = temp;
    }

}
