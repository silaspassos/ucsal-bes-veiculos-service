package com.veiculo.vagas_microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.veiculo.vagas_microservice.request_response.EntryExitRequest;
import com.veiculo.vagas_microservice.request_response.EntryExitResponse;
import com.veiculo.vagas_microservice.request_response.ParkingSpotResponse;
import com.veiculo.vagas_microservice.request_response.PaymentRequest;
import com.veiculo.vagas_microservice.request_response.PaymentResponse;
import com.veiculo.vagas_microservice.servicos.EntryExitService;
import com.veiculo.vagas_microservice.servicos.ParkingSpotService;
import com.veiculo.vagas_microservice.servicos.PaymentService;

@SpringBootApplication
public class VagasMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VagasMicroserviceApplication.class, args);
		   try {
	            ParkingSpotService parkingSpotService = new ParkingSpotService();
	            ParkingSpotResponse response = parkingSpotService.getParkingSpot();
	            System.out.println("Spot Name: " + response.getSpotName());
	            System.out.println("Capacity: " + response.getCapacity());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
    try {
        PaymentService paymentService = new PaymentService();
        PaymentRequest request = new PaymentRequest();
        request.setCardNumber("1234567890123456");
        request.setCardHolderName("John Doe");
        request.setExpirationDate("12/2022");
        request.setCvv("123");
        PaymentResponse response = paymentService.makePayment(request);
        System.out.println("Transaction ID: " + response.getTransactionId());
        System.out.println("Success: " + response.isSuccess());
        System.out.println("Message: " + response.getMessage());
    } catch (Exception e) {
        e.printStackTrace();
    }
    try {
        EntryExitService entryExitService = new EntryExitService();
        EntryExitRequest request = new EntryExitRequest();
        request.setUserId("123456789");
        request.setEntryExitType("entry");
        EntryExitResponse response = entryExitService.registerEntryExit(request);
        System.out.println("EntryExit ID: " + response.getEntryExitId());
        System.out.println("Success: " + response.isSuccess());
        System.out.println("Message: " + response.getMessage());
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}

