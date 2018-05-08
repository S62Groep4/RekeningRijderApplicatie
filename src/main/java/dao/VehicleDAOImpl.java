package dao;

import domain.Journey;
import domain.SubInvoice;
import domain.Vehicle;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

/**
 *
 * @author Teun
 */
@Stateless
public class VehicleDAOImpl implements VehicleDAO {

    @PersistenceContext(name = "ptt_test")
    EntityManager em;

    @Override
    public List<Vehicle> getAllVehicles() throws PersistenceException {
        return em.createNamedQuery("Vehicle.findAll").getResultList();
    }

    @Override
    public Vehicle getVehicle(String hashedLicenceplate) throws PersistenceException {
        return (Vehicle) em.createNamedQuery("Vehicle.findByLicenceplate").setParameter("hashedLicencePlate", hashedLicenceplate).getSingleResult();
    }

    @Override
    public List<SubInvoice> getVehicleInvoices(String hashedLicencePlate) throws PersistenceException {
        return em.createNamedQuery("Vehicle.findInvoices").setParameter("hashedLicencePlate", hashedLicencePlate).getResultList();
    }

    @Override
    public List<Journey> getVehicleJourneys(String hashedLicencePlate) throws PersistenceException {
        return em.createNamedQuery("Vehicle.findJourneys").setParameter("hashedLicencePlate", hashedLicencePlate).getResultList();
    }

    @Override
    public Vehicle updateVehicle(Vehicle vehicle) throws PersistenceException {
        return em.merge(vehicle);
    }

    @Override
    public void removeVehicle(String hashedLicenceplate) throws PersistenceException {
        Vehicle temp = em.find(Vehicle.class, hashedLicenceplate);

        for (Journey j : temp.getJourneys()) {
            em.remove(j);
        }
        for (SubInvoice si : temp.getSubInvoices()) {
            em.remove(si);
        }

        em.remove(temp);
    }

    @Override
    public Vehicle insertVehicle(Vehicle vehicle) throws PersistenceException {
        em.persist(vehicle);
        return vehicle;
    }
}
