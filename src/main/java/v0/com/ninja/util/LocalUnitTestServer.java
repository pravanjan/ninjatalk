package v0.com.ninja.util;


import org.apache.log4j.Logger;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalMemcacheServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.google.appengine.tools.development.testing.LocalTaskQueueTestConfig;




public class LocalUnitTestServer {
	private static final Logger logger = Logger.getLogger(LocalUnitTestServer.class.getPackage().getName());
	
	private static final LocalServiceTestHelper dataStoreHelper =  
	        new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());
	
	private  final LocalServiceTestHelper memcacheHelper =
		    new LocalServiceTestHelper(new LocalMemcacheServiceTestConfig());
	
	private static final LocalTaskQueueTestConfig.TaskCountDownLatch latchHelper = new LocalTaskQueueTestConfig.TaskCountDownLatch(1);
	
	private static final LocalServiceTestHelper taskQueryHelper = new LocalServiceTestHelper(new LocalTaskQueueTestConfig().setDisableAutoTaskExecution(false).
			setCallbackClass(LocalTaskQueueTestConfig.DeferredTaskCallback.class).setTaskExecutionLatch(latchHelper));
	
	
	  
	public  static void setUpConfiguration(String configurationType) {
		if(configurationType!=null && configurationType != ""){
			LocalUnitTestServer locatest = new LocalUnitTestServer();
			
			switch(configurationType){
			case "datastore":
				locatest.setUpDateSoreUnitTest();
				break;
			case "memcache":
				locatest.setUpMemcacheUnitTest();
				break;
			case "taskqueue":
				setupTaskQueueUnitTest();
				break;
				
			}
		}
		
		
	}
	
	public  static void tearDownConfiguration(String configurationType){
		if(configurationType!=null && configurationType != ""){
			LocalUnitTestServer locatest = new LocalUnitTestServer();

			switch(configurationType){
			case "datastore":
				locatest.tearDownUpDateSoreUnitTest();
				break;
			case "memcache":
				locatest.tearUpMemcacheUnitTest();
				break;
			case "taskQueue":
				tearTaskQueueUnitTest();
				break;
				
			}

			
		}
		
		
	}
	
	

	private static void tearTaskQueueUnitTest() {
		latchHelper.reset();

		taskQueryHelper.tearDown();

		
	}

	private  void tearUpMemcacheUnitTest() {
		memcacheHelper.tearDown();          
		
	}

	private  void tearDownUpDateSoreUnitTest() {
		dataStoreHelper.tearDown();  
		
	}

	private static void setupTaskQueueUnitTest(){ 
		
			logger.info("The setupTask queue ");
			taskQueryHelper.setUp();


	
		
		

		
	}

	private  void setUpMemcacheUnitTest() {
		logger.info("The memcache queue ");

		memcacheHelper.setUp();          
		
	}

	private  void setUpDateSoreUnitTest() {
		dataStoreHelper.setUp();          
		
	}
	

}
