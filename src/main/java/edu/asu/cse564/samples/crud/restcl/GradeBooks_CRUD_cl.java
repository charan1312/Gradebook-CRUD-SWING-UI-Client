/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.asu.cse564.samples.crud.restcl;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Jersey REST client generated for REST resource:AppointmentResource
 * [Appointment]<br>
 * USAGE:
 * <pre>
 *        Appointment_CRUD_cl client = new Appointment_CRUD_cl();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author fcalliss
 * @author Charan1312
 */
public class GradeBooks_CRUD_cl {
    
    private static final Logger LOG = LoggerFactory.getLogger(GradeBooks_CRUD_cl.class);
    
    private WebResource webResource;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/CRUD-GradeBook-caware1-Eclipse/rest";

    public GradeBooks_CRUD_cl() {        
        ClientConfig config = new DefaultClientConfig();
        client = Client.create(config);
        webResource = client.resource(BASE_URI).path("gradebooks");
    }

    public ClientResponse readAllGradebooks(String requestEntity) {
        return webResource.type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
    }
    
    public ClientResponse deleteAllGradebooks(String requestEntity) {
        return webResource.type(MediaType.APPLICATION_JSON).delete(ClientResponse.class, requestEntity);
    }
    
    public ClientResponse createNewGradeBook(String requestEntity) throws UniformInterfaceException {
        return webResource.path("gradebook").type(MediaType.APPLICATION_JSON).post(ClientResponse.class, requestEntity);
    }

    public ClientResponse readAGradeBook(int gbId, String requestEntity) {      // --gradebook/0
        return webResource.path("gradebook").path(String.valueOf(gbId)).type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
    }
    
    public ClientResponse updateAGradeBook(int gbId, String requestEntity) {      // --gradebook/0
        return webResource.path("gradebook").path(String.valueOf(gbId)).type(MediaType.APPLICATION_JSON).put(ClientResponse.class, requestEntity);
    }

    public ClientResponse deleteAGradeBook(int gbId, String requestEntity) {      // --gradebook/0
        return webResource.path("gradebook").path(String.valueOf(gbId)).type(MediaType.APPLICATION_JSON).delete(ClientResponse.class, requestEntity);
    }

    public ClientResponse createNewStudentInGradeBook(int gbId,String requestEntity) {         //  --gradebook/1/Student
        return webResource.path("gradebook").path(String.valueOf(gbId)).path("Student").type(MediaType.APPLICATION_JSON).post(ClientResponse.class, requestEntity);
    }
    
    public ClientResponse readAllStudentsInGradeBook(int gbId, String requestEntity) {   //  --gradebook/1/Student
        return webResource.path("gradebook").path(String.valueOf(gbId)).path("Student").type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
    }

    public ClientResponse readAStudentInGradeBook(int gbId, int sId, String requestEntity) {          //  --gradebook/1/Student/1
        return webResource.path("gradebook").path(String.valueOf(gbId)).path("Student").path(String.valueOf(sId)).type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
    }

    public ClientResponse updateAStudentInGradeBook(int gbId, int sId, String requestEntity) {         // --gradebook/1/Student/1
        return webResource.path("gradebook").path(String.valueOf(gbId)).path("Student").path(String.valueOf(sId)).type(MediaType.APPLICATION_JSON).put(ClientResponse.class, requestEntity);
    }

    public ClientResponse deleteAllStudentsInGradeBook(int gbId, String requestEntity) {                  // --gradebook/1/Student
        return webResource.path("gradebook").path(String.valueOf(gbId)).path("Student").type(MediaType.APPLICATION_JSON).delete(ClientResponse.class, requestEntity);
    }
    
    public ClientResponse deleteAStudentInGradeBook(int gbId, int sId, String requestEntity) {                  // --gradebook/1/Student/1
        return webResource.path("gradebook").path(String.valueOf(gbId)).path("Student").path(String.valueOf(sId)).type(MediaType.APPLICATION_JSON).delete(ClientResponse.class,requestEntity);
    }
    
    public ClientResponse createNewAssignmentForAllStudentsInGradeBook(int gbId, String requestEntity) {            // --gradebook/1/Student/Assignment
        return webResource.path("gradebook").path(String.valueOf(gbId)).path("Student").path("Assignment").type(MediaType.APPLICATION_JSON).post(ClientResponse.class,requestEntity);    
    }
    
    public ClientResponse createNewAssignmentForAStudentInGradeBook(int gbId, int sId, int aId, String requestEntity) {                // --gradebook/1/Student/1/Assignment/1
        return webResource.path("gradebook").path(String.valueOf(gbId)).path("Student").path(String.valueOf(sId)).path("Assignment").path(String.valueOf(aId)).type(MediaType.APPLICATION_JSON).post(ClientResponse.class,requestEntity);
    }
    

    public ClientResponse readAllAssignmentForAStudentInGradeBook(int gbId, int sId, String requestEntity) {                         // --gradebook/1/Student/1/Assignment
        return webResource.path("gradebook").path(String.valueOf(gbId)).path("Student").path(String.valueOf(sId)).path("Assignment").type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
    }
    
    public ClientResponse readAnAssignmentForAStudentInGradeBook(int gbId, int sId, int aId, String requestEntity) {               // --gradebook/1/Student/1/Assignment/1
        return webResource.path("gradebook").path(String.valueOf(gbId)).path("Student").path(String.valueOf(sId)).path("Assignment").path(String.valueOf(aId)).type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
    }
    
    public ClientResponse updateGradeForAnAssignmentForAStudentInGradeBook(int gbId, int sId, int aId, String requestEntity) {                       // --gradebook/1/Student/1/Assignment/1
        return webResource.path("gradebook").path(String.valueOf(gbId)).path("Student").path(String.valueOf(sId)).path("Assignment").path(String.valueOf(aId)).type(MediaType.APPLICATION_JSON).put(ClientResponse.class,requestEntity);
    }
    
    public ClientResponse deleteAnAssignmentForAStudentInGradeBook(int gbId, int sId, int aId, String requestEntity) {                    // --gradebook/1/Student/1/Assignment/1
        return webResource.path("gradebook").path(String.valueOf(gbId)).path("Student").path(String.valueOf(sId)).path("Assignment").path(String.valueOf(aId)).type(MediaType.APPLICATION_JSON).delete(ClientResponse.class,requestEntity);
    }
    
    public ClientResponse createNewQuizForAllStudentsInGradeBook(int gbId, String requestEntity) {            // --gradebook/1/Student/Quiz
        return webResource.path("gradebook").path(String.valueOf(gbId)).path("Student").path("Quiz").type(MediaType.APPLICATION_JSON).post(ClientResponse.class,requestEntity);    
    }
    
    public ClientResponse createNewQuizForAStudentInGradeBook(int gbId, int sId, int aId, String requestEntity) {                // --gradebook/1/Student/1/Quiz/1
        return webResource.path("gradebook").path(String.valueOf(gbId)).path("Student").path(String.valueOf(sId)).path("Quiz").path(String.valueOf(aId)).type(MediaType.APPLICATION_JSON).post(ClientResponse.class,requestEntity);
    }
    
    public ClientResponse readAllQuizForAStudentInGradeBook(int gbId, int sId, String requestEntity) {                         // --gradebook/1/Student/1/Quiz
        return webResource.path("gradebook").path(String.valueOf(gbId)).path("Student").path(String.valueOf(sId)).path("Quiz").type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
    }
    
    public ClientResponse readAQuizForAStudentInGradeBook(int gbId, int sId, int aId, String requestEntity) {               // --gradebook/1/Student/1/Quiz/1
        return webResource.path("gradebook").path(String.valueOf(gbId)).path("Student").path(String.valueOf(sId)).path("Quiz").path(String.valueOf(aId)).type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
    }
    
    public ClientResponse updateGradeForAQuizForAStudentInGradeBook(int gbId, int sId, int aId, String requestEntity) {          // --gradebook/1/Student/1/Quiz/1
        return webResource.path("gradebook").path(String.valueOf(gbId)).path("Student").path(String.valueOf(sId)).path("Quiz").path(String.valueOf(aId)).type(MediaType.APPLICATION_JSON).put(ClientResponse.class,requestEntity);
    }
    
    public ClientResponse deleteAQuizForAStudentInGradeBook(int gbId, int sId, int aId, String requestEntity) {             // --gradebook/1/Student/1/Quiz/1
        return webResource.path("gradebook").path(String.valueOf(gbId)).path("Student").path(String.valueOf(sId)).path("Quiz").path(String.valueOf(aId)).type(MediaType.APPLICATION_JSON).delete(ClientResponse.class,requestEntity);
    }
    
    public ClientResponse createNewLabForAllStudentsInGradeBook(int gbId, String requestEntity) {            // --gradebook/1/Student/Lab
        return webResource.path("gradebook").path(String.valueOf(gbId)).path("Student").path("Lab").type(MediaType.APPLICATION_JSON).post(ClientResponse.class,requestEntity);    
    }
    
    public ClientResponse createNewLabForAStudentInGradeBook(int gbId, int sId, int aId, String requestEntity) {                // --gradebook/1/Student/1/Lab/1
        return webResource.path("gradebook").path(String.valueOf(gbId)).path("Student").path(String.valueOf(sId)).path("Lab").path(String.valueOf(aId)).type(MediaType.APPLICATION_JSON).post(ClientResponse.class,requestEntity);
    }
    
    public ClientResponse readAllLabForAStudentInGradeBook(int gbId, int sId, String requestEntity) {                         // --gradebook/1/Student/1/Lab
        return webResource.path("gradebook").path(String.valueOf(gbId)).path("Student").path(String.valueOf(sId)).path("Lab").type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
    }
    
    public ClientResponse readALabForAStudentInGradeBook(int gbId, int sId, int aId, String requestEntity) {               // --gradebook/1/Student/1/Lab/1
        return webResource.path("gradebook").path(String.valueOf(gbId)).path("Student").path(String.valueOf(sId)).path("Lab").path(String.valueOf(aId)).type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
    }
    
    public ClientResponse updateGradeForALabForAStudentInGradeBook(int gbId, int sId, int aId, String requestEntity) {             // --gradebook/1/Student/1/Lab/1
        return webResource.path("gradebook").path(String.valueOf(gbId)).path("Student").path(String.valueOf(sId)).path("Lab").path(String.valueOf(aId)).type(MediaType.APPLICATION_JSON).put(ClientResponse.class,requestEntity);
    }
    
    public ClientResponse deleteALabForAStudentInGradeBook(int gbId, int sId, int aId, String requestEntity) {                    // --gradebook/1/Student/1/Lab/1
        return webResource.path("gradebook").path(String.valueOf(gbId)).path("Student").path(String.valueOf(sId)).path("Lab").path(String.valueOf(aId)).type(MediaType.APPLICATION_JSON).delete(ClientResponse.class,requestEntity);
    }
    
    public ClientResponse readMidTermForAStudentInGradeBook(int gbId, int sId, String requestEntity) {        // --gradebook/1/Student/1/MidTerm
        return webResource.path("gradebook").path(String.valueOf(gbId)).path("Student").path(String.valueOf(sId)).path("MidTerm").type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
    }

    public ClientResponse updateMidTermForAStudentInGradeBook(int gbId, int sId, String requestEntity) {      // --gradebook/1/Student/1/MidTerm
        return webResource.path("gradebook").path(String.valueOf(gbId)).path("Student").path(String.valueOf(sId)).path("MidTerm").type(MediaType.APPLICATION_JSON).put(ClientResponse.class,requestEntity);
    }
    
    public ClientResponse createAppointment(Object requestEntity) throws UniformInterfaceException {
        LOG.info("Initiating a Create request");
        LOG.debug("XML String = {}", (String) requestEntity);
        
        return webResource.type(MediaType.APPLICATION_XML).post(ClientResponse.class, requestEntity);
    }

    public ClientResponse deleteAppointment(String id) throws UniformInterfaceException {
        LOG.info("Initiating a Delete request");
        LOG.debug("Id = {}", id);
        
        return webResource.path(id).delete(ClientResponse.class);
    }

    public ClientResponse updateAppointment(Object requestEntity, String id) throws UniformInterfaceException {
        LOG.info("Initiating an Update request");
        LOG.debug("XML String = {}", (String) requestEntity);
        LOG.debug("Id = {}", id);
        
        return webResource.path(id).type(MediaType.APPLICATION_XML).put(ClientResponse.class, requestEntity);
    }

    public <T> T retrieveAppointment(Class<T> responseType, String id) throws UniformInterfaceException {
        LOG.info("Initiating a Retrieve request");
        LOG.debug("responseType = {}", responseType.getClass());
        LOG.debug("Id = {}", id);
        
        //WebResource resource = webResource;
        //resource = resource.path(id);
        
        return webResource.path(id).accept(MediaType.APPLICATION_XML).get(responseType);
    }


    public void close() {
        LOG.info("Closing the REST Client");
        
        client.destroy();
    }









    
    
    
}
