package mohamed;


public class ProductModel {
	
	private int id;
	private String productName , Base64	, description;
	private java.sql.Timestamp timestamp	;
	private byte [] photo;
	
	
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getBase64() {
		return Base64;
	}
	public void setBase64(String base64) {
		Base64 = base64;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public java.sql.Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(java.sql.Timestamp timestamp2) {
		this.timestamp = timestamp2;
	}
	
	
	

}
