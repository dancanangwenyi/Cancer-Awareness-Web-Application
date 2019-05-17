/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cassiopeia.resource;

import com.mycompany.cassiopeia.ejb.SymptomRepository;
import com.mycompany.cassiopeia.entity.Symptom;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author dancan
 */
@Path("/symptom")
@Stateless
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SymptomResource {
    @EJB
    SymptomRepository srBean;
    
    @GET
    public List<Symptom> getSymptomData(){
        return srBean.findAllSymptoms();
    }
    
    @POST
    public List<Symptom> addSymptomData(List<Symptom> list){
        return srBean.addAllSymptoms(list);
    } 
}
