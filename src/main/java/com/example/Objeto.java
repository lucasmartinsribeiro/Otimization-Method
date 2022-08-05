package com.example;

public class Objeto implements Comparable<Objeto> {
    int id;
    double peso;
    double lucro;

    public Objeto() {
    }

    public Objeto(int id, double peso, double lucro) {
        this.id = id;
        this.peso = peso;
        this.lucro = lucro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getLucro() {
        return lucro;
    }

    public void setLucro(double lucro) {
        this.lucro = lucro;
    }

    public double divisaoDoLucroPeso() {
        double divisao = this.lucro / this.peso;

        return divisao;
    }

    //compara dois objetos, retornando um valor negativo, zero, ou um valor positivo 
    //se o objeto for menor, igual ou maior que o objeto especificado.
    @Override
    public int compareTo(Objeto obj) {
        if (this.divisaoDoLucroPeso() < obj.divisaoDoLucroPeso()) {
            return 1;
        } else if (this.divisaoDoLucroPeso() > obj.divisaoDoLucroPeso()) {
            return -1;
        }
        return 0;
    }
}
