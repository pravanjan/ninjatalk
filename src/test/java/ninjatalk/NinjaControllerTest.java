package ninjatalk;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import v0.com.ninja.util.LocalUnitTestServer;



@RunWith(value=SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/resources/test-servlet.xml")
@FixMethodOrder(MethodSorters.DEFAULT)
public class NinjaControllerTest {
	@Autowired
	private WebApplicationContext wac;
	private MockMvc mockMvc;
	private MockMvc mockStandAlong;
	
	@Before
	public void setUp(){
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		LocalUnitTestServer.setUpConfiguration("datastore");
	}
	@After
	public void tearDown(){
		LocalUnitTestServer.tearDownConfiguration("datastore");
	}
	@Test
	public void savewishTest() throws Exception{
		System.out.println("inside test savewish method");
		this.mockMvc.perform(get("/ninja/getSpeaker/rajesh")).andExpect(status().is2xxSuccessful());
	
	}
	

}
