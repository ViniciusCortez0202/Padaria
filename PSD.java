/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psd;

import java.util.Scanner;

/**
 *
 * @author Rocha
 */
public class PSD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner input = new Scanner(System.in);
        
        Menu menu = new Menu();
        
        
             
        do
        {
            //Menu para gerenciamento
            System.out.println("--------------- MENU ---------------");
            System.out.println("(1) Para PEGAR uma nova COMANDA;");
            System.out.println("(2) Para ADICIONAR na COMANDA;");
            System.out.println("(3) Para consultar VALOR em caixa;");
            System.out.println("(4) Para consultar PRODUTOS comprados de uma COMANDA;");
            System.out.println("(5) Para consultar QUANTIDADE e VALOR vendido de um PRODUTO;");
            System.out.println("(6) Para adicionar CLIENTES na fila");
            System.out.println("(7) Para criar um CADASTRO;");
            System.out.println("(8) Para consultar CLIENTE com mais e menos compras;");
            System.out.println("(9) Para consultar fila do CAIXA;");
            System.out.println("(10)Para descontar 15%;");
            System.out.println("(11)Para RECEBER dos clientes que estão na fila;");
            System.out.println("(12)Para consultar todos os CLIENTES;");
            System.out.println("(13)Para remover produto de comanda");
            System.out.println("(14)Para mostrar os Clientes que já pagaram e o valor contido no Caixa");
            System.out.println("(15)Para SAIR do programa.");
            
            //Variável para gerenciar a escolha do menu.
            int  i = input.nextInt();

            switch (i)
            {
                case 1:
                    //Verifica se o cliente já tem cadastro e toma a decisão.
                    System.out.println("Já possui cadastro?");
                    System.out.print("<digite 'N' para não; digite 'S' para sim>");
                    char resposta = input.next().charAt(0);
                    if(resposta == 'N')
                    {
                        //Método que vai fazer o cadastro do cliente e 
                        // dar para ele uma comanda.
                        menu.pegarComandaSemCadastro();
                        
                    }
                    else if(resposta == 'S')
                    {
                        //Se o cliente já tiver cadastro vai dar para.
                        //ele uma comanda
                        menu.pegarComandaComCadastro();
                        
                    }
                    break;
   
                case 2:
                    //Chama o método para adicionar um produto.
                    menu.adicionarProduto();
                    break;

                case 3:
                    //Mostra valor em caixa.
                    menu.valorEmCaixa();
                    break;

                case 4:
                    //Mostra os produtos em uma determinada comanda.
                    menu.mostrarProdutosEmComanda();
                    break;

                case 5:
                    //Mostra a quantidade e o valor que foram comprados de 
                    //um determinado produto.
                    menu.quantidadeValorDeUmProduto();
                    break;
                    
                case 6:
                    //Chama o mátodo para adicionar clientes na fila.
                    menu.adicionarClienteEmFila();
                    break;
                    
                case 7:
                    //Chama um método para criar cadastro para um cliente.
                    menu.criarCadastro();
                    break;
                    
                case 8:
                    //Mostra quaç foi o cliente que mais comprou e o que menos comprou.
                    menu.clienteMaisMenos();
                    break;
                case 9:
                    //Mostra as pessoas que estão da fila começando pelas que tem
                    //prioridade e quantidade de pessoas que tem na fila.
                    menu.clientesNaFila();
                    break;
                    
                case 10:
                    //Mostra quanto custaria o desconto de 15% para cliente com mais
                    // de 65 anos de idade.
                    menu.desconte15();
                    break;
                case 11:
                    //Atende as pessoas que estão na fila.
                    menu.pagamentoDaFila();
                    break;
                case 12:
                    //Mostra o cadastro de todos os clientes.
                    menu.clientesCadastrados();
                    break;
                    //Fecha o programa.'

                case 13:
                    
                    //Para remover produto de uma comanda.
                    menu.removerProduto();
                    break;
                    
		case 14:
		     //Mostra os clientes atentidos e o valor no caixa.
		     menu.clientesAtendidos();
                     break;		

                case 15:
                    menu.fechar();
            }
        }   while(true);//Fim dowhile
    }
    
}
