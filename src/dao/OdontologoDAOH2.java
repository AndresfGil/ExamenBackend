package dao;

import model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOH2 implements iDao<Odontologo> {

    private static final Logger logger= Logger.getLogger(OdontologoDAOH2.class);

    private static final String SQL_INSERT="INSERT INTO ODONTOLOGOS VALUES(?,?,?,?)";

    private static final String SQL_LIST="SELECT * FROM ODONTOLOGOS";




    @Override
    public Odontologo guardar(Odontologo odontologo) {
        logger.info("Guardando odontologo");
        Connection connection=null;
                try {
                    connection= BD.getConnection();
                    PreparedStatement psInsert= connection.prepareStatement(SQL_INSERT);
                    psInsert.setInt(1, odontologo.getId());
                    psInsert.setInt(2, odontologo.getNumeroMatricula());
                    psInsert.setString(3, odontologo.getNombre());
                    psInsert.setString(4, odontologo.getApellido());
                    psInsert.execute();


                }catch (Exception e){
                    logger.warn(e.getMessage());
                }
        return odontologo;
    }

    @Override
    public List<Odontologo> listarTodos() {
        List<Odontologo> listaOdontologos = new ArrayList<>();
        Connection connection = null;
        try {
            connection = BD.getConnection();
            PreparedStatement psList = connection.prepareStatement(SQL_LIST);
            ResultSet rs = psList.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                // Asume que tienes un constructor en la clase Odontologo que acepta estos parámetros
                Odontologo odontologo = new Odontologo(id, nombre, apellido);
                listaOdontologos.add(odontologo);
            }
            logger.info("Listando odontologos");
        } catch (Exception e) {
            logger.warn(e.getMessage());
        }
        return listaOdontologos;

    }
}
