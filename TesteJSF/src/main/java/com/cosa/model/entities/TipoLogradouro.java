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
public class TipoLogradouro implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name = "idTipoLogradouro", nullable = false)
    private Integer idTipoLogradouro;
    
    @Column(name = "descricaoLargadouro", nullable = false, length = 35)
    private String descricaoLogradouro;
    
    
    @OneToMany (mappedBy = "tipoLogradouro",fetch = FetchType.LAZY)
    @ForeignKey(name = "Endereco_tipoLogradouro")
    private List<Endereco> endereco;

    public TipoLogradouro() {
    }

    public List<Endereco> getEndereco() {
        return endereco;
    }

    public void setEndereco(List<Endereco> endereco) {
        this.endereco = endereco;
    }



    public String getDescricaoLogradouro() {
        return descricaoLogradouro;
    }

    public void setDescricaoLogradouro(String descricaoLogradouro) {
        this.descricaoLogradouro = descricaoLogradouro;
    }

    public Integer getIdTipoLogradouro() {
        return idTipoLogradouro;
    }

    public void setIdTipoLogradouro(Integer idTipoLogradouro) {
        this.idTipoLogradouro = idTipoLogradouro;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + (this.idTipoLogradouro != null ? this.idTipoLogradouro.hashCode() : 0);
        hash = 43 * hash + (this.descricaoLogradouro != null ? this.descricaoLogradouro.hashCode() : 0);
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
        final TipoLogradouro other = (TipoLogradouro) obj;
        if (this.idTipoLogradouro != other.idTipoLogradouro && (this.idTipoLogradouro == null || !this.idTipoLogradouro.equals(other.idTipoLogradouro))) {
            return false;
        }
        if ((this.descricaoLogradouro == null) ? (other.descricaoLogradouro != null) : !this.descricaoLogradouro.equals(other.descricaoLogradouro)) {
            return false;
        }
        return true;
    }

    
    
}
