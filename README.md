# n26_Challenge
Code​ ​Challenge We​ ​would​ ​like​ ​to​ ​have​ ​a​ ​restful​ ​API​ ​for​ ​our​ ​statistics.​ ​The​ ​main​ ​use​ ​case​ ​for​ ​our​ ​API​ ​is​ ​to calculate​ ​realtime​ ​statistic​ ​from​ ​the​ ​last​ ​60​ ​seconds.​ ​There​ ​will​ ​be​ ​two​ ​APIs,​ ​one​ ​of​ ​them​ ​is called​ ​every​ ​time​ ​a​ ​transaction​ ​is​ ​made.​ ​It​ ​is​ ​also​ ​the​ ​sole​ ​input​ ​of​ ​this​ ​rest​ ​API.​ ​The​ ​other​ ​one returns​ ​the​ ​statistic​ ​based​ ​of​ ​the​ ​transactions​ ​of​ ​the​ ​last​ ​60​ ​seconds

Requirements For​ ​the​ ​rest​ ​api,​ ​the​ ​biggest​ ​and​ ​maybe​ ​hardest​ ​requirement​ ​is​ ​to​ ​make​ ​the​​ ​​GET​ ​/statistics execute​ ​in​ ​constant​ ​time​ ​and​ ​space.​ ​The​ ​best​ ​solution​ ​would​ ​be​ ​O(1).​ ​It​ ​is​ ​very​ ​recommended​ ​to tackle​ ​the​ ​O(1)​ ​requirement​ ​as​ ​the​ ​last​ ​thing​ ​to​ ​do​ ​as​ ​it​ ​is​ ​not​ ​the​ ​only​ ​thing​ ​which​ ​will​ ​be​ ​rated​ ​in the​ ​code​ ​challenge. 
 
Other​ ​requirements,​ ​which​ ​are​ ​obvious,​ ​but​ ​also​ ​listed​ ​here​ ​explicitly: 
 
● The​ ​API​ ​have​ ​to​ ​be​ ​threadsafe​ ​with​ ​concurrent​ ​requests ● The​ ​API​ ​have​ ​to​ ​function​ ​properly,​ ​with​ ​proper​ ​result 

● The​ ​project​ ​should​ ​be​ ​buildable,​ ​and​ ​tests​ ​should​ ​also​ ​complete​ ​successfully.​ ​e.g.​ ​If maven​ ​is​ ​used,​ ​then​ ​mvn​ ​clean​ ​install​ ​should​ ​complete​ ​successfully.

● The API should be able to deal with time discrepancy, which means, at any point of time, we​ ​could​ ​receive​ ​a​ ​transaction​ ​which​ ​have​ ​a​ ​timestamp​ ​of​ ​the​ ​past ● Make​ ​sure​ ​to​ ​send​ ​the​ ​case​ ​in​ ​memory​ ​solution​ ​without​ ​database​ ​(including​ ​in-memory database) 

● Endpoints​ ​have​ ​to​ ​execute​ ​in​ ​constant​ ​time​ ​and​ ​memory​ ​(O(1))

● Please​ ​complete​ ​the​ ​challenge​ ​using​ ​Java 

# Technologies used in this project

Spring Boot,

Spring MVC, 

Jpring Data,

JPA,

Junit,

ConcurrentMap to storege,

Swagger for the documentation,

Maven,

Java 8

# To run the application
Maven update project, clean install spring-boot:run
To test the endpoints, Please refere to http://localhost:8080/swagger-ui.html there will be a swagger file descriping the endpoints.
