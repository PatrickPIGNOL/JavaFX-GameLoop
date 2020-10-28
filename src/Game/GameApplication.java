package Game;

import java.util.ArrayList;
import java.util.List;

import GameEngine.Dimensions;
import GameEngine.GameGroup;
import GameEngine.GameWindow;
import GameEngine.IOnDrawEventListener;
import GameEngine.IOnUpdateEventListener;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public class GameApplication extends Application 
{
	private GameWindow aWindow;
	private Scene aScene;
	private BreakoutGroup aGroup;
	private double aNanoTime;
	private List<IOnUpdateEventListener> aUpdateEventListeners; 
	private List<IOnDrawEventListener> aDrawEventListeners;
	
	@Override
	public void start(Stage pStage) throws Exception
	{
		this.aUpdateEventListeners = new ArrayList<IOnUpdateEventListener>();
		this.aDrawEventListeners = new ArrayList<IOnDrawEventListener>();
		this.aNanoTime = Double.valueOf(System.nanoTime());
		this.aGroup = new BreakoutGroup();
		this.aWindow = new GameWindow(this.aGroup, pStage, new Dimensions(800, 600), "NewJavaFX-GameBase", true);
		this.aWindow.mAddOnResisedListener(this.aGroup);
		new AnimationTimer()
		{
			@Override
			public void handle(long pNanoTime) 
			{
				mGameLoop(Double.valueOf(pNanoTime));
			}
		}.start();
		this.mAddUpdateEventListener(this.aGroup);
		this.mAddDrawEventListener(this.aGroup);
		this.aWindow.show();
	}
		
	private void mGameLoop(double pNanoTime)
	{
		double vDeltaTime = pNanoTime - this.aNanoTime;
		this.aNanoTime = pNanoTime;
		this.mUpdateEvent(vDeltaTime);		
		this.mDrawEvent(this.aGroup.mGraphicsContext());
	}
	
	public void mAddUpdateEventListener(IOnUpdateEventListener pUpdateEventListener)
	{
		this.aUpdateEventListeners.add(pUpdateEventListener);
	}
	
	public void mRemoveUpdateEventListener(IOnUpdateEventListener pUpdateEventListener)
	{
		this.aUpdateEventListeners.remove(pUpdateEventListener);
	}
	
	private void mUpdateEvent(double pDeltaTime)
	{
		for(IOnUpdateEventListener vUpdateListener : this.aUpdateEventListeners)
		{
			vUpdateListener.mOnUpdate(pDeltaTime);
		}
	}
	
	public void mAddDrawEventListener(IOnDrawEventListener pDrawEventListener)
	{
		this.aDrawEventListeners.add(pDrawEventListener);
	}
	
	public void mRemoveDrawEventListener(IOnDrawEventListener pDrawEventListener)
	{
		this.aDrawEventListeners.remove(pDrawEventListener);
	} 
	
	private void mDrawEvent(GraphicsContext pGraphicContext)
	{
		for(IOnDrawEventListener vDrawListener : this.aDrawEventListeners)
		{
			vDrawListener.mOnDraw(pGraphicContext);
		}
	}
}
