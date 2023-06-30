FROM openjdk:17-jdk
WORKDIR /app
COPY . /app
RUN javac src/ValidData.java src/DateValidCheck.java src/People.java src/Main.java
CMD ["java", "-cp", "src", "Main", "Чайкин Георгий Максимович 01.05.2023"]
