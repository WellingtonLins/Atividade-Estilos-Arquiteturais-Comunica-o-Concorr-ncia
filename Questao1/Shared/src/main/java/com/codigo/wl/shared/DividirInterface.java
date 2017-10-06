package com.codigo.wl.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @Date  04/10/2017 @Time 12:38:03
 * @author Wellington Lins Claudino Duarte   
 * @mail wellingtonlins2013@gmail.com
 */ 
public interface DividirInterface extends Remote {

    Operacao calcular(Operacao operacao)throws RemoteException;
}