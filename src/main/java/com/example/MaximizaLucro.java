package com.example;

import java.util.ArrayList;
import java.util.Collections;

public class MaximizaLucro {
    private ArrayList<Objeto> lista_objetos = new ArrayList<Objeto>();
    private ArrayList<Objeto> lista_ordenada = new ArrayList<Objeto>(lista_objetos);
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

        this.lista_ordenada = (ArrayList<Objeto>)lista_objetos.clone();
        Collections.sort(this.lista_ordenada);
        
        System.out.println("\n");
        
        for(int i = 0; i < this.lista_ordenada.size(); i++){
            if((caminhao.getCapacidadeAtual() + this.lista_ordenada.get(i).getPeso()) <= caminhao.getCapacidade()){
                caminhao.adicionaObjeto(this.lista_ordenada.get(i));
            }
        }

        imprimeListaObjetosCarregados(caminhao);

        for(Objeto obj: caminhao.getLista_obj()){
            for(int i=0;i<this.lista_objetos.size();i++){
                //comparar o objeto que está dentro do caminhao até encontrar, 
                //encontrei ele vai adionar um 1 a minha lista solucao
                if(obj.getId() == this.lista_objetos.get(i).getId()){
                    this.solucao[i] = 1;
                }
            }
        }
        
        System.out.println("\n");
        
        f_solucao(caminhao);
        
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
    
    public void f_solucao(Veiculo veiculo){
        System.out.println("Vetor solução: ");
        for(int cont = 0; cont < this.solucao.length; cont++){
            System.out.print(this.solucao[cont] + " | ");
        }
    }
    
    public void imprimeListaObjetosCarregados(Veiculo veiculo){
        System.out.println("Lista de Objetos Carregados: ");
        System.out.println("obj - lucro - peso - div lucro/peso");
        
        for(Objeto obj: veiculo.getLista_obj()){
            System.out.println(obj.getId() + " - " + obj.getLucro() + " - " + obj.getPeso() + " - " + obj.divisaoDoLucroPeso()+ " - ");
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
        System.out.println("\nLucro Total = " + "R$" + aux); 
    }
}
