package util;

import domain.Journey;
import domain.SubInvoice;
import domain.TransLocation;
import domain.Vehicle;
import dto.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 *
 * @author Teun
 */
public class DtoToDomain {

    public static List<Vehicle> VEHICLE_DTO_TO_DOMAIN(List<VehicleDTO> vehicleDTOs) {
        List<Vehicle> vehicles = new ArrayList<>();
        if (vehicleDTOs == null || vehicleDTOs.isEmpty()) {
            return vehicles;
        }

        for (VehicleDTO v : vehicleDTOs) {
            Vehicle vehicle = new Vehicle(new String(Base64.getDecoder().decode(v.getHashedLicensePlate())));
            vehicles.add(vehicle);
        }
        return vehicles;
    }

    public static Vehicle VEHICLE_DTO_TO_DOMAIN(VehicleDTO vehicleDTO) {
        if (vehicleDTO == null) {
            return new Vehicle();
        }
        return new Vehicle(new String(Base64.getDecoder().decode(vehicleDTO.getHashedLicensePlate())));
    }

    public static List<SubInvoice> SUBINVOICE_DTO_TO_DOMAIN(List<SubInvoiceDTO> invoiceDTOs) {
        List<SubInvoice> invoices = new ArrayList<>();
        if (invoiceDTOs == null || invoiceDTOs.isEmpty()) {
            return invoices;
        }

        for (SubInvoiceDTO s : invoiceDTOs) {
            SubInvoice invoice = new SubInvoice(
                    s.getInvoiceNumber(),
                    s.getCountry(),
                    Double.parseDouble(s.getPrice()),
                    s.getInvoiceDate(),
                    s.getPaymentStatus());
            invoices.add(invoice);
        }
        return invoices;
    }

    public static SubInvoice SUBINVOICE_DTO_TO_DOMAIN(SubInvoiceDTO invoiceDTO) {
        if (invoiceDTO == null) {
            return new SubInvoice();
        }
        return new SubInvoice(
                invoiceDTO.getInvoiceNumber(),
                invoiceDTO.getCountry(),
                Double.parseDouble(invoiceDTO.getPrice()),
                invoiceDTO.getInvoiceDate(),
                invoiceDTO.getPaymentStatus());
    }

    public static List<Journey> JOURNEY_DTO_TO_DOMAIN(List<JourneyDTO> journeyDTOs) {
        List<Journey> journeys = new ArrayList<>();
        if (journeyDTOs == null || journeyDTOs.isEmpty()) {
            return journeys;
        }

        for (JourneyDTO j : journeyDTOs) {
            Journey journey = new Journey(j.getId());
            journeys.add(journey);
        }
        return journeys;
    }

    public static Journey JOURNEY_DTO_TO_DOMAIN(JourneyDTO journeyDTO) {
        if (journeyDTO == null) {
            return new Journey();
        }

        return new Journey(journeyDTO.getId());
    }

    public static List<TransLocation> TRANSLOCATION_DTO_TO_DOMAIN(List<TransLocationDTO> locationDTOs) {
        List<TransLocation> translocations = new ArrayList<>();
        if (locationDTOs == null || locationDTOs.isEmpty()) {
            return translocations;
        }

        for (TransLocationDTO t : locationDTOs) {
            TransLocation location = new TransLocation(
                    Double.longBitsToDouble(t.getLat()),
                    Double.longBitsToDouble(t.getLon()),
                    t.getSerialNumber(),
                    t.getCountryCode());
            translocations.add(location);
        }
        return translocations;
    }

    public static TransLocation TRANSLOCATION_DTO_TO_DOMAIN(TransLocationDTO locationDTO) {
        if (locationDTO == null) {
            return new TransLocation();
        }

        return new TransLocation(
                Double.longBitsToDouble(locationDTO.getLat()),
                Double.longBitsToDouble(locationDTO.getLon()),
                locationDTO.getSerialNumber(),
                locationDTO.getCountryCode());
    }
}
