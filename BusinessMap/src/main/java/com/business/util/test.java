package com.business.util;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.business.system.controller.IdxController;
 
public class test {
	    public static String doPostOrGet(String pathUrl, String data){
	        OutputStreamWriter out = null;
	        BufferedReader br = null;
	        //Map dicts = new HashMap();
	        String result = "";
	        try {
	            URL url = new URL(pathUrl);
	            //open the connection 
	            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	            //request method: POST
	            conn.setRequestMethod("POST");
	            //conn.setRequestMethod("GET");
 
	            //Some basic configuration
	            conn.setRequestProperty("accept", "*/*");
	            conn.setRequestProperty("connection", "Keep-Alive");
	            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
	            conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");
 
	           
	            conn.setDoOutput(true);
	            conn.setDoInput(true);
	            
	            //request from other interface
	            //get URLConnection object correspondingly output stream
	            out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
	            //request parameter
	            out.write(data);
	            //flush
	            out.flush();
 
	            //get URLConnection object correspondingly input stream
	            InputStream is = conn.getInputStream();
	            
	            //new a bufferedReader
	            br = new BufferedReader(new InputStreamReader(is));
	            String str = "";
	            while ((str = br.readLine()) != null){
	                result += str;
	            }	       
 
	            System.out.println(result);
	            System.out.println(result.getClass().getName());
	            //close the stream
	            is.close();

	            //cut off the connection
	            conn.disconnect();
	            return result ;
	            		
	        } catch (Exception e) {
	            e.printStackTrace();
	        }finally {
	            try {
	                if (out != null){
	                    out.close();
	                }
	                if (br != null){
	                    br.close();
	                }
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
			return result;
	    }

//	    //用来单独测试返回结果
//	    public static void main(String[] args) {
//
//
//	    	String URL_link = "http://127.0.0.1:5000/hello?place_name=";
//	    	String URL_name = "Westleigh Mezze Bar"; 
//	    	String urls = URL_link + URL_name;
//	    	String new_URL = urls.replace(" ", "%20");
//	    	//List<String> s = new ArrayList<> ();
//	    	
//	    	String s = doPostOrGet(new_URL, "");
//	    	String [] arr2 = s.split("#");
//	        System.out.println(s);
//	    	System.out.println(arr2);
//	    }
}
