package zombie;
import java.net.InetAddress;
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
			//upTime = Tool.runCmd('uptime');
		}
		else{
			//upTime = Tool.rundCmd("net stats srv");
		}
		try{
			getHostName();
			getIPAddress();
			
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
}
