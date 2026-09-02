# PP_TP1_legajo 53185

Trabajo Práctico N°1 - Programación Orientada a Objetos en Java
Unidad 1 - Fundamentos de la POO e implementación básica en Java
UTN - FRM - Paradigmas de Programación



## Estructura del proyecto

El código está organizado en un solo proyecto (IntelliJ), con **un paquete por ejercicio**
para poder ver la evolución del modelo sin romper lo ya entregado:

```
src/
├── ejercicio1/
│   ├── EventoUniversitario.java
│   └── App.java
├── ejercicio2/
│   ├── EventoUniversitario.java
│   ├── Sala.java
│   ├── Actividad.java
│   ├── Estudiante.java
│   ├── Inscripcion.java
│   └── App.java
├── ejercicio3/
│   ├── EventoUniversitario.java
│   ├── Sala.java
│   ├── Actividad.java   (ahora abstracta)
│   ├── Charla.java
│   ├── Taller.java
│   ├── Estudiante.java
│   ├── Inscripcion.java
│   └── App.java
└── ejercicio4/
    └── App4.java        (reutiliza las clases de ejercicio3)
```

Cada `App.java` es un `main` independiente y ejecutable, correspondiente al resultado
esperado de cada ejercicio.

## Ejercicio 1

Clase `EventoUniversitario` aislada (sin relaciones), con constructor normal y
constructor de copia, contador estático de eventos (`cantidadEventos`) y
`calcularCostoEstimado()` simple (0 si es gratuito, `costoBase` en caso contrario).

En este ejercicio **no se implementan `asignarSala` ni `crearActividad`**, ya que
el propio enunciado aclara que todavía "no se necesita... vincularlos a otro tipo
de entidades" — esas relaciones recién se agregan en el Ejercicio 2.

## Ejercicio 2

Se incorporan las clases `Sala`, `Actividad`, `Estudiante` e `Inscripcion`:

- **Agregación**: `EventoUniversitario` tiene una `Sala` que existe independientemente
  del evento (asignada con `asignarSala`).
- **Composición**: `EventoUniversitario` compone una lista de `Actividad`
  (creadas con `crearActividad`, no existen fuera del evento).
- **Asociación**: `Actividad` inscribe `Estudiante`s generando objetos `Inscripcion`,
  que a su vez referencian tanto a la actividad como al estudiante.

## Ejercicio 3

`Actividad` pasa a ser **abstracta** (con método final `mostrarIdentificacion()`
y métodos abstractos `calcularCostoMateriales()` y `getTipo()`), y se agregan las
subclases concretas `Charla` (gratuita) y `Taller` ($5000 con notebook / $2000 sin
notebook).

`crearActividad(id, titulo, cupo, tipo, detalle)` recibe el tipo como `String`
("Charla" o "Taller") y un parámetro adicional `Object detalle`:
- Para "Charla": un `String` con el disertante.
- Para "Taller": un `Boolean` que indica si requiere notebook.

`calcularCostoEstimado()` del evento: si es gratuito, 0. Si no, `(costoBase + suma
de costoMateriales de sus actividades) * 1.21`.

`mostrarDatos()` recorre las actividades llamando a `mostrarIdentificacion()` de
forma **polimórfica** (cada subclase resuelve `getTipo()` a su manera).

## Ejercicio 4

`App4` reutiliza el modelo del Ejercicio 3 con el escenario exacto pedido:
3 estudiantes, 1 evento, 1 sala, 2 actividades (una Charla y un Taller), 2
estudiantes inscriptos en la Charla y 2 en el Taller.

El mapa de memoria de esa ejecución está en `mapa_memoria.svg`, y muestra:
- Variables locales del `main` (stack) y objetos en el heap.
- La agregación Evento→Sala.
- La composición Evento→Actividades.
- La herencia Actividad→Charla/Taller.
- Las referencias de cada `Inscripcion` hacia su `Actividad` y su `Estudiante`.


