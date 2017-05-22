package deakin.edu.au.sarms.mysql;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;

public class QueryExecutor {

	public static ConcurrentLinkedQueue<Query> queries = new ConcurrentLinkedQueue<>();

	public QueryExecutor(){
		
		/*
		 * If a query is available, it will submit one per second to the database
		 */
		Timer timer = new Timer();
		TimerTask queryTask = new TimerTask() {
			@Override
			public void run(){
				if(!queries.isEmpty()){
					Query q = queries.poll();
					q.execute();

				}
			}
		};
		
		timer.schedule(queryTask, 1000, 1000);

	}
	
	/**
	 * Adds a query to the queue for delayed execution
	 * @param q The statement
	 */
	public static void addQuery(String q){
		queries.add(new Query(q));
	}
	
	

}
