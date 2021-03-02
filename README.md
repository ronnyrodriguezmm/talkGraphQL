# talkGraphQL
Charla - Introducción a graphql con spring boot

## Para probar el servidor
```sh
 curl -XPOST -H 'Content-Type: application/json' -d '{"query":"query {post:recentPosts(count:1, offset:0) {title}}"}' http://localhost:8080/graphql
 ```

## Explorar el servidor, y construir consultas, y suscripciones:

```
http://localhost:8080/graphiql
```