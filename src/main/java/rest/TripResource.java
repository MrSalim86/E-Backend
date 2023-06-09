package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.TripDTO;
import dtos.UserDTO;
import facades.TripFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;

@Path("trip")
public class TripResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final TripFacade FACADE = TripFacade.getTripFacade(EMF);

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getAllTrip() {
        return "{\"msg\":\"Hello Mohamed\"}";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("all")
    public String getAllTrips() {
        // Assuming FACADE.getAllTrips() returns a valid List<TripDTO>
        List<TripDTO> trips = FACADE.getAllTrips();
        System.out.println("Hello from getAllTrips" + trips);
        return GSON.toJson(trips);

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("assignUserToTrip")
    public String assignUserToTrip(TripDTO tripDTO, UserDTO userDTO) {
        // assignUserToTrip() should return a valid TripDTO
        // Assuming the request body is a valid AssignTripRequest
        TripDTO trip = FACADE.assignUserToTrip(tripDTO, userDTO);
        return GSON.toJson(trip);
    }

}

