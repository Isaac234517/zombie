package zombie;
import java.util.*;
import java.io.*;
public class Helper {
	public static String captureCmdResult (String command) throws IOException{
		String result ="";
		String s;
		String[] commands ={
				"/bin/sh",
				"-c",
				command
		};
		Process p = Runtime.getRuntime().exec(commands);
		BufferedReader bf = new BufferedReader(new InputStreamReader(p.getInputStream()));
		while((s=bf.readLine())!=null){
			result+=s;
		}
		bf.close();
		return result;
		
	}
}
