/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.HibernateUtil;
import modelo.Usuario;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


/**
 *
 * @author jack
 */
public class operacionUsuario {
    public Usuario getUsuarioPorId(int id){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Usuario usr = (Usuario)session.get(Usuario.class, id);
        tx.commit();
        session.close();
        return usr;
    }
    public Usuario validarLogin(String login, String clave){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        
            Query q = session.createQuery("from Usuario where login= :vlogin and clave = :vclave ");
            q.setParameter("vlogin", login);
            q.setParameter("vclave", clave);
            Usuario usuario = (Usuario) q.uniqueResult();
        
        tx.commit();
        session.close();
        
        return usuario;
    }
    
}
