/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psd;
/**
 * @author Vinicius Cortez Cavalcante Rocha;
 *         Noemy Roberta de Oliveira Silva.
 *  Turma: 922-A.
 */
public class Caixa {

    //Variável static para quardar o valor em caixa
    private static double valor_em_caixa;

    //Recebe os valores que foram comprados e soma ao valor atual em caixa.
    public static void setValor_em_caixa(double valor_em_caixa) {
        Caixa.valor_em_caixa += valor_em_caixa;
    }

    //Devolve o valor que se encontra no caixa
    public static double getValor_em_caixa() {
        return valor_em_caixa;
    }

}
