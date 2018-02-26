package entity;

public class Catelog {
	private int cid;
	private String name;
	private String introduce;

	public Catelog(int cid, String name, String introduce) {
		this.cid = cid;
		this.name = name;
		this.introduce = introduce;
	}
	public Catelog() {
		super();
	}
	public int getCid() {
		return cid;
	}
	public String getName() {
		return name;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	@Override
	public String toString() {
		return "Catelog [cid="+cid+",name="+name+",introduce="+introduce+"]";
	}
	
}
