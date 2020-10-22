package dto;

import java.io.Serializable;

public class MusicVo implements Serializable {

	private String title;
	private int like;
	
	public MusicVo() {
		
	}

	public MusicVo(String title, int like) {
		super();
		this.title = title;
		this.like = like;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like = like;
	}

	@Override
	public String toString() {
		return "MusicVo [title=" + title + ", like=" + like + "]";
	}
	
	
}
