package vectores;

public class Vector{
	public static final int CAPACIDAD = 30;
	private double[] vec;
	private int cant;
	
//constructor por defecto
public Vector(){
	this(CAPACIDAD);
	
}	
//constructor 
public Vector (int capacidad){
	vec = new double[capacidad];
	cant = 0;
}

public void agregar(double n){
	vec[this.cant] = n;
	cant++;
}
//getter para obtener la cantidad
public int getCant(){
	return cant;
}

//getter para obtener el elemento corriente
public double getElem(int pos){
	double elem = 0;
	for(int i = 0;i <= pos ;i++){
		elem = vec[i];
	}
	return elem;
}
//multiplicacion por un escalar
	public Vector multEscalar(double escalar){
		if(cant == 0){
			throw new IllegalStateException("uno de los argumentos no es valido");
		}
		Vector v1 = new Vector();
		for(int i = 0;i<cant;i++){
			v1.vec[i] = this.vec[i] * escalar;
			v1.cant++;
		}
		return v1;
	}
//suma de dos vectores
	 
	public Vector suma(Vector vector2){
		if(!(this.cant == vector2.cant)){
			throw new IllegalStateException("los elementos deben ser del mismo tamaño");
		}
		Vector v1 = new Vector(this.cant);
		for(int i=0;i< cant;i++){
			v1.vec[i] = vector2.vec[i] + this.vec[i];
			v1.cant++;
		}
		return v1;
	}
	
	//producto punto
	public double productoPoint(Vector v2){
		double acum = 0;
		if(!(v2.cant == this.cant )){
			throw new IllegalStateException("argumento no valido");
		}
		for(int i = 0; i < this.cant ; i++){
			acum = acum + v2.vec[i] * this.vec[i];
		}
		return acum;
	}

	@Override
	public boolean equals(Object otro){
		if(otro == null)
		return false;

		if(otro == this)
		return true;

		if(!(otro instanceof Vector))
		return false;
		
		Vector otroVec = (Vector) otro;
	
		if(!(otroVec.getCant()== this.cant))
		return false;

		for(int i = 0;i < this.cant;i++){
			if(!(this.vec[i] == otroVec.getElem(i))){
				return false;
			}
		}
		return true;
}

	@Override
	public String toString(){
		if(cant == 0){
			String result = "vector vacio";
			return result;
		}
		String result = "[";
		for(int i=0;i<cant;i++){
			result += this.vec[i]; 
			if(!(i+1 == cant)){
				result = result + " , ";
			}
		}
		return result + "]";
	}
}
