 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cosa.model.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author Thiago
 */
@Entity 
@Table (name="pessoa")
public class Pessoa implements Serializable{
    
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column (name="IdPessoa", nullable = false)
    private String idPessoa;
    
    @Column (name= "Nome",nullable = false, length =80 )
    private String nome;

    @Column (name= "Email",nullable = false, length =80 )
    private String email;
    
    @Column (name= "Telefone",nullable = false, length =15 )
    private String telefone;
    
    @Column (name= "CPF",nullable = false, length =11 )
    private String cpf;    
    
    @Column (name= "DataNascimento",nullable = false, length =80 )
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataNascimento;    
    
    @Column (name= "DataCadrastro",nullable = false, length =80 )
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataCadrastro;    

    //---------------------------------------------------------------------
    
    @OneToOne (mappedBy = "pessoa",fetch = FetchType.LAZY)
    @ForeignKey(name = "enderecoPessoa")
    private Endereco endereco;
    
    
    @ManyToOne(optional = false)
    @ForeignKey (name = "PessoaSexo")
    @JoinColumn (name="idSexo",referencedColumnName = "idSexo")
    private Sexo sexo;
    
    
    public Pessoa() {
    }

    public String getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(String idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getDataCadrastro() {
        return dataCadrastro;
    }

    public void setDataCadrastro(Date dataCadrastro) {
        this.dataCadrastro = dataCadrastro;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (this.idPessoa != null ? this.idPessoa.hashCode() : 0);
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
        final Pessoa other = (Pessoa) obj;
        if ((this.idPessoa == null) ? (other.idPessoa != null) : !this.idPessoa.equals(other.idPessoa)) {
            return false;
        }
        return true;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    
       
}
