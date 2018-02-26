package entity;

public class Book {
	private int bid;
	private String name;
	private String author;
	private String publish;
	private double price;
	private String introduce;
	private Catelog catelog;
	
	public Book(int bid, String name, String author, String publish, double price, String introduce, Catelog catelog) {
		super();
		this.bid = bid;
		this.name = name;
		this.author = author;
		this.publish = publish;
		this.price = price;
		this.introduce = introduce;
		this.catelog = catelog;
	}

	public Book() {
		super();
	}

	public int getBid() {
		return bid;
	}

	public String getName() {
		return name;
	}

	public String getAuthor() {
		return author;
	}

	public String getPublish() {
		return publish;
	}

	public double getPrice() {
		return price;
	}

	public String getIntroduce() {
		return introduce;
	}

	public Catelog getCatelog() {
		return catelog;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setPublish(String publish) {
		this.publish = publish;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public void setCatelog(Catelog catelog) {
		this.catelog = catelog;
	}
	
	@Override
	public String toString() {
		return "Book [bid=" + bid + ", name=" + name + ", author=" + author + ", publish=" + publish + ", price="
				+ price + ", introduce=" + introduce + ", catelog=" + catelog + "]";
	}
}
