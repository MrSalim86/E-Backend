package facades;

import javax.persistence.EntityManagerFactory;

public class GuideFacade {

    private static GuideFacade instance;
    private static EntityManagerFactory emf;

    private GuideFacade() {

    }

    public static GuideFacade getGuideFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new GuideFacade();
        }
        return instance;
    }

    private EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }

    public void createGuide() {


    }
}
