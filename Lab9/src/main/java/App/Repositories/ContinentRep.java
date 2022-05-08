package App.Repositories;

import App.Entities.Continent;
import App.Manager;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ContinentRep {
        private static EntityManager entityManager = Manager.getInstance().em.createEntityManager();
    public static Continent create(Continent continent) {
        entityManager.getTransaction().begin();
        entityManager.persist(continent);
        entityManager.getTransaction().commit();
        return continent;
    }
    public static Continent findById(int id) {
            return entityManager.find(Continent.class, id);
        }
}
