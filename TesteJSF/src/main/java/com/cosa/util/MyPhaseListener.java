/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cosa.util;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import org.hibernate.Session;

/**
 *
 * @author Thiago
 */
public class MyPhaseListener implements PhaseListener{

    @Override
    public void afterPhase(PhaseEvent phase) {
        System.out.println("Depois da fase"+ getPhaseId());
        if (phase.getPhaseId().equals(PhaseId.RENDER_RESPONSE)) {
            Session session = FacesContextUtil.getRequestSession();
            
            try {
                session.getTransaction().commit();
            } catch (Exception e) {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
            }finally{
                session.close();
            }
        }
    }

    @Override
    public void beforePhase(PhaseEvent phase) {
        if(phase.getPhaseId().equals(PhaseId.RESTORE_VIEW)){
            System.out.println("Antes da fase"+ getPhaseId());
            Session session = HibernateUtil.getSession_factory().openSession();
            session.beginTransaction();
            FacesContextUtil.setRequestSession(session);
            
        }
    }

    @Override
    public PhaseId getPhaseId() {
       return PhaseId.ANY_PHASE;
    }
    
}
