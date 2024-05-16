

import dao.BD;
import dao.OdontologoDAOCollection;
import model.Odontologo;
import service.OdontologoService;
import org.junit.jupiter.api.Test;
import service.OdontologoServiceCollection;

import java.util.List;
import static org.junit.Assert.assertEquals;

public class OdontologoTestService {

    @Test
    public void testAgregarOdontologo() {
        OdontologoServiceCollection odontologoServiceCollection = new OdontologoServiceCollection();

        // Crear un odontólogo para guardar
        Odontologo odontologo = new Odontologo(1, 227374, "Jorge", "Guzman");

        odontologoServiceCollection.guardarOdontologo(odontologo);

        OdontologoService odontologoService = new OdontologoService();

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
