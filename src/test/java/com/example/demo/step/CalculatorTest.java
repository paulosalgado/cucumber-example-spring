package com.example.demo.step;

import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import com.example.demo.CalculatorController;
import static org.hamcrest.Matchers.equalTo;

import cucumber.api.java.Before;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class CalculatorTest {

	private MockMvc mockMvc;
	private MvcResult response;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(CalculatorController.class).build();
	}

	@Given("^I have a calculator$")
	public void i_have_a_calculator() {
		response = null;
	}

	@When("^I add (-?\\d+) and (-?\\d+)$")
	public void i_add_and(int arg1, int arg2) throws Throwable {
		response = mockMvc.perform(get("/add?value1=" + arg1 + "&value2=" + arg2)).andDo(print()).andReturn();
	}

	@Then("^the result should be (-?\\d+)$")
	public void the_result_should_be(int arg1) throws Throwable {
		assertThat(Integer.valueOf(response.getResponse().getContentAsString()), equalTo(arg1));
	}

}
