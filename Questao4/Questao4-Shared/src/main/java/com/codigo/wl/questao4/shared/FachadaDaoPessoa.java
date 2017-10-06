package com.codigo.wl.questao4.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * @Date 06/10/2017 @Time 09:21:23
 * @author Wellington Lins Claudino Duarte
 * @mail wellingtonlins2013@gmail.com
 */
public interface FachadaDaoPessoa extends Remote {

    public void salvar(Pessoa pessoa) throws RemoteException;
    
    public Pessoa consultaPorId(int id) throws RemoteException;
   
    public void remover(int id) throws RemoteException;
    
    public void atualizar(Pessoa pessoa) throws RemoteException;

    public List<Pessoa> todos() throws RemoteException;

}
