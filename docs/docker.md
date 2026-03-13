# Issues about Docker

## Docker test is failing...

* Docker가 root 권한을 요구하기 때문에
* rootless Docker를 사용하자
* 혹은 사용자를 docker 그룹에 추가하는 방법도 있다 (추천 X)

## Docker Image

* `application.properties`와 `application.yml`을 환경에 따라 나누어 적용할 때 문법에 유의하자
* 사소한 실수: `spring.profiles` 대신 `spring.profile`이라고 적는 등...
* build 시의 `--no-cache` 옵션
* 잦은 build로 인한 공간 낭비: `prune`하기

