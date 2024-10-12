package beans;

public class Bien {
	private int id;
	private int category_id;
	private String type;
	private String title;
	private String description;
	private String price_per_day;
	private String disponibility;
	private String image;


	public Bien(int id, int category_id, String type, String title, String description, String price_per_day,
			String disponibility, String image) {
		super();
		this.id = id;
		this.category_id = category_id;
		this.type = type;
		this.setTitle(title);
		this.description = description;
		this.price_per_day = price_per_day;
		this.disponibility = disponibility;
		this.setImage(image);
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPrice_per_day() {
		return price_per_day;
	}
	public void setPrice_per_day(String price_per_day) {
		this.price_per_day = price_per_day;
	}
	public String getDisponibility() {
		return disponibility;
	}
	public void setDisponibility(String disponibility) {
		this.disponibility = disponibility;
	}
	public int getCategorie() {
		return category_id;
	}
	public void setCategorie(int categorie) {
		this.category_id = categorie;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}
	
}
