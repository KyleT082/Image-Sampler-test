package kgt.dev.image.sampler;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
/**
 * 
 * @author Kyle
 *
 * Sampler class allows for the display of the binary pixel data 
 * shown in a grid.
 */
public class Sampler extends JPanel {

	private TrainingData data;
	
	public Sampler(int width, int height){
		this.data = new TrainingData(' ',width,height);
	}
	
	public void paint(final Graphics g){
		if(this.data == null){
			return;
		}
		int x,y;
		final int vertCell = this.getHeight() / this.data.getHeight();
		final int horiCell = this.getWidth() / this.data.getWidth();
		
		g.setColor(Color.white);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		g.setColor(Color.black);
		
		for(y  = 0;y < this.data.getHeight(); y++){
			g.drawLine(0, y * vertCell, getWidth(), y * vertCell);
		}
		
		for( x = 0; x < this.data.getWidth(); x++){
			g.drawLine(x * horiCell,0, x*horiCell,getHeight());
		}
		
		for(y = 0;y < this.data.getHeight();y++){
			for( x = 0; x < this.data.getWidth(); x++){
				if(this.data.getPixel(x,y)){
					g.fillRect(x*horiCell, y * vertCell, horiCell ,vertCell);
				}
			}
		}
		
		g.setColor(Color.black);
		g.drawRect(0, 0, this.getWidth()-1, this.getHeight()-1);
	}
	
	
	public void setData(TrainingData data){
		this.data = data;
	}
}
