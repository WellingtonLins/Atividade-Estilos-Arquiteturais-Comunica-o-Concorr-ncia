/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codigo.wl.questao2.shared.interfaces;

import com.codigo.wl.questao2.shared.entidade.User;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author welli
 */
public interface InterfacePersistir extends Remote {
    void persistir(List<User> user) throws RemoteException;

}
