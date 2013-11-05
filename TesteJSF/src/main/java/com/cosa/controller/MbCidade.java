/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cosa.controller;

import com.cosa.model.DAO.HibernateDAOImpl;
import com.cosa.model.DAO.InterfaceDAO;
import com.cosa.model.entities.Cidade;
import com.cosa.util.FacesContextUtil;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Thiago
 */
@ManagedBean(name = "mbCidade")
@SessionScoped
public class MbCidade implements Serializable {

    private static final long serialVersionUID = 1L;

    private Cidade cidade = new Cidade();

    private List<Cidade> cidades = new LinkedList<Cidade>();

    public MbCidade() {
    }

    private InterfaceDAO<Cidade> cidadeDAO() {
        InterfaceDAO<Cidade> cidadeDAO = new HibernateDAOImpl<Cidade>(Cidade.class, FacesContextUtil.getRequestSession());

        return cidadeDAO;
    }

    public String limparCidade() {
        this.cidade = new Cidade();
        return "/restrict/cadastrarcidade.faces";
    }

    public String editCidade() {

        return "/restrict/cadastrarCidades.faces";
    }

    public String addCidade() {
        if (cidade.getIdCidade() == null || cidade.getIdCidade() == 0) {
            
            insertCidade(cidade);
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Já existe!", ""));
            //updateCidade();
        }
        limparCidade();
        return null;
    }

    private void insertCidade(Cidade cidade1) {
        this.cidades.add(cidade1);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravação efetuada com sucesso!", ""));
    }

   // private void updateCidade() {
   //     cidadeDAO().update(cidade);
   //     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização efetuada com sucesso!", ""));
   // }

    
    public void deleteCidade(){
        cidadeDAO().remove(cidade);
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public List<Cidade> getCidades() {
      
      
        
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {

        this.cidades = cidades;
    }
    
    
}