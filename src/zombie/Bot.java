package zombie;
import java.net.InetAddress;
public class Bot {
	private String id;
	private Status status;
	private String ccInitPassword;
	private String ccInitURL;
	private int sleepCycle;
	private int sleepRandomness;
	private InetAddress publicIP;
	
	public Bot(){
		status = new Init();
		ccInitPassword="234123Abcfg";
		ccInitURL="https://example.com";
		sleepCycle = 10;
		sleepRandomness = 5;
		publicIP = null;
		
	}
	
	public void generateID(){
		//@TODO 
	}
}
