package com.maven.rest.myrest.it;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.servlet.ServletContextHandler.Context;
import org.junit.*;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses(TestScenarios1.class)
public class IntegrationSuite {

	private static Server server = null;
	private static ServletContextHandler ctx = null;
	
	@BeforeClass
	public static void setup() throws Exception{
		server = new Server(8123);
		ctx = new ServletContextHandler(ServletContextHandler.SESSIONS);
		ctx.setContextPath("/myrest");
		ServletHolder servletHolder = ctx.addServlet(org.glassfish.jersey.servlet.ServletContainer.class, "/*");
		servletHolder.setInitOrder(0);
		servletHolder.setInitParameter("jersey.config.server.provider.packages", "com.maven.rest.myrest");
		server.setHandler(ctx);
		server.start();
		Thread.sleep(Integer.valueOf(System.getProperty("delay")));
	}
	
	@AfterClass
	public static void teardown() throws Exception{
		server.stop();
	}
}
