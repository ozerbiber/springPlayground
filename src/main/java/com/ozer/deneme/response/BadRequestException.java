package com.ozer.deneme.response;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)

public class BadRequestException extends RuntimeException {
    public BadRequestException(String e){
        super(e);
    }

}
