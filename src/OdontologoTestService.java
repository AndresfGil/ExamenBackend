

import dao.BD;
import dao.OdontologoDAOCollection;
import model.Odontologo;
import service.OdontologoService;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class OdontologoTestService {

    @Test
    public void testAgregarOdontologo() {
        // Crear una instancia de OdontologoDAOCollection para simular la base de datos en memoria
        OdontologoDAOCollection daoCollection = new OdontologoDAOCollection();
        // Crear una instancia de OdontologoService utilizando OdontologoDAOCollection
        OdontologoService odontologoService = new OdontologoService(daoCollection);

        // Crear un odontólogo para guardar
        Odontologo odontologo = new Odontologo(1, 227374, "Jorge", "Guzman");

        // Llamar al método guardarOdontologo() para guardar el odontólogo
        odontologoService.guardarOdontologo(odontologo);

        // Listar todos los odontólogos en la base de datos simulada
        List<Odontologo> odontologos = odontologoService.listarOdontologos();

        // Verificar que el odontólogo guardado está presente en la lista
        assertEquals(1, odontologos.size());
        // Verificar que el odontólogo guardado es el mismo que el que se intentó guardar
        assertEquals(odontologo, odontologos.get(0));
    }
}
