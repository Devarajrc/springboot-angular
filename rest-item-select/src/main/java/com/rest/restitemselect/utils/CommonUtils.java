package com.rest.restitemselect.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.restitemselect.constants.StatusCode;
import com.rest.restitemselect.responses.ErrorObject;
import com.rest.restitemselect.responses.Response;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

public class CommonUtils {

	static ObjectMapper mapper = new ObjectMapper();
	private static final Logger logger = LoggerFactory.getLogger(CommonUtils.class);

	public static String getJson(Object obj) {
		try {
			mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
			mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
			return mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			logger.error("getJsonResponse:Error in json processing: ", e);
		}
		return "";
	}

	public static Response getResponseObject(String message) {
		Response response = new Response();
		response.setStatus(StatusCode.SUCCESS.name());
		response.setMessage(message);
		return response;
	}

	public static ErrorObject getErrorResponse(String title, String detail) {
		ErrorObject errorObject = new ErrorObject();
		errorObject.setTitle(title);
		errorObject.setDetail(detail);
		return errorObject;
	}

}
