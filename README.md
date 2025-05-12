[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/BAFVM91p)
# Taller 4 - Creación de programas usando estructuras de control selectivas y repetitivas

## Diseño orientado a objetos (DOO) aplicando estructuras de control

* Leer detenidamente cada problemática propuesta.
* Usar el programa **DIA-UML** _(Open source)_ para generar la representación de su solución _(modelado)_, vía diagramas de clases.
* Para cada diagrama/solución _(modelado de su solución)_, genere/agregue 2 archivos _(fuente e img: \*.dia y \*.png \*.jpeg, etc)_. No olvide titular a cada clase, con el nombre representativo del análisis/solución. Para el nombre de cada archivo use el formato: _Problema-NroProbl_NombClase_. Ejemplo **Problema-1_Trabajador**. Todos estos archivos agréguelos en el subDirectorio: **Modelos_UML**
* En el subDirectorio **Solucion_Codigo** cree un único proyecto NetBeans - _Java Aplication_ (o con el IDE de su preferencia) y en él, agregue todas las clases necesarias para la solución de cada problema _(no use paquetes aún)_. Y para facilitar la revisión, utilice para la clase base el formato _Problema-NroProbl_NombClaseBase_, y para la clase de prueba/ejecutor use _Problema-NroProbl_NombClaseEjecutor_ (Ésta última es la clase de prueba que genera/instancia con objetos cada entidad/clase y verifica su funcionalidad). 
* Respete la arquitectura **MVC**, es decir, no implemente entradas/salidas desde/hacia teclado-consola directamente en la clase base. Los datos de entrada y resultados deben ser ingresados/mostrados desde/hacia teclado-consola, en la clase de prueba/ejecutor.
* Para retornar los datos del objeto, usar el método _**toString()**_, vía cadena con formato legible. 

___


## Problema 1 - Aplicación de _if()_

Desarrolla un programa que automatice la venta de **_X_** producto. El programa debe permitir al usuario ingresar el precio de un producto y determinar el descuento aplicable según las siguientes reglas:

* Si el precio del producto es mayor o igual a $1000, y el número de productos al menos 10, se aplica un descuento del 10%.
* Si el precio del producto es menor a $1000, se aplica un descuento del 5%, independientemente del número de productos.

Una vez determinado el descuento, el programa debe calcular y mostrar el precio final la la compra después de aplicar el descuento.

El programa debe implementar una clase respectiva base que contenga al menos los métodos:

* Un método llamado "**calcularDescuento**" que tome como parámetro el precio y número de productos y devuelva el descuento correspondiente.
* Un método llamado "**calcularPrecioFinal**" que devuelva el precio final después de aplicar el descuento.

Además, el programa debe solicitar al usuario ingresar el precio y número de productos y utilizar los métodos de la clase para calcular y mostrar el descuento aplicado y el precio final. No olvide que la clase de prueba (que contiene el método main), es quien realiza la gestión de ingreso de datos y/o visualización de resultados.

> [!Note]
> - Implemente los constructores y propiedades _**set(tipo arg)**_ y _**get()**_ unicamente necesarios/usados.

## Problema 2 - Aplicación de ciclos _for(), while(), do-while()_

Desarrolla un programa que permita gestionar una lista de empleados de una empresa y su nómina de pagos. El programa debe permitir al usuario realizar las siguientes acciones:

1.	Agregar un empleado: El usuario debe ingresar el nombre, el salario y la edad del empleado. El programa debe crear un objeto de la clase "Empleado" con esta información y agregarlo a la lista de empleados.
2.	Mostrar información de los empleados: El programa debe mostrar en pantalla la información de todos los empleados registrados, incluyendo su nombre, salario y edad.
3.	Calcular aumento de salario: El programa debe solicitar al usuario ingresar un porcentaje de aumento salarial. Luego, para cada empleado cuyo salario sea menor al salario promedio de todos los empleados, se debe aplicar el aumento correspondiente y mostrar en pantalla el nuevo salario.

La clase "Empleado" debe tener los siguientes atributos:
- Nombre: nombre del empleado (cadena de caracteres).
- Salario: salario del empleado (número decimal).
- Edad: edad del empleado (entero).

> [!Note]
> - Clase "Empleado" debe tener un método llamado "mostrarInformacion" (toString) que imprima en pantalla la información del empleado.

## Problema 3 - Autobús escolares

Un conductor de autobús escolar necesita un sistema sencillo que le permita verificar si los estudiantes tienen permitido subir al autobús, según su ruta y si están autorizados para ese día. El programa debe permitir registrar temporalmente una lista de estudiantes con su nombre, grado, y si tienen permiso vigente. Luego, debe simular el ingreso de estudiantes, indicando si pueden subir o no, y mostrando al final un resumen del total de estudiantes aceptados y rechazados.

Los requerimientos generales en resumen son los siguientes:

-	Registrar estudiantes con los datos requeridos.  
-	Simular el ingreso y verificar condiciones dadas. 
-	Mostrar un resumen con totales de aceptados y rechazados.

> [!Note]
> - No olvide formatear el _**toString()**_ para visualizar los resultados de manera personalizada, organizada, comprensible. 

## Problema 4 - Parque de diversiones

Un parque de diversiones necesita controlar la entrada de visitantes según su edad y altura. Solo pueden ingresar a ciertos juegos los visitantes que cumplen con las restricciones mínimas. El programa debe registrar a los visitantes e indicar a cuáles juegos pueden acceder. Al final, debe mostrar cuántos visitantes cumplieron con todos los requisitos.
Por tanto, los requerimientos generales son los siguientes:
-	Registrar al visitante con los datos de entreda necesarios.
-	Determinar si el visitante puede acceder al juegos de su elección.
-	Al final del día, se debe mostrar el resumen de cuántos cumplen con todas las condiciones.

> [!Note]
> - Para el **DOO** se sugiere modelar dos clases base, por ejemplo, Visitante y Parque, y finalmente el Ejecutor, que pruebe su funcionalidad. Nota: analice acertadamente la relación existen entre Visitante y Parque.
> - No olvide formatear el _**toString()**_ para visualizar los resultados de manera personalizada, organizada, comprensible. 

## Problema 5 - Gym

Un gimnasio desea implementar un sistema sencillo para registrar las rutinas de ejercicio de sus clientes. Cada cliente puede seleccionar entre diferentes tipos de ejercicios (cardio, fuerza, estiramiento), la duración de cada uno y si completó o no la rutina diaria. Al finalizar, el sistema debe mostrar cuántos clientes completaron su rutina y el tiempo promedio invertido.

Por tanto, los requerimientos generales son los siguientes:
-	Registrar nombre del cliente, tipo de ejercicio, duración y cumplimiento.
-	Calcular estadísticas básicas.
-	Mostrar resumen al finalizar: cuántos completaron su rutina y promedio de tiempo.

> [!Note]
> - Para el **DOO** se sugiere modelar dos clases base, por ejemplo, Cliente y Gimnasio, y finalmente el Ejecutor, que pruebe su funcionalidad. Nota: analice acertadamente la relación existen entre Cliente y Gimnasio.
> - No olvide formatear el _**toString()**_ para visualizar los resultados de manera personalizada, organizada, comprensible. 
