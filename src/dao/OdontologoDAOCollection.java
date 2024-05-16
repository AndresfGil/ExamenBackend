package dao;

import model.Odontologo;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OdontologoDAOCollection implements iDao<Odontologo> {

    private final Map<Integer, Odontologo> odontologosMap = new HashMap<>();
    private static int idCounter = 1;
    private static final Logger logger= Logger.getLogger(OdontologoDAOCollection.class);


    @Override
    public Odontologo guardar(Odontologo odontologo) {
        logger.info("Guardando odontologo");
        odontologo.setId(idCounter++);
        odontologosMap.put(odontologo.getId(), odontologo);
        return odontologo;
    }

    @Override
    public List<Odontologo> listarTodos() {
        logger.info("Listando odontologos");
        return new ArrayList<>(odontologosMap.values());
    }
}
