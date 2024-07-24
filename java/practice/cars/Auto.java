package cars;

public class Auto{
    //atributos
    private int km;
    private String color;
    private int precio;
    
    //metodo constructor
    public Auto(int km, String color, int precio){
        this.km = km;
        this.color = color;
        this.precio = precio;
    }
    //getter para obtener el color
    public String color (){
        return color;
    }
    //setter para cambiar el color 
    public void cambiarColor (String color){
        this.color = color;
    } 
    //getter para obtener los kilometros
    public int  km(){
        return km;
    }
    //setter para obtener modificar el valor de los kilometros
    public void cambiarKm(int km){
        this.km = km;
    }
    //getter para obtener el precio de mi auto
    public int precio(){
        return precio;
    }
    //setter para cambiar el precio de mi auto
    public void setPrecio(int precio){
        this.precio = precio;
    }
}