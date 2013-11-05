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
@Table (name = "cidade")
public class Cidade implements Serializable{
    
     private static final long serialVersionUID = 1L;
     
     @Id
     @GeneratedValue
     @Column (name = "IdCidade", nullable = false)
     private Integer idCidade;
     
     @Column(name="Nome", nullable = false, length= 80)
     private String nome;

     
     @OneToMany
     @ForeignKey(name="CidadeEndereco")
     private List<Endereco> enderecos;
     
    public Cidade() {
    }

    public Cidade(Integer idCidade, String nome) {
        this.idCidade = idCidade;
        this.nome = nome;
    }

    
    
    public Integer getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Integer idCidade) {
        this.idCidade = idCidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + (this.idCidade != null ? this.idCidade.hashCode() : 0);
        hash = 83 * hash + (this.nome != null ? this.nome.hashCode() : 0);
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
        final Cidade other = (Cidade) obj;
        if (this.idCidade != other.idCidade && (this.idCidade == null || !this.idCidade.equals(other.idCidade))) {
            return false;
        }
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        return true;
    }
     
     
    
}
