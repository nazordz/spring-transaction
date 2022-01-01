# Spring boot Transactional + flyway migration + Scheduler

## Run the migration
```sh
./mvnw flyway:migrate -Dflyway.configFiles=myFlywayConfig.conf
```

## Run in development server
```sh
./mvnw spring-boot:run
```