package com.miniproject.nishi.OrderInventoryMiniProject.model.outbound;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class ErrorDetails {
    private Date timestamp;
    private String errorCode;
    private String message;
    private String path;
    private List<String> details;
    private Map<String, Object> errorData;

    public ErrorDetails() {}

    public ErrorDetails(Date timestamp, String errorCode, String message, List<String> details) {
        super();
        this.timestamp = timestamp;
        this.errorCode = errorCode;
        this.message = message;
        this.details = details;
    }

    public ErrorDetails(
            Date timestamp, String errorCode, String message, List<String> details, String path) {
        super();
        this.timestamp = timestamp;
        this.errorCode = errorCode;
        this.message = message;
        this.details = details;
        this.path = path;
    }

    public ErrorDetails(Date timestamp, String errorCode, String message) {
        super();
        this.timestamp = timestamp;
        this.errorCode = errorCode;
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }

    public List<String> getDetails() {
        return details;
    }

    public Map<String, Object> getErrorData() {
        return errorData;
    }

    public void setErrorData(Map<String, Object> errorData) {
        this.errorData = errorData;
    }

    @Override
    public String toString() {
        return "ErrorDetails{"
                + "timestamp="
                + timestamp
                + ", errorCode='"
                + errorCode
                + '\''
                + ", message='"
                + message
                + '\''
                + ", path='"
                + path
                + '\''
                + ", details="
                + details
                + '}';
    }
}
