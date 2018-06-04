package rest;

import domain.SubInvoice;
import dto.SubInvoiceDTO;
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
import service.SubInvoiceService;
import util.DomainToDto;
import util.DtoToDomain;

/**
 *
 * @author Teun
 */
@Stateless
@Path("subinvoices")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SubInvoiceResource {

    @Inject
    SubInvoiceService subInvoiceService;
    
    @GET
    @Path("{invoiceNumber}")
    public Response getSubInvoice(@PathParam("invoiceNumber") String invoiceNumber) {
        SubInvoiceDTO dto = DomainToDto.SUBINVOICESTODTOS(subInvoiceService.getSubInvoice(invoiceNumber));
        return Response.ok(dto).build();
    }
    
    @GET
    @Path("{hashedLicenseplate}")
    public Response getSubInvoicesForVehicle(@PathParam("hashedLicenseplate") String hashedLicenseplate){
        List<SubInvoiceDTO> dtos = DomainToDto.SUBINVOICESTODTOS(subInvoiceService.getAllSubInvoices(hashedLicenseplate));
        return Response.ok(dtos).build();
    }
}
