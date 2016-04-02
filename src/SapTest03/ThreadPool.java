package SapTest03;

import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class ThreadPool extends ThreadGroup {
	public static List threads = new LinkedList();
	private TaskQueue queue;
	private List<File> fileList;
	public ThreadPool(TaskQueue queue){
		super("thread-Pool");
		this.queue = queue;
	}
	public synchronized void addWorderThread(List<File> fileList,CountDownLatch cdl){
		Thread t = new WorderThread(this,queue,fileList,cdl);
		threads.add(t);			
		t.start();
	}
	/*
	public synchronized void removeWorderThread(){
		if(threads.size() > 0){
			WorderThread t = (WorderThread)threads.remove(0);
			t.shutDown();
		}
	}
	public synchronized void currentStatus(){
		boolean flag = true;
		Iterator it = threads.iterator();
		while(it.hasNext()){
			WorderThread t = (WorderThread)it.next();
			if(t.isIdle()){
				t.shutDown();				
				flag = true;
			}else{
				flag = false;			
			}
		}
		if(flag == false){
			MainTest.udFlag = false;
		}else{
			MainTest.udFlag = true;
		}
	}
	*/
}
