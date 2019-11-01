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
    
    MetodosOrdenacao ordenacao = new MetodosOrdenacao();
    
    //Método de Amostragem Aleatória Com Reposição
    public void aleatoriaComReposicao(ViewPrincipal view){
        ArrayList<Integer> vetor = new ArrayList<>();
        int i, pop, amostra;
        
        pop = Integer.parseInt(view.getFieldTamanhoPopulacaoComRep().getText());
        amostra = Integer.parseInt(view.getFieldTamanhoAmostraComRep().getText());
        
        Random random = new Random();
        for(i = 0; i < amostra; i++){
            vetor.add((random.nextInt(pop)+1));
        }
        
        ordenacao.selecao(vetor);
        
        String titulo = "TESTE\n";
        String msg = "";
        for(i = 0; i < amostra; i++){
            msg = msg+vetor.get(i)+"\t";
        }
        
        view.getTextAreaResultadoComReposicao().setText(titulo+msg);
    }
    
    //Método de Amostragem Aleatória Sem Reposição
    public void aleatoriaSemReposicao(ViewPrincipal view){
        ArrayList<Integer> vetor = new ArrayList<>();
        int i, j, pop, amostra, teste, aux;
        
        pop = Integer.parseInt(view.getFieldTamanhoPopulacaoSemRep().getText());
        amostra = Integer.parseInt(view.getFieldTamanhoAmostraSemRep().getText());
        
        Random random = new Random();
        for(i = 0; i < amostra;){
            teste = 0;
            aux = (random.nextInt(pop)+1);
            for(j = 0; j < i; j++){
                if(vetor.get(j) == aux){
                    teste = 1;
                }
            }
            if(teste == 0){
                vetor.add(aux);
                i++;
            }
        }
        
        ordenacao.selecao(vetor);
        
        String titulo = "TESTE\n";
        String msg = "";
        for(i = 0; i < amostra; i++){
            msg = msg+vetor.get(i)+"\t";
        }
        
        view.getTextAreaResultadoSemReposicao().setText(titulo+msg);
    }
    //Método de Amostragem Sistemática
    public void sistematica(ViewPrincipal view){
        ArrayList<Integer> vetor = new ArrayList<>();
        int k; //Razão
        int i, pop, amostra, inicio, kAnterior;
        
        Random random = new Random();
        
        pop = Integer.parseInt(view.getFieldTamanhoPopulacaoSistematica().getText());
        amostra = Integer.parseInt(view.getFieldTamanhoAmostraSistematica().getText());
        
        k = pop/amostra;
        kAnterior = k;
        
        inicio = random.nextInt(k)+1;
        
        for( ;k < pop; k =  k+kAnterior){
            vetor.add(inicio+k);
        }
        
        String titulo = "Intervalo sistemático: "+k+"\nPrimeiro número sorteado: "+inicio+"\n";
        String msg = "";
        for(i = 0; i < vetor.size(); i++){
            msg = msg+vetor.get(i)+"\t";
        }
        
        view.getTextAreaResultadoSistematica().setText(titulo+msg);
    }
}
