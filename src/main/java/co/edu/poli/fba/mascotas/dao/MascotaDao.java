package co.edu.poli.fba.mascotas.dao;

import co.edu.poli.fba.mascotas.models.Mascota;

import java.util.List;

public interface MascotaDao {

    List<Mascota> getMascotas();

    Mascota getMascota(int id);

    Mascota createMascota(Mascota mascota);

    Mascota updatedMascota(int id, Mascota mascota);

    Mascota deleteMascota(int id);
}
