package cola;

public class TuplaPriori<T>{
    private T info;
    private int prioridad;

    //getter para obtener el primer elemento
    public T getInfo(){
        return info;
    }
    //getter para obtener el segundo elemento
    public int getPrioridad(){
        return prioridad;
    }

    //setter para cambiar el info
    public void setInfo(T info)

    //setter para cambiar al prioridad
    public void setPrioridad(T priori){
        this.prioridad = priori;
    }
    //constructor de la clase
    public TuplaPriori(T inf,int priori){
        this.info = inf;
        this.prioridad = priori;
    }
}