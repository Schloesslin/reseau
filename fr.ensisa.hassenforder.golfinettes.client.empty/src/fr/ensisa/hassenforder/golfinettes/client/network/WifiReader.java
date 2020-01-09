package fr.ensisa.hassenforder.golfinettes.client.network;

import java.io.InputStream;

import fr.ensisa.hassenforder.golfinettes.client.model.Version;
import fr.ensisa.hassenforder.golfinettes.network.Protocol;
import fr.ensisa.hassenforder.network.BasicAbstractReader;

public class WifiReader extends BasicAbstractReader {

	private Version version;

	public WifiReader(InputStream inputStream) {
		super(inputStream);
	}

	public void receive() {
		type = readInt();
		version = null;
		switch (type) {
		case Protocol.RP_UPDATE:
			this.version = this.readVersion();
			break;
		}
	}

	public Version getVersion() {
		return version;
	}

	public Version readVersion() {
		String versionCode = this.readString();
		System.out.println(versionCode);
		String fileContent1 = this.readString();
		System.out.println(fileContent1);
		int n = this.readInt();
		byte[] fileContent2 = new byte[n];
		for (int i = 0 ; i < n ; i++) {
			fileContent2[i] = this.readByte();
		}
		return new Version(versionCode, fileContent1, fileContent2);
	}
}
