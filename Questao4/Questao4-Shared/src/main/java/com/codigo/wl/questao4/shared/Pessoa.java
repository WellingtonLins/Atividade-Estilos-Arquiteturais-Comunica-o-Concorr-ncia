package com.codigo.wl.questao4.shared;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Document   Pessoa
 * @Date  02/08/2016 @Time 08:35:26
 * @author Wellington Lins Claudino Duarte   
 * @mail wellingtonlins2013@gmail.com
 */ 
@Entity
public class Pessoa implements Serializable {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
   
   private String nome;

    public Pessoa() {
    }

    public Pessoa(String nome) {
        this.nome = nome;
    }
    public Pessoa(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    

   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "id=" + id + ", nome=" + nome;
    }
   
   
}