package com.example;

import java.util.ArrayList;

public class Veiculo {
    int capacidade;
    int capacidadeAtual;
    private ArrayList<Objeto> lista_obj = new ArrayList<>();

    public Veiculo() {
    }

    public Veiculo(int capacidade) {
        this.capacidade = capacidade;
        this.capacidadeAtual = 0;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getCapacidadeAtual(){
        return capacidadeAtual;
    }

    public ArrayList<Objeto> getLista_obj() {
        return lista_obj;
    }

    public void setLista_obj(ArrayList<Objeto> lista_obj) {
        this.lista_obj = lista_obj;
    }

    public void adicionaObjeto(Objeto obj){
        this.lista_obj.add(obj);
        this.capacidadeAtual += obj.getPeso();
    }
}
