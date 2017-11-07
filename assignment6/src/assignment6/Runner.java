package assignment6;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.tree.*;
/**
 * Main class to generate the tree and code for
 * the genetic algorithm in Interactive C.
 * 
 * @author Nick Rummel
 * @author Alex Medellin
 *
 */


public class Runner
{
	public static ArrayList<DefaultMutableTreeNode> tree = new ArrayList<DefaultMutableTreeNode>();
	static char i = '`';
	private final static int THRESHOLD = 235;
	public static void main(String[] args)
	{
		DefaultMutableTreeNode root = chooseComponent(generateRandomSensor(),generateRandomComponent(),THRESHOLD);
		
		Enumeration en = root.preorderEnumeration();
		while(en.hasMoreElements())
			System.out.println(en.nextElement() + "\n");
	}
	
	/**
	 * Generates a random number between 1 and 4,
	 * inclusively. Each number corresponds to a
	 * sensor.
	 * 
	 * @return the randomly generated integer
	 */
	public static int generateRandomSensor()
	{
		return (int) Math.floor(((Math.random()*4+1)));
	}
	
	/**
	 * Generates a random number between 1 and 12,
	 * inclusively. Each number corresponds to a
	 * component.
	 * 
	 * @return the randomly generated integer
	 */
	public static int generateRandomComponent()
	{
		return (int) Math.floor(((Math.random()*12+1)));
	}
	
	/**
	 * A recursive method that will generate the nodes for the tree
	 * @param sensor The sensor number to be used
	 * @param component The component to be used
	 * @param threshold The threshold to be used
	 */
	public static DefaultMutableTreeNode chooseComponent(int sensor, int component, int threshold)
	{
		i++;
		String s = "";
		DefaultMutableTreeNode node = new DefaultMutableTreeNode();
		
		// 1 - Are We Close To Wall
		if(component == 1)
		{
			s = "Close to Wall: Sensor " + sensor + ", threshold " + threshold;
			node.setUserObject(s);
			tree.add(node);
			node.add(chooseComponent(generateRandomSensor(), generateRandomComponent(), THRESHOLD));
		}
		// 2 - While Too Far From Wall
		else if(component == 2)
		{
			s = "Far from Wall: Sensor " + sensor + ", threshold " + threshold;
			node.setUserObject(s);
			tree.add(node);
			node.add(chooseComponent(generateRandomSensor(), generateRandomComponent(), THRESHOLD));
		}
		// 3 - Do 2 Far From Wall
		else if(component == 3)
		{
			s = "Do Two Far Far: Sensor " + sensor + ", threshold " + threshold;
			node.setUserObject(s);
			tree.add(node);
			node.add(chooseComponent(generateRandomSensor(), generateRandomComponent(), THRESHOLD));
			node.add(chooseComponent(generateRandomSensor(), generateRandomComponent(), THRESHOLD));
		}
		// 4 - Do 2 Close To Wall
		else if(component == 4)
		{
			s = "Do Two Close Close: Sensor " + sensor + ", threshold " + threshold;
			node.setUserObject(s);
			tree.add(node);
			node.add(chooseComponent(generateRandomSensor(), generateRandomComponent(), THRESHOLD));
			node.add(chooseComponent(generateRandomSensor(), generateRandomComponent(), THRESHOLD));
		}
		// 5 - Do 2 Far Close
		else if(component == 5)
		{
			s = "Do Two Far Close: Sensor " + sensor + ", threshold " + threshold;
			node.setUserObject(s);
			tree.add(node);
			node.add(chooseComponent(generateRandomSensor(), generateRandomComponent(), THRESHOLD));
			node.add(chooseComponent(generateRandomSensor(), generateRandomComponent(), THRESHOLD));
		}
		// 6 - Do 2 Close Far
		else if(component == 6)
		{
			s = "Do Two Close Far: Sensor " + sensor + ", threshold " + threshold;
			node.setUserObject(s);
			tree.add(node);
			node.add(chooseComponent(generateRandomSensor(), generateRandomComponent(), THRESHOLD));
			node.add(chooseComponent(generateRandomSensor(), generateRandomComponent(), THRESHOLD));
		}
		// 7 - Go Forward
		else if(component == 7)
		{
			s = "Go Forward";
			node.setUserObject(s);
			tree.add(node);
		}
		// 8 - Turn Right
		else if(component == 8)
		{
			s = "Turn Right";
			node.setUserObject(s);
			tree.add(node);
		}
		// 9 - Turn Left
		else if(component == 9)
		{
			s = "Turn Left";
			node.setUserObject(s);
			tree.add(node);
		}
		// 10 - Backup
		else if(component == 10)
		{
			s = "Backup";
			node.setUserObject(s);
			tree.add(node);
		}
		// 11 - Turn Parallel to Position
		else if(component == 11)
		{
			s = "Turn Parallel To Wall";
			node.setUserObject(s);
			tree.add(node);
		}
		// 12 - Turn Square with Wall
		else if(component == 12)
		{
			s = "Turn Square with Wall";
			node.setUserObject(s);
			tree.add(node);
		}
		return node;
		
	}

}