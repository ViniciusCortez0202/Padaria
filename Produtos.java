/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psd;
import java.util.ArrayList;
/**
 * @author Vinicius Cortez Cavalcante Rocha;
 *         Noemy Roberta de Oliveira Silva.
 *  Turma: 922-A.
 */
public class Produtos {

    //Variáveis para armazenar os produtos comprados
    private String nome;
    private int quantidade;
    private double valor;

    //Construtor para guardar os produtos comprados
    public Produtos(String nome, int quantidade, double valor) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade += quantidade;
    }

    public void setValor(double valor) {
        this.valor += valor;
    }

}
