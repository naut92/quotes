Project requirements:

* source code should be published on https://github.com/
* Docker image should be published on https://hub.docker.com/
* a working app should be deployed and be publicly available on https://www.heroku.com/
* use any in-memory database (Derby, H2, SQLite)
* use Java and Spring Boot

The API should allow:

* creation of a user account
* addition, view, modification, and deletion of quotes.
* voting on quotes (either upvote or downvote).
* view of the top 10 quotes, the details of each quote, and ideally a graph of the evolution of the votes over time.


swagger2 doc:
http://localhost:8081/swagger-ui/index.html

Docker image:

./gradlew build

docker build --build-arg JAR_FILE=build/libs/\*.jar -t quotes/quotes-docker .

docker-compose up
docker-compose down
