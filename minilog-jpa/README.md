# 

## Objectives 목표

* Entities 엔티티

* User:
  * users에 매핑하기
  * Auditing 감사 사용하기
    * 데이터 생성, 삭제시점 추적
  * Article과 적절히 참조 설정하기
    * 1-M
    * Cascade
    * Lazy fetch


## Repositories 리포

* `UserRepository`
* `ArticleRepository`
  * `findAllByAuthorId`
  * `findAllByFollowerId`: JPQL 사용
* `FollowRepository`
