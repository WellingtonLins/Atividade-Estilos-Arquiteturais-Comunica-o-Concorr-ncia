package com.codigo.wl.shared;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * @Date 04/10/2017 @Time 17:43:16
 * @author Wellington Lins Claudino Duarte
 * @mail wellingtonlins2013@gmail.com
 */
public class OperacaoDividirImpl extends UnicastRemoteObject implements
        DividirInterface {

    public OperacaoDividirImpl() throws RemoteException {

    }

    @Override
    public Operacao calcular(Operacao operacao) throws RemoteException, AccessException {

        int numeroA = operacao.getNumero1();
        int numeroB = operacao.getNumero2();
        String operador = operacao.getOperador();
        int resposta = 0;
        Operacao retorno = null;
        switch (operador) {
            case "/":
                resposta = ((2 * operacao.getNumero1()) / operacao.getNumero2());
                retorno = new Operacao(operador, numeroA, numeroB, resposta);
                System.out.println("Recebi >=====>    2 * " + numeroA + " " + operador + " " + numeroB);
                System.out.println("Resposta : " + resposta);
                break;

            case "*":
                try {
                    System.out.println("Recebi >=====>    2 * " + numeroA + " " + operador + " " + numeroB);
                    System.out.println("Divisor vou chamar o Node1 para resolver essa operação.");

                    Registry registry1 = LocateRegistry.getRegistry(10934);//NODE_1   2*x*y
                    MultiplicarInterface remoto = (MultiplicarInterface) registry1.lookup("Node1");
                    operacao = remoto.calcular(operacao);
                    retorno = new Operacao(operacao.getOperador(), operacao.getNumero1(),
                            operacao.getNumero2(), operacao.getResposta());
                } catch (Exception ex) {
                         retorno =  retornaOperacao(operacao);
                }
                break;

            default:
                System.out.println("Erro durante a elucidação da resposta!");
                break;
        }
        return retorno;

    }

    public Operacao retornaOperacao(Operacao operacao) throws RemoteException {

        try {
            System.out.println("Recebi >=====>    2 * " + operacao.getNumero1()+ 
                    " " + operacao.getOperador()+ " " + operacao.getNumero2());
            System.out.println("Divisor , nao consegui vou chamar o Node2 para resolver essa operação.");

            Registry registry2 = LocateRegistry.getRegistry(10935);//NODE_2   2*x*y
            MultiplicarInterface remoto = (MultiplicarInterface) registry2.lookup("Node2");
            operacao = remoto.calcular(operacao);
            return new Operacao(operacao.getOperador(), operacao.getNumero1(),
                    operacao.getNumero2(), operacao.getResposta());
        } catch (NotBoundException ex2) {
            System.out.println("Erro durante a elucidação da resposta!" + ex2);
        }
        return null;
    }
}
