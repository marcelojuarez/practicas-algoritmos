package cola;

public class ColaPriori<T>{
    public static final int MAX = 100;
    private TuplaPriori[] cola;
    private int elem;

//constructor de la clase
public ColaPriori(){
    cola= (TuplaPriori[]) new Object[MAX];
    elem = 0;
}

//constructor de la clase con longitud
public ColaPriori(int length){
    cola = (TuplaPriori[]) new Object[length];
    elem = 0;
}

//metodo insertar

public TuplaPriori[] insertar(TuplaPriori tupla){
    if(this.elem == 0){
        this.cola[0] = tupla;
        return true;
    }else{
        if(this.elem == MAX){
            return false;            
        }
        int i=0;
        while((this.cola[i].getPrioridad()) < tupla.getPrioridad()){
                i=i++;
            }
            this.cola[i] = tupla;
            return true;
        }
    
    }
    
}
