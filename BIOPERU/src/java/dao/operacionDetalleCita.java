/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.Detallecita;
import modelo.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author jack
 */
public class operacionDetalleCita {
    private Session session;
    
    public void agregarDetalleCita( Detallecita detalleCita){
       
        session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(detalleCita);
        session.getTransaction().commit();
        session.close();
    }
}
