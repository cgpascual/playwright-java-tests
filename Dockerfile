FROM mcr.microsoft.com/playwright/java:v1.52.0-jammy

WORKDIR /tests

COPY pom.xml .
COPY src ./src

RUN mvn dependency:go-offline

ENV TEST_GROUP=""

CMD ["sh", "-c", "if [ -z \"$TEST_GROUP\" ]; then mvn test -Dheadless=true; else mvn test -Dheadless=true -Dgroups=$TEST_GROUP; fi"]