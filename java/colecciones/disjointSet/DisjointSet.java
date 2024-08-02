package disjointSet;

/**
* Esta interfaz representa un conjunto disjunto o Disjoint Set, 
* también conocido como Union-Find, que permite operaciones eficientes de 
* unión y búsqueda en conjuntos disjuntos.
* Las operaciones disponibles para esta estructura son:
* <ul>
*   <li> find: Encuentra el representante del conjunto que contiene un elemento</li>
*   <li> union: Une dos conjuntos en un solo conjunto</li>
*   <li> connected: Verifica si dos elementos están en el mismo conjunto</li>
*   <li> repOK: Permite validar si una instancia satisface el invariante de representación</li>
*   <li> toString: Retorna una representación en forma de cadena</li>
*   <li> equals: Permite evaluar si otra instancia de DisjointSet es igual a esta</li>
* </ul>
*/
public interface DisjointSet {

    /**
    * Encuentra el representante del conjunto que contiene el elemento especificado.
    * @param x el elemento del que se quiere encontrar el representante
    * @return el representante del conjunto que contiene el elemento
    */
    public int find(int x);

    /**
    * Une los conjuntos que contienen los dos elementos especificados.
    * @param x el primer elemento
    * @param y el segundo elemento
    * @return {@code true} si los conjuntos fueron unidos, {@code false} si ya estaban unidos
    */
    public boolean union(int x, int y);

    /**
    * Verifica si los dos elementos especificados están en el mismo conjunto.
    * @param x el primer elemento
    * @param y el segundo elemento
    * @return {@code true} si los elementos están en el mismo conjunto, {@code false} en caso contrario
    */
    public boolean connected(int x, int y);

    /**
    * Invariante de clase.
    * @return {@code true} si el DisjointSet satisface su invariante de clase
    */
    public boolean repOK();

    @Override
    public String toString();

    @Override
    public boolean equals(Object other);
}
