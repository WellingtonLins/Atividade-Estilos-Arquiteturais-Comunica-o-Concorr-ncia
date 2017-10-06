package com.codigo.wl.node1;

/**
 * @Date 28/07/2017 @Time 10:59:02
 * @author Wellington Lins Claudino Duarte
 * @mail wellingtonlins2013@gmail.com
 */
import com.codigo.wl.questao2.shared.entidade.User;
import com.codigo.wl.questao2.shared.interfaces.InterfacePersistir;
import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

public class Node1 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try {
            Registry registry = LocateRegistry.getRegistry(10934);//NODE_2
            InterfacePersistir remoto = (InterfacePersistir) registry.lookup("Node2");
            List lista = new ArrayList();
            for (int i = 1; i <= 100; i++) {
                lista.add(new User("User" + i));
            }
            remoto.persistir(lista);

        } catch (Exception e) {

            System.err.println("Sistema falhou ao tentar enviar a lista para: " + e.getMessage());
        }
    }
}
