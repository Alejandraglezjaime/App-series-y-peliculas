package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.model.DatosEpisodio;
import com.aluracursos.screenmatch.model.DatosSerie;
import com.aluracursos.screenmatch.model.DatosTemporadas;
import com.aluracursos.screenmatch.model.Episodio;
import com.aluracursos.screenmatch.service.ConsumoAPI;
import com.aluracursos.screenmatch.service.ConvierteDatos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private final String URL_BASE = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&tu-apikey";
    private ConvierteDatos conversor = new ConvierteDatos();


    public void muestraElMenu(){
        System.out.println("Escribe el nombre de la série que deseas buscar");
        //** BUSCA LOS DATOS GENERALES DE LAS SERIES
        var nombreSerie = teclado.nextLine();
        var json = consumoApi.obtenerDatos(URL_BASE + nombreSerie.replace(" ", "+") + API_KEY);
        //*** replace sirve para el espacio lo suple con +

        //https://www.omdbapi.com/?t=game+of+thrones&apikey=4fc7c187
        DatosSerie datos = conversor.obtenerDatos(json, DatosSerie.class);
        System.out.println(datos);

        //** BUSCA LOS DATOS DE TODAS LAS TEMPORADAS
        List<DatosTemporadas> temporadas = new ArrayList<>();

        for (int i = 1; i <= datos.totalTemporadas(); i++) {
            json = consumoApi.obtenerDatos(URL_BASE + nombreSerie.replace(" ", "+") + "&Season=" + i + API_KEY);
            DatosTemporadas datosTemporada = conversor.obtenerDatos(json, DatosTemporadas.class);
            temporadas.add(datosTemporada);
        }
        temporadas.forEach(System.out::println);
        //MOSTRAR SOLO EL TITULO DE LOS EPISODIOS PARA LAS TEMPORADAS
        for (int i = 0; i < datos.totalTemporadas(); i++) {
            List<DatosEpisodio> episodiosTemporadas = temporadas.get(i).episodios();
            for (int j = 0; j < episodiosTemporadas.size(); j++) {
                System.out.println(episodiosTemporadas.get(j).titulo());
            }
        }
        // Mejoría usando funciones Lambda, esta linea simplifica la línea 42 a 47
        temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));

        //CONVERTIR TODAS LAS INFORMACIONES A UNA LISTA DEL TIPO DATOSEPISODIO
        List<DatosEpisodio> datosEpisodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream())
                .collect(Collectors.toList());

        //TOP DE LOS MEJORES 5 EPISODIOS
        System.out.println("\n Top 5 episodios");
        datosEpisodios.stream()
                .filter(e -> !e.evaluacion().equalsIgnoreCase("N/A"))
                .peek(e -> System.out.println("PRIMER FILTRO (N/A)" + e ))
                .sorted(Comparator.comparing(DatosEpisodio::evaluacion).reversed())
                .peek(e -> System.out.println("SEGUNDO FILTRO ORDENACION DE MAYOR A MENOR" + e ))
                .map(e->e.titulo().toUpperCase()) //toUpperCase() convierte en mayusculas
                .peek(e -> System.out.println("TERCER FILTRO CONVIERTE EN MAYUSCULAS" + e ))
                .limit(5)
                .forEach(System.out::println);

        //CONVIRTIENDO LOS DATOS A UNA LISTA DEL TIPO EPISODIO
        List<Episodio> episodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream()
                        .map(d -> new Episodio(t.numero(), d)))
                .collect(Collectors.toList());

        episodios.forEach(System.out::println);

        // BUSQUEDA DE EPISODIOS A PARTIR DEL AÑO X
    /*    System.out.println("a partir de que año deseas ver los episodios?");
        var fecha = teclado.nextInt();
        teclado.nextLine();

        LocalDate fechaBusqueda = LocalDate.of(fecha, 1, 1);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        episodios.stream()
                .filter(e -> e.getFechaDeLanzamiento() != null && e.getFechaDeLanzamiento().isAfter(fechaBusqueda))
                .forEach(e -> System.out.println(
                        "Temporada: " + e.getTemporada() +
                                " Episodio: " + e.getTitulo() +
                                " Fecha de Lanzamiento: " + e.getFechaDeLanzamiento().format(dtf)
                ));  */

        //BUSCA EPISODIOS POR PEDAZO DEL TITULO
    /*    System.out.println("ESCRIBE EL TITULO DEL EPISODIO A BUSCAR");
        var pedazoTitulo = teclado.nextLine();
        Optional<Episodio> episodioBuscado = episodios.stream()
                .filter(e -> e.getTitulo().toUpperCase().contains(pedazoTitulo.toUpperCase( )))
                .findFirst();
        if (episodioBuscado.isPresent()){
            System.out.println("EPISODIO ENCONTRADO ");
            System.out.println("LOS DATOS SON: " +episodioBuscado.get());
        } else {
            System.out.println("EPISODIO NO ENCONTRADO ");
        } */

        Map<Integer , Double> evaluacionesPorTemporada = episodios.stream()
                .filter(e->e.getEvaluacion()>0.0)
                .collect(Collectors.groupingBy(Episodio::getTemporada,Collectors.averagingDouble(Episodio::getEvaluacion)));
        System.out.println(evaluacionesPorTemporada);

        DoubleSummaryStatistics est = episodios.stream()
                .filter(e->e.getEvaluacion()>0.0)
                .collect(Collectors.summarizingDouble(Episodio::getEvaluacion));
        System.out.println("MEDIA DE LAS EVALUACIONES  :  " +est.getAverage());
        System.out.println("EPISODIO MEJOR EVALUADO  :  " +est.getMax());
        System.out.println("EPISODIO PEOR EVALUADO  :  " +est.getMin());



    }
}
