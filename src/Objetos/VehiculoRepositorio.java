
package Objetos;

import Objetos.VehiculoRepositorio;
import Objetos.Vehiculos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Miriam
 */
public class VehiculoRepositorio implements Repositorio<Vehiculos>{

    public Connection getConnection() throws Exception {
        try {
            String lib = "jdbc";
            String base = "derby";
            String servidor = "localhost";
            String puerto = "1527";
            String nombreBase = "VehiculoDB";

            String cadenaConexion = String.format("%s:%s://%s:%s/%s", lib, base, servidor, puerto, nombreBase);
            String usuario = "UTH";
            String contrasenia = "UTH";

            return DriverManager.getConnection(cadenaConexion, usuario, contrasenia);
        } catch (Exception e) {
            throw new Exception("No se pudo establecer la conexión: " + e.toString());
        }
    }

    
    public void crear(Vehiculos t) throws Exception {
        try {
            Connection cnx = getConnection();

            String sql = "INSERT INTO VEHICULOS(PLACA, MODELO, MARCA, ANIO, MOTOR, PRECIO, NOMBRE, DESCRIPCION, IMAGEN) "
                    + " VALUES "
                    + "(?,?,?,?,?,?,?,?,?) ";
            
            PreparedStatement ps=cnx.prepareStatement(sql);
            ps.setString(1, t.getPlaca());
            ps.setString(2, t.getModelo());
            ps.setString(3, t.getMarca());
            ps.setInt(4, t.getAnio());
            ps.setString(5, t.getMotor());
            ps.setDouble(6, t.getPrecio());
            ps.setString(7, t.getNombre());
            ps.setString(8, t.getDescripcion());
            ps.setString(9, t.getImagen());
            
            ps.execute();
            
            ps.close();
            cnx.close();
        } catch (Exception e) {
            throw new Exception("Error al insertar: " + e.toString());
        }
    }


    public void eliminar(Vehiculos t) throws Exception {

        try {
            Connection cnx = getConnection();

            String sql = "DELETE FROM VEHICULOS "
                    + "WHERE PLACA=?";

            PreparedStatement ps = cnx.prepareStatement(sql);
            ps.setString(1, t.getPlaca());

            ps.execute();

            ps.close();
            cnx.close();
        } catch (Exception e) {
            throw new Exception("Error al eliminar: " + e.toString());
        }
    }

   
    public void actualizar(Vehiculos t) throws Exception {

        try {
            //Traer la conexion o la session
            Connection cnx = getConnection();

            String sql = "UPDATE VEHICULOS "
                    + "SET MODELO=?, MARCA=?, ANIO=?, MOTOR=?, PRECIO=?, NOMBRE=?, DESCRIPCION=?, IMAGEN=?"
                    + "WHERE PLACA=?";

            PreparedStatement ps = cnx.prepareStatement(sql);
            ps.setString(1, t.getModelo());
            ps.setString(2, t.getMarca());
            ps.setInt(3, t.getAnio());
            ps.setString(4, t.getMotor());
            ps.setDouble(5, t.getPrecio());
            ps.setString(6, t.getNombre());
            ps.setString(7, t.getDescripcion());
            ps.setString(8, t.getImagen());
            ps.setString(9, t.getPlaca());

            ps.execute();

            ps.close();
            cnx.close();
        } catch (Exception e) {
            throw new Exception("Error al actualizar: " + e.toString());
        }
    }

    public Vehiculos buscar(Object id) throws Exception {
        Vehiculos valorRetorno = new Vehiculos("placa", "modelo", "marca", 0, "motor", 0, "nombre", "descripcion", "imagen");
        try {
            Connection cnx = getConnection();

            String sql = "SELECT * FROM VEHICULOS WHERE PLACA = '"+id+"' ";

            Statement st = cnx.createStatement();

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                String placa = resultado.getString("PLACA");
                String modelo= resultado.getString("MODELO");
                String marca= resultado.getString("MARCA");
                int anio = resultado.getInt("ANIO");
                String motor = resultado.getString("MOTOR");
                double precio = resultado.getDouble("PRECIO");
                String nombre = resultado.getString("NOMBRE");
                String descripcion = resultado.getString("DESCRIPCION");
                String imagen = resultado.getString("IMAGEN");
                                
                valorRetorno.setPlaca(placa);
                valorRetorno.setModelo(modelo);
                valorRetorno.setMarca(marca);
                valorRetorno.setAnio(anio);
                valorRetorno.setMotor(motor);
                valorRetorno.setPrecio(precio);
                valorRetorno.setNombre(nombre);
                valorRetorno.setDescripcion(descripcion);
                valorRetorno.setImagen(imagen);
            }

            st.close();
            cnx.close();
                        
        } catch (Exception e) {
            throw new Exception("Error al buscar todos: " + e.toString());
        }
        return valorRetorno;
    }

    public List<Vehiculos> buscarTodo()throws Exception {
         List<Vehiculos> listaRetorno=new ArrayList<>();
        try {
            Connection cnx = getConnection();

            String sql = "SELECT * FROM VEHICULOS ";

            Statement st = cnx.createStatement();

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                Vehiculos valorRetorno = new Vehiculos("placa", "modelo", "marca", 0, "motor", 0, "nombre", "descripcion", "imagen");
                
                String placa = resultado.getString("PLACA");
                String modelo= resultado.getString("MODELO");
                String marca= resultado.getString("MARCA");
                int anio = resultado.getInt("ANIO");
                String motor = resultado.getString("MOTOR");
                double precio = resultado.getDouble("PRECIO");
                String nombre = resultado.getString("NOMBRE");
                String descripcion = resultado.getString("DESCRIPCION");
                String imagen = resultado.getString("IMAGEN");
                                
                valorRetorno.setPlaca(placa);
                valorRetorno.setModelo(modelo);
                valorRetorno.setMarca(marca);
                valorRetorno.setAnio(anio);
                valorRetorno.setMotor(motor);
                valorRetorno.setPrecio(precio);
                valorRetorno.setNombre(nombre);
                valorRetorno.setDescripcion(descripcion);
                valorRetorno.setImagen(imagen);
                
                listaRetorno.add(valorRetorno);
            }

            st.close();
            cnx.close();
        } catch (Exception e) {
            throw new Exception("Error al buscar todos: " + e.toString());
        }
        return listaRetorno;
    }
}
