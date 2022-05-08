package App;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Manager {
    private static Manager managerInstance = null;
    public EntityManagerFactory em;

    private Manager() {

        em = Persistence.createEntityManagerFactory("hibernate.persistence");
    }

    public static Manager getInstance() {
        if (managerInstance == null) {
            managerInstance = new Manager();
        }
        return managerInstance;
    }
}
