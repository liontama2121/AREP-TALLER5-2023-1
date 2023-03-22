# Aplicación distribuida segura en todos sus frentes


Desarrolle una aplicación Web segura con los siguientes requerimientos:

1. Debe permitir un acceso seguro desde el browser a la aplicación. Es decir debe garantizar autenticación, autorización e integridad de usuarios.
2. Debe tener al menos dos computadores comunicacndose entre ellos y el acceso de servicios remotos debe garantizar: autenticación, autorización e integridad entre los servicios. Nadie puede invocar los servicios si no está autorizado.

3. Explique como escalaría su arquitectura de seguridad para incorporar nuevos servicios.

## Entregables:

1. Código en github, bien documentado.
2. Informe que describe la arquitectura de seguridad de su prototipo. (en el README)
3. Video de experimento en AWS


## Ayudas:

https://github.com/tipsy/spark-ssl

https://www.baeldung.com/spring-boot-https-self-signed-certificate

https://docs.oracle.com/cd/E19798-01/821-1841/gjrgy/

https://docs.oracle.com/cd/E19509-01/820-3503/ggfen/index.html

https://aws.amazon.com/es/serverless/build-a-web-app/


## Arquitectura propuesta

<img src="./resources/images/01-Arquitectura.jpg" />


## **Prerrequisitos**

-   [Git](https://git-scm.com/downloads) - Sistema de control de versiones
-   [Maven](https://maven.apache.org/download.cgi) - Gestor de dependencias
-   [Java 8](https://www.java.com/download/ie_manual.jsp) - Entorno de desarrollo
-   [Intellij Idea](https://www.jetbrains.com/es-es/idea/download/) (Opcional)

## Configuracion ralizada para los certificados


Para la generacion de certificados, se utilizo la siguiente contraseña
```java
public class Password {
    public static String keyStorePassword = "123456";
}
```

1. Se creo una carpeta llamada keystores en la raiz del proyecto
2. Se genero un certificado digital con el siguiente comando

    ```
    keytool -genkeypair -alias ecikeypair -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore ecikeystore.p12 -validity 3650
    ```
   Se debe de llenar con la siguiente informacion( de manera local)
   ```
   localhost-> aqui debe ir el nombre del servidor
   AREP
   ECI
   Bogota
   Bogota D.C.
   CO
   yes
   ```
   
  

    
## **Instrucciones de ejecución local**

Desde cmd clonar el repositorio

    ```git
    https://github.com/liontama2121/AREP-TALLER5-2023-1
    ```

Ahora procederemos a iniciar el servidor HelloServer

```
java -cp "target/classes;target/dependency/*" co.edu.escuelaing.sparkdockerdemolive.SparkWebServer
```
Ejecutamos el proyecto
```maven
mvn exec:java -Dexec.mainClass="eco.edu.escuelaing.sparkdockerdemolive.App"
```
Una vez tengamos el proyecto en ejecucion, desde nuestro navegador colocaremos la ruta
```
https://localhost:5000/
```

y nos saldra la siguiente ventana

<img src="./resources/images/05-Login.jpg" alt="login" />

Cabe recalcar que el login solo detectara los siguientes usuarios
```java
private static void generateUsers() {
 users.put("juank", hasher.hash("juan133812"));
        users.put("leon", hasher.hash("solopola"));
        users.put("jorge", hasher.hash("srcode"));
        users.put("test", hasher.hash("test"));}```

## Usuarios no autenticados o no existentes

<img src="./resources/images/6-usuario-no-existente.jpg" alt="badRequest" />

<br />


<img src="./resources/images/06-usuario-no-existente-2.jpg" alt="badRequest-2" />


## Usuarios existentes y autenticados

<img src="./resources/images/07-usuario-existente.jpg" alt="goodRequest" />

<br />

<img src="./resources/images/07-usuario-existente-2.jpg" alt="goodRequest-2" />

# Instancias AWS:

#Maquina1

ec2-3-94-29-8.compute-1.amazonaws.com

#Maquina2

 ec2-100-24-123-218.compute-1.amazonaws.com

### Autor
- juan Camilo Molina 



