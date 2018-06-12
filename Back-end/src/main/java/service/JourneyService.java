package service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import dao.JourneyDAO;
import domain.Journey;
import java.io.IOException;
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
public class JourneyService {

    @Inject
    JourneyDAO journeyDao;

    private static final Logger LOGGER = Logger.getLogger(JourneyService.class.getName());

    public JourneyService() {
    }

    public Journey getJourney(Long id) throws PersistenceException {
        try {
            return journeyDao.getJourney(id);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getVehicle operation; {0}", pe.getMessage());
            return null;
        }
    }

    public List<Journey> getAllJourneys() throws PersistenceException {
        try {
            return journeyDao.getAllJourneys();
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getAllVehicles operation; {0}", pe.getMessage());
            return null;
        }
    }

    public Journey updateJourney(Journey journey) throws PersistenceException {
        try {
            return journeyDao.updateJourney(journey);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing updateVehicle operation; {0}", pe.getMessage());
            return null;
        }
    }

    public void removeJourney(Long id) throws PersistenceException {
        try {
            journeyDao.removeJourney(id);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing removeVehicle operation; {0}", pe.getMessage());
        }
    }

    public Journey insertJourney(Journey journey) throws PersistenceException {
        try {
            return journeyDao.insertJourney(journey);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing insertVehicle operation; {0}", pe.getMessage());
            return null;
        }
    }
    
    public List<Journey> getJourneysFromInvoice(String invoiceId){
        try {
            String url = "";
            
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet get = new HttpGet(url);
            
            HttpResponse response = httpClient.execute(get);
            String json = EntityUtils.toString(response.getEntity());
            
            Gson gson = new GsonBuilder().create();
            
            Type listType = new TypeToken<List>() {}.getType();
            List<Journey> journeys = gson.fromJson(json, listType);
            return journeys;
        } catch (IOException ex) {
            Logger.getLogger(JourneyService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
