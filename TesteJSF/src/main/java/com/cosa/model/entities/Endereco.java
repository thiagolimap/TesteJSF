/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cosa.model.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author Thiago
 */
@Entity
@Table (name = "endereco")
public class Endereco implements Serializable{
    
     private static final long serialVersionUID = 1L;
     
     @Id
     @GeneratedValue
     @Column(name = "idEndereco", nullable = false)
     private Integer idEndereco;
     
     @Column(name = "Bairro",length = 60)
     private String bairro;
     
     @Column(name = "nomeLogradouro",length = 80)
     private String nomeLogradouro;
     
     @Column(name = "CEP",length = 9)
     private String cep;
     
     @Column(name = "numero")
     private Integer numero;
     
     @Column(name = "complemento",length = 5)
     private String complemento;
     
     @OneToOne(optional = true, fetch = FetchType.LAZY)
     @ForeignKey(name = "enderecoPessoa")
     @JoinColumn(name= "idPessoa", referencedColumnName = "idPessoa")
     private Pessoa pessoa;
     
     @ManyToOne(optional = false,fetch = FetchType.LAZY)
     @ForeignKey(name = "EnderecoTipoLogradouro")
     @JoinColumn (name = "idTipoLogradouro", referencedColumnName = "idTipoLogradouro" )
     private TipoLogradouro tipoLogradouro;
     
     @ManyToOne(optional = false,fetch = FetchType.LAZY)
     @ForeignKey(name = "EnderecoTipoEndereco")
     @JoinColumn (name = "idTipoEndereco", referencedColumnName = "idTipoEndereco")
     private TipoEndereco tipoEndereco;
     
     @ManyToOne(optional = false,fetch = FetchType.LAZY)
     @ForeignKey(name = "EnderecoCidade")
     @JoinColumn (name = "idCidade", referencedColumnName = "idCidade")
     private Cidade cidade;
     
     @ManyToOne(optional = false,fetch = FetchType.LAZY)
     @ForeignKey(name = "EnderecoEstado")
     @JoinColumn (name = "idEstado", referencedColumnName = "idEstado")
     private Estado estado;

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public TipoLogradouro getTipoLogradouro() {
        return tipoLogradouro;
    }

    public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    public TipoEndereco getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(TipoEndereco tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }

    
    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNomeLogradouro() {
        return nomeLogradouro;
    }

    public void setNomeLogradouro(String nomeLogradouro) {
        this.nomeLogradouro = nomeLogradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }
    
    

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + (this.idEndereco != null ? this.idEndereco.hashCode() : 0);
        hash = 37 * hash + (this.bairro != null ? this.bairro.hashCode() : 0);
        hash = 37 * hash + (this.nomeLogradouro != null ? this.nomeLogradouro.hashCode() : 0);
        hash = 37 * hash + (this.cep != null ? this.cep.hashCode() : 0);
        hash = 37 * hash + (this.numero != null ? this.numero.hashCode() : 0);
        hash = 37 * hash + (this.complemento != null ? this.complemento.hashCode() : 0);
        hash = 37 * hash + (this.pessoa != null ? this.pessoa.hashCode() : 0);
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
        final Endereco other = (Endereco) obj;
        if (this.idEndereco != other.idEndereco && (this.idEndereco == null || !this.idEndereco.equals(other.idEndereco))) {
            return false;
        }
        if ((this.bairro == null) ? (other.bairro != null) : !this.bairro.equals(other.bairro)) {
            return false;
        }
        if ((this.nomeLogradouro == null) ? (other.nomeLogradouro != null) : !this.nomeLogradouro.equals(other.nomeLogradouro)) {
            return false;
        }
        if ((this.cep == null) ? (other.cep != null) : !this.cep.equals(other.cep)) {
            return false;
        }
        if (this.numero != other.numero && (this.numero == null || !this.numero.equals(other.numero))) {
            return false;
        }
        if ((this.complemento == null) ? (other.complemento != null) : !this.complemento.equals(other.complemento)) {
            return false;
        }
        if (this.pessoa != other.pessoa && (this.pessoa == null || !this.pessoa.equals(other.pessoa))) {
            return false;
        }
        return true;
    }

    public Endereco() {
        this.cidade= new Cidade();
        this.estado= new Estado();
        this.tipoLogradouro= new TipoLogradouro();
        this.tipoEndereco= new TipoEndereco();
        this.pessoa= new Pessoa();
    }

     
     
     
     
     
     
     
     
     
     
     
     
    
    
}
