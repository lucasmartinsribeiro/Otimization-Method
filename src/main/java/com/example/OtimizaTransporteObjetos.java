package com.example;

/**
 * 
 * @author: lucas
 *
 */
public class OtimizaTransporteObjetos {
    public static void main( String[] args ){
        MaximizaLucro otimiza_entregas = new MaximizaLucro();
        
        Veiculo caminhao = new Veiculo(2000);

        otimiza_entregas.OtimizaTransporte(caminhao);
    }
}
