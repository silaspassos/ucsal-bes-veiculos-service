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
import com.veiculo.vagas_microservice.request_response.EntryExitRequest;
import com.veiculo.vagas_microservice.request_response.EntryExitResponse;

public class EntryExitService {
	private static final String SERVICE_URL = "http://localhost:8080/entry-exit";

	private CloseableHttpClient httpClient;
	private Gson gson;

	public EntryExitService() {
		httpClient = HttpClientBuilder.create().build();
		gson = new Gson();
	}

	public EntryExitResponse getEntryExit() throws Exception {
		HttpGet request = new HttpGet(SERVICE_URL);
		CloseableHttpResponse response = httpClient.execute(request);
		org.apache.http.HttpEntity entity = response.getEntity();
		String responseJson = EntityUtils.toString(entity);
		return gson.fromJson(responseJson, EntryExitResponse.class);
	}

	public EntryExitResponse registerEntryExit(EntryExitRequest request) throws Exception {
		HttpPost httpPost = new HttpPost(SERVICE_URL);
		StringEntity requestBody = new StringEntity(gson.toJson(request));
		httpPost.setEntity(requestBody);
		httpPost.setHeader("Content-type", "application/json");
		CloseableHttpResponse response = httpClient.execute(httpPost);
		HttpEntity entity = response.getEntity();
		String responseJson = EntityUtils.toString(entity);
		return gson.fromJson(responseJson, EntryExitResponse.class);
	}
}
