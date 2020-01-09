package fr.ensisa.hassenforder.golfinettes.server.network;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import fr.ensisa.hassenforder.golfinettes.network.Protocol;
import fr.ensisa.hassenforder.golfinettes.server.model.Battery;
import fr.ensisa.hassenforder.golfinettes.server.model.Battery.BatteryMode;
import fr.ensisa.hassenforder.golfinettes.server.model.Event;
import fr.ensisa.hassenforder.golfinettes.server.model.Location;
import fr.ensisa.hassenforder.golfinettes.server.model.Usage;
import fr.ensisa.hassenforder.golfinettes.server.model.Usage.BorrowerEvent;
import fr.ensisa.hassenforder.golfinettes.server.model.Usage.UsageState;
import fr.ensisa.hassenforder.golfinettes.server.model.Version;
import fr.ensisa.hassenforder.network.BasicAbstractReader;

public class WifiReader extends BasicAbstractReader {

	private static String versionCode;
	private List<Event> events;
	private static Version version;
	private long id;
	private String kind;
	
	public WifiReader(InputStream inputStream) {
		super (inputStream);
	}

	public void receive() {
		type = readInt ();
		switch (type) {
		case 0 : break;
		case Protocol.SEND_UPDATE:
			System.out.println("send update");
			version = this.readVersion();
			System.out.println(this.getVersion());
			break;
		case Protocol.RQ_UPDATE:
			versionCode = this.readVersionCode();
		}
	}

	public String getVersionCode() {
		return versionCode;
	}

	public List<Event> getEvents() {
		return events;
	}

	public Version getVersion() {
		return version;
	}

	public long getId() {
		return id;
	}

	public String getKind() {
		return kind;
	}
	
	public Version readVersion() {
		String versionCode = this.readString();
//		System.out.println(versionCode);
		String fileContent1 = this.readString();
//		System.out.println(fileContent1);
		int n = this.readInt();
		byte[] fileContent2 = new byte[n];
		for (int i = 0 ; i < n ; i++) {
			fileContent2[i] = this.readByte();
//			System.out.println(i);
		}
		return new Version(versionCode, fileContent1, fileContent2);
	}
	
	public String readVersionCode() {
		return this.readString();
	}

}
