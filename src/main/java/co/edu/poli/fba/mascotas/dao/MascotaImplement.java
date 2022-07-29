package co.edu.poli.fba.mascotas.dao;

import co.edu.poli.fba.mascotas.models.Mascota;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class MascotaImplement implements MascotaDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Mascota> getMascotas() {
        String query = "FROM Mascota";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Mascota getMascota(int id) {
        return entityManager.find(Mascota.class, id);
    }

    @Override
    public Mascota createMascota(Mascota mascota) {
        return entityManager.merge(mascota);
    }

    @Override
    public Mascota updatedMascota(int id, Mascota mascota) {
        mascota.setId(id);
        return entityManager.merge(mascota);
    }

    @Override
    public Mascota deleteMascota(int id) {
        Mascota m = entityManager.find(Mascota.class, id);
        entityManager.remove(m);
        return m;

    }
}
