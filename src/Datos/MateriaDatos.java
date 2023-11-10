package Datos;

import Entidades.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class MateriaDatos {

    private static Connection con = Conexion1.getConexion();
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;

    public static void guardarMateria(Materia materia) {
        String sql = "insert into materia(nombre, año, anual, estado) value(?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAño());
            ps.setBoolean(3, materia.isAnual());
            ps.setBoolean(4, materia.isEstado());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                materia.setIdMateria(rs.getInt(1));
                System.out.println("Se agrego con exito al ID");
            } else {
                System.out.println("no se obtuvo al ID");
            }
            ps.close();
            JOptionPane.showMessageDialog(null, ">>> Guardado <<<");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al insertar " + ex.getMessage());
        }
    }

    public static Materia buscarMateriaPorId(int id) {
        String sql = "select nombre, año, anual from materia where idMateria = ? and estado = 1";
        Materia materia = new Materia();
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                materia.setIdMateria(id);
                materia.setNombre(rs.getString("nombre"));
                materia.setAño(rs.getInt("año"));
                materia.setAnual(rs.getBoolean("anual"));
                materia.setEstado(rs.getBoolean("estado"));
            } else {
                JOptionPane.showMessageDialog(null, "Materia no encontrada o Inactiva");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: Acceso Materia");
        }
        return materia;
    }

    public static List<Materia> listarMaterias() {
        List<Materia> listaMaterias = new ArrayList<>();
        String sqlMateria = "select * from materia";
        try {
            ps = con.prepareStatement(sqlMateria);
            rs = ps.executeQuery();
            while (rs.next()) {
                Materia materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAño(rs.getInt("año"));
                materia.setAnual(rs.getBoolean("anual"));
                materia.setEstado(rs.getBoolean("estado"));
                listaMaterias.add(materia);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla de materias");
        }
        System.out.println("---> Lista de Materias Registrada");
        return listaMaterias;
    }
    
    public static List<Materia> listarMateriasActivas() {
        List<Materia> listaMaterias = new ArrayList<>();
        String sqlMateria = "select * from materia where estado = 1";
        try {
            ps = con.prepareStatement(sqlMateria);
            rs = ps.executeQuery();
            while (rs.next()) {
                Materia materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAño(rs.getInt("año"));
                materia.setAnual(rs.getBoolean("anual"));
                materia.setEstado(rs.getBoolean("estado"));
                listaMaterias.add(materia);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla de materias");
        }
        System.out.println("---> Lista de Materias Registrada");
        return listaMaterias;
    }

    public static void modicarMateria(Materia materia) {
        String sql = "update materia set nombre = ?, año = ?, anual = ? where idMateria = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAño());
            ps.setBoolean(3, materia.isAnual());
            ps.setInt(4, materia.getIdMateria());
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Materia Actualizado");
            } else {
                JOptionPane.showMessageDialog(null, "Error: Materia no Existe");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceso a la tabla Materia" + ex.getMessage());
        }
    }

    public static void eliminarMateria(int id) {
        String sql = "update materia set estado = 0 where idMateria = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int fila = ps.executeUpdate();
            if (fila == 1) {
                JOptionPane.showMessageDialog(null, "---> Materia Eliminada");
            } else {
                JOptionPane.showMessageDialog(null, "---> Materia inactiva");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceso a la tabla Materia" + ex.getMessage());
        }

    }
}
