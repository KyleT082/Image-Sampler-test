package test;

import java.awt.Dimension;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.opencv.core.Core;

import kgt.dev.image.sampler.Entry;
import kgt.dev.image.sampler.ImageSet;
import kgt.dev.image.sampler.Sampler;

/**
 * 
 * @author Kyle
 *
 */
public class Test {
	
	public static final ImageSet set = new ImageSet();

	public static void main(String[] args) {
		
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		File f = new File("C:/Users/Kyle/Pictures/letters/chars/C-.png");
		Entry e = new Entry(f,20,20);

		JFrame frame = new JFrame("Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		
		JPanel panel1  = new JPanel();
		panel1.setPreferredSize(new Dimension(420,420));
	
		Sampler sample = new Sampler(20,20);
		sample.setData(set.getData(0));
		System.out.println(set.getData(0).getCharacter());
		sample.setPreferredSize(new Dimension(420,420));
		panel1.add(sample);
		frame.add(panel1);
		frame.setVisible(true);
		
		
			
	}

}
