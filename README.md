# APLICACION QUE BUSCA INFORMACION DE SERIES.

## Descripción del proyecto 

Este repositorio fue creado para entender la programación backend, utilizando Spring Boot, API KEY, lenguaje java, y base de datos (SQL).
La aplicación permite que el usuario ingrese el nombre de la serie que desea buscar, muestra tres opciones diferentes: 

    1.- Buscar serie
    2.- Buscar un episodio en específico 
    3.- Mostar el historial de las series buscadas.

#### BUSCAR SERIE.
Cuando selecciona esta opción y el usuario escribe el nombre de la serie muestra los datos: título, total de temporadas, evaluación, url del poster, género, actores y sinópsis. La sinópsis se encuentra en ingles ya que la API donde estamos tomando la información esta en dicho idioma, por lo que en el código encontraras una sección donde muestra como traducirlo a español usando una IA, en este caso el uso de chatgpt, para poderlo implementar necesitas obtener la llave APIKEY de chatgpt. 

    _NOTA: Si ya habías creado una cuenta gratuita de chatgpt y ya lo has usado es probable que te acabaras los créditos gratuitos que te otorga, ya que aunque crees una cuenta nueva este te va a pedir tu número de celular y si detecta el mismo número usado en otro correo, lo asociaral, por ende no te dara créditos nuevos._ 

Si el nombre esta mal escrito te mandara la lista pero con la información en null. 

#### MOSTRAR EL HISTORIAL DE LAS SERIES BUSCADAS.
Cuando seleccionas esta opción te muestra un historial de las series que has buscado, regresando la información en un array. 