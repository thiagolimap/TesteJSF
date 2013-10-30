package com.cosa.util;

import com.sun.org.apache.xalan.internal.xsltc.runtime.BasisLibrary;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author Admin
 */
public class HibernateUtil {
    
   private static final SessionFactory session_factory;
   
   public static final String HIBERNATE_SESSION = "hibernate_session";
   
   static {
       try{
           System.out.println("Configurando una sessión");
      
           Configuration configuration = new Configuration().configure();
           ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
           session_factory = configuration.buildSessionFactory(serviceRegistry);
           
           System.out.println("Creado una sessión");
           
       }catch(Exception error){
           
           System.out.println("Ocorrio un problema en la session" + error);
           
           throw new ExceptionInInitializerError(error);
       }
   }

    public static SessionFactory getSession_factory() {
        return session_factory;
    }

}
