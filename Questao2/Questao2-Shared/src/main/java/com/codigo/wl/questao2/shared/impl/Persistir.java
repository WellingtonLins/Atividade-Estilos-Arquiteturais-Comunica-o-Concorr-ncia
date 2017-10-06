package com.codigo.wl.questao2.shared.impl;

import com.codigo.wl.questao2.shared.entidade.User;
import com.codigo.wl.questao2.shared.interfaces.InterfacePersistir;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @Date 05/10/2017 @Time 20:43:49
 * @author Wellington Lins Claudino Duarte
 * @mail wellingtonlins2013@gmail.com
 */
public class Persistir extends UnicastRemoteObject implements
        InterfacePersistir {

    static long inicioPostgre;
    static long fimPostgre;
    static long inicio;
    static long fim;
    static int xPostgre = 0;
    static int x = 0;

    public Persistir() throws RemoteException {
    }

    @Override
    public void persistir(List<User> userList) throws RemoteException {
        EntityManagerFactory emfPostgre = Persistence.createEntityManagerFactory("Postgre-PU");
        EntityManager em1 = emfPostgre.createEntityManager();

        inicioPostgre = System.currentTimeMillis();

        for (User user : userList) {
            try {
                em1.getTransaction().begin();

                em1.persist(user);

                em1.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
                em1.getTransaction().rollback();
            }
        }

        fimPostgre = System.currentTimeMillis();
        xPostgre = (int) (fimPostgre - inicioPostgre);
        System.out.println("\nTEMPO DECORRIDO PARA O POSTGRE " + xPostgre + "\n");

        em1.close();
        emfPostgre.close();

        EntityManagerFactory emfMysql = Persistence.createEntityManagerFactory("Mysql-PU");
        EntityManager em2 = emfMysql.createEntityManager();

        inicio = System.currentTimeMillis();
        for (User user : userList) {
            try {
                em2.getTransaction().begin();

                em2.persist(user);

                em2.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
                em2.getTransaction().rollback();
            }
        }
        fim = System.currentTimeMillis();
        x = (int) (fim - inicio);
        System.out.println("\nTEMPO DECORRIDO PARA O MySQL " + x + "\n");

        int total = x + xPostgre;
        System.out.println("\nTEMPO DECORRIDO TOTAL PARA AMBOS " + total + "\n");

        em2.close();
        emfMysql.close();
    }
}
