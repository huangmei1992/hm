package com.hm.testdata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ReadCSVUtils {
	
	public static void main(String[] args) {
		Object[][] o = getPlainCSVData("ecshopLoginTestData.csv");
		for(int i = 0; i<o.length; i++){
			for(int j = 0; j<o[1].length; j++){
				System.out.print(o[i][j]+"\t");
			}
			System.out.println();//每输完一行打个回车,这边打印出来如果有乱码的话，则下面读取的方法有误
		}
	}
	public static Object[][] getPlainCSVData(String filename){
		Object[][] objs = null;
		InputStream is = ReadCSVUtils.class.getClassLoader().getResourceAsStream(filename);//输入流
		BufferedReader br = new BufferedReader(new InputStreamReader(is));//里面的参数放的是字符流，但is是个字节流，所以要把字节流转化为字符流
		String line = null;
		//读出来的是一行值
		try {
			line = br.readLine();
			List<Object[]> list = new ArrayList<>();
			//不为空就往下读一行
			while((line = br.readLine()) != null){
				list.add(ParseData(line.split(",")));//用逗号分割
			}
			
			//转换为Object
			int size = list.size();
			objs = new Object[size][];
			for(int i = 0; i < size; i++){
				objs[i] = list.get(i);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				br.close();
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return objs;
	}
	
	
	//数据解析:如果是double类型的值
	private static Object[] ParseData(String[] strData){
		Object[] objs = new Object[strData.length];
		for(int i = 0;i < objs.length; i++){
			try{
				double tmp = Double.parseDouble(strData[i]);
				objs[i] = DataParse.double2int(tmp);
			}catch(NumberFormatException e){
				if(strData[i].equalsIgnoreCase("true")||strData[i].equalsIgnoreCase("false")){
					objs[i] = Boolean.parseBoolean(strData[i]);
				}else{
					objs[i] = strData[i];
				}
			}
		}
		return objs;
	}
	
}
