package com.codigo.wl.node2;

/**
 * @Date 28/07/2017 @Time 10:59:02
 * @author Wellington Lins Claudino Duarte
 * @mail wellingtonlins2013@gmail.com
 */
import com.codigo.wl.shared.OperacaoApenasMultiplicar;
import com.codigo.wl.shared.OperacaoMultiplicarImpl;
import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Node2 {

    public static void main(String[] args) throws IOException {
  
        try {

            Registry registry = LocateRegistry.createRegistry(10935);
            registry.bind("Node2",  new OperacaoApenasMultiplicar());

            System.out.println("Servidor Node2 Pronto!");
     

        } catch (Exception e) {
            System.err.println("Servidor Node2 falhou : " + e.getMessage());
        }
  
    }
}