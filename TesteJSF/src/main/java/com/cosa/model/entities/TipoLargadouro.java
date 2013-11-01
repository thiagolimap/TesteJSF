/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cosa.model.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author Thiago
 */
@Entity
@Table (name = "tipoLargadouro")
public class TipoLargadouro implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name = "idLargadouro", nullable = false)
    private Integer idLargadouro;
    
    @Column(name = "descricaoLargadouro", nullable = false, length = 35)
    private String descricaoLargadouro;
    
    
    @OneToMany (mappedBy = "tipoLargadouro",fetch = FetchType.LAZY)
    @ForeignKey(name = "Endereco_tipoLargadouro")
    private List<Endereco> endereco;

    public TipoLargadouro() {
    }

    public List<Endereco> getEndereco() {
        return endereco;
    }

    public void setEndereco(List<Endereco> endereco) {
        this.endereco = endereco;
    }
    
    

    public Integer getIdLargadouro() {
        return idLargadouro;
    }

    public void setIdLargadouro(Integer idLargadouro) {
        this.idLargadouro = idLargadouro;
    }

    public String getDescricaoLargadouro() {
        return descricaoLargadouro;
    }

    public void setDescricaoLargadouro(String descricaoLargadouro) {
        this.descricaoLargadouro = descricaoLargadouro;
    }

 

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (this.idLargadouro != null ? this.idLargadouro.hashCode() : 0);
        hash = 23 * hash + (this.descricaoLargadouro != null ? this.descricaoLargadouro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TipoLargadouro other = (TipoLargadouro) obj;
        if (this.idLargadouro != other.idLargadouro && (this.idLargadouro == null || !this.idLargadouro.equals(other.idLargadouro))) {
            return false;
        }
        if ((this.descricaoLargadouro == null) ? (other.descricaoLargadouro != null) : !this.descricaoLargadouro.equals(other.descricaoLargadouro)) {
            return false;
        }
        return true;
    }
    
    
    
}
