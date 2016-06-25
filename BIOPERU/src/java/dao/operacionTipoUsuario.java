/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.HibernateUtil;
import modelo.Tipousuario;
import modelo.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author jack
 */
public class operacionTipoUsuario {
    public Tipousuario getTipoPorId(int id){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Tipousuario tu = (Tipousuario)session.get(Tipousuario.class, id);
        tx.commit();
        session.close();
        return tu;
    }
}
