package es.unileon.spring.liquidate;

import javax.validation.constraints.Min;


public class LiquidateQuantity {

    @Min(0)
    private double quantity;
    
    @Min(1)
    private int numberFees;
    
    public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public int getNumberFees() {
		return numberFees;
	}

	public void setNumberFees(int numberFees) {
		this.numberFees = numberFees;
	}
    
    

}
