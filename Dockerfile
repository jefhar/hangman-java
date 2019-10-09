FROM adoptopenjdk/openjdk13:jdk-13_33-alpine-slim
COPY ./out/production/Hangman/ /tmp/
COPY ./words /tmp/words
WORKDIR /tmp
ENTRYPOINT ["java", "us.jeffharris.hangman.Hangman"]
