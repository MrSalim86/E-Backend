/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import javax.persistence.EntityManagerFactory;

import dtos.TripDTO;
import dtos.UserDTO;
import entities.Guide;
import entities.Trip;
import entities.User;
import utils.EMF_Creator;

/**
 * @author tha
 */
public class Populator {
    public static void populate() {
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
      /*FacadeExample fe = FacadeExample.getFacadeExample(emf);
       fe.create(new RenameMeDTO(new RenameMe("First 1", "Last 1")));
       fe.create(new RenameMeDTO(new RenameMe("First 2", "Last 2")));
        fe.create(new RenameMeDTO(new RenameMe("First 3", "Last 3")));*/
        TripFacade tf = TripFacade.getTripFacade(emf);

    }

    public static void main(String[] args) {
        //Trip trip = new Trip("London", "22-12-2020", 22, "big appel", "kbh", "22", new Guide("hans", "mail", 1986, "linkind", "1234"));
        //Trip trip2 = new Trip("London", "22-12-2020", 22, "big appel", "kbh", "22", new Guide("kim", "mail", 1988, "linkind", "1234"));

        //TripFacade tf = TripFacade.getTripFacade(EMF_Creator.createEntityManagerFactory());
        Guide guide = new Guide("hans", "mail", 1986, "linkind", "1234");
        Guide guide2 = new Guide("kim", "mail", 1988, "linkind", "1234");

        GuideFacade gf = GuideFacade.getGuideFacade(EMF_Creator.createEntityManagerFactory());


        /*User user = new User("GoMo", "Go1234");
        UserFacade uf = UserFacade.getUserFacade(EMF_Creator.createEntityManagerFactory());
        uf.createUser(user);*/


    }
}
