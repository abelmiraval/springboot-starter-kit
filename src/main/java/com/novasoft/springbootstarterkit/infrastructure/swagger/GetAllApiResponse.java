package com.novasoft.springbootstarterkit.infrastructure.swagger;

import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Specific annotation for GET endpoints that return collections
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@BaseApiResponse
@ApiResponse(responseCode = "200", description = "Resources successfully retrieved")
public @interface GetAllApiResponse {
}
