/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.HibernateUtil;
import modelo.Paciente;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author jack
 */
public class operacionPaciente {
    public Paciente getPacientePorId(int id){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Paciente pac = (Paciente)session.get(Paciente.class, id);
        tx.commit();
        session.close();
        return pac;
    }
    public Paciente getPacientePorDni(int dni){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        
            Query q = session.createQuery("from Paciente where dni= :vdni");
            q.setParameter("vdni", dni);
            Paciente paciente = (Paciente) q.uniqueResult();
        
        tx.commit();
        session.close();
        
        return paciente;
    }
    public void agregarPaciente(Paciente pac){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(pac);
        tx.commit();
        session.close();
    }
}
