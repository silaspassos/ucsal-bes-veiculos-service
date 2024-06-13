package com.veiculo.vagas_microservice.request_response;

public class EntryExitRequest {

    private String userId;
    private String entryExitType;

    // getters and setters

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEntryExitType() {
        return entryExitType;
    }

    public void setEntryExitType(String entryExitType) {
        this.entryExitType = entryExitType;
    }
}