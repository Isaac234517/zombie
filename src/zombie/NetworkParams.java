package zombie;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sourceforge.jpcap.capture.*;
public class NetworkParams {
	public String primaryNetInterfaceName;
	public String primaryNetIP;
	public String primaryNetInterface;
	public String primaryNetSubnetMask;
	public String defaultGateWay;
	public String hostRoutes;
	public String domainName;
	public String hostFQDN;
	
	public NetworkParams(){
		try{
			String routesData = Helper.captureCmdResult("netstat -rn");
			String[]  routesDataArr = routesData.split("\n");
			for(String line: routesDataArr){
				if(line.indexOf("default") >=0){
					String[] valueArr = line.split("\\s+");
					for(String text: valueArr){
						Pattern reg = Pattern.compile("(?:[0-9]{1,3}.){3}[0-9]{1,3}");
						Matcher match = reg.matcher(text);
						if(match.matches()){
							defaultGateWay = match.group(0);
						}
					}
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
