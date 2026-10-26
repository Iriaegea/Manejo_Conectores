import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ud02act2 {
    static void main() {
        String ruta = "./data/instituto";
        String url = "jdbc:h2:"+ruta;
        String usuario = "sa";
        String contraseña = "";



        String sql = "CREATE TABLE IF NOT EXISTS Ciclos (" +
                "id INT PRIMARY KEY AUTO_INCREMENT, " +
                "nombre VARCHAR(100) NOT NULL, " +
                "grado VARCHAR(50) CHECK(grado IN('medio', 'superior'))" +
                ")";


        try(Connection conn = DriverManager.getConnection(url, usuario, contraseña);

            Statement stmt = conn.createStatement()){
            stmt.executeUpdate(sql);
            System.out.println("Tabla creada o ya existente");

            String registro1  = "INSERT INTO Ciclos(nombre, grado) VALUES( 'Iria', 'superior')";
            System.out.println("Registro insertado");
            stmt.executeUpdate(registro1);
            String registro2  = "INSERT INTO Ciclos(nombre, grado) VALUES( 'Maria', 'superior')";
            System.out.println("Registro insertado");
            stmt.executeUpdate(registro2);


            String modificarRegistro = "UPDATE Ciclos SET grado = 'medio' WHERE nombre = 'Iria'";
            int filasModificadas = stmt.executeUpdate(modificarRegistro);
            System.out.println("Total de filas modificadas: " + filasModificadas);

        }catch(SQLException e){
            System.out.println("Error: "+ e.getMessage());
        }


    }




}
