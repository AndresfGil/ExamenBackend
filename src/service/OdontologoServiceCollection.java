package service;

import dao.OdontologoDAOCollection;
import dao.iDao;
import model.Odontologo;

import java.util.List;

public class OdontologoServiceCollection {
    private iDao<Odontologo> odontologoiDao;

    public OdontologoServiceCollection() { odontologoiDao= new OdontologoDAOCollection();}

    public Odontologo guardarOdontologo(Odontologo odontologo){
        return odontologoiDao.guardar(odontologo);
    }

    public List<Odontologo> listarOdontologos(){
        return odontologoiDao.listarTodos();
    }
}
