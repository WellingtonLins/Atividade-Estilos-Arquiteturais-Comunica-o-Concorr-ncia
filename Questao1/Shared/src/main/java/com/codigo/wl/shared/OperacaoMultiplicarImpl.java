package com.codigo.wl.shared;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @Date 04/10/2017 @Time 17:43:16
 * @author Wellington Lins Claudino Duarte
 * @mail wellingtonlins2013@gmail.com
 */
public class OperacaoMultiplicarImpl extends UnicastRemoteObject implements
        MultiplicarInterface {

    public OperacaoMultiplicarImpl() throws RemoteException {

    }

    @Override
    public Operacao calcular(Operacao operacao) throws RemoteException, AccessException {

        int numeroA = operacao.getNumero1();
        int numeroB = operacao.getNumero2();
        String operador = operacao.getOperador();
        int resposta = 0;
        Operacao retorno = null;
        switch (operador) {
            case "*":
                resposta = (2 * (operacao.getNumero1() * operacao.getNumero2()));
                retorno = new Operacao(operador, numeroA, numeroB, resposta);
                System.out.println("Recebi >=====>    2 * " + numeroA + " " + operador + " " + numeroB);
                System.out.println("Resposta : " + resposta);
                break;

            case "/":

                try {
                    System.out.println("Recebi >=====>    2 * " + numeroA + " " + operador + " " + numeroB);
                    System.out.println("Multiplicador vou chamar o Node3 para resolver essa operação.");
               
                    Registry registry3 = LocateRegistry.getRegistry(10936);//NODE_3   2x/y
                    DividirInterface remoto = (DividirInterface) registry3.lookup("Node3");
                   operacao = remoto.calcular(operacao);
                    retorno = new Operacao(operacao.getOperador(), operacao.getNumero1(),
                            operacao.getNumero2(), operacao.getResposta());
                } catch (NotBoundException ex) {
                    System.out.println("Erro " + ex);
                }
                break;

            default:
                System.out.println("Erro durante a elucidação da resposta!");
                break;
        }
        return retorno;
    }
}
