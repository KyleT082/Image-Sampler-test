package kgt.dev.image.sampler;
/**
 * 
 * @author Kyle
 *
 */
public class TrainingData {
	
	private boolean grid[][];
	private char character;
	
	public TrainingData(char letter,int charWidth, int charHeight){
		this.grid = new boolean[charWidth][charHeight];
		this.character = letter;
	}
	
	///return a pixel from the data image
	public boolean getPixel(int x, int y){
		return this.grid[x][y];
	}
	
	//set the pixel
	public void setPixel(int x,int y,boolean isSet){
		this.grid[x][y] = isSet;
	}
	
	public int getHeight(){
		return this.grid[0].length;
	}
	
	public int getWidth(){
		return this.grid.length;
	}
	
	public char getCharacter(){
		return this.character;
	}
	
	@Override
	public String toString(){
		return " " + this.character;
	}
	
}
