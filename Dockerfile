FROM openjdk:8
VOLUME /tmp
ADD ./target/socialweb-usuarios-0.0.1-SNAPSHOT.jar socialweb-usuarios.jar
ENTRYPOINT ["java","-jar","/socialweb-usuarios.jar"]