package Metodos;

import View.ViewPrincipal;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author CPD
 */
public class MetodosAmostragem {
    public MetodosAmostragem(){}

    //Método de Amostragem Aleatória Com Reposição
    public void aleatoriaComReposicao(){
        
    }
    //Método de Amostragem Aleatória Sem Reposição
    public void aleatoriaSemReposicao(ViewPrincipal view){
        ArrayList<Integer> vetor = new ArrayList<>();
        int i, pop, amostra;
        
        pop = Integer.parseInt(view.getFieldTamanhoPopulacaoSemRep().getText());
        amostra = Integer.parseInt(view.getFieldTamanhoAmostraSemRep().getText());
        
        System.out.println(pop);
        System.out.println(amostra);
        
        Random random = new Random();
        for(i = 0; i < amostra; i++){
            vetor.add((random.nextInt(pop)+1));
        }
        String titulo = "TESTE\n";
        String msg = "";
        for(i = 0; i < amostra; i++){
            msg = msg + vetor.get(i)+"\t";
        }
        view.getTextAreaResultadoSemReposicao().setText(titulo+msg);
    }
    //Método de Amostragem Sistemática
    public void sistematica(){
    }
}
