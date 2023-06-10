package utils;


import entities.Guide;
import entities.Role;
import entities.Trip;
import entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class SetupTestUsers {

  public static void main(String[] args) {

    EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
    EntityManager em = emf.createEntityManager();
    
    // IMPORTAAAAAAAAAANT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    // This breaks one of the MOST fundamental security rules in that it ships with default users and passwords
    // CHANGE the three passwords below, before you uncomment and execute the code below
    // Also, either delete this file, when users are created or rename and add to .gitignore
    // Whatever you do DO NOT COMMIT and PUSH with the real passwords
// this.name = name;
//        this.date = date;
//        this.time = time;
//        this.location = location;
//        this.duration = duration;
//        this.packingList = packingList;
//        this.guide = guide;
    User user = new User("user", "test123");
    User admin = new User("admin", "test123");
    User both = new User("user_admin", "test123");
    User user1 = new User("mo", "test123", "low-way", "+918976543", "Mo@gmail.com", 1986, "male");
    Guide guide1 = new Guide("hans", "male", 1986, "linkind", "https://unsplash.com/photos/9aZAZF4SoiA");
    Guide guide2 = new Guide("kim", "male", 1988, "linkind", "https://unsplash.com/photos/dV5Yz97d_6Q");
    Guide guide3 = new Guide("lone", "female", 2008, "facebook", "https://unsplash.com/photos/f2Em6TIQObc");
    Trip trip = new Trip("London", "22-12-2020", 22, "big appel", "aarhus", "22", guide1);
    Trip trip2 = new Trip("Dubai", "22-12-2022", 15, "skydive", "kbh", "sun class", guide2);
    Trip trip3 = new Trip("Bali", "22-12-2024", 11, "sol", "london", "suncream", guide3);

    if(admin.getUserPass().equals("test")||user.getUserPass().equals("test")||both.getUserPass().equals("test"))
      throw new UnsupportedOperationException("You have not changed the passwords");

    em.getTransaction().begin();
    Role userRole = new Role("user");
    Role adminRole = new Role("admin");
    user1.addRole(userRole);
    user.addRole(userRole);
    admin.addRole(adminRole);
    both.addRole(userRole);
    both.addRole(adminRole);
    em.persist(userRole);
    em.persist(adminRole);
    em.persist(user);
    em.persist(user1);
    em.persist(admin);
    em.persist(both);
    em.getTransaction().commit();
    System.out.println("PW: " + user.getUserPass());
    System.out.println("Testing user with OK password: " + user.verifyPassword("test"));
    System.out.println("Testing user with wrong password: " + user.verifyPassword("test1"));
    System.out.println("Created TEST Users");
    em.getTransaction().begin();
    em.persist(guide1);
    em.persist(guide2);
    em.persist(guide3);
    em.persist(trip);
    em.persist(trip2);
    em.persist(trip3);
    em.getTransaction().commit();

    System.out.println("Created TEST Guides");
   
  }

}
