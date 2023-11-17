package com.iti.jwt;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import jakarta.servlet.ServletException;

@RestControllerAdvice
public class JwtExceptionHandler {

    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<String> handleExpiredJwtException(ExpiredJwtException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body("Token has expired");
    }

    @ExceptionHandler({MalformedJwtException.class, SignatureException.class})
    public ResponseEntity<String> handleInvalidJwtException(Exception e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body("Invalid token");
    }

    @ExceptionHandler(ServletException.class)
    public ResponseEntity<String> handleOtherExceptions(Exception e) {
        // Handle other unexpected exceptions
    	System.out.println("exception is"+e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Token is Required for getting data.");
    }
    
    
}


