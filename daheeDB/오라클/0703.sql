-- LIKE : 문자 패턴 검색 연산자 키워드
-- 구조 : 컬럼명 LIKE 패턴 으로 정의
-- 패턴 : %와 _ 을 사용

-- % 패턴을 이용하는 LIKE 연산자
-- 사원테이블에서 S로 시작하는 사원의 이름을 검색
select ename from emp;
select ename from emp where ename like 'S%';
-- 이름에 R이 들어가면 출력
select ename from emp where ename like '%R%';
-- 이름이 N으로 끝나면 출력
select ename from emp where ename like '%N';

-- _ 연산자는 문자의 자리(위치) 고정을 의미 : 해당 자리에는 어떠한 값이 와도 상관없음
-- _A 라고 사용했을때 _를 사용한 첫번째 자리에는 어떠한 값이 와도 상관없지만 _뒤에 두번째자리에는 A가 무조건와야한다.
-- _ 패턴을 이용하는 LIKE 연산자
select ename from emp;
-- 두번째 자리에 L이 오는 이름을 출력
select ename from emp where ename like '_L%';
-- 세번째 자리에 L이 오는 이름을 출력
select ename from emp where ename like '__L%';
select ename from emp where ename like 'W__D%';

-- 사원의 이름중 'A'를 포함하지 않는 사원들을 검색
select * from emp where ename not like '%A%';

-- 컬럼의 데이터가 null 값 여부를 확인
-- is null -> 값이 null 일때 true
-- is not null -> 값이 null이 아닐때 true

--커미션을 받지 않는 사원
select * from emp where comm is null or comm = 0;

--커미션을 받는 사원
select * from emp where not(comm is null or comm = 0);
select * from emp where comm is not null and comm > 0;

-- 결과 테이블의 로우 정렬
-- order by 컬럼명 [asc]/desc , 컬럼명 [asc]/desc
-- 오름차순(asc) : 작은게 제일 윗줄에 출력
-- 내림차순(desc) : 큰게 제일 윗줄에 출력
-- 기본값이 asc 이기때문에 내림차순으로 표현할때만 desc를 사용하면된다.

-- 오른차순정렬
select * from emp
order by empno;
-- 내림차순정렬
select * from emp
order by empno desc;

--급여가 작은 사원부터 급여가 많은 사원 순으로 정렬
select ename 사원명, sal 급여 from emp
order by sal;

--급여가 큰 사원부터 급여가 많은 사원 순으로 정렬
select ename 사원명, sal 급여 from emp
order by sal desc;

--최근 입사한 사원 순으로(큰순으로) 사원의 리스트 출력
select * from emp
order by hiredate desc;

--사원의 급여 기준으로 급여가 많은 사람 순으로 정렬, 급여가 같은 사원의 경우 이름순으로 정렬
select ename, sal, hiredate from emp
order by sal desc, ename asc;

-- 급여가 같으면 입사일이 더 빠른 사원으로 출력
select ename, sal, hiredate from emp
order by sal desc, hiredate asc;


---------------함수---------------------------
--TO_CHAR
--DATE -> STR
-- 날짜 표현형식 바꾸기
-- sysdate : 시스템에 있는 날짜정보를 가져옴 dual 테이블은 하나의 로우를 출력하기 위해 있는 테이블
select sysdate 날짜, to_char(sysdate, 'YYYY-MM-DD HH24:MI:SS') 변환날짜
from dual;

select m_num, u_num,m_title,m_content, to_char(message.m_writedate, 'MM-DD HH24:MI'), m_to
from message where m_num = 31;

select m_num, to_char(message.m_writedate, 'MM-DD HH24:MI') 변환날짜
from message;

select hiredate, to_char(hiredate, 'YYYY.MM.DD(DY)') 날짜
from emp;

-- 숫자를 문자로 변경
-- number -> str : to_char(숫자타입, '패턴')
-- L : 각 지역의 통화기호를 붙여줌
-- 0 : 숫자가 없다면 자리를 채워줌
select to_char(10000, 'L000,000.00')
from dual;
-- 9 : 숫자가 없다면 채우지않음
select to_char(10000, 'L999,999.99')
from dual;

select sal, to_char(sal, 'L999,999') 월급여, to_char(sal*12+nvl(comm, 0), 'L999,999') 연봉
from emp
order by 월급여 desc;

-- to_date(원본, 'yyyymmdd') -> date 타입으로 바뀜 (같은타입으로 비교)
select ename, hiredate, to_date(19810220,'yyyymmdd')
from  emp
where hiredate = to_date(19810220,'yyyymmdd')
;

-- trunc : 
select sysdate, to_date('1997/03/25', 'YYYY/MM/DD'), trunc(sysdate-to_date('1997/03/25', 'YYYY/MM/DD')) "태어난지.."
from dual
;

--decode 함수 : switch case 형식과 유사하다.
-- decode(컬럼명, 조건1, 결과1, 조건2, 결과2, 조건3, 결과3)
select ename, deptno, decode(deptno,10,'ACCOUNTING',20,'REARCH',30,'SALES',40,'OPERATIONS') DNAME
from emp
order by deptno;

select ename, job, sal, decode(job,'ANALYST',sal*1.05,'SALESMAN',sal*1.1,'MANAGER',sal*1.15,'CLERK',sal*1.2) 인상된급여
from emp
order by job
;


select ename, deptno, case 
                        when deptno=10 then 'ACCOUNTING'
                        when deptno=20 then 'REARCH'
                        when deptno=30 then 'SALES'
                        when deptno=40 then 'OPERATIONS'
                        else'no Name'--부서가 없는 사원은 noName으로 표시
                      end "DNAME"
from emp
order by deptno
;

