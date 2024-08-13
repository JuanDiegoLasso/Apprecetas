package Controller;

import Model.Registro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;



import java.util.ArrayList;
import java.util.List;


public class SQLregistro {
    
    private SQLConnect conn;
    
    public SQLregistro(SQLConnect conn_in) {
        this.conn = conn_in;
    }
    
    public void InsertaRegistro(Registro registro){
        try {
            Connection reg;
            reg = conn.getConnection();
            //registro.showInfo();
            String sql = "INSERT INTO recetas( nombre, tipo, sabor, receta, precio" 
             + ") VALUES(?,?,?,?,?)";
            try(PreparedStatement stm = reg.prepareStatement(sql)){
                 stm.setString(1,registro.getNombre());
                 stm.setString(2,registro.getTiporeceta());
                 stm.setString(3, registro.getSabor());
                 stm.setString(4, registro.getRecetapap());
                 stm.setFloat(5, registro.getPrecio());
                    //ese numero es para cada signo de interrogacion 
                 stm.execute();
                if(stm != null)
                    stm.close();                             
            }
        }   catch (SQLException e) {
            System.out.println("SQLException");
             throw new RuntimeException();
             }        
    }
    
   
   
    private void transformResultadorooms(List<Registro> registro, PreparedStatement statement) throws SQLException{
        try(ResultSet result = statement.executeQuery()) {
            while(result.next()){
                                
                String nombre = result.getString("nombre");                
                String tiporeceta = result.getString("tipo");                
                String sabor = result.getString("sabor");                                
                String recetapap = result.getString("receta");                                
                Float precio = result.getFloat("precio");                                                                

                Registro obj = new Registro( nombre, tiporeceta, sabor, recetapap, precio);
                
                registro.add(obj);
            }
        } catch (SQLException e) {
            System.out.println("ERRRROOR");
            throw new RuntimeException();
        }
    }
    
    public List<Registro> ConsultaRecetas(){
        Connection reg;
        reg = conn.getConnection();

        List<Registro> registro = new ArrayList<Registro>();
        try {
            String sql = "SELECT * FROM recetas"
                    ;
            try(PreparedStatement stm = reg.prepareStatement(sql)){
                stm.execute();
                transformResultadorooms(registro, stm);
            }
            return registro;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
    

}
