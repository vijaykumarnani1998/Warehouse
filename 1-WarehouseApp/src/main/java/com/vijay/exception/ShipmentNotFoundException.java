package com.vijay.exception;

public class ShipmentNotFoundException extends  RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1943846193654292134L;
	 
	public ShipmentNotFoundException ()
	{
		super();
	}
	public ShipmentNotFoundException (String message)
	{
		super(message);
	}
	

}
