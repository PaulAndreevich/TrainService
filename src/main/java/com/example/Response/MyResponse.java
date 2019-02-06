package com.example.Response;

public class MyResponse {
    private Boolean success;
    private String message;
    private Long id;

    public MyResponse(Boolean success, Long id, String message) {
        this.success = success;
        this.message = message;
        this.id = id;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
