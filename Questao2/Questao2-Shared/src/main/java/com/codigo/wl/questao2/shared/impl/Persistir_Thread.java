package com.codigo.wl.questao2.shared.impl;

import com.codigo.wl.questao2.shared.entidade.Salvando;
import com.codigo.wl.questao2.shared.entidade.User;
import com.codigo.wl.questao2.shared.interfaces.InterfacePersistir;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @Date 05/10/2017 @Time 20:43:49
 * @author Wellington Lins Claudino Duarte
 * @mail wellingtonlins2013@gmail.com
 */
public class Persistir_Thread extends UnicastRemoteObject implements
        InterfacePersistir {

    static long inicioPostgre;
    static long fimPostgre;
    static long inicio;
    static long fim;
    static int xPostgre = 0;
    static int x = 0;

    public Persistir_Thread() throws RemoteException {
    }

    @Override
    public void persistir(List<User> userList) throws RemoteException {

        EntityManagerFactory emfPostgre = Persistence.createEntityManagerFactory("Postgre-PU");
        EntityManagerFactory emfMysql = Persistence.createEntityManagerFactory("Mysql-PU");

                Salvando salvando = new Salvando("Postgre", emfPostgre, userList);
                Salvando salvando2 = new Salvando("Mysql", emfMysql, userList);
                
                salvando.start();
                salvando2.start();
    }
}
