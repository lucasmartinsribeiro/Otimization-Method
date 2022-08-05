package com.example;

import java.util.ArrayList;

public class Veiculo {
    int capacidade;
    private ArrayList<Objeto> lista_obj = new ArrayList<>();

    public Veiculo() {
    }

    public Veiculo(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public ArrayList<Objeto> getLista_obj() {
        return lista_obj;
    }

    public void setLista_obj(ArrayList<Objeto> lista_obj) {
        this.lista_obj = lista_obj;
    }
}
