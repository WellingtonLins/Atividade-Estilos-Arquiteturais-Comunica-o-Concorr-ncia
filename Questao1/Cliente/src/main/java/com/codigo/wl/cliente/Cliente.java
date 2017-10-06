package com.codigo.wl.cliente;

/**
 * @Date 04/10/2017 @Time 12:19:02
 * @author Wellington Lins Claudino Duarte
 * @mail wellingtonlins2013@gmail.com
 */
import com.codigo.wl.shared.Operacao;
import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import com.codigo.wl.shared.DividirInterface;
import com.codigo.wl.shared.MultiplicarInterface;

public class Cliente {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        try {
            Registry registry1 = LocateRegistry.getRegistry(10934);//NODE_1   2*x*y
            Registry registry2 = LocateRegistry.getRegistry(10935);//NODE_2   2*x*y
            Registry registry3 = LocateRegistry.getRegistry(10936);//NODE_3   2x/y


            MultiplicarInterface remoto1 = (MultiplicarInterface) registry1.lookup("Node1");
            MultiplicarInterface remoto2 = (MultiplicarInterface) registry2.lookup("Node2");
            DividirInterface remoto3 = (DividirInterface) registry3.lookup("Node3");

            Operacao operacao = new Operacao("*", 3, 2);
            System.out.println(remoto1.calcular(operacao));
    

        } catch (Exception e) {

            System.err.println("Cliente Node1 falhou : " + e.getMessage());
        }
    }
}
