package com.codigo.wl.node1;

/**
 * @Date 28/07/2017 @Time 10:59:02
 * @author Wellington Lins Claudino Duarte
 * @mail wellingtonlins2013@gmail.com
 */
import com.codigo.wl.shared.OperacaoMultiplicarImpl;
import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Node1 {

    public static void main(String[] args) throws IOException {

        try {
            Registry registry = LocateRegistry.createRegistry(10934);
            registry.bind("Node1",  new OperacaoMultiplicarImpl());
            
            System.out.println("Servidor Node1 Pronto!");
           
        } catch (Exception e) {
            System.err.println("Servidor Node1 falhou : " + e.getMessage());
        }

    }
}
