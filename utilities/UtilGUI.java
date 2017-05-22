package deakin.edu.au.sarms.utilities;

import java.awt.Component;
import java.util.List;

import javax.swing.JPanel;

/**
 * 
 * @author Tom Hoogstra - SIT215123867 (23/05/2017)
 *
 */


public class UtilGUI {

	public static void togglePanel(JPanel panel, boolean enabled){
    	for(Component c : panel.getComponents()){
    		c.setEnabled(enabled);
    	}
    }
	
	 public static Object[] getList(List<?> list){
			return  list.toArray();
		}
	
}
