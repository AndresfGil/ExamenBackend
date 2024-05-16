package service;

import dao.OdontologoDAOCollection;
import dao.OdontologoDAOH2;
import dao.iDao;
import model.Odontologo;

import java.util.List;

public class OdontologoService {
    private iDao<Odontologo> odontologoiDao;

    public OdontologoService(OdontologoDAOCollection daoCollection) { odontologoiDao= new OdontologoDAOH2();}

    public Odontologo guardarOdontologo(Odontologo odontologo){
        return odontologoiDao.guardar(odontologo);
    }

    public List<Odontologo> listarOdontologos(){
        return odontologoiDao.listarTodos();
    }

}
