package mx.unam.ciencias.icc;

/**
 * <p>
 * Clase para listas de estudiantes doblemente ligadas.
 * </p>
 *
 * <p>
 * Las listas de estudiantes nos permiten agregar elementos al inicio o final
 * de la lista, eliminar elementos de la lista, comprobar si un elemento está o
 * no en la lista, y otras operaciones básicas.
 * </p>
 *
 * <p>
 * Las listas de estudiantes son iterables utilizando sus nodos. Las listas
 * no aceptan a <code>null</code> como elemento.
 * </p>
 *
 * <p>
 * Los elementos en una lista de estudiantes siempre son instancias de la
 * clase {@link Estudiante}.
 * </p>
 */
public class ListaEstudiante {

    /**
     * Clase interna para nodos.
     */
    public class Nodo {

        /* El elemento del nodo. */
        private Estudiante elemento;
        /* El nodo anterior. */
        private Nodo anterior;
        /* El nodo siguiente. */
        private Nodo siguiente;

        /* Construye un nodo con un elemento. */
        private Nodo(Estudiante elemento) {
            // Aquí va su código.
            this.elemento = elemento;
        }

        /**
         * Regresa el nodo anterior del nodo.
         * 
         * @return el nodo anterior del nodo.
         */
        public Nodo getAnterior() {
            // Aquí va su código.
            return this.anterior;
        }

        /**
         * Regresa el nodo siguiente del nodo.
         * 
         * @return el nodo siguiente del nodo.
         */
        public Nodo getSiguiente() {
            // Aquí va su código.'
            return this.siguiente;
        }

        /**
         * Regresa el elemento del nodo.
         * 
         * @return el elemento del nodo.
         */
        public Estudiante get() {
            // Aquí va su código.
            return this.elemento;
        }
    }

    /* Primer elemento de la lista. */
    private Nodo cabeza;
    /* Último elemento de la lista. */
    private Nodo rabo;
    /* Número de elementos en la lista. */
    private int longitud;

    /**
     * Regresa la longitud de la lista.
     * 
     * @return la longitud de la lista, el número de elementos que contiene.
     */
    public int getLongitud() {
        // Aquí va su código.
        longitud = 0;
        Nodo viajero = this.cabeza;

        if (viajero == null) {
            longitud = 0;
            return longitud;
        }
        while (viajero != null) {
            longitud++;
            viajero = viajero.siguiente;
        }
        return longitud;

    }

    /**
     * Nos dice si la lista es vacía.
     * 
     * @return <code>true</code> si la lista es vacía, <code>false</code> en
     *         otro caso.
     */
    public boolean esVacia() {
        // Aquí va su código.
        return this.cabeza == null && this.rabo == null;

    }

    /**
     * Agrega un elemento al final de la lista. Si la lista no tiene elementos,
     * el elemento a agregar será el primero y último.
     * 
     * @param elemento el elemento a agregar. El elemento se agrega únicamente
     *                 si es distinto de <code>null</code>.
     */
    public void agregaFinal(Estudiante elemento) {
        // Aquí va su código.
        if (elemento == null) {
            return;
        }
        Nodo n = new Nodo(elemento);
        longitud++;
        if (rabo == null) {
            cabeza = rabo = n;
        } else {
            rabo.siguiente = n;
            n.anterior = rabo;
            rabo = n;
        }
    }

    /**
     * Agrega un elemento al inicio de la lista. Si la lista no tiene elementos,
     * el elemento a agregar será el primero y último.
     * 
     * @param elemento el elemento a agregar. El elemento se agrega únicamente
     *                 si es distinto de <code>null</code>.
     */
    public void agregaInicio(Estudiante elemento) {
        // Aquí va su código.
        if (elemento == null) {
            return;
        }
        Nodo n = new Nodo(elemento);
        longitud++;
        if (cabeza == null) {
            cabeza = rabo = n;
        } else {
            cabeza.anterior = n;
            n.siguiente = cabeza;
            cabeza = n;
        }
    }

    /**
     * Inserta un elemento en un índice explícito.
     *
     * Si el índice es menor o igual que cero, el elemento se agrega al inicio
     * de la lista. Si el índice es mayor o igual que el número de elementos en
     * la lista, el elemento se agrega al fina de la misma. En otro caso,
     * después de mandar llamar el método, el elemento tendrá el índice que se
     * especifica en la lista.
     * 
     * @param i        el índice dónde insertar el elemento. Si es menor que 0 el
     *                 elemento se agrega al inicio de la lista, y si es mayor o
     *                 igual
     *                 que el número de elementos en la lista se agrega al final.
     * @param elemento el elemento a insertar. El elemento se inserta únicamente
     *                 si es distinto de <code>null</code>.
     */
    public void inserta(int i, Estudiante elemento) {
        // Aquí va su código.
        if (elemento != null) {
            Nodo n = new Nodo(elemento);
            int tamanio = getLongitud();
            if (i <= 0) {
                agregaInicio(elemento);
            } else if (i >= tamanio) {
                agregaFinal(elemento);
            } else {
                Nodo viajero = this.cabeza;
                int contador = 0;
                while (contador < i - 1) {
                    viajero = viajero.siguiente;
                    contador++;
                }
                n.siguiente = viajero.siguiente;
                n.anterior = viajero;
                viajero.siguiente.anterior = n;
                viajero.siguiente = n;
                longitud++;
            }
        }
    }

    /**
     * Elimina un elemento de la lista. Si el elemento no está contenido en la
     * lista, el método no la modifica.
     * 
     * @param elemento el elemento a eliminar.
     */
    public void elimina(Estudiante elemento) {
        // Aquí va su código.

        /*
         * if(!contiene(elemento)) return;
         * // buscar al nodo que contiene al elemento
         * Nodo aEliminar = buscaNodo(elemento);
         * // Si N coincide con la cabeza
         * if(cabeza == aEliminar)
         * eliminarPrimero();
         * if (rabo == aEliminar)
         * eliminaUltimo();
         * else {
         * Nodo A = aEliminarant;
         * Nodo C = lo mismo;
         * A.sig = C
         * C.ant = A
         * longitud --;
         * }
         * 
         */

        if (elemento == null) {
            return;
        }
        Nodo porEliminar = new Nodo(elemento);
        Nodo viajero = cabeza;
        Nodo tail = rabo;
        /*
         * Nodo antesViajero = viajero.anterior;
         * Nodo despuesViajero = viajero.siguiente;
         */

        if (viajero == porEliminar || tail == porEliminar) {
            viajero = null;
            longitud--;
        } else {
            if (!porEliminar.equals(viajero)) {
                viajero.anterior = viajero;
                viajero = viajero.siguiente;
            }
            if (porEliminar.equals(viajero)) {
                viajero.anterior.siguiente = viajero.siguiente;
                viajero.siguiente.anterior = viajero.anterior;
                longitud--;
            }
        }

    }

    /**
     * Elimina el primer elemento de la lista y lo regresa.
     * 
     * @return el primer elemento de la lista antes de eliminarlo, o
     *         <code>null</code> si la lista es vacía.
     */
    public Estudiante eliminaPrimero() {
        // Aquí va su código.

        /*
         * if (esVacia())
         * return null;
         * if (cabeza == rabo){
         * Nodo copia = cabeza;
         * cabeza = cabeza.siguiente;
         * rabo = cabeza;
         * longitud = longitud -1;
         * return copia.elemento;
         * } else {
         * Nodo copia = cabeza;
         * cabeza = cabeza.siguiente;
         * cabeza.anterior = null;
         * longitud --
         * } return copia.elemento;
         * 
         */

        Nodo n = this.cabeza;
        if (n == null) {
            return null;
        } else if (n != null && n.siguiente == null) {
            this.cabeza = null;
            this.rabo = null;
            return n.elemento;
        } else {
            this.cabeza = this.cabeza.siguiente;
            this.cabeza.anterior = null;
            return n.elemento;
        }
    }

    /**
     * Elimina el último elemento de la lista y lo regresa.
     * 
     * @return el último elemento de la lista antes de eliminarlo, o
     *         <code>null</code> si la lista es vacía.
     */
    public Estudiante eliminaUltimo() {
        // Aquí va su código.
        Nodo n = this.rabo;
        if (n == null) {
            return null;
        } else if (n != null && n.anterior == null) {
            this.cabeza = null;
            this.rabo = null;
            longitud--;
            return n.elemento;
        } else {
            this.rabo = this.rabo.anterior;
            this.rabo.siguiente = null;
            longitud--;
            return n.elemento;
        }
    }

    /**
     * Nos dice si un elemento está en la lista.
     * 
     * @param elemento el elemento que queremos saber si está en la lista.
     * @return <code>true</code> si <code>elemento</code> está en la lista,
     *         <code>false</code> en otro caso.
     */
    public boolean contiene(Estudiante elemento) {
        // Aquí va su código.
        if (cabeza == null) {
            return false;
        }

        if (elemento == null) {
            return false;
        }

        Nodo viajero = this.cabeza;

        while (viajero != null) {
            if (viajero.elemento.equals(elemento)) {
                return true;
            }
            viajero = viajero.siguiente;
        }
        return false;
    }

    /**
     * Regresa la reversa de la lista.
     * 
     * @return una nueva lista que es la reversa la que manda llamar el método.
     */
    public ListaEstudiante reversa() {
        // Aquí va su código.
        ListaEstudiante reversa = new ListaEstudiante();
        Nodo n = rabo;
        while (n != null) {
            reversa.agregaFinal(n.elemento);
            n = n.anterior;
        }
        return reversa;
    }

    /**
     * Regresa una copia de la lista. La copia tiene los mismos elementos que la
     * lista que manda llamar el método, en el mismo orden.
     * 
     * @return una copiad de la lista.
     */
    public ListaEstudiante copia() {
        // Aquí va su código.
        ListaEstudiante copia = new ListaEstudiante();
        Nodo n = cabeza;
        while (n != null) {
            copia.agregaFinal(n.elemento);
            n = n.siguiente;
        }
        return copia;
    }

    /**
     * Limpia la lista de elementos, dejándola vacía.
     */
    public void limpia() {
        // Aquí va su código.
        Nodo n = cabeza;
        while (n != null) {
            elimina(n.elemento);
            n = n.siguiente;
        }
    }

    /**
     * Regresa el primer elemento de la lista.
     * 
     * @return el primer elemento de la lista, o <code>null</code> si la lista
     *         es vacía.
     */
    public Estudiante getPrimero() {
        // Aquí va su código.
        if (cabeza == null) {
            return null;
        }
        return cabeza.elemento;
    }

    /**
     * Regresa el último elemento de la lista.
     * 
     * @return el último elemento de la lista, o <code>null</code> si la lista
     *         es vacía.
     */
    public Estudiante getUltimo() {
        // Aquí va su código.
        Nodo n = rabo;
        if (n == null) {
            return null;
        }
        return n.elemento;

    }

    /**
     * Regresa el <em>i</em>-ésimo elemento de la lista.
     * 
     * @param i el índice del elemento que queremos.
     * @return el <em>i</em>-ésimo elemento de la lista, o <code>null</code> si
     *         <em>i</em> es menor que cero o mayor o igual que el número de
     *         elementos en la lista.
     */
    public Estudiante get(int i) {
        // Aquí va su código.
        Nodo n = cabeza;
        int contador = 0;
        if (i < 0 || i >= getLongitud()) {
            return null;
        } else {
            while (contador < i) {
                n = n.siguiente;
                contador++;
            }
            return n.elemento;
        }
    }

    /**
     * Regresa el índice del elemento recibido en la lista.
     * 
     * @param elemento el elemento del que se busca el índice.
     * @return el índice del elemento recibido en la lista, o -1 si el elemento
     *         no está contenido en la lista.
     */
    public int indiceDe(Estudiante elemento) {
        // Aquí va su código.

        /*
         * int indice = 0;
         * Nodo n = cabeza;
         * while (n! == null){
         * indice = indice +1;
         * n = n.siguiente;
         * }
         * if ( 0 <= i && i < longitud){
         * return i;
         * else return -1;
         * 
         * }
         */

        int contador = 0;
        Nodo n = cabeza;
        if (elemento == null) {
            return -1;
        }
        while (n != null) {
            if (n.elemento.equals(elemento)) {
                return contador;
            }
            n = n.siguiente;
            contador++;
        }
        return -1;
    }

    /**
     * Regresa una representación en cadena de la lista.
     * 
     * @return una representación en cadena de la lista.
     */
    public String toString() {
        // Aquí va su código.

        /*
         * if(esVacia())
         * return "[]"
         * if (cabeza == rabo && longitud == 1)
         * return "[" + cabeza.elemento.toString() + "]"
         * else {
         * Nodo n = cabeza;
         * //crear la cadena "[A"
         * String s = "[";
         * s = n + n.elemento.toString();
         * n = n.siguiente;
         * //repetir la cadena ", X"
         * while (n != null){
         * s += ", " + n.elemento.toString();
         * n.siguiente;
         * }
         * return s + "]";
         * }
         */

        String s = "[";
        Nodo n = cabeza;
        while (n != null) {
            s += n.elemento;
            if (n.siguiente != null) {
                s += ", ";
            }
            n = n.siguiente;
        }
        s += "]";
        return s;
    }

    /**
     * Nos dice si la lista es igual a la lista recibida.
     * 
     * @param lista la lista con la que hay que comparar.
     * @return <code>true</code> si la lista es igual a la recibida;
     *         <code>false</code> en otro caso.
     */
    public boolean equals(ListaEstudiante lista) {
        // Aquí va su código.

        /*
         * if (lista == null)
         * return
         * //comparar tamaños
         * if (lista.getLongitud() != this.getLongitud())
         * return false;
         * Nodo n = cabeza;
         * Nodo m = lista.cabeza;
         * while (n != null && m != null){
         * if (!n.elemento.equals(m.elemento))
         * return false;
         * n = n.siguiente;
         * m = m.siguiente;
         * }
         * // si nunca paso que salieramos, solo queda que sean igueales las listas
         * return true;
         * 
         * 
         */

        Nodo viajero = cabeza;
        Nodo viajero2 = lista.cabeza;

        if (lista == null) {
            return false;
        }
        if (this.getLongitud() != lista.getLongitud()) {
            return false;
        }
        while (viajero != null && viajero2 != null) {
            if (!viajero.elemento.equals(viajero2.elemento)) {
                return false;
            }
            viajero = viajero.siguiente;
            viajero2 = viajero2.siguiente;
        }
        return true;

    }

    /**
     * Regresa el nodo cabeza de la lista.
     * 
     * @return el nodo cabeza de la lista.
     */
    public Nodo getCabeza() {
        // Aquí va su código.
        return cabeza;
    }

    /**
     * Regresa el nodo rabo de la lista.
     * 
     * @return el nodo rabo de la lista.
     */
    public Nodo getRabo() {
        // Aquí va su código.
        return rabo;
    }

}
