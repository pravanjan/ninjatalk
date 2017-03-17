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

import v0.com.ninja.datamodel.NinjaDAO;


@RunWith(PowerMockRunner.class)

@PrepareForTest ({TalkHelper.class,NinjaDAO.class})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class NinjaHelperTest {
	
	
	@BeforeClass	
	public static void setup() {
	}

	@Test
	public void atestwithmokitoSpy() {
		final TalkHelper  talk = spy(new TalkHelper());
		doReturn("Dont call me agina... ..... ").when(talk).getTalk("pravanjan");
		NinjaHelper helper = new NinjaHelper();
		assertEquals("Dont call me agina... .....",helper.getTalk(talk, "pravanjan"));
	}
	
	@Test
	public void btestwithmokito() {
		
		final TalkHelper  talk = spy(new TalkHelper());
		when(talk.getTalk("pravanjan")).thenReturn("hi");
		
		NinjaHelper helper = new NinjaHelper();
		assertEquals("hi",helper.getTalk(talk, "pravanjan"));
	}
	
	@Test
	public void ctestpowerMoktio() {
		PowerMockito.mockStatic(TalkHelper.class);
		PowerMockito.when(TalkHelper.getTalkStatic(any(String.class))).thenReturn("pravanjan");
		assertEquals("pravanjan",NinjaHelper.getTalk("pravanjan"));

	}
	@Test
	public void dtestDAO() {
		PowerMockito.mockStatic(NinjaDAO.class);
		PowerMockito.when(NinjaDAO.getSpeaker((any(String.class)))).the;
		assertEquals("pravanjan",NinjaHelper.getTalk("pravanjan"));

	}
	
}
