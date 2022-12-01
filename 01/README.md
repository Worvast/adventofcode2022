# Día 1

La verdad es que ha sido una mierda. A parte de que he 
empezado muy tarde, me ha costado la vida lanzar el proyecto
sin tener que crear toda una estructura, solo un script.

Eso me ha llevado la mayor parte. Se supone que instalando el
snap de kotlin podría lanzar el script simplemente con:

`> kotlinc -script 01.kts`

Pero al ejecutarlo en consola me estaba dando todo el rato
como si no hiciera nada. Tampoco he conseguirlo ejecutarlo
desde InelliJ. Es algo que tengo que revisar y arreglar.

Así que al final he tenido que crearme los archivos tipo .kt
que he visto que con:

```
> kotlinc <fileinput>.kt -include-runtime -d <fileoutput>.jar
> java -jar <fileoutput>.jar  
```

Si que he podido ejecutarlo, aunque me ha molestado tener
que estar compilando, yo que vengo de Python :(

# El problema

El problema estaba dividido en 2 partes. La primera la he solucionado
de una manera bastante tradicional, he buscado como leer archivos en kotlin
y tras aplicar esta solución línea a línea he visto que no podía
saber si estaba en un EOF dentro del bucle, así que, ante lo tarde que es, 
he decidido tirar hacia adelante y duplicar el código para verificar la última suma

Había pensado en ponerlo en una función al menos pero desconozco como se
comporta Kotlin ahora mismo con el tema de variables entre funciones así que
para simplificar, en esta primera versión lo he hecho así.


Para la parte 2, he simplemente convertido en un array el maxCalc, 
modificado 2 tonterías y al carrer que tengo sueño.

No ha sido la mejor solución ni algorítmicamente hablando pero
está hecho y ya sé hacer algo en Kotlin. Ole yo.