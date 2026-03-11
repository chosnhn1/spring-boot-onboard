# GraphQL 문제

* build fail....

* com.graphql-java-kickstart가 deprecated되었다고 한다
* ("Spring for GraphQL"로 Spring이 공식 지원)
* 그럼 어떻게 설정을 바꾸어야 할까!

## 해법

* 의존성이 문제가 아니었다
* `schema.graphqls` 파일의 오타
  * `type FollowResponse`라고 적을걸 `type followResponse`라고 소문자로 적었네
  * 에러를 어떻게 읽었어야 했나?
  * Gradle의 `Caused by` 스택의 앞에서 읽지말고 뒤에서 읽었어야 했다 (마지막 Cause by 스택이 `type Mutation`에서 `field type FollowReseponse`를 찾지 못했다고 친절하게 알려주고 있었다


