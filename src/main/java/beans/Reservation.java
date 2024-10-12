package beans;


public class Reservation {
	private int id;
	private String id_utilisateur;
	private String id_bien;
	private String start_rent;
	private String end_rent;
	private String state;
	private String total_amount;
	
	
	public Reservation() {
		this.id_utilisateur = id_utilisateur;
		this.id_bien = id_bien;
		this.start_rent = start_rent;
		this.end_rent = end_rent;
		this.state = state;
		this.total_amount = total_amount;
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getId_user() {
		return id_utilisateur;
	}

	public void setId_user(String id_user) {
		this.id_utilisateur = id_user;
	}

	public String getId_bien() {
		return id_bien;
	}

	public void setId_bien(String id_bien) {
		this.id_bien = id_bien;
	}

	public String getStart_rent() {
		return start_rent;
	}

	public void setStart_rent(String start_rent) {
		this.start_rent = start_rent;
	}

	public String getEnd_rent() {
		return end_rent;
	}

	public void setEnd_rent(String end_rent) {
		this.end_rent = end_rent;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(String total_amount) {
		this.total_amount = total_amount;
	}
	
}
