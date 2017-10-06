package com.codigo.wl.questao4.node1;

import com.codigo.wl.questao4.shared.FachadaDaoPessoa;
import com.codigo.wl.questao4.shared.Pessoa;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @Date 06/10/2017 @Time 09:21:23
 * @author Wellington Lins Claudino Duarte
 * @mail wellingtonlins2013@gmail.com
 */
public class Cliente {

    public static void main(String[] args) {

        try {
            Registry registry = LocateRegistry.getRegistry(10934);

            FachadaDaoPessoa dao = (FachadaDaoPessoa) registry.lookup("DaoRemoto");

            Pessoa pessoa = new Pessoa("Chiquinha");
            Pessoa pessoa2 = new Pessoa("Kiko");
            Pessoa pessoa3 = new Pessoa("Chaves");

//          Salvando tres entidade
//            dao.salvar(pessoa);
//            dao.salvar(pessoa2);
//            dao.salvar(pessoa3);
//          Buscando todos
//            System.out.println("\nListando todos os elementos \n" + dao.todos());
////          Fazendo Buscando por id
//            Pessoa recuperadaDoBanco = dao.consultaPorId(3);
//            System.out.println("\nBusacando por Id \n" + recuperadaDoBanco);
//          Atualizando o Pessoa Chiquinha => Chiquinha Legal

//           recuperadaDoBanco.setNome("Chiquinha Legal");
//            System.out.println("\nAtualizando a Pessoa Chiquinha \n"); 
//             dao.atualizar(recuperadaDoBanco);
//          
            System.out.println("\nListando todos os elementos \n" + dao.todos());
           
            System.out.println("\nRemovendo entidade \n") ;
            dao.remover(5);
            
            
            System.out.println("\nListando todos os elementos \n" + dao.todos());

        } catch (Exception e) {

            System.err.println("Cliente CRUD falhou : " + e.getMessage());
        }

    }
}
