
// MAIN POR SI QUIERO EJECUTAR LA APLICACION EN CONSOLA
/*
package com.aluracursos.screenmatch;

import com.aluracursos.screenmatch.principal.PrincipalModificaciones;
import com.aluracursos.screenmatch.repositorio.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplicationConsola implements CommandLineRunner {
	@Autowired
	private SerieRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplicationConsola.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		PrincipalModificaciones principalModificaciones = new PrincipalModificaciones(repository);
		principalModificaciones.muestraElMenu();

		//Principal principal = new Principal();
		//principal.muestraElMenu();

		//EjemploStreams ejemploStreams = new EjemploStreams();
		//ejemploStreams.muestraEjemplo();

	}
}
*/