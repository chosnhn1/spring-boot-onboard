# 책이 하지 않은 것들

## 몇 가지 변경점들

* IDE로 VS Code 사용
  * Spring Boot Extension
  * Java Extension
  * Gradle Extension
* Spring Boot 3.5.11 기반
* 버전에 따른 의존성 변경
  * GraphQL 도입에 kickstart(deprecated) 대신 Spring for GraphQL 사용
* `application.properties` 대신 `application.yml` 사용

## 몇 가지 변경하고 싶었던? 점들

* 용도 기반 packaging
  * 클래스명에서 클래스 역할을 유추할 수 있는데 굳이 패키지명까지...?
  * 앱 규모에 비해 패키지가 너무 많다 (물론 확장성이 있지만)
  * 도메인 기반으로의 변경 -> Article, Authentication, ...
  * 사실 애매하다 (정답은 없을지도...)
* 테스트 코드 의존성 변경
  * Mock is deprecated: Mockito 사용으로 변경하면 좋을 것

