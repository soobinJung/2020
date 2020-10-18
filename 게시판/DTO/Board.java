package DTO;

public class Board {
	private String id;
	private String replyid;
	private String title;
	private String content;
	private String update;
	private String hits;
	private String likes;
	private String reply;
	private String replydate;
	
	private String B_ID;
	private String B_TITLE;
	private String B_UPDATE;
	private String B_UPTIME;
	
	
	public String getReplyid() {
		return replyid;
	}
	public void setReplyid(String replyid) {
		this.replyid = replyid;
	}
	public String getB_TITLE() {
		return B_TITLE;
	}
	public void setB_TITLE(String b_TITLE) {
		B_TITLE = b_TITLE;
	}
	public String getB_ID() {
		return B_ID;
	}
	public void setB_ID(String b_ID) {
		B_ID = b_ID;
	}
	public String getB_UPDATE() {
		return B_UPDATE;
	}
	public void setB_UPDATE(String b_UPDATE) {
		B_UPDATE = b_UPDATE;
	}
	public String getB_UPTIME() {
		return B_UPTIME;
	}
	public void setB_UPTIME(String b_UPTIME) {
		B_UPTIME = b_UPTIME;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public String getReplydate() {
		return replydate;
	}
	public void setReplydate(String replydate) {
		this.replydate = replydate;
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
	public String getUpdate() {
		return update;
	}
	public void setUpdate(String update) {
		this.update = update;
	}
	public String getHits() {
		return hits;
	}
	public void setHits(String hits) {
		this.hits = hits;
	}
	public String getLikes() {
		return likes;
	}
	public void setLikes(String likes) {
		this.likes = likes;
	}
	
	
}
