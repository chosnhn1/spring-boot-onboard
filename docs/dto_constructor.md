# DTO 생성자 문제

* 요청을 했을 때 `constructor threw Exception` 에러 발생
* 갖가지 문제를 찾아봤는데... 해결
* 이유: Controller에서 `@RequestBody`를 잘못 갖고왔다 (Spring MVC가 아니라 Swagger 걸 갖고 오다니...)

* 그래도 배운 것
* DTO 작성의 요지 (기본 생성자, Java 17+의 `record` 등)

# 그래도 에러가 나길래...

* 이번에는 User 생성 시에 `created_at`에 `null`을 넣는 문제 (?)
* 해결: 주 Application 클래스에 `@EnableJpaAuditing`을 넣어야 한다
* Auditing 작동에 대해 자세히 살피기

# 거의 다 왔는데 글을 못 쓴다

* 해결: DTO 더이상 쓰지 않는(@Deprecated) @NonNull AuthorId에 걸렸다
* 찾아보니 @NonNull을 지우는데 나는 지우지 않았다
* @Deprecated를 표기하더라도 @NonNull은 적용된다...

* 이제 진짜 잘 된다 (phew)

## 여전히 해야 할 일...?

* too much deprecated methods in JWT token process
* 어떻게 하면 현대화할 수 있을까

