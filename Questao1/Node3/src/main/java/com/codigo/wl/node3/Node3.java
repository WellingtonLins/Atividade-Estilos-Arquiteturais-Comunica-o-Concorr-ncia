package com.codigo.wl.node3;

/**
 * @Date 28/07/2017 @Time 10:59:02
 * @author Wellington Lins Claudino Duarte
 * @mail wellingtonlins2013@gmail.com
 */

import com.codigo.wl.shared.OperacaoDividirImpl;
import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Node3 {

    public static void main(String[] args) throws IOException {
          try {

            Registry registry = LocateRegistry.createRegistry(10936);
            registry.bind("Node3",  new OperacaoDividirImpl());

            System.out.println("Servidor Node3 Pronto!");
     

        } catch (Exception e) {
            System.err.println("Servidor Node3 falhou : " + e.getMessage());
        }
  
    }
}