/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.auto_park;

import org.hibernate.HibernateException;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

public class HibernateUtil {
  private static final SessionFactory sessionFactory;
    static {
      try {
        sessionFactory = new Configuration().configure().buildSessionFactory();
      } catch (HibernateException ex) {
        //System.err.println('Initial SessionFactory creation failed.');
        throw new ExceptionInInitializerError(ex);
      }
    }

    public static SessionFactory getSessionFactory() {
      return sessionFactory;
    }
}