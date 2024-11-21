package com.muminat.Employee_management_system.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ApiResponse <T>{

    private  String responseMessage;

    private T responseData;
}
