package SapTest03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import java.util.TreeMap;

public class CalcTask implements Task {
	//private String path ;
	private ConcurrentHashMap<String,Integer> wordsMap =  new ConcurrentHashMap<String,Integer>();
	
	@Override
	public ConcurrentHashMap<String, Integer> execute(File f) {
		// TODO Auto-generated method stub
		File file = new File(f.getAbsolutePath());
		String line = null;
		if(!file.exists()){
			return null;
		}else{
			
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				try {
					//line = br.readLine();
					
					while((line = br.readLine()) != null){
						line = line.toLowerCase();//ignore case
						//������Ӣ�Ķ��źͿո�ָ���
						String[] words = line.split(",|��|\\s+");
						for(String str :words){
							//ֻ������ĸ���ַ����ż���
							if (str.matches("^[A-Za-z]+$")){   
								if( wordsMap.containsKey(str)){   //exsits already
									wordsMap.put(str, wordsMap.get(str).intValue()+1);
								}else{
									wordsMap.put(str, 1);
								}
							}											
						}
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
						
			return  wordsMap;
		}
	}

}
