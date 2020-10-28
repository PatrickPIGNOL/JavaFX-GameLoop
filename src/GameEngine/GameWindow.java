package GameEngine;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameWindow extends Stage
{
	private Scene aScene;
	List<IOnResizedEventListener> aResizedListeners;
	public GameWindow(GameGroup pGameGroup, Stage pStage, Dimensions pScreen, String pTitle, boolean pResizeable)
	{
		super(pStage.getStyle());
		this.aResizedListeners = new ArrayList<IOnResizedEventListener>();
		this.setTitle(pTitle);
		this.aScene = new Scene(pGameGroup, 800, 600);
		this.setScene(this.aScene);
		this.setResizable(pResizeable);
		this.widthProperty().addListener(new ChangeListener<Number>() 
		{
			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) 
			{
				mOnResizedEvent();
			}
		});
		this.heightProperty().addListener(new ChangeListener<Number>() 
		{
			@Override
			public void changed(ObservableValue<? extends Number> pObservableValue, Number pOldValue, Number pNewValue) 
			{
				mOnResizedEvent();
			}
		});
	}
	
	public void mAddOnResisedListener(IOnResizedEventListener pOnResizedListener)
	{
		this.aResizedListeners.add(pOnResizedListener);
	}
	
	public void mRemoveOnResisedListener(IOnResizedEventListener pOnResizedListener)
	{
		this.aResizedListeners.remove(pOnResizedListener);
	}
		
	private void mOnResizedEvent()
	{
		for(IOnResizedEventListener vListener : this.aResizedListeners)
		{
			vListener.mOnResized(new Dimensions(this.getWidth(), this.getHeight()));
		}
	}
}
