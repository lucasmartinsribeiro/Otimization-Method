package com.example;

import java.util.ArrayList;
import java.util.Collections;

public class MaximizaLucro {
    private ArrayList<Objeto> lista_objetos = new ArrayList<Objeto>();
    private int []solucao;
    
    public void OtimizaTransporte(Veiculo caminhao){
        Objeto obj1 = new Objeto(1, 400, 200);
        Objeto obj2 = new Objeto(2, 500, 200);
        Objeto obj3 = new Objeto(3, 700, 300);
        Objeto obj4 = new Objeto(4, 900, 400);
        Objeto obj5 = new Objeto(5, 600, 400);

        this.lista_objetos = new ArrayList<>();

        this.lista_objetos.add(obj1);
        this.lista_objetos.add(obj2);
        this.lista_objetos.add(obj3);
        this.lista_objetos.add(obj4);
        this.lista_objetos.add(obj5);

        this.solucao = new int[lista_objetos.size()];
        
        imprimeListaObjetos();

        Collections.sort(this.lista_objetos);
        
        System.out.println("\n");

        imprimeListaObjetosCarregados();

        int aux = caminhao.getCapacidade();
        for(Objeto obj: this.lista_objetos){
            aux -= obj.getPeso();
            if(aux > 0){
                //verificar se cabe no caminhão, se cabe ele vai acrecentar 1 na lista de solução
                this.solucao[obj.getId() - 1] = 1;
            }
        }
        
        System.out.println("\n");
        
        f_solucao();
        
        System.out.println("\n");
        
        calculaLucroTotal();
    }
    
    public MaximizaLucro() {
    }

    public MaximizaLucro(int[] solucao) {
        this.solucao = solucao;
    }

    public int[] getSolucao() {
        return solucao;
    }

    public void setSolucao(int[] solucao) {
        this.solucao = solucao;
    }
    
    public void f_solucao(){
        System.out.println("Vetor solução: ");
        for(int cont = 0; cont < this.solucao.length; cont++){
            System.out.print(this.solucao[cont] + " | ");
        }
    }
    
    public void imprimeListaObjetosCarregados(){
        System.out.println("\nLista de Objetos Carregados: ");
        System.out.println("obj - lucro - peso - div lucro/peso");
        
        for(Objeto obj: this.lista_objetos){
            if(obj.divisaoDoLucroPeso() > 0.43){
                System.out.println(obj.getId() + " - " + obj.getLucro() + " - " + obj.getPeso() + " - " + obj.divisaoDoLucroPeso()+ " - ");
            }
        }
    }
    
    public void imprimeListaObjetos(){
        System.out.println("\nLista de Objetos: ");
        System.out.println("obj - lucro - peso - div lucro/peso");

        for(Objeto obj: this.lista_objetos){
            System.out.println(obj.getId() + " - " + obj.getLucro() + " - " + obj.getPeso() + " - " + obj.divisaoDoLucroPeso()+ " - "); 
        }
        
    }
    
    public void calculaLucroTotal(){
        int aux = 0;
        for(int cont = 0; cont < this.solucao.length; cont++){
            if(this.solucao[cont] == 1){
                // System.out.println(cont+1);
                for(Objeto obj: this.lista_objetos){
                    if (obj.getId() == cont + 1){
                        aux += obj.getLucro();
                    }
                }
            }
        }
        System.out.println("\nLucro Total = " + aux); 
    }
}
