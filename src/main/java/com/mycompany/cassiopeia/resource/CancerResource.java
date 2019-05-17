/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cassiopeia.resource;

import com.mycompany.cassiopeia.ejb.cancerRepository;
import com.mycompany.cassiopeia.entity.Cancer;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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
    
    /**
     * Creates a new instance of CancerResource
     */
    public CancerResource() {
    }

}
