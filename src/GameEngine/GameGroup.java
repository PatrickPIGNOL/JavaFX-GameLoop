package GameEngine;

import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;

public class GameGroup extends Group implements IGameGroup
{
	private Dimensions aScreenSize;
	
	public GameGroup()
	{
		super();
		this.aScreenSize = new Dimensions(0, 0);
	}

	@Override
	public void mOnResized(Dimensions pScreen) 
	{
		this.aScreenSize = pScreen;
		System.out.println("Width : " + pScreen.getWidth() + ", Height : " + pScreen.getHeight());
	}
	
	public Dimensions mScreenSize()
	{
		return new Dimensions(this.aScreenSize);
	}

	@Override
	public void mOnUpdate(double pDeltaTime) 
	{
		
	}

	@Override
	public void mOnDraw(GraphicsContext pGraphicContext) 
	{
		
	}
}
