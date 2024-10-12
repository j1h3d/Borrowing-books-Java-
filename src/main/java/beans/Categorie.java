package beans;

public class Categorie {
	private int id;
	private String category_name;
	private String cat_image;
	private String description;
	
	
	public Categorie(String category_name, String cat_image,String description) {
		this.category_name = category_name;
		this.cat_image = cat_image;
		this.description = description;
	}

	public Categorie() {
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public String getCat_image() {
		return cat_image;
	}
	public void setCat_image(String cat_image) {
		this.cat_image = cat_image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
