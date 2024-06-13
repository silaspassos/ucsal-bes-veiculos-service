package com.veiculo.vagas_microservice.servicos;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.veiculo.vagas_microservice.request_response.ParkingSpotRequest;
import com.veiculo.vagas_microservice.request_response.ParkingSpotResponse;

public class ParkingSpotService {
	private static final String SERVICE_URL = "http://localhost:8080/parking-spot";

	private CloseableHttpClient httpClient;
	private Gson gson;

	public ParkingSpotService() {
		httpClient = HttpClientBuilder.create().build();
		gson = new Gson();
	}
	
	public ParkingSpotResponse getParkingSpot() throws Exception {
		HttpGet request = new HttpGet(SERVICE_URL);
		CloseableHttpResponse response = httpClient.execute(request);
		org.apache.http.HttpEntity entity = response.getEntity();
		String responseJson = EntityUtils.toString(entity);
		return gson.fromJson(responseJson, ParkingSpotResponse.class);
	}
	
	public ParkingSpotResponse makeParkingSpot(ParkingSpotRequest request) throws Exception {
		HttpPost httpPost = new HttpPost(SERVICE_URL);
		StringEntity requestBody = new StringEntity(gson.toJson(request));
		httpPost.setEntity(requestBody);
		httpPost.setHeader("Content-type", "application/json");
		CloseableHttpResponse response = httpClient.execute(httpPost);
		HttpEntity entity = response.getEntity();
		String responseJson = EntityUtils.toString(entity);
		return gson.fromJson(responseJson, ParkingSpotResponse.class);
	}
}
