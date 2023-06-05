package facades;

import dtos.TripDTO;
import entities.Trip;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class TripFacade {

    private static TripFacade instance;
    private static EntityManagerFactory emf;

    private TripFacade() {

    }

    public static TripFacade getTripFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new TripFacade();
        }
        return instance;
    }

    private EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }

    public List<TripDTO> getAllTrips() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Trip> query = em.createQuery("SELECT t FROM Trip t", Trip.class);
            List<Trip> trips = query.getResultList();


            List<TripDTO> tripDTO = new ArrayList<>();
            for (Trip trip : trips) {
                System.out.println("Hello from getAllTrips" + trip);
                TripDTO tripDTO1 = new TripDTO();
                tripDTO1.setName(trip.getName());
                tripDTO1.setDate(trip.getDate());
                tripDTO1.setTime(trip.getTime());
                tripDTO1.setLocation(trip.getLocation());
                tripDTO1.setDuration(trip.getDuration());
                tripDTO1.setPacking_list(trip.getPackingList());
                tripDTO.add(tripDTO1);
            }
            return tripDTO;
        } finally {
            em.close();
        }
    }


    public void createTrip(Trip trip) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(trip);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

}
