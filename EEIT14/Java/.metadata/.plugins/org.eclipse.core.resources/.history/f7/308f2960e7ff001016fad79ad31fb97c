package tw.brad.listener;

import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;
import jakarta.servlet.annotation.WebListener;
/*
 * WebApp
 */
@WebListener
public class AttritubteListener implements ServletContextAttributeListener {
    public void attributeReplaced(ServletContextAttributeEvent scae)  { 
    	String name = scae.getName();
    	Object obj = scae.getValue();
    	System.out.println("replace: " + name + ":" + obj);
    }

    public void attributeRemoved(ServletContextAttributeEvent scae)  { 
    }

    public void attributeAdded(ServletContextAttributeEvent scae)  { 
    	String name = scae.getName();
    	Object obj = scae.getValue();
    	System.out.println(name + ":" + obj);
    }
	
}