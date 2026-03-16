# Minilog with REST API + GraphQL, Dockerized

* 책에서는 Amazon Web Service 이용한 배포까지
* 여기서는 생략합니다 (oh my money)
* 홈서버 등에서 테스트해보는 것도 좋다: 나중에 문서화하기

## 주요 사항

* [Dockerfile](./Dockerfile)
  * Dockerize app
  * 베이스 이미지, 볼륨, 적용할 구성, 명령 등 정의
* Ok, but how can I build & run this?

```sh
# build하기
docker build -t minilog-graphql:latest .
# -t로 태그 부여 ("minilog-graphql:latest")
# 위치는 "." (여기 Dockerfile이 있으니)

# 이미지 잘 있니
docker images | grep minilog-graphql

# 돌리기
docker run -e SPRING_PROFILES_ACTIVE=dev --network="host" minilog-graphql
# -e SPRING_PROFILES_ACTIVE로 구동할 구성 환경변수로 명시
# --network="host" 호스트 PC의 네트워크 공유
```

## 차이점

* `application.properties` 대신 `application.yml`로 구성을 작성합니다.
  * 왜? 그냥... (이 쪽이 조금 더 세련된 표현법이 아닐까?)
  * YAML 파일 작성 시에는 구성이 나뉘는 것에 유의해서 작성하기
  * 적용되는 세부 구성(e.g. application-dev.yml)에서 정의하지 않은 구성은 기본(application.yml)으로 fallback됨
* 베이스 이미지 변경
  * `opendjk:21-jdk-slim`이 이제 Docker Hub에 없는 모양 (내가 못 찾았나...?)
  * `eclipse-temurin:21`로 변경 (Temurin JDK를 사용하는 이미지)
    * [참고: Temurin 웹페이지](https://adoptium.net/temurin)


## 주의점

* 오타 (`graphql` 대신 `graphiql` 적는 경우 등)
* 뭐가 잘 안 되니?
  * 잘못 적용한 docker build 가 계속 도는 것 같을 때: prune build
* DB가 돌고 있어야 작동합니다
  * AWS 사용하는 경우: Amazon RDS 설정을 YAML에 주입하기
  * AWS를 사용하지 않는 경우: 기존에 하던 것처럼? DB Docker Image 사용하기
* [기타 사항들은 여기 참조](../docs/)

