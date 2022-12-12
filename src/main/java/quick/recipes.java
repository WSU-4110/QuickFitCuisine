package quick;
public class recipes {
	protected int recipeid;
	protected String link;
	protected String name;
	protected int time;
	protected int count;

	// constructors
	public recipes(int recipeid, String link, String name, int time, int count) {
		this.link = link;
		this.name = name;
		this.time = time;
		this.count = count;
		this.recipeid = recipeid;
	}
	
	public recipes(String link, String name, int time, int count) {
    	this.link = link;
    	this.name = name;
    	this.time = time;
    	this.count = count;
    }

	// getter and setter methods
	public int getRecipeid() {
		return recipeid;
	}

	public void setRecipeid(int recipeid) {
		this.recipeid = recipeid;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}