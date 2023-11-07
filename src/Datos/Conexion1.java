package Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion1 {

    private static final String url = "jdbc:mariadb://localhost/universidadutn";
    private static final String usuario = "root";
    private static final String password = "";

    private static Conexion1 conexion = null;

    private Conexion1() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Clase Conexion: Error al cargar Driver");
        }
    }

    public static Connection getConexion() {
        Connection con = null;
        if (conexion == null) {

            conexion = new Conexion1();
        }
        try {
            // Setup the connection with the DB
            con = DriverManager.getConnection(url + "?useLegacyDatetimeCode=false&serverTimezone=UTC" + "&user=" + usuario + "&password=" + password);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion ");
        }

        return con;
    }
}