package com.codigo.wl.shared;

import java.rmi.AccessException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @Date 04/10/2017 @Time 17:43:16
 * @author Wellington Lins Claudino Duarte
 * @mail wellingtonlins2013@gmail.com
 */
public class OperacaoApenasMultiplicar extends UnicastRemoteObject implements
        MultiplicarInterface {

    public OperacaoApenasMultiplicar() throws RemoteException {

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

                System.out.println("Eu não posso resolver essa operação!");
                operacao.setMensagem("Eu sou o node 2 não sei Fazer Divisão!");
                  retorno = operacao;
                break;

            default:
                System.out.println("Erro durante a elucidação da resposta!");
                break;
        }
        return retorno;
    }
}
