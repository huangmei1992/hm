/**读取数据库的数据
 * 2017-8-26 周六 上午10：00-12：00
 * 
 * 
 */

package com.hm.testdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReadDatabaseUtils {
	
	public static void main(String[] args) {
		//String className = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql:///cloud5?characterEncoding=UTF8&serverTimezone=CST&useSSL=false";//cloud5为数据库名
		String username = "root";
		String password = "";
		String tableName = "calctestdata";
		Object[][] objs = getDataFromDB(url, username, password, tableName);
		for(int i = 0; i < objs.length; i++) {
			for(int j = 0; j < objs[i].length; j++) {
				System.out.print(objs[i][j]+"\t");
			}
			System.out.println();//每输完一行回车
		}
	}
	
	public static Object[][] getDataFromDB(String url,
			String username,String password,String tableName){
		Object[][] objs = null;
		/*try {
			Class.forName(className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}*/
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(url,username,password);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from "+tableName);//SQL语句
			int cols = rs.getMetaData().getColumnCount();//获取有多少列，为下面的getObject做准备
			//由于不知道数据库里有几行数据，所以要做以下操作			
			List<Object[]> list = new ArrayList<>();
			while(rs.next()){
				Object[] o = new Object[cols];
				for(int i = 0; i < cols; i++)
					o[i] = rs.getObject(i+1);//不管是String、还是Int类型，用getObject都可以取出来，不用判断，但需要判断有多少列的数据,i为列数
				list.add(o);//将取到的值放入list集合中去
			}
			int size = list.size();
			objs = new Object[size][]; 
			for(int i = 0; i < size; i++){
				objs[i] = list.get(i);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {		
				e.printStackTrace();
			}
		}
		return objs;
	}

}
