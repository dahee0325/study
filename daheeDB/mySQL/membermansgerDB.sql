create table userInfo (
idx int(20) auto_increment,
uId varchar(50),
uPw varchar(50) NOT NULL,
uName varchar(50) NOT NULL,
uPhoto varchar(50),
regDate datetime default current_timestamp,
primary key(uId),
unique key m_auto_increment_test_idx01(idx)
)engine = innoDB default char set=utf8;

alter table userInfo add verify char(1) default 'N';
alter table userInfo add code char(20) not null;

drop table userInfo;
select * from userinfo;
commit;


select upw, md5(upw) sha, md5(upw) as md5
from userInfo limit 0,1;

-- passord 라는 키로 저장
update userinfo set upw=hex(aes_encrypt(upw, 'password'))
where idx = 25;

-- 복호화 (암호화된 암호 복구)
select upw, convert(aes_decrypt(UNHEX(upw), 'password') using utf8) as upw
from userinfo
where idx=20;

select upw, convert(aes_decrypt(UNHEX(upw), 'password') using utf8) as upw
from userinfo
where idx=25;

