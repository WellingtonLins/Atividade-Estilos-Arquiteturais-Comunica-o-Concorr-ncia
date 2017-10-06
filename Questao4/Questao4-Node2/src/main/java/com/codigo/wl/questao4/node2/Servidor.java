package com.codigo.wl.questao4.node2;

import com.codigo.wl.questao4.shared.dao.DaoPessoaRemoto;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @Date 16/08/2017 @Time 10:52:19
 * @author Wellington Lins Claudino Duarte
 * @mail wellingtonlins2013@gmail.com
 */
public class Servidor {

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(10934);
            registry.bind("DaoRemoto", new DaoPessoaRemoto());

            System.out.println("Servidor Pronto!");
        } catch (Exception e) {
            System.err.println("Servidor CRUD falhou : " + e.getMessage());
        }
    }
}
