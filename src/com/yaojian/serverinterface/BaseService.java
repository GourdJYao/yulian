package com.yaojian.serverinterface;

import java.util.HashMap;

public abstract class BaseService {
	protected static final String RESPONSE_STRING="_RSP";
	protected static final String MESSAGE_TYPE_PARAMS_STRING="message_type";
	protected static final String VERSION_PARAMS_STRING="version";
	protected static final String RESULT_PARAMS_STRING="result";
	protected static final String VERSION_STRING="v1.0";
	
	
	protected HashMap<String,Object> resultMap=new HashMap<String,Object>();
	
	protected HashMap<String,Object> returnResponse(String messageType){
		resultMap.put(MESSAGE_TYPE_PARAMS_STRING, messageType);	
		resultMap.put(VERSION_PARAMS_STRING, VERSION_STRING);
		Object object=returnResult();
		
		if(object!=null){
			resultMap.put(RESULT_PARAMS_STRING, object);
		}
		
		return resultMap;
	}
	protected abstract Object returnResult();
	
}
