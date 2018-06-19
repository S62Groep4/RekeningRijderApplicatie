package service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import dao.VehicleDAO;
import domain.Journey;
import domain.SubInvoice;
import domain.Vehicle;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.PersistenceException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author Teun
 */
@Stateless
public class VehicleService {

    @Inject
    VehicleDAO vehicleDao;

    private static final Logger LOGGER = Logger.getLogger(VehicleService.class.getName());

    public VehicleService() {
    }

    public Vehicle getVehicle(String hashedLicenceplate) throws PersistenceException {
        try {
            return vehicleDao.getVehicle(hashedLicenceplate);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getVehicle operation; {0}", pe.getMessage());
            return null;
        }
    }
    
    public List<Vehicle> getPersonVehicles(String personId){
            try {
            //TODO; add proper URL
            String url = "/api/vehicles/owner/" + personId;
            
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet get = new HttpGet(url);
            
            HttpResponse response = client.execute(get);
            //Get the SubInvoice from the JSON data
            String json = EntityUtils.toString(response.getEntity());
            System.out.println("Result: " + json);
            
            Gson gson = new GsonBuilder().create();
            
            //TODO; test this code
            Type listType = new TypeToken<List>() {}.getType();
            List<Vehicle> vehicles = gson.fromJson(json, listType);
            
            return vehicles;
            
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(TransLocationService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (IOException ex) {
            Logger.getLogger(TransLocationService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public List<SubInvoice> getVehicleInvoices(String hashedLicenceplate) throws PersistenceException {
        try {
            return vehicleDao.getVehicleInvoices(hashedLicenceplate);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getVehicleInvoices operation; {0}", pe.getMessage());
            return null;
        }
    }
    
    public List<Journey> getVehicleJourneys(String hashedLicenceplate) throws PersistenceException {
        try {
            return vehicleDao.getVehicleJourneys(hashedLicenceplate);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getVehicleJourneys operation; {0}", pe.getMessage());
            return null;
        }
    }

    public List<Vehicle> getAllVehicles() throws PersistenceException {
        try {
            return vehicleDao.getAllVehicles();
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getAllVehicles operation; {0}", pe.getMessage());
            return null;
        }
    }

    public Vehicle updateVehicle(Vehicle vehicle) throws PersistenceException {
        try {
            return vehicleDao.updateVehicle(vehicle);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing updateVehicle operation; {0}", pe.getMessage());
            return null;
        }
    }

    public void removeVehicle(String hashedLicenceplate) throws PersistenceException {
        try {
            vehicleDao.removeVehicle(hashedLicenceplate);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing removeVehicle operation; {0}", pe.getMessage());
        }
    }

    public Vehicle insertVehicle(Vehicle vehicle) throws PersistenceException {
        try {
            return vehicleDao.insertVehicle(vehicle);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing insertVehicle operation; {0}", pe.getMessage());
            return null;
        }
    }
}
