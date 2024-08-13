package Model;


public class Registro {
    private int numero;
    private String nombre;
    private String tiporeceta;
    private String sabor;
    private String recetapap;
    private Float precio;
    

    public Registro() {
    }

    public Registro( String nombre, String tiporeceta, String sabor, String recetapap, Float precio) {
        
        this.nombre = nombre;
        this.tiporeceta = tiporeceta;
        this.sabor = sabor;
        this.recetapap = recetapap;
        this.precio = precio;
        
        
    }

 



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTiporeceta() {
        return tiporeceta;
    }

    public void setTiporeceta(String tiporeceta) {
        this.tiporeceta = tiporeceta;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public String getRecetapap() {
        return recetapap;
    }

    public void setRecetapap(String recetapap) {
        this.recetapap = recetapap;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public void showInfo(){
        System.out.println("Objeto Registro :  " +  nombre + "," + tiporeceta + "," + sabor + "," + recetapap + "," + precio);  
    }
 }
    
