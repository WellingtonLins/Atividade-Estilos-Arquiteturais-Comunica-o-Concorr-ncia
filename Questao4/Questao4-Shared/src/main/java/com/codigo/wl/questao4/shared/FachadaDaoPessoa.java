package com.codigo.wl.questao4.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * @Date 16/08/2017 @Time 10:43:37
 * @author Wellington Lins Claudino Duarte
 * @mail wellingtonlins2013@gmail.com
 */

public interface FachadaDaoPessoa  extends Remote{


  public void salvar(Pessoa pessoa) throws RemoteException;

  public  List<Pessoa> todos() throws RemoteException;

}
