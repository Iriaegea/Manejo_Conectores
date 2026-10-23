import java.sql.*;

public class ud02act1 {
    static void main() {
 String url = "jdbc:h2:mem:mi_base";
 String usuario = "sa";
 String contraseña = "";

 String sql = "CREATE TABLE Alumnos (" +
         "id INT PRIMARY KEY AUTO_INCREMENT, " +
         "nombre VARCHAR(100) NOT NULL, " +
         "edad INT" +
         ")";

 String insertar1 = "INSERT INTO Alumnos (nombre, edad) VALUES ('Iria', 22)";
 String insertar2 = "INSERT INTO Alumnos (nombre, edad) VALUES ('Maria', 26)";
 String insertar3 = "INSERT INTO Alumnos (nombre, edad) VALUES ('Martin', 50)";

 String borrar = "DELETE FROM Alumnos";

 try(Connection conn = DriverManager.getConnection(url,usuario, contraseña);
 Statement stmt = conn.createStatement()){
    int resultado = stmt.executeUpdate(sql);
     System.out.println("Tabla creada correctamente(0): " + resultado);

     int resIns1= stmt.executeUpdate(insertar1);
        if (resIns1 >0){
            System.out.println("Insertado");
        } else {
            System.out.println("Error");
        }
     int resIns2= stmt.executeUpdate(insertar2);
     if (resIns2 >0){
         System.out.println("Insertado");
     } else {
         System.out.println("Error");
     }
     int resIns3= stmt.executeUpdate(insertar3);
     if (resIns3 >0){
         System.out.println("Insertado");
     } else {
         System.out.println("Error");
     }

     int totalBorrados = stmt.executeUpdate(borrar);
     System.out.println("Se han borrado " + totalBorrados);



 }catch (SQLException e){
     System.out.println("Error " +  e.getMessage());
 }




    }
}
