package cn.hdtmedia.conf;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.beans.factory.InitializingBean;

public class HdtReportInitBean implements InitializingBean {

	@Override
	public void afterPropertiesSet() throws Exception {
		
		//System.out.println("-----------afterPropertiesSet");

		this.init();
	}

	private void init() {
		
		System.out.println("-----------init");
		
//		InputStream inputStream = null;
//
//		try {
//			inputStream = this.getClass().getClassLoader()
//					.getResourceAsStream("configInfo.properties");
//			Properties properties = new Properties();
//			properties.load(inputStream);
//			
//			String host=properties.getProperty("hdt.host.name");
//			
//			AppConf.setHostName(host);
//			
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}finally{
//			if(inputStream!=null){
//				try {
//					inputStream.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}		
	}

}
