package zombie;
import java.net.InetAddress;
import java.io.*;
import java.net.UnknownHostException;
public class HostDetail {
	
	public String os;
	public String osVersion;
	public String osArch;
	public String upTime;
	public String hostName;
	public String ip;
	public String macAddress;
	
	public HostDetail(){
		os=System.getProperty("os.name");
		osVersion = System.getProperty("os.version");
		osArch = System.getProperty("osArch");
		
		if(os.toUpperCase()!="WINDOWS"){
			try{
				upTime = Helper.captureCmdResult("uptime");
			}
			catch (Exception e){
				e.printStackTrace();
			}
		}
		else{
			try{
				upTime = Helper.captureCmdResult("net stats srv");
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		try{
			getHostName();
			getIPAddress();
			getMacAddress();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	private void getHostName() throws UnknownHostException{
		hostName=InetAddress.getLocalHost().getHostName();
	}
	
	private void getIPAddress() throws UnknownHostException{
		InetAddress addresses[] = InetAddress.getAllByName(hostName);
		for(InetAddress address: addresses){
			if(!address.isLoopbackAddress()&&address.isSiteLocalAddress()){
				if(ip==null){
					ip=address.getHostAddress();
				}
				else{
					ip+=address.getHostAddress()+"|";
				}
			}
		}
	}
	
	private void getMacAddress() throws IOException{
		if(osVersion.toUpperCase()!="WINDOWS")
			macAddress = Helper.captureCmdResult("ifconfig -a | grep ether").split("ether")[1];
	}
}
