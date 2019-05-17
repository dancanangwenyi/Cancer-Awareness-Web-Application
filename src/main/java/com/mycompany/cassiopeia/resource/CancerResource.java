/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cassiopeia.resource;

import com.mycompany.cassiopeia.ejb.cancerRepository;
import com.mycompany.cassiopeia.entity.Cancer;
import java.util.HashMap;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
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
 * @author dancan
 */
@Path("/cancer")
@Stateless
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CancerResource {
    @EJB
    cancerRepository crBean;
    
    @GET
    public List<Cancer> getCancerData(){
        return crBean.findAllCancerNames();
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean addCancers(List<Cancer> cancers){
        return crBean.addListCancers(cancers);
    }
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CancerResource
     */
    public CancerResource() {
    }
    /**
     * Retrieves representation of an instance of com.mycompany.cassiopeia.CancerResource
     * @return an instance of java.lang.String
     */
//    @GET
//    @Produces(MediaType.TEXT_HTML)
//    public String getHtml() {
//        //TODO return proper representation object
//        //throw new UnsupportedOperationException();
//        return "<html><body><h1>Hello World!</body></h1></html>";
//    }

    /**
     * PUT method for updating or creating an instance of CancerResource
     * @param content representation for the resource
     */
    @PUT
    public void putHtml(String content) {
    }
}
