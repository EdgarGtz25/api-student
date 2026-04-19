Backend - App Student (Spring Boot)
📌 Descripción

API REST desarrollada en Spring Boot para la gestión académica de:

👨‍🎓 Estudiantes
🧑‍🏫 Asesores
📘 Materias
🔐 Autenticación básica

El sistema implementa arquitectura en capas (Controller → Service → Repository) y uso de DTOs para desacoplar la lógica de negocio.

🧰 Tecnologías
Java 21
Spring Boot 3
Spring Data JPA
Spring Security
Hibernate
H2 Database (dev)
Lombok
⚙️ Requisitos
Java 21
Maven 3+
🔧 Instalación
1. Clonar repositorio
git clone https://github.com/EdgarGtz25/app-student.git
cd app-student
2. Compilar proyecto
mvn clean install
3. Ejecutar aplicación
mvn spring-boot:run

o

java -jar target/students-0.0.1-SNAPSHOT.jar
🌐 Acceso
http://localhost:8080
🗄 Base de datos (H2)
Consola:
http://localhost:8080/h2-console
Configuración:
JDBC URL: jdbc:h2:mem:testdb
User: sa
Password: (vacío)
