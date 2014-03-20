package cn.hdtmedia.report.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class AppContextListener implements ServletContextListener {

	
	@Override
	public void contextDestroyed(ServletContextEvent event) {		
		System.out.println("----------afdsjfalsdjf----------------------------");		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		
		System.out.println("afdsjfalsdjf----------------------------");
		
//		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
//		System.out.println(request);
		
	}

}
