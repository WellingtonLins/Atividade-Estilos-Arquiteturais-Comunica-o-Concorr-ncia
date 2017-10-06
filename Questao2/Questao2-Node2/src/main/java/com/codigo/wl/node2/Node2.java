package com.codigo.wl.node2;

/**
 * @Date  05/10/2017 @Time 20:17:41
 * @author Wellington Lins Claudino Duarte   
 * @mail wellingtonlins2013@gmail.com
 */ 

import com.codigo.wl.questao2.shared.impl.Persistir;
import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Node2 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        try {
            Registry registry = LocateRegistry.createRegistry(10934);
            registry.bind("Node2", new Persistir());

            System.out.println("Servidor Node2 Pronto para persistir a Lista de Usuarios!");
      
        } catch (Exception e) {
            System.err.println("Servidor Node2 falhou : " + e.getMessage());
        }
    }
}
