package cn.hdtmedia.conf;

public class AppConf {

	// private final String HOST="http://10.10.4.96:8088";
	// private final String HOST2="http://10.10.4.96:8088/hdt-report";

	private static String hostName = null;

	public static void setHostName(String host) {
		hostName = host;
	}

	public static String getHostName() {
		return hostName;
	}

	// private final String HOST2="http://10.10.4.96:8088/hdt-report";

}
