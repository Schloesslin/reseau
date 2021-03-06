package fr.ensisa.hassenforder.golfinettes.client.network;

import java.io.OutputStream;
import java.util.List;

import fr.ensisa.hassenforder.golfinettes.client.model.Battery;
import fr.ensisa.hassenforder.golfinettes.client.model.Event;
import fr.ensisa.hassenforder.golfinettes.client.model.Location;
import fr.ensisa.hassenforder.golfinettes.client.model.Usage;
import fr.ensisa.hassenforder.golfinettes.client.model.Version;
import fr.ensisa.hassenforder.golfinettes.network.Protocol;
import fr.ensisa.hassenforder.network.BasicAbstractWriter;

public class WifiWriter extends BasicAbstractWriter {

    public WifiWriter(OutputStream outputStream) {
        super(outputStream);
    }
    
    public void writeUpdate(String version) {
    	this.writeInt(Protocol.RQ_UPDATE);
    	if (version == null) {
    		this.writeString("");
    	} else {
    		this.writeString(version);
    	}
    }

}
