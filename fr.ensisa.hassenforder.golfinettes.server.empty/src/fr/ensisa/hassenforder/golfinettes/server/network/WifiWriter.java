package fr.ensisa.hassenforder.golfinettes.server.network;

import java.io.OutputStream;
import java.util.Collection;
import java.util.List;

import fr.ensisa.hassenforder.golfinettes.network.Protocol;
import fr.ensisa.hassenforder.golfinettes.server.model.Event;
import fr.ensisa.hassenforder.golfinettes.server.model.Golfinette;
import fr.ensisa.hassenforder.golfinettes.server.model.Version;
import fr.ensisa.hassenforder.network.BasicAbstractWriter;

public class WifiWriter extends BasicAbstractWriter {

	public WifiWriter(OutputStream outputStream) {
		super (outputStream);
	}

	public void writeVersion(Version version) {
		this.writeInt(Protocol.RP_UPDATE);
		this.writeString(version.getVersion());
		this.writeString(version.getFileContent1());
		this.writeInt(version.getFileContent2().length);
		for (byte b : version.getFileContent2()) {
			this.writeByte(b);
		}
	}

}
