package Metodos;

import java.util.ArrayList;

/**
 * Métodos de ordenação
 * @author CPD
 */
public class MetodosOrdenacao {
    public MetodosOrdenacao(){}

    //Seleção
    public static void selecao(ArrayList<Integer> vetor){
         int i, j, posMenor, aux;

         for(i = 0; i < vetor.size() - 1; i++){
             posMenor = i;
             
             for(j = i+1; j < vetor.size(); j++){
                 if(vetor.get(j) < vetor.get(posMenor)){
                     posMenor = j;
                 }
             }
             if(i != posMenor){
                 aux = vetor.get(i);
                 vetor.set(i, vetor.get(posMenor));
                 vetor.set(posMenor, aux);
             }
         }
    }
    
    //Inserção
    public static void insercao(ArrayList<Integer> vetor){
        int i, j, aux;
        
        for (i = 1; i < vetor.size(); i++){
            aux = vetor.get(i);
            for(j = i-1; j >= 0 && aux < vetor.get(j); j--){ 
                vetor.set(j+1, vetor.get(j));
            }
            vetor.set(j+1, aux);
        }
    }
    
    //Bolha
    public static void bolha(ArrayList<Integer> vetor){
        int i, aux;
        boolean troca;
        do{
             troca = false;
             for(i = 0; i < vetor.size() - 1; i++){
                 if(vetor.get(i) > vetor.get(i+1)){
                     aux = vetor.get(i);
                     vetor.set(i, vetor.get(i+1));
                     vetor.set(i+1, aux);
                     troca = true;
                 }
             }
         } while(troca);
    }
    
    //Agitação
    public static void agitacao(ArrayList<Integer> vetor){
        int i, aux, ini, fim;
        ini = 0;
        fim = vetor.size() - 1;
        boolean houveTroca;
        
        do{
            houveTroca = false;
            for(i = ini; i < fim; i++){
                if(vetor.get(i) > vetor.get(i+1)){
                    aux = vetor.get(i);
                    vetor.set(i, vetor.get(i+1));
                    vetor.set(i+1, aux);
                    houveTroca = true;
                }
            }
            fim--;
            if(!houveTroca) break;
            
            houveTroca = false;
            
            for(i  = fim; i > ini; i--){
                if(vetor.get(i) < vetor.get(i-1)){
                    aux = vetor.get(i);
                    vetor.set(i, vetor.get(i-1));
                    vetor.set(i-1, aux);
                    houveTroca = true;
                }
            }
            ini++;
        }while(houveTroca  && fim > ini);
    }
    
    //Pente
    public static void pente(ArrayList<Integer> vetor){
        int i, distancia, aux;
        boolean houveTroca;
        
        distancia = vetor.size();
        
        do{
            distancia = (int) (distancia / 1.3);
            if(distancia < 1) distancia = 1; //Vira bolha
            houveTroca = false;
            for(i = 0; i + distancia < vetor.size(); i++){
                if(vetor.get(i) > vetor.get(i+distancia)){
                    aux = vetor.get(i);
                    vetor.set(i, vetor.get(i + distancia));
                    vetor.set(i+distancia, aux);
                    houveTroca = true;
                }
            }
        }while(distancia > 1 || houveTroca);
    }
    
    //Shell
    public static void shellSort(ArrayList<Integer> vetor){
        int i, j, aux, distancia = 1;

        do{
            distancia = 3 * distancia + 1;
        }while(distancia < vetor.size());
        
        do{
            distancia = (int) distancia/ 3;
            for(i =  distancia; i < vetor.size(); i++){
                aux = vetor.get(i);
                for(j =  i - distancia; j >= 0 && aux < vetor.get(j); j =  j - distancia){
                    vetor.set(j+distancia, vetor.get(j));
                }
                vetor.set(j+distancia, aux);
            }
        }while(distancia > 1);
    }
}
