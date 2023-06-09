package facades;

import dtos.TripDTO;
import dtos.UserDTO;
import entities.Guide;
import entities.Trip;
import entities.User;

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


    public void createTrip(TripDTO tripDTO) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Trip trip = new Trip(tripDTO.getName(), tripDTO.getDate(), tripDTO.getTime(), tripDTO.getLocation(), tripDTO.getDuration(), tripDTO.getPacking_list(), tripDTO.getGuide_id());
            em.persist(trip);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void setGuideToTrip(Trip trip, Guide guide) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Trip tripEntity = em.find(Trip.class, trip.getId());
            tripEntity.setGuide(guide);
            em.getTransaction().commit();
        } finally {
            em.close();
        }

    }


    public void deleteTrip(Trip trip) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(trip);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    // assigen user to trip
    public TripDTO assignUserToTrip(TripDTO tripDTO, UserDTO userDTO) {
        if (tripDTO == null || userDTO == null) {
            throw new IllegalArgumentException("TripDTO and UserDTO cannot be null");
        }

        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            // Ensure tripDTO and userDTO contain ids
            if (tripDTO.getId() != null && userDTO.getUserName() != null) {
                // Find Trip and User entities
                Trip trip = em.find(Trip.class, tripDTO.getId());
                User user = em.find(User.class, userDTO.getUserName());

                // Check if entities were found
                if (trip == null || user == null) {
                    em.getTransaction().rollback();
                    throw new IllegalStateException("Trip or User not found");
                }

                // Update relationship
                trip.setUsers(user);
                em.merge(trip);

                em.getTransaction().commit();

                // Convert the updated Trip entity to TripDTO and return
                return assignUserToTrip(); // assuming you have this method
            } else {
                em.getTransaction().rollback();
                throw new IllegalArgumentException("TripDTO and UserDTO must have ids");
            }
        } catch (Exception e) {
            // Rollback in case of an exception
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    private TripDTO assignUserToTrip() {
        return null;
    }

}
