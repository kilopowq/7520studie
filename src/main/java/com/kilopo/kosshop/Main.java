package com.kilopo.kosshop;

import com.kilopo.kosshop.util.HibernateUtil;
import org.hibernate.SessionFactory;


public class Main {

    public static void main(String[] args) {
        System.out.println("Oki doki!!!");
        System.out.println("I've already been there!!!");
        System.out.println("!!!!!!!!!!!!!!!!!!");
        SessionFactory session = HibernateUtil.getSessionFactory();
    }
}
