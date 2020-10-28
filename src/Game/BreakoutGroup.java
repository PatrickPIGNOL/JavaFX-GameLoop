package Game;

import GameEngine.Dimensions;
import GameEngine.GameGroup;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class BreakoutGroup extends GameGroup 
{
	private Canvas aCanvas;
	
	public BreakoutGroup()
	{
		super();
		this.aCanvas = new Canvas();
		this.getChildren().add(this.aCanvas);
	}
	
	@Override
	public void mOnResized(Dimensions pScreenSize)
	{
		super.mOnResized(pScreenSize);
		this.aCanvas.setWidth(pScreenSize.getWidth());
		this.aCanvas.setHeight(pScreenSize.getHeight());
	}
	
	public GraphicsContext mGraphicsContext()
	{
		return this.aCanvas.getGraphicsContext2D();
	}
	
	@Override
	public void mOnUpdate(double pDeltaTime) 
	{
		super.mOnUpdate(pDeltaTime);
	}

	@Override
	public void mOnDraw(GraphicsContext pGraphicContext) 
	{
		super.mOnDraw(pGraphicContext);
		pGraphicContext.setFill(new Color(0.0, 0.0, 0.0, 1.0));
		pGraphicContext.fillRect(0, 0, this.mScreenSize().getWidth(), this.mScreenSize().getHeight());
	}
}
