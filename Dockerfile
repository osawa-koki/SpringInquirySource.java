FROM openjdk:11
EXPOSE 80
COPY . /work
WORKDIR /work
RUN chmod +x ./gradlew
RUN ./gradlew build
RUN mv /work/build/libs/WebInquiryStarter.jar /work/app.jar
ENTRYPOINT ["java", "-jar", "/work/app.jar"]
