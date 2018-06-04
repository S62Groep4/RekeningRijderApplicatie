package service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import dao.SubInvoiceDAO;
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
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author Teun
 */
@Stateless
public class SubInvoiceService {

    @Inject
    SubInvoiceDAO subinvoiceDao;

    private static final Logger LOGGER = Logger.getLogger(SubInvoiceService.class.getName());

    public SubInvoiceService() {
    }
    

    public SubInvoice getSubInvoice(String invoiceNumber) throws PersistenceException {
        try {
            //TODO; add proper URL
            String url = "/api/subinvoices/" + invoiceNumber;
            
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet get = new HttpGet(url);
            
            HttpResponse response = client.execute(get);
            //Get the SubInvoice from the JSON data
            String json = EntityUtils.toString(response.getEntity());
            System.out.println("Result: " + json);
            
            Gson gson = new GsonBuilder().create();
            SubInvoice invoice = gson.fromJson(json, SubInvoice.class);
            return invoice;
            
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(TransLocationService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (IOException ex) {
            Logger.getLogger(TransLocationService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<SubInvoice> getAllSubInvoices(String hashedLicenseplate) throws PersistenceException {
        try {
            //TODO; add proper URL
            String url = "" + hashedLicenseplate;
            
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet get = new HttpGet(url);
            
            HttpResponse response = client.execute(get);
            //Get the SubInvoice from the JSON data
            String json = EntityUtils.toString(response.getEntity());
            System.out.println("Result: " + json);
            
            Gson gson = new GsonBuilder().create();
            
            //TODO; test this code
            Type listType = new TypeToken<List>() {}.getType();
            List<SubInvoice> invoices = gson.fromJson(json, listType);
            
            return invoices;
            
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(TransLocationService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (IOException ex) {
            Logger.getLogger(TransLocationService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
