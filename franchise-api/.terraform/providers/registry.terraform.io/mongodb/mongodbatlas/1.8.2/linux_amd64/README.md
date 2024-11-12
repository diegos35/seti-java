# Proyecto de Infraestructura con MongoDB Atlas y Terraform

Este proyecto es una aplicación Spring Boot que proporciona una API para gestionar franquicias, sucursales y productos. Incluye funcionalidades para obtener el producto con mayor stock para cada sucursal de una franquicia específica.
Este proyecto utiliza **Terraform** para gestionar la infraestructura en MongoDB Atlas y **Docker** para desplegar servicios asociados. A continuación, se proporcionan las instrucciones detalladas para instalar las dependencias necesarias, configurar los entornos y ejecutar los contenedores Docker y las configuraciones de Terraform.

## Requisitos
- Java 17
- Maven
- Docker
- Terraform
- Cuenta de MongoDB Atlas

Antes de comenzar, asegúrate de tener instalados los siguientes programas en tu sistema:

- **[Terraform](https://www.terraform.io/downloads.html)**: Herramienta de infraestructura como código para gestionar recursos de nube.
- **[Docker](https://www.docker.com/get-started)**: Plataforma para desarrollar, enviar y ejecutar aplicaciones en contenedores.
- **[MongoDB Atlas Account](https://www.mongodb.com/cloud/atlas)**: Necesitarás una cuenta en MongoDB Atlas y obtener las claves de API para interactuar con su servicio.
- **[Git](https://git-scm.com/)**: Para clonar este repositorio y manejar el código fuente.

## Instalación

### 1. Clonar el repositorio

Primero, clona el repositorio en tu máquina local:

    ```bash
    git clone https://github.com/diegos35/seti-java.git 
    cd tu-repositorio

### 2. Instalar dependencias
     ```bash
     mvn clean package

### Crear arhivo .env para las variables para el mongo atlas
MONGO_URI=
MONGO_DB=


### 4. Correr Aplicación
    ```bash
    mvn spring-boot:run

### Docker
        ```bash
        docker build -t franchise-api .

### Corre Docker
    ```bash
        docker run -p 8080:8080 franchise-api
### para corre terraform 
    Inicializar Terraform:  
    terraform init
    Aplicar la configuración de Terraform:  
    terraform apply



Licencia
Este proyecto está licenciado bajo la Licencia MIT.