package deakin.edu.au.sarms;

import javax.swing.SwingUtilities;

import deakin.edu.au.sarms.accounts.mysql.AccountRepository;
import deakin.edu.au.sarms.guis.LoginGUI;
import deakin.edu.au.sarms.mysql.Connect;
import deakin.edu.au.sarms.mysql.QueryExecutor;
import deakin.edu.au.sarms.units.mysql.UnitRepository;

/**
 * 
 * @author Tom Hoogstra - SIT215123867 (21/05/2017)
 *
 */

public class Main 
{
	public static boolean started;
	
    public static void main( String[] args )
    {
        new Connect();
        new QueryExecutor();
        
        loadDatabase();
        
        while(!started){
        	try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
        
        SwingUtilities.invokeLater(() -> new LoginGUI());
        
    }
    
    public static void loadDatabase(){
    	  AccountRepository.loadUsers();
          UnitRepository.loadUnits();
          
    }
}
