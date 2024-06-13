package com.veiculo.vagas_microservice.request_response;


public class EntryExitResponse {

    private String entryExitId;
    private boolean success;
    private String message;

    // getters and setters

    public String getEntryExitId() {
        return entryExitId;
    }

    public void setEntryExitId(String entryExitId) {
        this.entryExitId = entryExitId;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}