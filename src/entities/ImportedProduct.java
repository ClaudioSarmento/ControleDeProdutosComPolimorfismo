package entities;

public class ImportedProduct extends Product{
	private Double customsFree;

	public ImportedProduct() {
		super();
	}

	public ImportedProduct(String name, Double price, double customsFree) {
		super(name, price);
		this.customsFree = customsFree;
	}

	public double getCustomsFree() {
		return customsFree;
	}

	public void setCustomsFree(double customsFree) {
		this.customsFree = customsFree;
	}
	
	public Double totalPrice() {
		return super.getPrice() + this.customsFree;
	}
	
	@Override
	public String priceTag() {
		return "Product [name= " + super.getName() + ", price= " + String.format("%.2f",totalPrice()) 
		+ ", customsFree= "+ String.format("%.2f",customsFree) +"]";
	}
}
