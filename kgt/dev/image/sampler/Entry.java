package kgt.dev.image.sampler;

import java.io.File;

import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import test.Test;

public class Entry {
	
	private Mat img;
	
	private int width,height;
	
	private Mat sampled;
	
	private char charSymbol;
	
	protected int downSampleTop;
	protected int downSampleBottom;
	protected int downSampleRight;
	protected int downSampleLeft;
	
	public Entry(File f,int w,int h){
		this.img = Imgcodecs.imread(f.getPath());
		this.charSymbol = f.getName().charAt(0);
		this.width = w;
		this.height = h;
		init();
	}
	
	private void init(){
		//convert and binarize and resize
		sampled = new Mat(width,height,img.type());
		Imgproc.resize(img, sampled, sampled.size());
		Imgproc.cvtColor(sampled, sampled, Imgproc.COLOR_RGB2GRAY);
		Imgproc.threshold(sampled, sampled, 123, 255, Imgproc.THRESH_BINARY);
		
		
		TrainingData td = new TrainingData(charSymbol,width,height);
		
		for(int x = 0; x < sampled.cols();x++){
			for(int y = 0;y < sampled.rows();y++){
				double[] data = sampled.get(x, y);
				
				if(data[0] > 0){
					td.setPixel(y, x, false);
				}
				else{
					td.setPixel(y, x, true);
				}
			}
		}
		
		Test.set.addData(td);
		
	}
	
	
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
}
