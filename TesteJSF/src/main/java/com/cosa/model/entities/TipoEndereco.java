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
@Table (name = "tipoEndereco")
public class TipoEndereco implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name = "idTipoEndereco", nullable = false)
    private Integer idTipoEndereco;
    
    @Column(name = "DescricaoTipoEndereco", nullable = false, length = 35)
    private String descricaoTipoEndereco;

    @OneToMany(mappedBy = "tipoEndereco",fetch = FetchType.LAZY)
    @ForeignKey(name="Endereco_tipoEndereco")
    private List<Endereco> enderecos;

    public TipoEndereco() {
    }

    
    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
    
    
    
    public Integer getIdTipoEndereco() {
        return idTipoEndereco;
    }

    public void setIdTipoEndereco(Integer idTipoEndereco) {
        this.idTipoEndereco = idTipoEndereco;
    }

    public String getDescricaoTipoEndereco() {
        return descricaoTipoEndereco;
    }

    public void setDescricaoTipoEndereco(String descricaoTipoEndereco) {
        this.descricaoTipoEndereco = descricaoTipoEndereco;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + (this.idTipoEndereco != null ? this.idTipoEndereco.hashCode() : 0);
        hash = 11 * hash + (this.descricaoTipoEndereco != null ? this.descricaoTipoEndereco.hashCode() : 0);
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
        final TipoEndereco other = (TipoEndereco) obj;
        if (this.idTipoEndereco != other.idTipoEndereco && (this.idTipoEndereco == null || !this.idTipoEndereco.equals(other.idTipoEndereco))) {
            return false;
        }
        if ((this.descricaoTipoEndereco == null) ? (other.descricaoTipoEndereco != null) : !this.descricaoTipoEndereco.equals(other.descricaoTipoEndereco)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
