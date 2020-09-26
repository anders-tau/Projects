package com.mycompany.simple_hibernate_example;

import com.mycompany.simple_hibernate_example.entity.Users;
import com.mycompany.simple_hibernate_example.persistence.HibernateUtil;
import org.hibernate.Session;

public class EnterPoint {

    public static void main(String[] args) {
        System.out.println("Maven + Hibernate + MySQL");
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        Users users = new Users();

        users.setName("Anders");
        users.setAge(46);

        session.save(users);
        session.getTransaction().commit();
    }    
}
