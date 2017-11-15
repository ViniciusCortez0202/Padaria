/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psd;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Vinicius Cortez Cavalcante Rocha; Noemy Roberta de Oliveira Silva.
 * Turma: 922-A.
 */
public class Menu {

    private Scanner input = new Scanner(System.in);
    private Scanner input2 = new Scanner(System.in);//responsável por obter strings com espaços

    private ArrayList<Comanda> comanda = new ArrayList();
    private ArrayList<Clientes> cliente = new ArrayList();
    private ArrayList<Clientes> clientesAtendidos = new ArrayList();
    private int n = 1;
    //MENU ITEM 1.1

    public boolean pegarComandaSemCadastro() {

        System.out.println("--------------- CRIANDO CADASTRO ---------------");
        System.out.println("Nome: ");
        String nome = input2.nextLine();
        System.out.println("Data de nascimento: <sem espaços ou traços>");
        String datadeNascimento = input.next();//sem espaços

        for (int i = 0; i < cliente.size(); i++) {
            if (cliente.get(i).getNome().equalsIgnoreCase(nome)) {
                System.out.println("Este cliente já possui cadastro.");
                System.out.printf("\n\n\n\n\n\n\n");
                return false;
            }
        }

        cliente.add(new Clientes(nome, datadeNascimento));
        comanda.add(new Comanda(n + "", cliente.get(cliente.size() - 1)));//Cria uma nova comanda
        System.out.println("Número de comanda: " + n);
        n++;//Soma mais um no número de comandas.
        System.out.printf("\n\n\n\n\n\n\n");
        return true;
    }

    //MENU ITEM 1.2.
    public boolean pegarComandaComCadastro() {

        int contador = 0;
        System.out.print("Nome: ");
        String nome = input2.nextLine();
        //Verifica se o cliente já possui, ou não, comanda.
        for (int j = 0; j < comanda.size(); j++) {
            if (comanda.get(j).getCliente().getNome().equalsIgnoreCase(nome)) {
                System.out.println("Este cliente já possui comanda"
                        + ", seu número de comanda é: " + (j + 1) + ".");
                System.out.printf("\n\n\n\n\n\n\n");
                return false;
            }
        }

        while (contador < cliente.size()) {

            if (cliente.get(contador).getNome().equalsIgnoreCase(nome)) {
                comanda.add(new Comanda(n + "", cliente.get(contador)));//Cria uma nova comanda
                break;
            }
            contador++; //Conta a quantidade de nomes.
        }
        if (contador < cliente.size()) {
            System.out.println("O número da sua comanda é: " + n + ".");
            n++;//Soma mais um no número de comandas.
            System.out.printf("\n\n\n\n\n\n\n");
        } else {
            //Se o o nome do cliente foi digitado errado ou ele ainda não tem 
            //cadastro, foi feito um pequeno menu para resolver esse problema.
            System.out.println("Desculpe, mas não encontramos o seu cadastro.");
            System.out.println("    Digite '1' para digitar novamente o seu nome.");
            System.out.println("    Digite '2' para fazer o cadastro e pegar uma comanda.");
            int j = input.nextInt(); //pega a escolha do cliente

            switch (j) {
                case 1:
                    pegarComandaComCadastro();
                    break;

                case 2:
                    criarCadastro();
                    break;
            }
        }
        return true;
    }

    //MENU ITEM 2.
    public boolean adicionarProduto() {
        int numero;
        System.out.print("NÚMERO DA COMANDA: ");
        numero = input.nextInt() - 1;

        if (numero > comanda.size() - 1) {
            System.out.println("Esta comanda ainda não foi retirada.");
            System.out.printf("\n\n\n\n\n\n\n");
            return false;
        }
        if (numero < 0)//Não existe comandas com o número negativo.
        {
            System.out.println("Número de comanda inválido.");
            System.out.printf("\n\n\n\n\n\n\n");
            return false;
        }

        System.out.println("--------------- ADICIONANDO PRODUTO ---------------");
        System.out.println("Valor do produto: ");
        double valor = input.nextDouble();
        System.out.println("Nome do produto: ");
        String produto = input2.nextLine();
        System.out.println("Quantidade: ");
        int quantidade = input.nextInt();
        //Chama o metodo 'addProduto' da classe comanda para adicionar um novo produto na comanda numero.
        comanda.get(numero).addProduto(valor, quantidade, produto);
        System.out.printf("\n\n\n\n\n\n\n");

        return true;
    }

    //MENU ITEM 3.
    public void valorEmCaixa() {
        //Visualiza o valor em caixa.
        System.out.println("Valor em caixa: " + Caixa.getValor_em_caixa() + ".");
        System.out.printf("\n\n\n\n\n\n\n");
    }

    //MENU ITEM 4.
    public boolean mostrarProdutosEmComanda() {

        if (comanda.isEmpty()) {
            System.out.println("Nenhuma comanda foi retirada até o momento.");
            System.out.println("Digite '1' para retirar uma comanda.");
            System.out.printf("\n\n\n\n\n\n\n");
            return false;
        }
        System.out.println("Número da comanda: ");
        int numeroComanda = input.nextInt() - 1;
        int l = 0, k = 0;

        if (comanda.get(numeroComanda).getProduto().isEmpty()) {
            System.out.println("Nenhuma compra na comanda.");
            System.out.printf("\n\n\n\n\n\n\n");
        } else {

            //Repete enquanto não atinge a quantidade de produtos que tem na comanda.
            while (comanda.get(numeroComanda).getQuantidade() != l) {

                System.out.println("Quantidade do produto:" + comanda
                        .get(numeroComanda).getProduto().get(l).getQuantidade());
                System.out.println("O produto na comanda " + (numeroComanda + 1)
                        + " é: " + comanda.get(numeroComanda).getProduto().get(l).getNome() + ".");

                l++;//Para passar os produtos que estão na classe Produtos.

            }
        }
        System.out.printf("\n\n\n\n\n\n\n");

        return true;
    }

    //MENU ITEM 5.
    public boolean quantidadeValorDeUmProduto() {
        if (comanda.isEmpty()) {
            System.out.println("Nenhuma comanda foi retirada até o momento.");
            System.out.println("Digite '1' para retirar uma comanda.");
            return false;
        }
        System.out.println("Produto: ");
        String Produto = input2.nextLine();
        double valorProduto = 0;
        int quantidadeProduto = 0;
        for (int i = 0; i < Comanda.getProdutosTotal().size(); i++) {
            if (Comanda.getProdutosTotal().get(i).getNome().equalsIgnoreCase(Produto)) {
                valorProduto = Comanda.getProdutosTotal().get(i).getValor();
                quantidadeProduto = Comanda.getProdutosTotal().get(i).getQuantidade();
            }
        }

        System.out.println("A quantidade de compras do produto é: " + valorProduto + ".");
        System.out.println("Quantidade total do produto: " + quantidadeProduto + ".");
        System.out.printf("\n\n\n\n\n\n\n");

        return true;
    }

    //MENU ITEM 6.
    public boolean adicionarClienteEmFila() {

        if (comanda.isEmpty()) {
            System.out.println("Nenhuma comanda foi retirada até o momento.");
            System.out.println("Digite '1' para retirar uma comanda.");
            System.out.printf("\n\n\n\n\n\n\n");
            return false;
        }
        System.out.println("Quantos clientes vão para a fila?");
        int pessoas = input.nextInt();
        System.out.println("Digite o número das comandas.");
        for (int j = 0; j < pessoas; j++) {
            int com = input.nextInt() - 1; //numero da comanda

            FilaDoCaixa.fila(comanda.get(com));
        }

        System.out.printf("\n\n\n\n\n\n\n");

        return true;
    }

    //MENU ITEM 7.
    public void criarCadastro() {

        System.out.println("Nome: ");
        String nome = input2.nextLine();
        System.out.println("Data de nascimento: <sem espaços ou traços>");
        String datadeNascimento = input.next();
        cliente.add(new Clientes(nome, datadeNascimento));

        System.out.printf("\n\n\n\n\n\n\n");
    }

    //MENU ITEM 8.
    public boolean clienteMaisMenos() {

        if (comanda.isEmpty()) {
            System.out.println("Nenhuma comanda foi retirada até o momento.");
            System.out.println("Digite '1' para retirar uma comanda.");
            System.out.printf("\n\n\n\n\n\n\n");
            return false;
        }
        //Vai calcular o cliente que mais comprou e o que menos comprou.
        double maior = 0;
        int maiorp = 0;
        double menor = comanda.get(0).getValorTotal();
        int menorp = 0;
        for (int j = 0; j < comanda.size(); j++) {
            if (comanda.get(j).getValorTotal() > maior) {
                maior = comanda.get(j).getValorTotal();
                maiorp = j;
            }

            if ((comanda.get(j).getValorTotal() < menor) && (comanda.get(j).getValorTotal() > 0)) {
                menor = comanda.get(j).getValorTotal();
                menorp = j;
            }
        }
        System.out.print("O cliente que mais comprou foi: ");
        System.out.println(comanda.get(maiorp).getCliente().toString());
        System.out.print("O cliente que menos comprou foi: ");
        System.out.println(comanda.get(menorp).getCliente().toString());
        System.out.printf("\n\n\n\n\n\n\n");

        return true;
    }

    //MENU ITEM 9.
    public void clientesNaFila() {

        //Mostra os cliente na fila que tem proridade
        for (int j = 0; j < FilaDoCaixa.getPrioridade().size(); j++) {
            System.out.println(FilaDoCaixa.getPrioridade().get(j).getCliente().toString());
        }
        //Clientes normais
        for (int j = 0; j < FilaDoCaixa.getNormal().size(); j++) {
            System.out.println(FilaDoCaixa.getNormal().get(j).getCliente().toString());
        }
        //O tamanho da fila
        System.out.println(FilaDoCaixa.tamanhodaFila() + " pessoas estão no caixa.");

        System.out.printf("\n\n\n\n\n\n\n");

    }

    //MENU ITEM 10.
    public void desconte15() {

        double valor_nas_comandas = 0;

        for (int j = 0; j < comanda.size(); j++) {
            if (comanda.get(j).getCliente().getIdade() >= 65) {
                valor_nas_comandas = comanda.get(j).getValorTotal();
            }
        }

        System.out.println("O valor que a padaria perde dando um desconto de 15% para "
                + "pessoas com 65 anos de idade ou mais, será de: R$ " + (valor_nas_comandas * 0.15) + ".");

        System.out.printf("\n\n\n\n\n\n\n");
    }

    //MENU ITEM 11.
    public void pagamentoDaFila() {

        //Percore os Arrays da classe FIlaDOCaixa para receber o pagamento.
        for (int j = 0; j < FilaDoCaixa.getPrioridade().size(); j++) {

            Caixa.setValor_em_caixa(FilaDoCaixa.getPrioridade().get(j).getValorTotal());
            FilaDoCaixa.getPrioridade().get(j).setValorTotal(0.0);
            FilaDoCaixa.getPrioridade().get(j).getProduto().clear();
            clientesAtendidos.add(FilaDoCaixa.getPrioridade().get(j).getCliente());
        }
        FilaDoCaixa.getPrioridade().clear();
        for (int j = 0; j < FilaDoCaixa.getNormal().size(); j++) {
            Caixa.setValor_em_caixa(FilaDoCaixa.getNormal().get(j).getValorTotal());
            FilaDoCaixa.getNormal().get(j).setValorTotal(0.0);
            FilaDoCaixa.getNormal().get(j).getProduto().clear();
            clientesAtendidos.add(FilaDoCaixa.getNormal().get(j).getCliente());
        }
        FilaDoCaixa.getNormal().clear();
        System.out.println("Volte sempre!");
        System.out.printf("\n\n\n\n\n\n\n");
    }

    //MENU ITEM 12.
    public boolean clientesCadastrados() {

        if (cliente.isEmpty()) {
            System.out.println("Nenhum cliente foi cadastrado até o momento.");
            System.out.println("Digite '7' para cadastrar um novo cliente.");
            return false;
        }
        //Mostra todos os clientes cadastrados
        for (int j = 0; j < cliente.size(); j++) {
            System.out.println(cliente.get(j).toString());
        }

        System.out.printf("\n\n\n\n\n\n\n");

        return true;
    }

    //Menu item 13
    public void removerProduto() {

        System.out.println("Digite o número da comanda:");
        int numero = input.nextInt() - 1;
        System.out.println("Digite o produto que deseja remover:");
        String nome = input2.nextLine();

        for (int i = 0; i < comanda.get(numero).getProduto().size(); i++) {
            if (comanda.get(numero).getProduto().get(i).getNome().equalsIgnoreCase(nome)) {
               
                double a = -comanda.get(numero).getProduto().get(i).getValor();
                comanda.get(numero).setValorTotal(a);
                int b = comanda.get(numero).getQuantidade() - 1;
                comanda.get(numero).setQuantidade(b);
                comanda.get(numero).getProduto().remove(i);
            }
        }
        System.out.println("O produto foi removido!");
        System.out.printf("\n\n\n\n\n\n\n");

    }

    //Menu item 14.
    public void clientesAtendidos() {

        System.out.println("Os clintes que foram atendidos: ");
        for (int i = 0; i < clientesAtendidos.size(); i++) {
            System.out.println(clientesAtendidos.get(i).toString());
        }

        System.out.println("O valor total em caixa é: " + Caixa.getValor_em_caixa());
        System.out.printf("\n\n\n\n\n\n\n");
    }

    //MENU ITEM 15.
    public void fechar() {
        System.exit(0);//Sai do programa
    }

}
