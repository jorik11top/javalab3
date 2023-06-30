FROM adoptopenjdk:17-jdk
WORKDIR /app
COPY ./*.class /app/
CMD ["java", "Main"]