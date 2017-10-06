package com.codigo.wl.questao4.shared.dao;

import com.codigo.wl.questao4.shared.FachadaDaoPessoa;
import com.codigo.wl.questao4.shared.Pessoa;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @Date 16/08/2017 @Time 10:46:08
 * @author Wellington Lins Claudino Duarte
 * @mail wellingtonlins2013@gmail.com
 */
public class DaoPessoaRemoto extends UnicastRemoteObject implements FachadaDaoPessoa {

    private EntityManagerFactory emf;
    private EntityManager em;

    public DaoPessoaRemoto() throws RemoteException {
        emf = Persistence.createEntityManagerFactory("Postgre-PU");
        em = emf.createEntityManager();
    }

    @Override
    public void salvar(Pessoa pessoa) throws RemoteException {

        try {
            em.getTransaction().begin();
            em.persist(pessoa);
            em.getTransaction().commit();

        } catch (Exception e) {
            System.out.println("Erro ao salvar " + e);
            em.getTransaction().rollback();
        }
      
    }

    @Override
    public void remover(int id) throws RemoteException {

        Pessoa pessoa = em.find(Pessoa.class, id);
        try {
            em.getTransaction().begin();
            em.remove(pessoa);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Erro ao remover " + e);
        } 
    }

    @Override
    public Pessoa consultaPorId(int id) throws RemoteException {

        Pessoa pessoa = null;
        try {
            pessoa = em.find(Pessoa.class, id);// executa o select
        } catch (Exception e) {
            System.out.println("Erro ao buscar " + e);
        } 
        return pessoa;
    }

    @Override
    public void atualizar(Pessoa pessoa) throws RemoteException {
        try {
            em.getTransaction().begin();
            em.merge(pessoa);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();

            System.out.println("Erro ao atualizar " + ex);
        }
    }

    @Override
    public List<Pessoa> todos() throws RemoteException {
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas = em.createQuery("SELECT p FROM Pessoa p").getResultList();
        return pessoas;
    }

}
