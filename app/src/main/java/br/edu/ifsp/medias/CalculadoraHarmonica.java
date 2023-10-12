package br.edu.ifsp.medias;

public class CalculadoraHarmonica {

    public Double calcular(
            Double valorOne,
            Double valorTwo,
            Double valorThree,
            Double valorFour,
            Double valorFive
    ){

        return 5 / ((1/valorOne) +
                (1/valorTwo) +
                (1/valorThree) +
                (1/valorFour) +
                (1/valorFive)) ;
    }
}
