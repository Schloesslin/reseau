package fr.ensisa.hassenforder.golfinettes.admin.network;

import java.io.OutputStream;

import fr.ensisa.hassenforder.golfinettes.admin.model.Version;
import fr.ensisa.hassenforder.golfinettes.network.Protocol;
import fr.ensisa.hassenforder.network.BasicAbstractWriter;

public class AdminWriter extends BasicAbstractWriter {

    public AdminWriter(OutputStream outputStream) {
        super(outputStream);
    }
    
    public void writeVersion(Version version) {
		this.writeInt(Protocol.SEND_UPDATE);
		this.writeString(version.getVersion());
		this.writeString(version.getFileContent1());
		this.writeInt(version.getFileContent2().length);
		for (byte b : version.getFileContent2()) {
			this.writeByte(b);
		}
	}

}
