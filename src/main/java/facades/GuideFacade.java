package facades;

import dtos.GuideDTO;
import entities.Guide;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

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

    public List<GuideDTO> getAllGuides() {

        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Guide> query = em.createQuery("SELECT g FROM Guide g", Guide.class);
            query.getResultList();

            List<GuideDTO> guideDTOS = new ArrayList<>();
            for (Guide guide : query.getResultList()) {
                System.out.println("Hello from getAllGuides" + guide);
                GuideDTO guideDTO = new GuideDTO();
                guideDTO.setName(guide.getName());
                guideDTO.setBirth_year(guide.getBirthYear());
                guideDTO.setGender(guide.getGender());
                guideDTO.setImage_url(guide.getImage_url());
                guideDTO.setProfile(guide.getProfile());
                guideDTOS.add(guideDTO);
            }
            return guideDTOS;

        } finally {
            em.close();
        }

    }

    public void createGuide(GuideDTO guideDTO) {
        EntityManager em = emf.createEntityManager();
        try {
            Guide guide = new Guide(guideDTO.getName(), guideDTO.getGender(), guideDTO.getBirth_year(), guideDTO.getProfile(), guideDTO.getImage_url());
            em.getTransaction().begin();
            em.persist(guide);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    // Trip trip = new Trip(tripDTO.getName(), tripDTO.getDate(), tripDTO.getTime(), tripDTO.getLocation(), tripDTO.getDuration(), tripDTO.getPacking_list());

}
