package dto;

import java.io.Serializable;


/*
DROP TABLE PDS
CASCADE CONSTRAINTS;

DROP SEQUENCE SEQ_PDS;


CREATE TABLE PDS(
	SEQ NUMBER(8) PRIMARY KEY,	//외부에 불러오기전에는 충돌이 안되기 ㄷ때문에 안잡아놔도 상관없다
								//하지만 외래키로 쓸때는!
	ID VARCHAR2(50) NOT NULL,
	TITLE VARCHAR2(200) NOT NULL,
	CONTENT VARCHAR2(4000) NOT NULL,
	FILENAME VARCHAR2(50) NOT NULL,	//FILE 두가지 방법으로	톰캣 서버/		클라이언트 서버
	READCOUNT NUMBER(8) NOT NULL,
	DOWNCOUNT NUMBER(8) NOT NULL,
	REGDATE DATE NOT NULL
);

CREATE SEQUENCE SEQ_PDS
START WITH 1
INCREMENT BY 1;

ALTER TABLE PDS
ADD CONSTRAINT FK_PDS_ID FOREIGN KEY(ID)
REFERENCES MEMBER(ID);
 */
public class PdsDto implements Serializable {

	private int seq;
	private String id;
	private String title;
	private String content;
	
	//새로운..
	private String filename;	// 경로 + 파일명
	/*
		자료실의 원리 
		<a
		<form	둘 중 하나로 넘기면 String으로 날라감	중간에 서버가 존재
		어느 특정 부분에 파일을 올림(Server or Client)
		
		<file   		 넘기면 byte로 넘어감			다운로드는 byte 단위로 (데이터 정보) 날려줘서 새로 파일을 만드는.. 
		file이냐 form이냐 기능적 측면에서
	 */
	private int readcount;	// 조회수	
	private int downcount;	// 다운수
	
	private String regdate; // 등록일
	
//-------------------------------------------------
	public PdsDto() {
		
	}
//-------------------------------------------------
	public PdsDto(int seq, String id, String title, String content, String filename, int readcount, int downcount,
			String regdate) {
		super();
		this.seq = seq;
		this.id = id;
		this.title = title;
		this.content = content;
		this.filename = filename;
		this.readcount = readcount;
		this.downcount = downcount;
		this.regdate = regdate;
	}
//-------------------------------------------------	
		//유저 입장
	public PdsDto(String id, String title, String content, String filename) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.filename = filename;
	}
//-------------------------------------------------
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

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	public int getDowncount() {
		return downcount;
	}

	public void setDowncount(int downcount) {
		this.downcount = downcount;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
//-------------------------------------------------
	@Override
	public String toString() {
		return "PdsDto [seq=" + seq + ", id=" + id + ", title=" + title + ", content=" + content + ", filename="
				+ filename + ", readcount=" + readcount + ", downcount=" + downcount + ", regdate=" + regdate + "]";
	}
	
	
}
