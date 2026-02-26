# JPA

## JPA Annotations

* `@Entity`: JPA Entity -> map to DB
* `@Id`: set primary key 
* `@GeneratedValue`: set generation strategies for primary key
  * `GenerationType.AUTO`: JPA가 해줘!
  * `GenerationType.IDENTITY`: DB가 해줘!
  * `GenerationType.SEQUENCE`: use sequence (usually in Oracle)
  * `GenerationType.TABLE`: 별도 키 테이블 생성
* `@Table`: 매핑 테이블 지정
  * 나의 경우: `User` 같은 이름 겹칠 때...
* `@Column`: map column 
* `@ManyToOne`, `@OneToMany`: 참조관계 설정 (`@JoinColumn`)
* `@OneToOne`, `@ManyToMany`: 참조관계 설정 (`@JoinTable`)
* `@JoinTable`: 참조 중간 테이블 설정

## Hibernate DDL-Auto options

`spring.jpa.hibernate.ddl-auto: update`

* `none`: 아무 DDL 작업 안 함 (production-like, most-safe) 
* `create`: 기존 테이블 전부 삭제, 엔티티 구조에 따라 새 테이블 생성 
* `create-drop`: create but 종료 시 모든 테이블 삭제 (for test) 
* `update`: 기존 테이블은 유지하고 변경된 부분만 수정 (in dev, not good in prod) 
* `validate`: entity-DB 일치 검증만 수행 (DB 존재하는 상황에 사용)

