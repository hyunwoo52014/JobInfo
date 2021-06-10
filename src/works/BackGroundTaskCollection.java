package works;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskCollection {
	
	private ExecutorService ex;
	
	private TaskCollection() {
		this.ex = Executors.newCachedThreadPool();
	}
	
	
	protected static class TaskCollectionHolder {
		public static final TaskCollection INSTANCE = new TaskCollection();
	}
	
	public static TaskCollection getInstance() {
		return TaskCollectionHolder.INSTANCE;
	}

	public <T> boolean doTask(T threads) {
		
		return true;
	}
}