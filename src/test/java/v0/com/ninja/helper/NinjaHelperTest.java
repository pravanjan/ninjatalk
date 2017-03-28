package v0.com.ninja.helper;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import v0.com.ninja.datamodel.NinjaDAO;
import v0.com.ninja.jdo.Speaker;


@RunWith(PowerMockRunner.class)

@PrepareForTest ({TalkHelper.class,NinjaDAO.class})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class NinjaHelperTest {
	
	static NinjaHelper helper = null;
	@BeforeClass	
	public static void setup() {
		helper = new NinjaHelper();
	}

	@Test
	public void atestwithmokitoSpy() {
		final TalkHelper  talk = spy(new TalkHelper());
		 doReturn("Dont call me agina").when(talk).getTalk("pravanjan");
		assertEquals("Hello pravanjan",helper.getTalk(talk, "pravanjan"));
	}
	
	@Test
	public void btestwithmokito() {
		
		final TalkHelper  talk = spy(new TalkHelper());
		when(talk.getTalk("pravanjan")).thenReturn("hi");
		
		NinjaHelper helper = new NinjaHelper();
		assertEquals("hi",NinjaHelper.getTalk("pravanjan"));
	}
	
	@Test
	public void ctestpowerMoktio() {
		PowerMockito.mockStatic(TalkHelper.class);
		PowerMockito.when(TalkHelper.getTalkStatic(any(String.class))).thenReturn("pravanjan");
		assertEquals("pravanjan",NinjaHelper.getTalk("pravanjan"));

	}
	@Test
	public void dtestDAO() {
		Speaker  speaker = new Speaker();
		speaker.setId("sdfsdfsfsf");
		speaker.setName("pravanjan");
		PowerMockito.mockStatic(NinjaDAO.class);
		PowerMockito.when(NinjaDAO.getSpeaker((any(String.class)))).thenReturn(speaker);
		assertEquals(true,helper.getSpeaker("pravanjan").get("status"));

	}
	@Test
	public void privateMethodtest() throws Exception {
		NinjaHelper truckSpy = PowerMockito.spy(helper);
		PowerMockito.doReturn("Okay pravanjan").when(truckSpy,"computeSpeaker","pravanjan");
		
		

	}
	
}
