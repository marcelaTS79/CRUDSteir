
package clases;
import java.sql.*;
/**
 *
 * @author Marce Tangarife
 */
public class Conexion {
    Connection cn;
    PreparedStatement ps;
    ResultSet rs;
    
    public Conexion(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/steir","root","diosesamor");
            System.out.println("Conectado BD");
        }catch (Exception e){
            System.out.println("Error al conectar a BD");
        }
    }
    public int Reusuario(String Nombres_apellidos, String Tipo_documento, String Número, String Email, String Teléfono, String Clave){
        int res=0;
        try{
            ps=cn.prepareStatement("insert into usuario(Nombres_apellidos,Tipo_documento,Número,Email,Teléfono,Clave)values (?,?,?,?,?,?)");
            ps.setString(1, Nombres_apellidos);
            ps.setString(2, Tipo_documento);
            ps.setString(3, Número);
            ps.setString(4, Email);
            ps.setString(5, Teléfono);
            ps.setString(6, Clave);
            res=ps.executeUpdate();
            System.out.println("usuario registrado correctamente");
        } catch (Exception e){
            System.out.println ("Error al registrar");
        }
        return res;
    }
    
    public int Acusuario (String Nombres_apellidos, String Tipo_documento, String Número, String Email, String Teléfono, String Clave, String idusuario){
        int res=0;
        try{
           ps=cn.prepareStatement("update usuario set Nombres_apellidos=?, Tipo_documento=?, Número=?, Email=?, Teléfono=?, Clave=? where idusuario=?");
           ps.setString(1, Nombres_apellidos);
           ps.setString(2, Tipo_documento);
           ps.setString(3, Número);
           ps.setString(4, Email);
           ps.setString(5, Teléfono);
           ps.setString(6, Clave);
           ps.setString(7, idusuario);
           res=ps.executeUpdate();
           System.out.println("Datos modificados correctamente");
        } catch (Exception e){
            System.out.println("Error al modificar datos");
        }
        return res;
    }
    
    public int Elusuario(String idusuario){
        int res=0;
        try{
           ps=cn.prepareStatement("delete from usuario where idusuario=?");
           ps.setString(1, idusuario);
           res=ps.executeUpdate();
           System.out.println("usuario eliminado correctamente");
        } catch (Exception e){
            System.out.println("Error al eliminar usuario");
        }
        return res;
    }

    
    
}
