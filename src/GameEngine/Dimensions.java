package GameEngine;

import javafx.geometry.Dimension2D;

public class Dimensions extends Dimension2D
{
	public Dimensions(double pWidth, double pHeight) 
	{
		super(pWidth, pHeight);
	}
	
	public Dimensions(Dimensions pDimensions)
	{
		super(pDimensions.getWidth(), pDimensions.getHeight());
	}
	
	public Dimensions mAdd(double pFactor)
	{
		return new Dimensions(this.getWidth() + pFactor, this.getHeight() + pFactor);
	}
	
	public Dimensions mAdd(Dimensions pFactor)
	{
		return new Dimensions(this.getWidth() + pFactor.getWidth(), this.getHeight() + pFactor.getHeight());
	}
	
	public Dimensions mSubstract(double pFactor)
	{
		return new Dimensions(this.getWidth() - pFactor, this.getHeight() - pFactor);
	}
	
	public Dimensions mSubstract(Dimensions pFactor)
	{
		return new Dimensions(this.getWidth() - pFactor.getWidth(), this.getHeight() - pFactor.getHeight());
	}
	
	public Dimensions mMultiply(double pFactor)
	{
		return new Dimensions(this.getWidth() * pFactor, this.getHeight() * pFactor);
	}
	
	public Dimensions mMultiply(Dimensions pFactor)
	{
		return new Dimensions(this.getWidth() * pFactor.getWidth(), this.getHeight() * pFactor.getHeight());
	}
	
	public Dimensions mDivide(double pFactor)
	{
		return new Dimensions(this.getWidth() / pFactor, this.getHeight() / pFactor);
	}
	
	public Dimensions mDivide(Dimensions pFactor)
	{
		return new Dimensions(this.getWidth() / pFactor.getWidth(), this.getHeight() / pFactor.getHeight());
	}
}
