package com.aluracursos.screenmatch.principal;
import java.util.Arrays;
import java.util.List;

public class EjemploStreams {
    public void muestraEjemplo(){
        List<String> nombres = Arrays.asList("Oziel","Alejandra","Alfredo","Eduardo","Iker");
        nombres.stream()
                .sorted()  //ORDENAMIENTO ALFABETICAMENTE
                .limit(5) //ME MUESTRA LOS PRIMEROS 4 ELEMENTOS DE LA LISTA
                .filter(n -> n.startsWith("O")) //DE LA LISTA BUSCARA EL NOMBRE QUE COMIENCE AL INICIO CON O
                .map(n -> n.toUpperCase()) //VA A TRANSFORMAR EL NOMBRE A LETRA MAYUSCULA
                .forEach(System.out::println); //IMPRIME LA LISTA DE NOMBRES
    }

}
