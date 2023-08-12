
<h1 align="center">Proyecto de Automatización Demo QA </h1>

<div align="center">


[![License](https://img.shields.io/badge/license-MIT-blue.svg)](/LICENSE)

</div>

---

<p align="center">Este repositorio contiene un proyecto de automatización de pruebas.
    <br> 
</p>

## 📝 Table of Contents

- [Introducción](#introduccion)
- [Comencemos](#comencemos)
- [Requisitos](#requisitos)
- [Configuración del Proyecto](#configuracion)
- [Ejecución de los test](#ejecucion_test)
- [Navegadores Web](#navegadores_web)
- [Detalles Generales De La Implementación](#detalles_generales_implementación)
- [Autores](#autores)


## 🧐 Introducción <a name = "introduccion"></a>

Este proyecto contiene pruebas automatizadas utilizando Cucumber con Java como lenguaje de programación. Cucumber es una herramienta de automatización de pruebas que permite escribir pruebas en un lenguaje natural y es ampliamente utilizada en el desarrollo de software basado en comportamiento (BDD, por sus siglas en inglés).

## 🏁 Comencemos <a name = "comencemos"></a>

A continuación, se detallan las instrucciones que le permitirán obtener una copia funcional del proyecto en su máquina local, con el propósito de desarrollo y pruebas.

### 📋 Requisitos <a name = "requisitos"></a>

A continuación, se describen los requisitos necesarios para instalar el software, así como los pasos para llevar a cabo la instalación de manera efectiva.

```
Java JDK 8 o superior
Maven
Cucumber 7.11.2
JUnit version 5.9.2
```

### 🛠️🔩Configuración del Proyecto <a name = "configuracion"></a>

 pasos detallados para la configuración de un entorno de desarrollo: 
- Clonar este repositorio en su máquina local.
- Abra el proyecto en su entorno de desarrollo preferido (por ejemplo, IntelliJ IDEA o Eclipse).
- Verifique que tenga las dependencias necesarias en el archivo pom.xml del proyecto. Si falta alguna, asegúrese de agregarla.
- Ejecute el siguiente comando para compilar el proyecto y descargar las dependencias de Maven:

```
mvn clean compile
```
## 🚧⚒️ Ejecución de los test <a name="ejecucion_test"></a> 
- Para compilar el proyecto se debe ejecutar el comando:
```
mvn test
```
## 🌐 Navegadores Web <a name="navegadores_web"></a>
La automatización actualmente se ejecuta en los siguientes navegadores
- Google Chrome Version 115 o superior

## 💻 Detalles Generales De La Implementación <a name="detalles_generales_implementación"></a>
Los escenarios de pruebas se crean en el feature con lenguaje Gherkin, se conectan con un método de las clases StepDefinitions con la ayuda de anotaciones @Given, @When y @Then, los métodos de la definición de los pasos se conectan con clases tipo Task para el Given y el When, donde se realizan las acciones de alto nivel y desde las cuales se pueden invocar clases tipo Interactions en las cuales se realizan acciones de bajo nivel, pero para el Then se comunica con clases tipo Questions para hacer las validaciones.
🚧 **_La estructura completa del proyecto se verá así:_**

```bash
   📦fitlearning([FitlearningAutomation])
   ┣ 📂src
   ┃ ┣ 📂test
   ┃ ┃ ┣ 📂java
   ┃ ┃ ┃ ┣ 📂Data
   ┃ ┃ ┃ ┣ 📂Driver 
   ┃ ┃ ┃ ┣ 📂Models
   ┃ ┃ ┃ ┣ 📂Object
   ┃ ┃ ┃ ┣ 📂Steps 
   ┃ ┃ ┃ ┗ 📦RunnersTest 
   ┃ ┣ 📂test
   ┃ ┃ ┣ 📂resources
   ┃ ┃ ┃ ┗ 📂features 
   ┃ ┃ ┃ ┗ 📂org  
   ┣ 📂target
   ┣ 📜.gitignore
   ┣ 📜pom.xml
   ┣ 📜README.md
```
```src/test/java/data```: Esta carpeta contiene las clases que definen los objetos de datos que se utilizan en las pruebas. Estos objetos se utilizan para proporcionar datos de entrada a las pruebas y verificar los resultados de las mismas.

```src/test/java/Driver```: Esta carpeta contiene las clases que manejan la configuración y creación de instancias de los controladores de navegadores web (por ejemplo, Selenium WebDriver) utilizados en la automatización.

```src/test/java/models```: Esta carpeta contiene las clases que definen los modelos de objetos de la aplicación bajo prueba.

```src/test/java/Objetc```: Esta carpeta contiene las clases que representan los objetos de la interfaz de usuario (UI) de la aplicación web bajo prueba. Estas clases se utilizan para interactuar con los elementos de la UI de la aplicación web y hacer verificaciones en ellos.

```src/test/java/Steps```: Esta carpeta contiene las clases que definen los pasos de las pruebas escritas en lenguaje natural utilizando el formato de Cucumber Gherkin. Los pasos definidos aquí son los que se ejecutarán durante la ejecución de las pruebas.

```src/test/resources/features```: Esta carpeta contiene los archivos de características escritos en el formato de Cucumber Gherkin. Estos archivos describen los escenarios de prueba y los pasos correspondientes que se ejecutan durante las pruebas.

End with an example of getting some data out of the system or using it for a little demo.

## 🎈 Test <a name="test"></a>

Los escenarios de prueba se crean en el archivo de características utilizando el lenguaje Gherkin. Se conectan a un método en las clases de StepDefinitions utilizando anotaciones como @Given, @When y @Then. Los métodos de definición de pasos están conectados a clases de Tareas (Task) para los pasos Given y When, donde se realizan acciones de alto nivel. Estas clases de Tareas pueden invocar clases de Interacciones (Interactions) para acciones de bajo nivel. Para el paso Then, se comunica con clases de Preguntas (Question) para realizar validaciones.


## ⛏️ Construido con <a name = "Construido_con"></a>

- [Cucumber](https://cucumber.io/docs/installation/javascript/) - framework 
- [Selenium](https://www.selenium.dev/) -  Framework
- [Java](https://www.java.com/) - Technology

## ✍️ Autores <a name = "autores"></a>

- [@Guerra](https://github.com/6uerra) 