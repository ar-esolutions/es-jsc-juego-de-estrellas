# Esolutions
## Java Starters Challenge - Partido de las estrellas
*TODO*: agregar enunciado
### Endpoints
#### _GET_ /matches/{year}
````json
{
    "year": 2016, 
    "dayOfYear": 32, 
    "date": "01-02-2016"
}
````
#### _GET_ /players/last-name/repeated
````json
{
    "last-names": ["Acevedo", "Alvarez", "Perez"]
}
````
#### _GET_ /players/ranking
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