/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cassiopeia;

import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.EntityManager;

/**
 *
 * @author dancan
 */
@WebService(serviceName = "cancerController")
public class cancerController {

    @EJB
    private cancerRepository ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "getEntityManager")
    public EntityManager getEntityManager() {
        return ejbRef.getEntityManager();
    }

    @WebMethod(operationName = "createEmployee")
    public Cancer createEmployee(@WebParam(name = "id") int id, @WebParam(name = "cancerName") String cancerName, @WebParam(name = "lethalDegree") String lethalDegree, @WebParam(name = "treatmentType") String treatmentType) {
        return ejbRef.createEmployee(id, cancerName, lethalDegree, treatmentType);
    }

    @WebMethod(operationName = "findCancerName")
    public Cancer findCancerName(@WebParam(name = "id") int id) {
        return ejbRef.findCancerName(id);
    }

    @WebMethod(operationName = "findAllCancerNames")
    public List<Cancer> findAllCancerNames() {
        return ejbRef.findAllCancerNames();
    }
    
}
