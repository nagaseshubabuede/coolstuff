package com.example.springboottesting.helper;

import com.example.springboottesting.model.Error;
import com.example.springboottesting.model.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ErrorResponseHelper {

    public ResponseEntity getBadRequestErrorResponse(String methodName, List<ErrorAttributes> errorAttributeList) {
        Error posError = new Error();
        posError.setCode(1023001);
        posError.setMessage("Your request is not formatted correctly");
        posError.setMethod(methodName);
        posError.setAttributes(errorAttributeList);
        posError.setVendor("naga app");
        posError.setStatus(HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(posError);
    }

}
