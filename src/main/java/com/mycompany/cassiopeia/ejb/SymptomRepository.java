/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cassiopeia.ejb;

import com.mycompany.cassiopeia.entity.Symptom;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author dancan
 */
@Stateless
public class SymptomRepository {

    @PersistenceContext(unitName="com.mycompany_cassiopeia_war_1.0-SNAPSHOTPU")
    protected EntityManager em;

    public EntityManager getEntityManager() {
        return em;
    }
    
    public Symptom createSymptom(Symptom symptom){
        getEntityManager().persist(symptom);
        return symptom;
    }
    
    public List<Symptom> findAllSymptoms(){ 
        TypedQuery<Symptom> query = getEntityManager().createQuery(
                "SELECT s FROM Symptom s", Symptom.class);
        return query.getResultList();
    }
    
    public Symptom findSymptom(int id){
        return getEntityManager().find(Symptom.class, id);    
    }
    
    public List<Symptom> addAllSymptoms(List<Symptom> list){
        for(Symptom symptom: list){createSymptom(symptom);}
        return list;
   }
    
}