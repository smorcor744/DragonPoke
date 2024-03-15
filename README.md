[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/NBVXLiSy)
# Actividad: Desarrollo de Proyecto Software en Kotlin

**ID actividad:** 2324_PRO_u4u5u6_libre

**Agrupamiento de la actividad**: Individual 

---

### Descripción:

La actividad consiste en el desarrollo de un proyecto software en Kotlin, permitiendo al estudiante elegir la temática. Este proyecto debe demostrar la comprensión y aplicación de los conceptos de programación orientada a objetos (POO), incluyendo la definición y uso de clases, herencia, interfaces, genericos, principios SOLID y el uso de librerías externas.

**Objetivo:**

- Demostrar comprensión de los fundamentos de POO mediante la instanciación y uso de objetos.
- Aplicar conceptos avanzados de POO como herencia, clases abstractas, e interfaces.
- Crear y usar clases que hagan uso de genéricos. 
- Aplicar principios SOLID.
- Integrar y utilizar librerías de clases externas para extender la funcionalidad del proyecto.
- Documentar y presentar el código de manera clara y comprensible.

**Trabajo a realizar:**

1. **Selección de la Temática:** Elige un tema de tu interés que pueda ser abordado mediante una aplicación software. Esto podría ser desde una aplicación de gestión para una pequeña empresa, una herramienta para ayudar en la educación, hasta un juego simple. Define claramente el problema que tu aplicación pretende resolver.

2. **Planificación:** Documenta brevemente cómo tu aplicación solucionará el problema seleccionado, incluyendo las funcionalidades principales que desarrollarás.

3. **Desarrollo:**
   - **Instancia de Objetos:** Tu aplicación debe crear y utilizar objetos, demostrando tu comprensión de la instanciación y el uso de constructores, métodos, y propiedades.
   - **Métodos Estáticos:** Define y utiliza al menos un método estático, explicando por qué es necesario en tu aplicación.
   - **Uso de IDE:** Desarrolla tu proyecto utilizando un IDE, aprovechando sus herramientas para escribir, compilar, y probar tu código.
   - **Definición de Clases:** Crea clases personalizadas con sus respectivas propiedades, métodos, y constructores.
   - **Clases con genéricos:** Define y utiliza al menos una clase que haga uso de genéricos en tu aplicación.
   - **Herencia y Polimorfismo:** Implementa herencia y/o interfaces en tu proyecto para demostrar la reutilización de código y la flexibilidad de tu diseño.  **Usa los principios SOLID:** Ten presente durante el desarrollo los principios SOLID y úsalos durante el diseño para mejorar tu aplicación.
   - **Librerías de Clases:** Integra y utiliza una o más librerías externas que enriquezcan la funcionalidad de tu aplicación.
   - **Documentación:** Comenta tu código de manera efectiva, facilitando su comprensión y mantenimiento.

4. **Prueba y Depuración:** Realiza pruebas para asegurarte de que tu aplicación funciona como se espera y depura cualquier error encontrado.
5. **Contesta a las preguntas** ver el punto **Preguntas para la Evaluación**

### Recursos

- Apuntes dados en clase sobre programación orientada a objetos, Kotlin, uso de IDEs, y manejo de librerías.
- Recursos vistos en clase, incluyendo ejemplos de código, documentación de Kotlin, y guías de uso de librerías.

### Evaluación y calificación

**RA y CE evaluados**: Resultados de Aprendizaje 2, 4, 6, 7 y Criterios de Evaluación asociados.

**Conlleva presentación**: SI

**Rubrica**: Mas adelante se mostrará la rubrica.

### Entrega

> **La entrega tiene que cumplir las condiciones de entrega para poder ser calificada. En caso de no cumplirlas podría calificarse como no entregada.**
>
- **Conlleva la entrega de URL a repositorio:** El contenido se entregará en un repositorio GitHub. 
- **Respuestas a las preguntas:** Deben contestarse en este fichero, README.md


# Preguntas para la Evaluación

Este conjunto de preguntas está diseñado para ayudarte a reflexionar sobre cómo has aplicado los criterios de evaluación en tu proyecto. Al responderlas, **asegúrate de hacer referencia y enlazar al código relevante** en tu `README.md`, facilitando así la evaluación de tu trabajo.

#### **Criterio global 1: Instancia objetos y hacer uso de ellos**
- **(2.a, 2.b, 2.c, 2.d, 2.f, 2.h, 4.f, 4.a)**: Describe cómo has instanciado y utilizado objetos en tu proyecto. ¿Cómo has aplicado los constructores y pasado parámetros a los métodos? Proporciona ejemplos específicos de tu código.
Para instaciar los villanos que hay lo que he echo a sido hacer una funcion que contiene una instanciación de todos los villanos y despues añadirlos a un mapa donde la clave es un Pair con las filas y columnas
https://github.com/smorcor744/DragonPoke/blob/75b789781d636461ff63a9e4df1631e192366507/src/main/kotlin/Main.kt#L23-L34
Y despues la he iniciado en el main dandole un value
https://github.com/smorcor744/DragonPoke/blob/75b789781d636461ff63a9e4df1631e192366507/src/main/kotlin/Main.kt#L56
Y despues para el jugador he pedido que me de el nombre, el genero y la dificultad en la que quiere jugar
https://github.com/smorcor744/DragonPoke/blob/75b789781d636461ff63a9e4df1631e192366507/src/main/kotlin/Main.kt#L46-L55

#### **Criterio global 2: Crear y llamar métodos estáticos**
- **(4.i)**: ¿Has definido algún método/propiedad estático en tu proyecto? ¿Cuál era el objetivo y por qué consideraste que debía ser estático en lugar de un método/propiedad de instancia?
- Lo que he echo a sido generar las estadisticas en un companion object para que se vayan actualizando comforme entrenas o subes de nivel
https://github.com/smorcor744/DragonPoke/blob/75b789781d636461ff63a9e4df1631e192366507/src/main/kotlin/Estadisticas/EstadisticasSegunGenero.kt#L7-L28

- **(2.e)**: ¿En qué parte del código se llama a un método estático o se utiliza la propiedad estática?
En el paquete Entrenamiento
https://github.com/smorcor744/DragonPoke/blob/75b789781d636461ff63a9e4df1631e192366507/src/main/kotlin/Entrenamiento/Entrenador.kt#L16-L19
y tambien para que cuando entre en la casa para que se cure
https://github.com/smorcor744/DragonPoke/blob/75b789781d636461ff63a9e4df1631e192366507/src/main/kotlin/Mapas/Movimiento.kt#L28-L34
#### **Criterio global 3: Uso de entornos**
- **(2.i)**: ¿Cómo utilizaste el IDE para el desarrollo de tu proyecto? Describe el proceso de creación, compilación, y prueba de tu programa.
Pues el IDE me a ayudado bastante ya que durante el desarrollo de este me sirvio para arreglar que cuando el personaje se mueva se borre el @ en el que había estado y tambien me ayudo a lo hora de empaquetar el proyecto ya que me lo importaba solo y a la hora de cambiar cosas que tenia que hacerlo en todo el codigo poco a poco me lijero ese proceso el mandarme dirrectamente donde estaba el error

#### **Criterio global 4: Definir clases y su contenido**
- **(4.b, 4.c, 4.d, 4.g)**: Explica sobre un ejemplo de tu código, cómo definiste las clases en tu proyecto, es decir como identificaste las de propiedades, métodos y constructores y modificadores del control de acceso a métodos y propiedades, para representar al objeto del mundo real. ¿Cómo contribuyen estas clases a la solución del problema que tu aplicación aborda?
  Lo primero que hize fue un breve esquema de lo que quieria que hiciera mi proyecto y basandome en la ideal de la Isla hice los mapas, despues hice el movimiento del personaje donde hice la intanciacion del mapa Temporal que es el que aparece por pantalla y cambia en funcion de la fila y columna en el que esta el personaje y tambien le puse la propiedad de movimiento valido para que no se saliera del mapa despues tambien cree el teletrasporte para ayudarme a probar el codigo mejor aunque esta tiene algunos problemas, y tambien cree las funciones de entrenar y pelear para que cuando la posicion coincida con la de pelear o entrenar, pelease o entrenase el personaje y por ultimo obtimece el codigo creando metodos para que a la hora de cambiar de mapa no tener que repetir el mismo codigo tantas veces

#### **Criterio global 5: Herencia y uso de clases abstractas e interfaces**
- **(4.h, 4.j, 7.a, 7.b, 7.c)**: Describe sobre tu código cómo has implementado la herencia o utilizado interfaces en tu proyecto. ¿Por qué elegiste este enfoque y cómo beneficia a la estructura de tu aplicación? ¿De qué manera has utilizado los principios SOLID para mejorar el diseño de tu proyecto? ¿Mostrando tu código, contesta a qué principios has utilizado y qué beneficio has obtenido?
  Yo me decante más por el interfaz ya que para mi es mucho mejor utilizar este antes que una clase abstracta y basicamente lo utilize en entrenador para que dependiendo que quiera entrenar el usuario cambie las estadisticas que sube

#### **Criterio global 6: Diseño de jerarquía de clases**
- **(7.d, 7.e, 7.f, 7.g)**: Presenta la jerarquía de clases que diseñaste. ¿Cómo probaste y depuraste esta jerarquía para asegurar su correcto funcionamiento? ¿Qué tipo de herencia has utilizado: Especificación, Especialización, Extensión, Construcción?

#### **Criterio global 7: Librerías de clases**
- **(2.g, 4.k)**: Describe cualquier librería externa que hayas incorporado en tu proyecto. Explica cómo y por qué las elegiste, y cómo las incorporaste en tu proyecto. ¿Cómo extendió la funcionalidad de tu aplicación? Proporciona ejemplos específicos de su uso en tu proyecto.
  La unica que he utilizado a sido la de Ramdom ya que no se me ocurria utilizar otra
https://github.com/smorcor744/DragonPoke/blob/75b789781d636461ff63a9e4df1631e192366507/src/main/kotlin/Combates/Peleas.kt#L11
Y le he utilizado para que a la hora en la que el villano ataque que eliga un ataque random y si no lo puede realizar segun su raza lo falla
https://github.com/smorcor744/DragonPoke/blob/75b789781d636461ff63a9e4df1631e192366507/src/main/kotlin/Combates/Peleas.kt#L95-L100

#### **Criterio global 8: Documentado**
- **(7.h)**: Muestra ejemplos de cómo has documentado y comentado tu código. ¿Que herramientas has utilizado? ¿Cómo aseguras que tu documentación aporte valor para la comprensión, mantenimiento y depuración del código?
  Lo que he utilizado para documentarlo a sido chat gpt en donde primero le he dado un ejemplo para que me lo documento como yo quiero y despues lo he revisado para que no se equivoque
https://github.com/smorcor744/DragonPoke/blob/75b789781d636461ff63a9e4df1631e192366507/src/main/kotlin/Combates/Peleas.kt#L13-L18

#### **Criterio global 9: Genéricos**
- **(6.f)**: Muestra ejemplos de tu código sobre cómo has implementado una clase con genéricos. ¿Qué beneficio has obtenido?
  Lo que he echo a sido he creado la clase consola para que printe todos los mensajes que le venga pero no me a dado tiempo de implementarla en mi codigo
https://github.com/smorcor744/DragonPoke/blob/1e178e4f843a4933bf2aa67f5654ba15f6046d5b/src/main/kotlin/Consola.kt#L3-L9
