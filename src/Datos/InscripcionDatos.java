package Datos;

import Entidades.Inscripcion;
import Entidades.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class InscripcionDatos {

    private static Connection con = Conexion1.getConexion();
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;

    public static void guardarInscripcion(Inscripcion insc) {
        String sql = "insert into inscripcion (nota, idAlumno, idMateria) value(?, ?, ?)";
        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, insc.getNota());
            ps.setInt(2, insc.getAlumno().getIdAlumno());
            ps.setInt(3, insc.getMateria().getIdMateria());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                insc.setIdInscripcion(rs.getInt(1));
                System.out.println("Se genero el ID Inscripcion");
            } else {
                System.out.println("no se genero el ID Inscripcion");
            }
            ps.close();
            JOptionPane.showMessageDialog(null, ">>> Guardado <<<");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al insertar " + ex.getMessage());
        }
    }

    public static Inscripcion buscarInscripcionPorId(int id) {
        String busquedaSQL = "select nota, idAlumno, idMateria from inscripcion where idInscripcion = ?";
        Inscripcion insc = new Inscripcion();
        try {
            ps = con.prepareStatement(busquedaSQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                insc.setIdInscripcion(id);
                insc.setNota(rs.getDouble("nota"));
                insc.setAlumno(AlumnoDatos.buscarAlumnosPorId(rs.getInt("idAlumno")));
                insc.setMateria(MateriaDatos.buscarMateriaPorId(rs.getInt("idMateria")));
            } else {
                JOptionPane.showMessageDialog(null, "Inscripcion no Encontrada o Inactiva");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: Acceso Inscripcion");
        }
        return insc;
    }
    
    public static Inscripcion buscarInscripcionPorIdAlu(int idAlu) {
        String busquedaSQL = "select * from inscripcion where idAlumno = ?";
        Inscripcion insc = new Inscripcion();
        try {
            ps = con.prepareStatement(busquedaSQL);
            ps.setInt(1, idAlu);
            rs = ps.executeQuery();
            if (rs.next()) {
                insc.setIdInscripcion(rs.getInt("idInscripcion"));
                insc.setNota(rs.getDouble("nota"));
                insc.setAlumno(AlumnoDatos.buscarAlumnosPorId(idAlu));
                insc.setMateria(MateriaDatos.buscarMateriaPorId(rs.getInt("idMateria")));
            } else {
                JOptionPane.showMessageDialog(null, "Inscripcion no Encontrada o Inactiva");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: Acceso Inscripcion");
        }
        return insc;
    }

    public static List<Inscripcion> listarInscripciones() {
        List<Inscripcion> listaInsc = new ArrayList<>();
        String sqlBusqueda = "select * from inscripcion";
        try {
            ps = con.prepareStatement(sqlBusqueda);
            rs = ps.executeQuery();
            while (rs.next()) {
                Inscripcion inscripcion = new Inscripcion();
                inscripcion.setIdInscripcion(rs.getInt("idInscripcion"));
                inscripcion.setNota(rs.getInt("Nota"));
                inscripcion.setAlumno(AlumnoDatos.buscarAlumnosPorId(rs.getInt("idAlumno")));
                inscripcion.setMateria(MateriaDatos.buscarMateriaPorId(rs.getInt("idMateria")));
                listaInsc.add(inscripcion);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a los datos de las tablas" + ex.getMessage());
        }
        return listaInsc;
    }

    public static List<Materia> obtenerMateriasCursadas(int idA) {
        List<Materia> materia = new ArrayList<>();
        
        String sqlBusqueda = "SELECT inscripcion.idMateria, nombre, año, anual, estado FROM inscripcion JOIN materia ON(inscripcion.idMateria=materia.idMateria) WHERE inscripcion.idAlumno = ?";
        
        try {
            ps = con.prepareStatement(sqlBusqueda);
            ps.setInt(1, idA);
            rs = ps.executeQuery();
            while (rs.next()) {
                Materia materia1 = new Materia();
                materia1.setIdMateria(rs.getInt("idMateria"));
                materia1.setNombre(rs.getString("Nombre"));
                materia1.setAño(rs.getInt("Año"));
                materia1.setAnual(rs.getBoolean("anual"));
                materia1.setEstado(rs.getBoolean("estado"));
                materia.add(materia1);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a los datos de la tabla inscripción" + ex.getMessage());
        }
        return materia;

    }
    
     public static List<Materia> obtenerMateriasNoCursadas(int idA){
        
         List<Materia> materiaNoCursadas=new ArrayList<>();
        
        String sqlBusqueda="select * from materia where estado=1 and idMateria not in (select idMateria from inscripcion where idAlumno=?)";
        try {
            ps=con.prepareStatement(sqlBusqueda);
             ps.setInt(1,idA);
            rs=ps.executeQuery();
            while(rs.next()){
                Materia materiaNo = new Materia();
                materiaNo.setIdMateria(rs.getInt("idMateria"));
                materiaNo.setNombre(rs.getString("Nombre"));
                materiaNo.setAño(rs.getInt("Año"));
                materiaNo.setAnual(rs.getBoolean("anual"));
                materiaNo.setEstado(rs.getBoolean("estado"));
                materiaNoCursadas.add(materiaNo);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a los datos de la tabla inscripción"+ex.getMessage());
        }
        return materiaNoCursadas;
    }

    public static void modificarInscripcion(Inscripcion insc) {
        String sql = "update inscripcion set nota = ?, idAlumno = ?, idMateria = ? where idInscripcion = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setDouble(1, insc.getNota());
            ps.setInt(2, insc.getAlumno().getIdAlumno());
            ps.setInt(3, insc.getMateria().getIdMateria());
            int fila = ps.executeUpdate();
            if (fila > 0) {
                JOptionPane.showMessageDialog(null, "Nota Actualizada");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: Al acceder a la tabla inscripcion");
        }
    }

    public static void eliminarInscripcion(int id) {
        String sql = "delete from inscripcion where idInscripcion = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int fila = ps.executeUpdate();
            if (fila > 0) {
                JOptionPane.showMessageDialog(null, "Inscripcion Borrada");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: Al acceder a la tabla inscripcion");
        }
    }

}
