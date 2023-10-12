package br.edu.ifsp.medias;

public class CalculadoraPonderada {
    public Double calcular(
            Double valorOne,
            Double valorTwo,
            Double valorThree,
            Double valorFour,
            Double valorFive,
            Double pesoOne,
            Double pesoTwo,
            Double pesoThree,
            Double pesoFour,
            Double pesoFive
    ){
        return ((valorOne * pesoOne) +
                (valorTwo * pesoTwo) +
                (valorThree * pesoThree) +
                (valorFour * pesoFour) +
                (valorFive * pesoFive)
                ) / (pesoOne + pesoTwo + pesoThree + pesoFive + pesoFour);
    }
}
