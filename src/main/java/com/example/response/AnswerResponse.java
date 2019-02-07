package com.example.response;

public class AnswerResponse {
    private Boolean success;
    private String message;
    private Integer answer;

    public AnswerResponse(Boolean success, Integer result, String message) {
        this.success = success;
        this.answer = result;
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getAnswer() {
        return answer;
    }

    public void setAnswer(Integer answer) {
        this.answer = answer;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}