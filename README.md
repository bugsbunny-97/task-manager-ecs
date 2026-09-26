# task-manager-ecs

Small Spring Boot app for managing tasks. This README explains how to run the app locally using an in-memory H2 database for testing and how to access the H2 console.

Prerequisites
- Java 17
- Maven

Run locally (H2 in-memory)
1. Start the app with the `local` profile so the H2 console and in-memory DB are enabled:

   mvn spring-boot:run -Dspring-boot.run.profiles=local

2. Open the H2 console in your browser:

   http://localhost:8080/h2-console

   JDBC URL: jdbc:h2:mem:taskdb
   User: sa
   Password: (leave empty)

Notes and troubleshooting
- The in-memory H2 database exists only while the app runs. Restarting the app resets data.
- If you see Spring Boot's Whitelabel Error Page at /h2-console, verify the app is running with the `local` profile and that `spring.h2.console.enabled=true` is present in `src/main/resources/application-local.properties`.
- If Spring Security blocks the console, permit `/h2-console/**` and disable frameOptions in a development security config (see commit history or ask for a patch if you want this added).
- Hibernate auto DDL is configured with `spring.jpa.hibernate.ddl-auto=update` for local testing; entity IDs must use a numeric type for GenerationType.IDENTITY.

Files changed for local H2 support
- pom.xml: added H2 runtime dependency
- src/main/resources/application-local.properties: H2 + JPA settings

Need a security config to allow the H2 console or a README update? Reply and I'll add it.