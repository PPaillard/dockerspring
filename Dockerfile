# Sur quelle image on se base
FROM maven:3.8.5-jdk-11 as maven
# on definir le repertoire de travail
WORKDIR /app
# On copie le repertoire local vers le repertoire de travail
COPY . .
# on compile le projet
RUN mvn clean package -Dmaven.test.skip=true
# Quand on lancera l'image (conteneur) on execute spring-boot:run
CMD mvn spring-boot:run
