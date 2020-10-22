package dto;

import java.io.Serializable;

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
