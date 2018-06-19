package rest;

import domain.Vehicle;
import dto.JourneyDTO;
import dto.SubInvoiceDTO;
import dto.VehicleDTO;
import java.util.Base64;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import service.VehicleService;
import util.DomainToDto;
import util.DtoToDomain;

@Stateless
@Path("vehicles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class VehicleResource {

    @Inject
    VehicleService vehicleService;

    @GET
    @Path("{personId}")
    public Response getVehiclesFromUser(@PathParam("personId") String personId){
        List<VehicleDTO> vehicles = DomainToDto.VEHICLESTODTOS(vehicleService.getPersonVehicles(personId));
        return Response.ok(vehicles).build();
    }
}
