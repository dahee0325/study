CREATE TABLE GUESTBOOK_MESSAGE (
    MESSAGE_ID NUMBER(6) CONSTRAINT GM_MID_PK PRIMARY KEY,
    GUEST_NAME VARCHAR2(50) NOT NULL,
    PASSWORD VARCHAR2(20) NOT NULL,
    MESSAGE long NOT NULL
);

drop table GUESTBOOK_MESSAGE;
CREATE SEQUENCE GM_MID_SEQ;

select * from guestbook_message;

select rownum, message_id,guest_name, message from guestbook_message;
