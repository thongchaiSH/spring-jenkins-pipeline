package com.jenkins.app.model.base;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Data
@Slf4j
public class ReceivedResponseWithData<T> extends BaseResponse {
	
	private List<T> data;

	public ReceivedResponseWithData() {
	}

	public static <T> ReceivedResponseWithData<T> successMessage(List<T> data, StatusType statType) {
		ReceivedResponseWithData<T> response = new ReceivedResponseWithData<T>();
		response.setData(data);
		response.setStatus(statType.getStatus());
		response.setStatusCode(statType.getStatusCode());
		response.setMessage(statType.getMessage());
		log.info("successMessage="+response.getMessage());
		return response;
	}

	public static <T> ReceivedResponseWithData<T> failedMessage(StatusType statType) {
		ReceivedResponseWithData<T> response = new ReceivedResponseWithData<T>();
		response.setStatus(statType.getStatus());
		response.setStatusCode(statType.getStatusCode());
		response.setMessage(statType.getMessage());

		return response;
	}

	public static <T> ReceivedResponseWithData<T> missingFieldMessage(StatusType statType, String missingFieldName) {
		ReceivedResponseWithData<T> response = new ReceivedResponseWithData<T>();
		response.setStatus(statType.getStatus());
		response.setStatusCode(statType.getStatusCode());
		response.setMessage(statType.getMessage().concat(missingFieldName));

		return response;
	}
}
