package com.example.httpcall;

import java.util.ArrayList;

public class DataModel {

    String Status ;
    String Message;
    ArrayList<DataResult>  Result;

    public void setStatus(String status) {
        Status = status;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public void setResult(ArrayList<DataResult> result) {
        Result = result;
    }

    public String getStatus() {
        return Status;
    }

    public String getMessage() {
        return Message;
    }

    public ArrayList<DataResult> getResult() {
        return Result;
    }
}
