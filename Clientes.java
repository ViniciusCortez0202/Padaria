/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psd;
import java.util.Calendar;
/**
 * @author Vinicius Cortez Cavalcante Rocha;
 *         Noemy Roberta de Oliveira Silva.
 *  Turma: 922-A.
 */
public class Clientes {

    //Variáveis para guardar o nome, data de nascimento, idade,
    //alem da Calendar que por meio do metodo getInstance() vai 
    //fornecer o dia, mês e ano de acordo com o relógio do computado.
    private String nome;
    private String data_de_nascimento;
    private int idade;
    private Calendar data = Calendar.getInstance();

    //O construtor vai ter como parametro o nome e data de nascimento
    //a idade vai ser calcula por meio do metodo setIdade().
    public Clientes(String nomes, String data_de_nasciento) {
        this.data_de_nascimento = data_de_nasciento;
        this.nome = nomes;
        setIdade();

    }

    public String getNome() {
        return nome;
    }

    public String getData_de_nascimento() {
        return data_de_nascimento;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade() {

        //Variáveis para pegar o valor da data de nascimento.
        int dia = Integer.parseInt(this.data_de_nascimento.substring(0, 2));
        int mes = Integer.parseInt(this.data_de_nascimento.substring(2, 4));
        int ano = Integer.parseInt(this.data_de_nascimento.substring(4));
        //Variáveis para pegar o dia, mês e ano de acordo com o relógio da máquina.
        int Dia = data.get(Calendar.DATE);
        int Mes = data.get(Calendar.MONTH) + 1;
        int Ano = data.get(Calendar.YEAR);
        //Aqui é feito os testes e o cálculo para saber a idade do cliente.
        if (mes < Mes) {
            this.idade = ((Ano - ano));
        } else if (mes > Mes) {
            this.idade = ((Ano - ano) - 1);
        } else if (mes == Mes) {
            if (dia > Dia) {
                this.idade = ((Ano - ano) - 1);
            } else {
                this.idade = ((Ano - ano));
            }
        }

    }

    //O método toString para pegar as informações do cliente.
    @Override
    public String toString() {
        return "Clientes{" + "nome:" + nome + ", data de nascimento: " + data_de_nascimento + ", idade: " + idade + '}';
    }

}
