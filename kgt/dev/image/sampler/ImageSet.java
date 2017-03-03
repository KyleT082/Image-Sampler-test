package kgt.dev.image.sampler;

import java.util.ArrayList;
import java.util.List;

public class ImageSet {
	
	private List<TrainingData> trainingSet;
	
	public ImageSet(){
		this.trainingSet = new ArrayList<TrainingData>();
	}
	
	/**
	 * 
	 * @param newData
	 */
	public void addData(TrainingData newData){
		this.trainingSet.add(newData);
	}
	/**
	 * 
	 * @param pos
	 * @return
	 */
	public TrainingData getData(int pos){
		return trainingSet.get(pos);
	}
	
	public List<TrainingData> getList(){
		return trainingSet;
	}
	
}
