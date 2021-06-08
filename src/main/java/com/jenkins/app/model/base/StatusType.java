package com.jenkins.app.model.base;


public enum StatusType {
    success(0, "success", "OK"),
    db_conn_issue(1, "failed", "Database Connection Issue"),
    host_not_available(2, "failed", "Host Not Available / Fail To Reach Host"),
    internal_system_error(3, "failed", "Internal System Error / Null Pointer Exception"),
    api_obsolete(4, "failed", "API Obsolete And Not Longer Supported"),
    matching_data_not_found(5, "failed", "Data not found");

    private int statusCode;
    private String status;
    private String message;

    private StatusType(int statusCode, String status, String message) {
        this.statusCode = statusCode;
        this.status = status;
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }


    @Override
    public String toString() {
        return name();
    }
}
