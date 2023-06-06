package rest;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.GuideDTO;
import facades.GuideFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

@Path("guide")
public class GuideResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final GuideFacade FACADE = GuideFacade.getGuideFacade(EMF);

    @GET
    public String hello() {
        return "{\"msg\":\"Hello Guide\"}";
    }

    @GET
    @Path("all")
    public String getAllGuides() {
        List<GuideDTO> guides = FACADE.getAllGuides();
        System.out.println("Hello from getAllGuides" + guides);
        return GSON.toJson(guides);
    }
}
