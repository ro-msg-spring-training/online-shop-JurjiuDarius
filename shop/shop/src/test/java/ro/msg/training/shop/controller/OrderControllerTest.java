package ro.msg.training.shop.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ro.msg.training.shop.dto.order.OrderDetailDTO;
import ro.msg.training.shop.dto.order.OrderReadDTO;

import java.util.ArrayList;

@Profile("test")
@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
public class OrderControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testOrderCreationSuccess() throws Exception {
		
		String uri = "/order";
		ObjectMapper mapper = new ObjectMapper();
		
		String inputJson = mapper.writeValueAsString(initialiseOrderDTO());
		
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
		
		assert (result.getResponse().getStatus() == 200);
		assert (result.getResponse().getContentAsString().contains("\"customerId\":1"));
		assert (result.getResponse().getContentAsString().contains("\"country\":\"Romania\""));
		assert (result.getResponse().getContentAsString().contains("\"city\":\"Deva\""));
		assert (result.getResponse().getContentAsString().contains("\"county\":\"Hunedoara\""));
	}
	
	@Test
	public void testOrderCreationFailure() throws Exception {
		String uri = "/order";
		ObjectMapper mapper = new ObjectMapper();
		OrderReadDTO orderReadDTO = initialiseOrderDTO();
		orderReadDTO.getOrderDetails().get(0).setQuantity(100000);
		String inputJson = mapper.writeValueAsString(orderReadDTO);
		
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
		assert (result.getResponse().getStatus() == 400);
	}
	
	private OrderReadDTO initialiseOrderDTO() throws Exception {
		OrderReadDTO orderReadDTO = new OrderReadDTO();
		orderReadDTO.setCity("Deva");
		orderReadDTO.setCounty("Hunedoara");
		orderReadDTO.setCountry("Romania");
		orderReadDTO.setStreetAddress("Cuza Voda nr. 7");
		orderReadDTO.setCustomerId(1);
		OrderDetailDTO detailDTO = new OrderDetailDTO();
		detailDTO.setProductId(1);
		detailDTO.setQuantity(1);
		orderReadDTO.setOrderDetails(new ArrayList<OrderDetailDTO>());
		orderReadDTO.getOrderDetails().add(detailDTO);
		
		return orderReadDTO;
	}
	
}