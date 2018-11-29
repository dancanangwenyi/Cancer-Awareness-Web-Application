/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cassiopeia;

import javax.persistence.*;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author dancan
 */
@Stateless
public class cancerRepository {
    @PersistenceContext(unitName="POSTGRESQL_PU")
    protected EntityManager em;

    EntityManager getEntityManager() {
        return em;
    }
  
    public Cancer createEmployee(int id, String cancerName, String lethalDegree, String treatmentType) {
        Cancer cancer = new Cancer(id);
        cancer.setCancerName(cancerName);
        cancer.setLethalDegree(lethalDegree);
        cancer.setTreatmentType(treatmentType);
        getEntityManager().persist(cancer);
        return cancer;
    }

    public Cancer findCancerName(int id) {
        return getEntityManager().find(Cancer.class, id);
    }

    public List<Cancer> findAllCancerNames() {
        TypedQuery<Cancer> query = getEntityManager().createQuery(
                "SELECT c FROM Cancer c", Cancer.class);
        return query.getResultList();
    }

}
