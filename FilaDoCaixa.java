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
public class FilaDoCaixa {
    
    //ArrayList para guardar os numeros das comandas das pessoas que 
    //vão para a fila. Dois Arrays, um para guardar a fila normal e 
    //outro para a fila de proridade.
    private static ArrayList<Comanda> normal = new ArrayList();
    private static ArrayList<Comanda> prioridade = new ArrayList();
    //Quando chamar o classe FilaDeCaixa passa os paramentros da classe Comanda

    //Método static para adicionar uma pessoa na fila e decidir para qual
    //fila ela vai, normal ou de prioridade.
    public static void fila(Comanda comanda) {

        if (comanda.getCliente().getIdade() >= 65) {
            prioridade.add(comanda);
        } else {
            normal.add(comanda);
        }

    }
    
    //Método para faber o tamanho da fila
    public static int tamanhodaFila() {
        return normal.size() + prioridade.size();
    }

    public static ArrayList<Comanda> getNormal() {
        return normal;
    }

    public static void setNormal(ArrayList<Comanda> aNormal) {
        normal = aNormal;
    }

    public static ArrayList<Comanda> getPrioridade() {
        return prioridade;
    }

    public static void setPrioridade(ArrayList<Comanda> aPrioridade) {
        prioridade = aPrioridade;
    }

}
