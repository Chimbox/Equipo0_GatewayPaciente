/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restService;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Alfonso Felix
 */
@Path("paciente")
public class PacienteResource {

    private AuthPacienteClient authPaciente;
    private CitasClient citas;
    private ExpedienteClient expedientes;
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PacienteResource
     */
    public PacienteResource() {
        authPaciente=new AuthPacienteClient();
        citas=new CitasClient();
        expedientes=new ExpedienteClient();
    }

    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String postLogin(String json) {
        
        return authPaciente.postLogin(json);
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getPacienteResource() {
        return "ejecutando";
    }
    
    @POST
    @Path("/actualizarSolicitud")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String postActualizarSolicitud(String json) {
        citas.postActualizarSolicitud(json);
        return json;
    }
}
