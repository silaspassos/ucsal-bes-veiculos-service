package com.veiculo.vagas_microservice.servicos;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
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
}
