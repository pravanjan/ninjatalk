package v0.com.ninja.datamodel;

import static org.junit.Assert.assertEquals;

import javax.jdo.PersistenceManager;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import v0.com.ninja.jdo.Speaker;
import v0.com.ninja.util.LocalUnitTestServer;
import v0.com.ninja.util.PersistenceManagerUtil;

public class NinjaDAOTest {
	
    @BeforeClass
	public static void setupTest(){
    	LocalUnitTestServer.setUpConfiguration("datastore");
    	Speaker speaker = new Speaker();
    	speaker.setId("kshdfsh023e328238");
    	speaker.setName("pravanjan");
    	PersistenceManager pm = PersistenceManagerUtil.getPersistanceManager();
    	pm.makePersistent(speaker);
    
		
	}

	@Test
	public void test() {
		System.out.println("The requst of the call "+NinjaDAO.getSpeaker("pravanjan"));
		assertEquals("pravanjan",NinjaDAO.getSpeaker("pravanjan").getName());
	}
	
	@AfterClass
    public static void runOnceAfterClass() {
    	LocalUnitTestServer.tearDownConfiguration("datastore");
    }

}
