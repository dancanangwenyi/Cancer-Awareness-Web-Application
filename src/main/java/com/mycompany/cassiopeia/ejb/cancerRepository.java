/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cassiopeia.ejb;

import com.mycompany.cassiopeia.entity.Cancer;
import javax.persistence.*;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author dancan
 */
@Stateless
public class cancerRepository {
    @PersistenceContext(unitName="com.mycompany_cassiopeia_war_1.0-SNAPSHOTPU")
    protected EntityManager em;

    public EntityManager getEntityManager() {
        return em;
    }
    
  
    public Cancer createCancerName(Cancer cancer) {
//        Cancer cancer = new Cancer(id);
//        cancer.setCancerName(cancerName);
//        cancer.setLethalDegree(lethalDegree);
//        cancer.setTreatmentType(treatmentType);
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
    public boolean addListCancers(List<Cancer> list){
        boolean dan = false;
        try{
            for(Cancer c:list){
                /*Cancer c = new Cancer();
                c.setLethalDegree(c_hm.get("lethalDegree").toString());
                c.setLethalDegree(c_hm.get("treatmentType").toString());
                c.setLethalDegree(c_hm.get("cancerName").toString());*/
                createCancerName(c);
            }
            dan = true;
        }
        catch(Exception e){
            
        }
        finally{
            return dan;
        }
    }

}
