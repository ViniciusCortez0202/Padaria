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
public class Comanda {

    //Variáveis para armazenar os produtos, o número, valor total
    //e entre outras coisas que se encontram na comanda de número
    //numero_comanda.
    private String numero_comanda;
    private double valor;
    private ArrayList<Produtos> produto = new ArrayList();
    private int quantidade;
    private double valorTotal;
    private Clientes cliente;
    private static ArrayList<Produtos> produtosTotal = new ArrayList();

    //Recebe uma nova comanda, com o nome do cliente e aparti de agora o cliente
    //sempre vai usar aquela comanda quando ele vier à padaría
    public Comanda(String numero_comanda, Clientes cliente) {
        this.numero_comanda = numero_comanda;
        this.cliente = cliente;
    }

    //Adiciona um novo produto em uma determinada comanda
    public boolean addProduto(double valor, int quantidade, String nome) {
        //Verifica se já existe esse produto na comanda e apenas almenta a 
        //quantidade e o valor.
        for (int i = 0; i < produto.size(); i++) {
            if (produto.get(i).getNome().equalsIgnoreCase(nome)) {
                produto.get(i).setQuantidade(quantidade);
                produto.get(i).setValor(quantidade * valor);
                Comanda.produtosTotal.get(i).setQuantidade(quantidade);
                Comanda.produtosTotal.get(i).setValor(valor * quantidade);
                
                setValorTotal(quantidade * valor);
                return true;
            }
        }
        //Se o produto não estiver na comanda ele vai ser adicionado a seguir
        //junto do valor e quantidade.
        setValor(valor * quantidade);
        Comanda.produtosTotal.add(new Produtos(nome, quantidade, getValor()));
        produto.add(new Produtos(nome, quantidade, getValor()));
        this.quantidade++;
        setValorTotal(quantidade * valor);
        return true;
    }
    
    public String getNumero_comanda() {
        return numero_comanda;
    }
    
    public void setNumero_comanda(String numero_comanda) {
        this.numero_comanda = numero_comanda;
    }
    
    public double getValor() {
        return valor;
    }
    
    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public ArrayList<Produtos> getProduto() {
        return produto;
    }
    
    public void setProduto(ArrayList<Produtos> produto) {
        this.produto = produto;
    }
    
    public int getQuantidade() {
        return quantidade;
    }
    
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public double getValorTotal() {
        return valorTotal;
    }

    //Sempre que chamado vai adicionar o valor atual mais o valor da compra atual.
    public void setValorTotal(double valorTotal) {
        this.valorTotal += valorTotal;
    }
    
    public Clientes getCliente() {
        return cliente;
    }
    
    public static ArrayList<Produtos> getProdutosTotal() {
        return produtosTotal;
    }
    
    public static void setProdutos(ArrayList<Produtos> produtos) {
        Comanda.produtosTotal = produtos;
    }
    
}
