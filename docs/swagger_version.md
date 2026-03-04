# Swagger UI 버전 설정

* 현재 Spring Boot 3.5.11 사용 중
  * (어차피 이전 버전으로는 받아지지도 않는다)
* Swagger-UI 버전이 불일치하면...
  * `NoSuchMethodError` (`ControllerAdviceBean.init`) 발생
  * 버전을 맞춰주자

```build.gradle
dependencies {
    // ...
    implementation 'org.springdoc:springdoc-openapi-starter-webmvc-ui:2.8.9'

    }
```
