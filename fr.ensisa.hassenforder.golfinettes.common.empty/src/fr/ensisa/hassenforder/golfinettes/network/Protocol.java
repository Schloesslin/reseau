package fr.ensisa.hassenforder.golfinettes.network;

public class Protocol {

    public static final int GOLFINETTES_SIGFOX_PORT = 6666;
    public static final int GOLFINETTES_WIFI_PORT	= 7777;

    // left to help you (or not)
	public static final int SIGFOX_STD				= 0x01;
	
	public static final int RQ_UPDATE = 0x01;
	public static final int SEND_UPDATE = 0x02;
	
	public static final int RP_UPDATE = 0x101;
}
