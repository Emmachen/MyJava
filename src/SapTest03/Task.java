package SapTest03;


import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

public interface Task {
	public ConcurrentHashMap<String, Integer> execute(File file);
}
