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
@Table (name = "estado")
public class Estado implements Serializable{
    
     private static final long serialVersionUID = 1L;
     
     @Id
     @GeneratedValue
     @Column (name = "IdEstado", nullable = false)
     private Integer idEstado;
     
     @Column(name="descricaoEstado", nullable = false, length= 80)
     private String descricaoEstado;

     
     @OneToMany
     @ForeignKey(name="CidadeEndereco")
     private List<Endereco> enderecos;
     
    public Estado() {
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public String getDescricaoEstado() {
        return descricaoEstado;
    }

    public void setDescricaoEstado(String descricaoEstado) {
        this.descricaoEstado = descricaoEstado;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (this.idEstado != null ? this.idEstado.hashCode() : 0);
        hash = 97 * hash + (this.descricaoEstado != null ? this.descricaoEstado.hashCode() : 0);
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
        final Estado other = (Estado) obj;
        if (this.idEstado != other.idEstado && (this.idEstado == null || !this.idEstado.equals(other.idEstado))) {
            return false;
        }
        if ((this.descricaoEstado == null) ? (other.descricaoEstado != null) : !this.descricaoEstado.equals(other.descricaoEstado)) {
            return false;
        }
        return true;
    }

    
    
}
