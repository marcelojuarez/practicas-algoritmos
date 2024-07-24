package pila;

import pila.Pila;

public class PilaArreglo<T> implements Pila<T>  {
    //atributos
    public static final int CAPACIDAD_POR_DEFECTO = 20;
   private Object[] arreglo;
   private int elementos;

    //getter para obtener la cantidad de elementos
    public int getElem(){
        return elementos;
    }

    //constructor por defecto
    public PilaArreglo(){
        this(CAPACIDAD_POR_DEFECTO);
    }

    //constructor
    public PilaArreglo(int capacidad){
        if (capacidad < 0){
            throw new IllegalArgumentException("la capacidad del arreglo debe ser un numero coherente por favor");
        }
        arreglo = new Object[capacidad];
    }

    public T tope(){
        if(esVacia()){
            throw new IllegalStateException("no puedo mostrar el elemento de una pila vacia");
        }
         return (T) arreglo[0];
    }
    
    public boolean apilar(T elem){
        if(this.elementos == CAPACIDAD_POR_DEFECTO){
            throw new IllegalStateException("error pila llena");
        }

        for(int i=0; i< elementos();i++){
            arreglo[i+1] = arreglo[i];
        }
        arreglo[0] = elem;
        elementos++;
        return true;
    }        

    
    /**
     * Desapila el ultimo elemento de la pila
     */
    public T desapilar(){
        if(arreglo == null || esVacia()){
            throw new IllegalAccessError("no es posible desapilar de una pila vacia");
        }
        
        T acum = (T) arreglo[0];
        for (int i = 0 ;i < elementos(); i++) {
            arreglo[i] = arreglo[i+1];
        }
        elementos--;
        return acum;
    }

    
    /**
     * Devuelve la cantidad de elementos que contiene la pila
     * @return la cantidad de elementos de la pila
     */
    public int elementos(){
        return elementos;
    }

    /**
     * Devuelve si la pila está o no vacía
     * @return si la pila está vacía
     */
    public boolean esVacia(){
        return (elementos == 0);
    }

    /**
     * Vacía la pila
     */
    public void empty(){
        if (!(esVacia())) {
            for (int i = 0 ;i < elementos() ; i++) {
                
            }
        }
    }

    @Override
    public String toString(){
        String result = "[";
        for (int i = 0 ; i < elementos() ;i++) {
            result += arreglo[i].toString();
            if (!(i == elementos()-1)) {
                result += ",";
            }
        }
        return result + "]";
    }
}
