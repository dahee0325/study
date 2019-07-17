-- 그룹함수
-- sum(컬럼) : 그룹의 합을 반환
-- 사원 테이블에서 사원의 월 급여(sal)의 총합을 구해보자.
select sum(sal) "월 총급여"
from emp
;

-- 10번 부서 소속 직원들의 월 급여 총액을 구해보자.
select sum(sal) "10번부서 월급여"
from emp
where deptno=10
;

-- sum 함수에서 null 값 처리방식 : null 값은 무시한다.(수칙계산에서 아에 제외하고함)
select sum(comm)
from emp
;

select comm from emp;

--avg(컬럼) : 그룹에 포함된 값들의 평균값을 반환해주는 함수
--그룹함수의 결과는 단일행의 하나의 컬럼
select trunc(avg(sal)) "전체사원의 평균 월급여"
from emp
;

select trunc(avg(sal)) "매니저의 평균 월급여"
from emp
where job='MANAGER'
;

-- avg 함수도 컬럼의 값이 null일때 null값을 무시(제외)하고 처리한다
select avg(comm) 평균
from emp
;

-- max(컬럼) : 최대값 반환, min(컬럼) : 최소값 반환
select max(sal) "최대 급여", min(sal) "최소 급여"
from emp
;

-- count(컬럼) : row의 개수를 반환
-- 회사에 소속된 사원의 수
select count(*) "전체 사원의 수"
from emp
;

select count(*) "10번부서 사원 수"
from emp
where deptno = 10
;

-- 커미션을 받는 직원의 수
select count(comm)
from emp
where comm>0
;

-- 부서의 수를 구하자
select count(*)
from dept
;

-- 사원들이 소속된 부서의 수 distinct : 중복제거
select count(DISTINCT deptno) "부서의 수"
from emp
;


-- group by 컬럼이름 : row를 그룹핑 해서 처리, 집합함수(sum, avg, count)
-- group by 컬럼이름 : 컬럼이름이 그룹핑의 기준이 된다. (ex 부서별, 직무별)
-- 출력은 deptno 기준으로 그룹핑되어 생성된 컬럼만 출력가능하다
-- round : 반올림해서 출력됨
-- 그룹이 묶여있는 칼럼을 대상으로 count됨
select deptno, sum(sal), round(avg(sal)), count(*), count(comm), max(sal) , min(sal)
from emp
group by deptno
;

-- 직무별 지표를 출력
select job "직무", count(*) "직원의 수", to_char(sum(sal), '999,999') "급여의 총합", round(avg(sal)) "급여의 평균", max(sal) , min(sal)
from emp
group by job
;


-- 부서의 평균 급여가 2000 이상인 부서만 출력
select deptno, sum(sal), round(avg(sal)), count(*), count(comm), max(sal) , min(sal)
from emp
group by deptno
having avg(sal) >= 2000
;

-- 부서의 최대 급여가 2900이상인 부서를 출력
select deptno, sum(sal), round(avg(sal)), count(*), count(comm), max(sal) , min(sal)
from emp
group by deptno
having max(sal) >= 2900
;


-- join : 2개 이상의 테이블 옆으로 붙인다. -> 표현하는 컬럼이 늘어난다.
-- cross join : 테이블을 붙인다 (단순하게 조건없이 테이블끼리 붙여줌(테이블컬럼수끼리 곱하는 결과가 나옴))
select *
from emp, dept
;

-- equi join : 동등비교를 통해 얻어올 수 있다. 조건을 줘서 
select *
from emp, dept
where emp.deptno=dept.deptno
;

-- 이름이 'SCOTT'인 사원의 이름과 부서이름을 출력
select ename, dname
from emp, dept
where emp.deptno=dept.deptno and ename = 'SCOTT'
;

--주문테이블에서 회원의 이름이 박지성인 회원의 주문 정보를 출력
select orders.orderid, customer.name
from  orders, customer
where orders.custid = customer.custid and customer.name = '박지성'
;

--별칭 사용
select *
from emp e, dept d
where e.deptno = d.deptno
;

--3개 테이블 조인
-- customer, book, orders
select * from customer;
select * from book;
select * from orders;

select *
from customer c, orders o, book b
where c.custid = o.custid and b.bookid = o.bookid
;

-- 박지성 고객이 주문한 책의 이름을 출력
select o.orderid "주문 번호", c.custid "회원 번호", c.name "회원 이름", b.bookname "책 이름", b.publisher "출판사"
from customer c, orders o, book b                                                                                                
where c.custid = o.custid and b.bookid = o.bookid and c.name = '박지성'
;


select *
from emp e, salgrade s
where e.sal between s.losal and s.hisal
;

--self join
select e.ename || '의 매니저는 ' || m.ename || '입니다.' 출력
from emp e, emp m
where e.mgr = m.empno
order by m.ename
;

-- null값도 표시 (+) 를 사용, null값이 나올곳에 사용하면됨
select e.empno, e.ename, e.mgr, m.ename
from emp e, emp m
where e.mgr= m.empno(+)
;

-- ANSI CROSS JOIN
select *
from emp cross join dept
;
--랑 같은거
select *
from emp, dept
;

-- ANSI INNER JOIN
select *
from emp inner join dept
on emp.deptno = dept.deptno
;
--와 같다.
select *
from emp, dept
where emp.deptno = dept.deptno
;

--using 사용
select *
from emp join dept
-- 동등비교해줘야하는 컬럼명을 써줌
using(deptno)
;

-- (+) 대신 왼쪽기준으로 null포함 출력하게 하기위해 사용
select e.ename, m.ename
from emp e left outer join emp m
on e.mgr = m.empno
;

select *
from customer
;

select DISTINCT custid 
from orders
;

select *
from customer c, orders o
where o.custid(+) = c.custid
;

select *
from customer c left outer join orders o
on o.custid = c.custid
;