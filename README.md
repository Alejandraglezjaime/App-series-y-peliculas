# SCREENMATCH (APLICACION DE INFORMACION DE SERIES)

Esta aplicación es una versión similar a las aplicaciónes de entretenimiento como lo es Netflix o Prime Video, en ella puedes ver diferentes secciones que muestras los títulos de las series dependiendo de su clasificación.

## Descripción del proyecto 

Este repositorio fue creado para entender la programación backend, utilizando Spring Boot,API, API KEY, lenguaje java, y base de datos (SQL). Además de mostrar como configurar la programación backEnd a Front End para facilitar el uso al usuario. 

La aplicación cuenta con un menú en el cual el usuario puede interactuar con la base de datos y a la API. Es aquí donde el usuario ingresa los datos de las series a la base de datos.

    1.-  Buscar series.
    2.-  Buscar episodios.
    3.-  Mostrar series buscadas.
    4.-  Buscar series por título.
    5.-  Top 5 de las mejores series.  
    6.-  Mostrar series por categoría/género.     
    7.-  Filtrar series por temporada y evaluación. 
    8.-  Buscar episodios por título.
    9.-  Top 5 de los mejores episodios por serie.   
    10.- Top 10 de los mejores episodios.

La aplicación te permite obtener información hacerca de la serie buscada, así como en información específica de algun episodio en particular, así como filtrar el top 5 y top 10 ya sea de los episodios o series en general

*La API a utilizar: https://www.omdbapi.com/*
 
## USO DE LA BASE DE DATOS.

Para el curso se utlizo la base de datos Postgres y su administrador PGAdmin.

*link de descarga : https://www.postgresql.org/download/*

### REQUISITOS DEL PROYECTO USANDO BASE DE DATOS 

- [x] Poder buscar cualquier serie y guardarla en nuestra base de datos.
- [x] Buscar episodios y guardarlo en la base de datos.
- [x] Mostrar todas las series buscadas que fueron guardadas en la base de datos. 
- [x] Buscar series por título guardadas en la base de datos.
- [x] Top de las 5 mejores series 
- [x] Buscar series por categoría. 
- [x] Filtrar series por el número de temporadas y su evaluación
- [x] Buscar episodios por nombre
- [x] Top 5 episodios por serie 

Para poder hacer uso del menú a partir del punto dos debes pasar por el punto 1, la serie automáticamente se guarda en la base de datos, se recomienda enseguido ocupar el punto 2 para guardar los episodios de la serie y no tener problemas al mandar a llamar los siguientes puntos. 

# VISUALIZACION FRONT END

### REQUISITOS DE LA APLICACION

- [x] El usuario podra visualizar las series que se encuentran dentro de la base de datos, en tres diferentes secciones:

      1.- Lanzamientos en ScreenMatch: observando su porter 
    
![Imagen principal app](https://github.com/Alejandraglezjaime/App-series-y-peliculas/blob/master/imagenes/ImagReadme/principal1.jpg?raw=true)

      2.- Títulos populares, ordenados de la mejor a menor evaluación

![Imagen segunda app](https://github.com/Alejandraglezjaime/App-series-y-peliculas/blob/master/imagenes/ImagReadme/principla2.jpg?raw=true)

      3.- Títulos en la app. 
      
![Imagen tercera app](https://github.com/Alejandraglezjaime/App-series-y-peliculas/blob/master/imagenes/ImagReadme/principal3.jpg?raw=true)


- [x] Habilitar una lista desplegable para el usuario, donde pueda observar las películas de determinada categoría, un ejemplo, que muestre películas de comedia, drama, romance... 

![Imagen seccion de series de accion](https://github.com/Alejandraglezjaime/App-series-y-peliculas/blob/master/imagenes/ImagReadme/classAccion.jpg?raw=true)

![Imagen seccion de series de drama](https://github.com/Alejandraglezjaime/App-series-y-peliculas/blob/master/imagenes/ImagReadme/classDrama.jpg?raw=true)

- [x] Poder seleccionar una serie al darle click en su poster y este nos redireccione a su información general. (Poster, título, evaluación, sinópsis, actores, sección para observar temporadas) 

![Imagen informacion birderton](https://github.com/Alejandraglezjaime/App-series-y-peliculas/blob/master/imagenes/ImagReadme/informacionSeleccion.jpg?raw=true)

![Imagen informacon teen wolf](https://github.com/Alejandraglezjaime/App-series-y-peliculas/blob/master/imagenes/ImagReadme/informacionSeleccion2.jpg?raw=true)

- [x] En la sección donde nos muestra la información general nos muestre una lista desplegable para observar los títulos de los episodios, ya sea por temporada específica o los episodios de todas las temporadas.

![Imagen lista desplegable ](https://github.com/Alejandraglezjaime/App-series-y-peliculas/blob/master/imagenes/ImagReadme/buscadorInformacion.jpg?raw=true)

![Imagen ejemplo de la lista de episodios](https://github.com/Alejandraglezjaime/App-series-y-peliculas/blob/master/imagenes/ImagReadme/temporada1Bridgerton.jpg?raw=true)

![Imagen ejemplo de la lista de episodios 2](https://github.com/Alejandraglezjaime/App-series-y-peliculas/blob/master/imagenes/ImagReadme/temporada1Bridgerton.jpg?raw=true)

![Imagen información de todas las temporadas disponibles](https://github.com/Alejandraglezjaime/App-series-y-peliculas/blob/master/imagenes/ImagReadme/seleccionInformacionTodasTemporadas.jpg?raw=true)

## REQUISITOS FALTANTES 

- [ ] Se busca que en la aplicación nos permmita desde la barra de busqueda buscar nuevos títulos e ingresarlos, en caso que no exista, mostrar una ventana que indique que el título no se encuentre disponible, y permita en un botón regresar a la ventana principal.

- [ ] Al seleccionar un título, nos manda a la ventana de información del mismo, debe aparecer un botón que nos permita regresar a la ventana principal.

#### DEPENDENCIAS. 

![Dependencias utilizadas](https://github.com/Alejandraglezjaime/App-series-y-peliculas/blob/master/imagenes/ImagReadme/dependencias.jpg?raw=true)

#### IMPORTANTE

Para poder observar el programa corriendo correctamente, debes compilar el programa en el IDE IntelliJ IDEA y para visualizarlo debes ejecutarlo desde un live server (se recomienda Visual Stude Code).

Acuerdate obtener tu llave API-KEY para que pueda obtener los datos de en la API OMDb que es un servicio web RESTful para obtener información de películas, todo el contenido y las imágenes del sitio son aportadas y mantenidas por los usuarios. 

# AUTOR
#### © Alejandra Gonzalez     