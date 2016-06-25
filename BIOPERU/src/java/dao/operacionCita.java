/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.Cita;
import modelo.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author jack
 */
public class operacionCita {
     
    private Session session;
    
    public void agregarCita( Cita cita){
       
        session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(cita);
        session.getTransaction().commit();
        session.close();
    }
     public Cita getUltimaCita(){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        session = factory.openSession();
        Transaction tx = session.beginTransaction();
        
            Query q = session.createQuery("from Cita order by idCita desc ");
            q.setMaxResults(1);
            Cita cita = (Cita) q.uniqueResult();
        
        tx.commit();
        session.close();
        
        return cita;
    }
}
