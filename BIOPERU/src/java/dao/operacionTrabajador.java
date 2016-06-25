/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.HibernateUtil;
import modelo.Trabajador;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author jack
 */
public class operacionTrabajador {
    public Trabajador getTrabajadorPorId(int id){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Trabajador pac = (Trabajador)session.get(Trabajador.class, id);
        tx.commit();
        session.close();
        return pac;
    }
}
