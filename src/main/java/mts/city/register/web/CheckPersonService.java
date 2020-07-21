package mts.city.register.web;

import mts.city.register.business.CityManager;
import mts.city.register.view.PersonRequest;
import mts.city.register.view.PersonResponse;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Веб-сервис, который по факту является сервлетом
 */
@Path("/check")
@Singleton
public class CheckPersonService {

    CityManager manager;

    @PostConstruct
    public void init() {
        System.out.println("INIT");
        manager = new CityManager();
    }


    // TODO 105
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public PersonResponse checkPerson(PersonRequest personRequest) {

//        PersonRequest pr = new PersonRequest();
//        pr.setSurName("Васильев");
//        pr.setGivenName("Павел");
//        pr.setPatronymicName("Николаевич");
//        pr.setDateOfBirth(LocalDate.of(1995,3,18));
//        pr.setStreetCode(1);
//        pr.setBuilding("10");
//        pr.setExtension("2");
//        pr.setApartment("141");
//
        System.out.println(personRequest);

        return manager.checkPerson(personRequest);
    }

//    @GET
//    @Path("/{id}")
//    public String checkPerson(@PathParam("id") int simpleId,
//                              @QueryParam("name") String simpleName) {
//
//         http://localhost:8080/CityRegisterOffice-h/rest/check/201?name=qwe
//         201: qwe
//        return simpleId + ": " +simpleName;
//    }

//    @GET
//    public String checkPerson() {
//        return "Simple string";
//    }
}
