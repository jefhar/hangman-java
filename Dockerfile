FROM openjdk:12
COPY ./out/production/Hangman/ /tmp/
COPY ./words /tmp/words
WORKDIR /tmp
ENTRYPOINT ["java", "Hangman"]
