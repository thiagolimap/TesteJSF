/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cosa.model.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Thiago
 */
@Entity
@Table (name = "Endereco")
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
     
     
    
    
}
