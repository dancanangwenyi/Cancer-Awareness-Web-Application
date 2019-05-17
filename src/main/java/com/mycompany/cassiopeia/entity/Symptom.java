/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cassiopeia.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dancan
 */
@Entity
@Table(name = "symptom", catalog = "cancerdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Symptom.findAll", query = "SELECT s FROM Symptom s")
    , @NamedQuery(name = "Symptom.findBySymptomID", query = "SELECT s FROM Symptom s WHERE s.symptomID = :symptomID")
    , @NamedQuery(name = "Symptom.findBySymptomName", query = "SELECT s FROM Symptom s WHERE s.symptomName = :symptomName")
    , @NamedQuery(name = "Symptom.findByCancerStage", query = "SELECT s FROM Symptom s WHERE s.cancerStage = :cancerStage")})
public class Symptom implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "symptomID", nullable = false)
    private Integer symptomID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "symptomName", nullable = false, length = 255)
    private String symptomName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cancerStage", nullable = false)
    private int cancerStage;
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Cancer id;

    public Symptom() {
    }

    public Symptom(Integer symptomID) {
        this.symptomID = symptomID;
    }

    public Symptom(Integer symptomID, String symptomName, int cancerStage) {
        this.symptomID = symptomID;
        this.symptomName = symptomName;
        this.cancerStage = cancerStage;
    }

    public Integer getSymptomID() {
        return symptomID;
    }

    public void setSymptomID(Integer symptomID) {
        this.symptomID = symptomID;
    }

    public String getSymptomName() {
        return symptomName;
    }

    public void setSymptomName(String symptomName) {
        this.symptomName = symptomName;
    }

    public int getCancerStage() {
        return cancerStage;
    }

    public void setCancerStage(int cancerStage) {
        this.cancerStage = cancerStage;
    }

    public Cancer getId() {
        return id;
    }

    public void setId(Cancer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (symptomID != null ? symptomID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Symptom)) {
            return false;
        }
        Symptom other = (Symptom) object;
        if ((this.symptomID == null && other.symptomID != null) || (this.symptomID != null && !this.symptomID.equals(other.symptomID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.cassiopeia.entity.Symptom[ symptomID=" + symptomID + " ]";
    }
    
}
