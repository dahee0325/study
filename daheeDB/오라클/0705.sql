-- 서브쿼리
-- SCOTT 사원이 소속된 부서 이름을 출력
select dname
from dept
where deptno =
(select deptno
from emp
where ename = 'SCOTT')
;

--사원들 중 평균 급여보다 많은 급여를 받는 사원의 이름과 급여를 출력해보자.
select ename, sal
from emp
where sal > (select avg(sal)
from emp)
;

-- 급여가 3000이상인 사원의 소속 부서 
-- 해당 부서의 근무하는 사원의 리스트 ( 해당하는 근무부서는 여러개 나올 수 있다,)
select ename
from emp
where deptno in (select deptno
                 from emp
                 where sal >= 3000)
;


--서브커리에 있는 내용과 메인커리에 있는 내용이 하나라도 일치하면 참으로 실행결과를 보여줌
select ename, sal
from emp
where sal > any(select sal
from emp
where deptno = 30)
;

-- 인라인 뷰 : from 절 뒤에 서브쿼리가 위치
-- 서브쿼리의 검색 결과값이 대상으로 들어감
select *
from ( select empno, ename, job, hiredate
       from emp )
;

select ename 사원명, (select dname from dept where dept.deptno = emp.deptno) 부서이름
from emp
;


-----------------------------------------------------
--DDL

-- create table : 테이블 생성(데이터 저장 규칙을 정의)
-- 컬럼 이름, 저장 데이터의 타입, 저장 데이터 사이즈, 제약조건
-- null 유무, 중복여부, 기본값 설정, 기본키 설정, 외래키 설정 , 체크(ex) 정해놓은 값만 들어오도록 제약)

--create table : 컬럼을 직접 설정하는 방법
create table emp01 (--테이블 이름은 emp01로 생성
    empno number(4),--컬럼이름이 empno 인 저장공간을 생성. 숫자타입. 4자리까지 입력가능
    ename varchar2(20),--컬럼이름이 ename, 가변문자타입, 20자리(영문일때만 20자리 한글은 10자리)
    sal number(7,2)--컬럼이름 sal,숫자타입, 7자리, 7자리중 뒤 2자리는 소수표현
)

--create table : 서브 쿼리를 이용하는 방법
--서브쿼리로 출력한 컬럼을 가져와서 새로운 테이블명으로 저장됨 (하지만 제약조건을 가져오지않는다)
create table emp02
as
select * from emp
;

create table emp03
as
select empno, ename, job, hiredate from emp
;

create table emp04
as
select * from emp where deptno = 20
;

-- 구조만 복사하기위해서는 조건이 false 가 나오면 된다.
create table emp05
as
select * from emp where 1=2
;


create table memberinfo (
    userid varchar2(12),
    userpw varchar2(16),
    username varchar2(20),
    userphoto varchar2(30),
    regdate date
);

drop table memberinfo;

-- 테이블 구조를 수정하는 명령 : alter tble
-- 컬럼의 추가, 컬럼의 수정 : 컬럼이 가지고있는 도메인정의(제약)같은거, 컬럼의 삭제

-- 컬럼 추가 : alter table 테이블명 add 컬럼명
alter table emp01 add(job varchar2(9));

-- 컬럼 수정 : alter table 테이블명 modify (컬럼정의)
alter table emp01 modify(job varchar2(30));

-- 컬럼 삭제 : alter table 테이블명 drop column 컬럼명
alter table emp01 drop column job;

-- 테이블이 가지고있는 모든 로우를 제거
TRUNCATE table emp02;
select * from emp02;

--테이블명 변경
rename emp02 to test;
rename test to emp02;
desc emp02;
desc test;

-- 제약 조건 적용
create table emp06 (
    empno number(4) primary key,
    ename varchar2(20) not null,
    sal number(7,2) default 1000,
    grade number(1) check(grade between 1 and 5), --1~5까지의 숫자만들어오도록 제약
    gender char(1) check(gender in('M','W')), -- M아니면 W만 들어오도록 제약
    deptno number(2),
    FOREIGN KEY(DEPTNO) REFERENCES DEPT(DEPTNO) --references : 참조할거다
)
;

drop table emp06;

desc emp06;

-- insert into 테이블 이름 (컬럼리스트 : 저장하고자하는 컬럼명나열)
-- ex) insert into 테이블 이름 (컬럼리스트) values (값, 값, 값..) : 값은 컬럼의 개수와 같아야한다.
insert into emp06 (empno, ename) values(2, null);
insert into emp06 (empno, ename) values(1,'dahee');
insert into emp06 (empno, ename, grade, gender) values(1111,'dahee',1,'W');
insert into emp06 values(3333,'lllll',default,3,'M');
select * from emp06;

create table emp07(
    empno number(4) constraint emp07_empno_nn not null, --constraint 제약이름 설정
    ename varchar2(10) constraint emp07_ename_nn not null,
    job varchar2(9),
    deptno number(2),
    --제약설정
    constraint emp07_empno_pk primary key (empno), --emp07_empno_pk  라고 이름정해주고 empno 컬럼에 primary key 제약을 걸어줌
    constraint emp07_job_uk unique (job),
    constraint emp07_deptno_fk foreign key (deptno) references dept(deptno) -- deptno 을 foreign key로 설정하고 dept테이블의 deptno 을 참조한다.
);

select * from emp07;

-- MEMBERINFO 테이블 생성
-- 대리키 : idx                       - 기본키
-- 아이디 : 6~12 자리 문자열            - not null, unique
-- 비밀번호 : 8~16자리 문자열            - not null
-- 이름 : 10자리 문자열                - not null
-- 사진경로(파일이름) : 30자리 문자열
-- 가입날짜 : 날짜타입                  - default sysdate

create table memberinfo (
    idx number,
    u_id varchar2(12) CONSTRAINT memberinfo_uid_nn not null,
    u_pw varchar2(16) CONSTRAINT memberinfo_upw_nn not null,
    u_name varchar2(20) CONSTRAINT memberinfo_uname_nn not null,
    u_photo varchar2(30),
    regdate date default sysdate,
    CONSTRAINT memberinfo_idx_pk primary key (idx),
    CONSTRAINT memberinfo_uid_uk unique (u_id)
);

