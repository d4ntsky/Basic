package calendarEx;

import java.io.Serializable;


/*
DROP TABLE CALENDAR
CASCADE CONSTRAINTS;

DROP SEQUENCE SEQ_CAL;

CREATE TABLE CALENDAR(
	SEQ NUMBER(8) PRIMARY KEY,			//SEQUENCE 키는 프라이머리 키로 안잡아도 되는데 JOIN 시킬 때 필요함
	ID VARCHAR2(50) NOT NULL,			//ID는 외래키
	TITLE VARCHAR2(200) NOT NULL,
	CONTENT VARCHAR2(4000) NOT NULL,
	RDATE VARCHAR2(12) NOT NULL,		//RDATE 기입받느라 만들어서 
	WDATE DATE NOT NULL
);

CREATE SEQUENCE SEQ_CAL
START WITH 1
INCREMENT BY 1;

ALTER TABLE CALENDAR
ADD CONSTRAINT FK_CAL_ID FOREIGN KEY(ID)
REFERENCES MEMBER(ID);
*/

public class CalendarDto implements Serializable {
//달력 쓰는 곳 : 병원 일정/대학 일정/회사 행사 등등
	
	private int seq;
	private String id;
	private	String title;	
	private String content;
	private String rdate;	// 일정이 있는 날 			20/08/03	/record date
	private	String wdate;	// 작성일(일정을 작성한 날)	20/07/31	/write date
	
	public CalendarDto() {
		
	}

	public CalendarDto(int seq, String id, String title, String content, String rdate, String wdate) {
		super();
		this.seq = seq;
		this.id = id;
		this.title = title;
		this.content = content;
		this.rdate = rdate;
		this.wdate = wdate;
	}
	
	//외부에서 들어올 것들!!!!!!!!!!!!!!!!!!!
	public CalendarDto(String id, String title, String content, String rdate) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.rdate = rdate;
	}

	
	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	@Override
	public String toString() {
		return "CalendarDto [seq=" + seq + ", id=" + id + ", title=" + title + ", content=" + content + ", rdate="
				+ rdate + ", wdate=" + wdate + "]";
	}
	
	
}
