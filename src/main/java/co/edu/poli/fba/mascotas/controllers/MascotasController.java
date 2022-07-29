package co.edu.poli.fba.mascotas.controllers;

import co.edu.poli.fba.mascotas.dao.MascotaDao;
import co.edu.poli.fba.mascotas.models.Mascota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MascotasController {

    @Autowired
    private MascotaDao mascotaDao;

    @RequestMapping(value = "test")
    public String test(){
        return "Hola Spring Boot FBA";
    }

    @RequestMapping(value = "api/mascotas", method = RequestMethod.GET)
    public List<Mascota> getMascotas(){
        return mascotaDao.getMascotas();
    }

    @RequestMapping(value = "api/mascota/{id}", method = RequestMethod.GET)
    public Mascota getMascota(@PathVariable("id") int id){
        return mascotaDao.getMascota(id);
    }

    @RequestMapping(value = "api/mascota", method = RequestMethod.POST)
    public Mascota createMascota(@RequestBody Mascota m){
        return mascotaDao.createMascota(m);
    }

    @RequestMapping(value = "api/mascota/{id}", method = RequestMethod.PUT)
    public Mascota createMascota(@PathVariable("id") int id, @RequestBody Mascota m){
        return mascotaDao.updatedMascota(id, m);
    }

    @RequestMapping(value = "api/mascota/{id}", method = RequestMethod.DELETE)
    public Mascota deleteMascota(@PathVariable("id") int id){
        return mascotaDao.deleteMascota(id);
    }

}
