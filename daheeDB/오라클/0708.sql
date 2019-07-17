-- 부속질의 2
-- 스칼라부속질의 : select 에서 사용되는 부속질의
-- 고객이름별 구매 총금액을 출력
select custid "구매번호", (
    select name
    from customer
    where orders.custid = customer.custid) "고객명"
, sum(saleprice) "총 금액"
from orders
group by custid;

-- join 처리
select o.custid, c.name "고객명", sum(o.saleprice) "총 금액"
from orders o join customer c
on o.custid = c.custid
group by o.custid, c.name
order by o.custid
;

-- 인라인 뷰 : from 에서 사용되는 부속질의
select *
from customer
where custid <= 2;

-- custid 가 1,2 인 구매자들의 정보 출력
select *
from(select * 
from customer
where custid <= 2) c, orders o
where c.custid = o.custid
;


-- row num : 자동으로 순번을 추가해줌
-- 부속질의를 사용하여 새로운 rownum 을 받을 수 있다.
select rownum, empno, ename
from emp
order by ename
;

-- (select * from emp order by ename)를 통해 새로운 테이블을 생성하는 것
-- 새로운 테이블을 생성 후 순번을 추가해준거라 순서대로 입력이된다.
select rownum, empno, ename
from (select * from emp order by ename)
;

--중첩질의 : where 절에서 사용되는 부속질의
-- 평균 주문 금액 이하의 주문에 대해서 주문번호와 금액을 출력
select avg(saleprice)
from orders;

select orderid, saleprice
from orders
where saleprice <= (select avg(saleprice)
from orders)
;

-- 각 고객의 평균 주문금액 보다 큰 금액의 주문 내역에 대해서 주문번호, 고객번호, 금액 출력
select orderid, custid, saleprice
from orders od
where saleprice > (select avg(saleprice)
from orders so
where od.custid = so.custid)
;

-- 대한민국에 거주하는 고객에게 판매한 도서의 총판매액을 구하시오.
select sum(saleprice) "총 판매금액"
from orders
where custid in(
    select custid
    from customer
    where address like '%대한민국%')
;

select *
from customer
where address like '%대한민국%'
;

-- join
select sum(saleprice) "총 판매금액"
from orders o join customer c
on o.custid = c.custid
where c.address like '%대한민국%'
;

-- 3번 고객이 주문한 도서의 최고 금액보다 더 비싼 도서를 구입한 주문의 주문번호와 금액을 출력
select max(saleprice)
from orders
where custid = 3
;

select orderid, saleprice
from orders
where saleprice > all (
    select saleprice
    from orders
    where custid = 3)
;
    
select orderid, saleprice
from orders
where saleprice > (
    select max(saleprice)
    from orders
    where custid = 3)
;

-- EXISTS 연산자로 대한민국에 거주하는 고객에게 판매한 도서의 총 판매액을 구하시오.
select sum(saleprice) "총 판매액"
from orders o
where exists (
    select * 
    from customer c 
    where o.custid = c.custid and address like '%대한민국%'
)
;


-- DML : 데이터조작언어
-- 테이블 삭제 : drop table 테이블명;
drop table dept01;
-- 테이블 생성 : create table 테이블명 (컬럼 리스트)
-- where 절에 false 값이 들어가게하면 구조만 가져온다.
create table dept01 as select * from dept where 1=0;
-- 데이터 입력 : insert into 테이블명 (컬럼 리스트) values (입력 데이터 리스트)
insert into dept01 (deptno, dname, loc) values(10, 'accounting', 'newyork');
insert into dept01 values(20, 'research', 'dallas');

-- null값의 입력 : 암묵적/암시적 방법
-- 컬럼을 빼고 입력
insert into dept01 (deptno, dname) values(30, 'sales');
-- null값 기입
insert into dept01 values(40, 'operations', null);
-- 공백문자열 : null로 추가
insert into dept01 values(50, '', null);
-- dept에 있는 행이 삽입됨
insert into dept01 select * from dept;

select * from dept01;

-- 데이터의 수정
-- : update 테이블 이름 set 컬럼명 = 변경데이터 .. where 변경하고자하는 행을 찾기위한 조건;
update emp01
set deptno = 30;

update emp01
set sal = sal*1.1;

update emp01
set hiredate = sysdate;

--where 절을 이용한 특정행의 데이터 변경
--부서번호가 10번인 사원의 부서번호를 30번으로 수정
update emp01
set deptno = 10
where deptno = 30
;

-- 급여가 3000이상인 사원만 급여를 10% 인상
update emp01
set sal = sal*1.1
where sal >= 3000
;

-- 1987년에 입사한 사원의 입사일이 오늘로 수정
update emp01
set hiredate = sysdate
where hiredate like '87%'
;

update emp01
set hiredate = sysdate
where SUBSTR(HIREDATE, 1, 2)='87'
;

-- SCOTT 사원의 부서번호는 20번으로, 직급은 MANAGER로 한꺼번에 수정
update emp01
set deptno = 20, job = 'MANAGER'
where ename = 'SCOTT'
;

-- SCOTT 사원의 입사일자는 오늘로, 급여를 50 으로 커미션을 4000 으로 수정
update emp01
set hiredate = sysdate, sal = 50, comm = 4000
where ename = 'SCOTT'
;

-- 20번 부서의 지역명을 40번 부서의 지역명으로 변경
update dept01
set loc = (select loc from dept01 where deptno = 40)
where deptno = 20;

--서브 쿼리를 이용해서 부서번호가 20인 부서의 부서명과 지역명을 부서 번호가 40번인 부서와 동일하게 변경
update dept01
set (dname, loc) = (
    select dname, loc
    from dept01
    where deptno = 40
)
where deptno = 10
;

-- 데이터 삭제 : delete from 테이블명 where 조건
-- 조건에 해당하는 행을 삭제, 전체 행을 삭제하려면 조건을 안걸면됨
delete from dept01;

delete from dept01
where deptno = 10
;

select * from dept01;

select * from memberinfo;
insert into memberinfo values(1, 'dahee','1234', '다희', '', default);
insert into memberinfo values(2, 'minhee','1111', '민희', 'tree.jpg', default);
insert into memberinfo values(3, 'hyewon','2222', '혜원', '', default);
insert into memberinfo values(4, 'hi','3333', '회원', '', default);

commit;

update memberinfo
set regdate = '97/05/25'
where u_name = '다희'
;

delete memberinfo
where u_id = 'hi';

commit; -- 저장

delete memberinfo;

rollback; -- 마지막 커밋순간으로 돌아감


-- view : 사용자에게 보여주는 가상 테이블 (특정 컬럼을 제외하거나 복잡한 sql 문을 간호화 시킨다.)
-- ㄴ보안 : 필요한 정보만 보여주기 위해서 생성, 복잡한 쿼리문을 더 간소화 시킴(자주쓰는 쿼리문으로 테이블을 만들어서 사용)
-- view 생성 : create view 뷰이름 as 서브쿼리 - 서브쿼리의 결과가 지정된 view이름으로 저장됨

-- or relpace : 생략가능, 만약 같은 이름의 view 가 있다면 수정역할도함
create or replace view emp_view30 as 
select empno, ename, deptno from emp where deptno=30
;

-- 인라인뷰
-- 사원 중에서 입사일이 빠른 사람 5명(TOP-5)만을 얻어 오는 질의문을 작성
select rownum, empno, ename, hiredate
from (select rownum, empno, ename, hiredate
from emp
order by hiredate)
where rownum <= 5
;

--view 사용
create or replace view emp_view_hd as
select empno, ename, hiredate
from emp
order by hiredate;

select rownum, empno, ename, hiredate
from emp_view_hd
where rownum <= 5
;

create or replace view emp_view_hd as
select empno, ename, hiredate
from emp
order by hiredate;


-- sequence : 자동 숫자 증가해주는 객체
-- 시퀀스 생성 : 아무것도 설정안해주면 디폴트값은 1
create sequence test_seo
start with 10   -- 시작 숫자 10
increment by 10 -- 10씩 증가
;

drop sequence test_seo;

select test_seo.currval from dual; --현재값을 반환
select test_seo.nextval from dual; --다음값을 반환

-- 10씩 증가하며 데이터가 들어간다.
insert into dept01 values(test_seo.nextval, 'design', 'seoul');
select * from dept01;

select * from memberinfo;
-- 회원가입시 증가하는 idx 값을 위한 sequence 생성
create sequence memberinfo_idx_seq;


-- 회원가입
insert into memberinfo values (memberinfo_idx_seq.nextval, 'dada','4444','다다','', default);
insert into memberinfo values (memberinfo_idx_seq.nextval, 'heee','5555','희희','', default);

ROLLBACK;
commit;

select * from emp join dept using (deptno);

select * from emp;
DELETE emp
where empno=7777;

update emp set sal = 3000 where ename='SCOTT';

select * from emp where ename='SCOTT';