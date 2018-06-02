package com.fangyuan.myschool;

import com.alibaba.fastjson.JSONObject;
import com.fangyuan.myschool.comm.UserCreateReqData;
import com.fangyuan.myschool.comm.UserUpdateReqData;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
@Slf4j
public class MyschoolApplicationTests {

	MockMvc mvc;

	@Autowired
	WebApplicationContext webApplicationConnect;

	String expectedJson;

	@Before
	public void setUp() throws JsonProcessingException {
		mvc = MockMvcBuilders
				.webAppContextSetup(webApplicationConnect)
                .build();
	}

//	@Test
//	public void loginTest() throws Exception{
//		val mvcResult = mvc.perform(MockMvcRequestBuilders.post("/login")
//				.param("username", "13540305185")
//				.param("password", "password")
//				.accept(MediaType.APPLICATION_JSON))
//				.andReturn();
//		val status  = mvcResult.getResponse().getStatus();
//		val content = mvcResult.getResponse().getContentAsString();
//		log.info("login test completed!" + "status: " + status + ", result: " + content);
//	}

	@Test
	public void getUserTest() throws Exception {
        val mvcResult = mvc.perform(MockMvcRequestBuilders.get("/users")
                .accept(MediaType.APPLICATION_JSON))
                .andReturn();
        val status  = mvcResult.getResponse().getStatus();
        val content = mvcResult.getResponse().getContentAsString();
        log.info("get user test completed!" + "status: " + status + ", result: " + content);
	}

    @Test
    public void getUserInfoTest() throws Exception {
        val mvcResult = mvc.perform(MockMvcRequestBuilders.get("/users/1")
                .accept(MediaType.APPLICATION_JSON))
                .andReturn();
        val status  = mvcResult.getResponse().getStatus();
        val content = mvcResult.getResponse().getContentAsString();
        log.info("get user info test completed!" + "status: " + status + ", result: " + content);
    }

	@Test
	public void createUserTest() throws Exception {
		val user = new UserCreateReqData();
		user.setUsername("Test");
		user.setPassword("password");
		user.setPhone("13888888888");
		user.setTitle("TestTitle");
		user.setAddress("TestAddress");

		val mvcResult = mvc.perform(MockMvcRequestBuilders.post("/users")
				.contentType(MediaType.APPLICATION_JSON).content(JSONObject.toJSONString(user))
				.accept(MediaType.APPLICATION_JSON))
				.andReturn();
        val status  = mvcResult.getResponse().getStatus();
        val content = mvcResult.getResponse().getContentAsString();
        log.info("add user test completed!" + "status: " + status + ", result: " + content);
	}

    @Test
    public void deleteUserTest() throws Exception {
        val mvcResult = mvc.perform(MockMvcRequestBuilders.delete("/users/2")
                .accept(MediaType.APPLICATION_JSON))
                .andReturn();
        val status  = mvcResult.getResponse().getStatus();
        val content = mvcResult.getResponse().getContentAsString();
        log.info("delete user test completed!" + "status: " + status + ", result: " + content);
    }

    @Test
    public void updateUserTest() throws Exception {
        val user = new UserUpdateReqData();
        user.setUserId((long)3);
        user.setUsername("TestNew");
        user.setTitle("TestTitleNew");
        user.setAddress("TestAddressNew");
        val mvcResult = mvc.perform(MockMvcRequestBuilders.put("/users")
                .contentType(MediaType.APPLICATION_JSON).content(JSONObject.toJSONString(user))
                .accept(MediaType.APPLICATION_JSON))
                .andReturn();
        val status  = mvcResult.getResponse().getStatus();
        val content = mvcResult.getResponse().getContentAsString();
        log.info("update user test completed!" + "status: " + status + ", result: " + content);
    }
}
