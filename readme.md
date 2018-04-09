# Esolutions
## Java Starters Challenge - Partido de las estrellas
Dentro del dominio del mundial de futbol, cada año se realiza el denominado "Partido de las Estrellas", donde participan los mejores jugadores de las mismas.

Este partido se realiza todos los años, un día diferente.

### Requerimiento 1
Existe la particularidad de que previo el mundial de Brasil **1950**, las fechas se basaban en el **Calendario Juliano**. En el año 1950, se realizó la transición al **Calendario Gregoriano**, cuando el día siguiente al **31 de enero** fue el **14 de febrero**. Es decir que, en 1950, el 14 de febrero fue el día 32 del año.

En ambos calendarios, febrero es el único mes con una cantidad de días variables. Tiene 29 días durante los años bisiestos, y 28 el resto. En el Calendario Juliano, los años bisiestos son divisibles por 4; en el Calendario Gregoriano, los años bisiestos pueden ser:

- Divisibles por 400
- Divisibles por 4, y no divisibles por 100

Se cuenta con los siguientes datos de ejemplo:

| Año | Día del año |
| :---: | :---------: |
| 1930 | 189 |
| 1936 | 157 |
| 1950 | 40 |
| 1980 | 75 |
| 2017 | 256 |
| ... | ... |

Dado un único input: en año (dentro del rango válido), calcular la fecha en que cae ese partido para el año dado.

> **Limites:** 1930 <= year <= 1918

Luego presentar el resultado en formato **dd-mm-yyyy**, donde "dd" es el día en 2 dígitos, "mm" el mes en 2 dígitos, y "yyyy" el año.


#### Ejemplo 1

En el año **2017**, enero tiene 31 días, febrero tiene 28 días, marzo tiene 31 días, abril tiene 30 días, mayo tiene 31 días, junio tiene 30 días, julio tiene 31 días, y agosto tiene 31 días. Cuando sumamos el total de días en los primeros 8 meses, obtenemos 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 = 243. El día del partido es el 256, así que el cálculo 256 – 243 = 13 determina que es el día 13 del mes 9 (septiembre).  
_Entrada:_ 2017  
_Salida:_ 13-09-2017

#### Ejemplo 2

En el año **1980 (bisiesto)**, enero tiene 31 días y febrero tiene 29 días. Cuando sumamos el total de días en los primeros 2 meses, obtenemos 31 + 29 = 60. El día del partido es el 75, así que el cálculo 75 – 60 = 15 determina que es el día 15 del mes 3 (marzo).   
_Entrada:_ 1980  
_Salida:_ 12-09-1980

##### Endpoint _GET_ /matches/{year}
````json
{
    "year": 2016, 
    "dayOfYear": 32, 
    "date": "01-02-2016"
}
````

### Requerimiento 2
Dado un listado de jugadores con nombre y apellido, devolver un listado de apellidos repetidos.

#### Ejemplo
Dada la siguiente tabla:  

| Id | Name |
| :---: | :---------: |
| 1 | **Alvarez**, Jose |
| 2 | **Paredes**,Jorge |
| 3 | Romario,Luis |
| 4 | **Alvarez** ,Marcos |
| 5 | Michellin,Agustin |
| 6 | **Alvarez**, Nicolas |
| 7 | **Paredes**, Nicolas |
| ... | ... |
_Salida:_ ["Alvarez", "Paredes"]


##### Endpoint _GET_ /players/last-name/repeated
````json
{
    "last-names": ["Alvarez", "Paredes"]
}
````

### Requerimiento 3


##### Endpoint _GET_ /players/ranking

Top 10 jugadores con mayor cantidad de partidos
````json
{
    "players": [
        {"name": "Acevedo,Juan", "played": 15},
        {"name": "Perez, Carlos", "played": 13}
    ]
}
````

### Conexión BD
1. Datos para usar cliente de BD
    1. Driver: H2
    2. Url: jdbc:h2:mem:jsc
    3. Port: 6000
    4. User: jsc
    5. Password: jsc00
2. Consola de bd embebida
    1. Url: http://localhost:8080/db
    2. _Driver Class_: org.h2.Driver
    3. _JDBC URL_: jdbc:h2:tcp://localhost:6000/mem:jsc
    4. _User Name_: jsc
    5. _Password_: jsc00