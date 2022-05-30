### 기존의 REST API에서의 문제점

* over-fetching
    * 데이터베이스에서 사용하지 않는 데이터까지 불러오는 문제
* under-fetching
    * 한 페이지를 완성하려면 많은 API 요청을 하게됨

### graphql
* 여러 url이 존재하지 않음

```
query {
    board {
        title,
        content
    }
    notification {
        count
    }
}
```
=> 이러한 방식으로 요청

graphql 테스트 해볼 수 있는 사이트
https://graphql.org/swapi-graphql

### 예시
type Query {
  Tweet {
    title,
    content,
    author
  }
  allTweet: [Tweet]!
}

type Mutation {
  postTweet(text: String!, userId?: ID!): Tweet!
  deleteTweet(id: ID): Boolean!
  putTweet(text:String! id: ID!): Tweet!
}

**함수처럼 만들어서 사용가능**

* 파라미터가 필요하다면 무조건 root가 오고 args가 와야함
const resolver = {
  Query: {
    tweet(root, {id}) {
      console.log(id)
    },
    ping() {return "pong"}
  },
  Mutation: {
    postTweet(_, {text, userId}) {
      ...
    }
  },
  User: { fullName() {} },
  Tweet: { author({userId}) { db 조회 } }
}

* 실제 데이터에 fullName 이 없다고 해도 resolver에 fullName을 실행시켜줌
* resolver에 tweet을 찾으면서 author가 있으면 resolver의 author()를 호출해서 찾음