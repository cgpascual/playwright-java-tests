FROM mcr.microsoft.com/playwright/java:v1.52.0-jammy

WORKDIR /tests

COPY pom.xml .
COPY src ./src

RUN mvn dependency:go-offline

CMD ["mvn", "test", "-Dheadless=true"]