package com.yaojian.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yaojian.model.User;
import com.yaojian.service.UserService;
import com.yaojian.utils.StringUtils;

@Controller
// @RequestMapping("/yuelianservice")
public class ServiceController {
	@Autowired
	private UserService userService;

	private static final String DEFAULT_ENCODING = "UTF-8";
	private static final String REQUEST_PARAMS_STRING = "_REQ";
	private static final String RESPONSE_PARAMS_STRING = "_RSP";
	private static final String MESSAGETYPE_PARAMS_STRING = "messagetype";
	private static final String VERSION_PARAMS_STRING = "version";
	private static final String RESULTCODE_PARAMS_STRING = "resultcode";
	private static final String RESULT_PARAMS_STRING = "result";
	private static final String PARAMS_STRING = "params";
	private static final String RESULTMESSAGE_PARAMS_STRING = "resultmessage";
	private static final String VERSION_STRING = "v1.0";
	private static final String MESSAGEERROR_RSP_STRING = "MESSAGE_ERROR_RSP";
	private static final String MESSAGEERROR_MESSAGE_STRING = "消息格式错误~";
	// 消息格式错误
	private static final String MESSAGEERROR_CODE_STRING = "0x000001";
	// 接口访问成功
	private static final String MESSAGEERROR_SUCCESS_CODE_STRING = "0x000000";
	// 用户存在
	private static final String MESSAGEERROR_USEREXISTS_CODE_STRING = "0x100001";
	// 未注册
	private static final String MESSAGEERROR_USERLONIN_CODE_STRING = "0x100002";
	// 登录失效
	private static final String MESSAGEERROR_USERLONIN_TIMEOUT_CODE_STRING = "0x100003";

	private static final String REGISTER_PARAMS_STRING = "REGISTER_REQ";
	private static final String LOGIN_PARAMS_STRING = "LOGIN_REQ";
	private static final String UPDATEUSER_PARAMS_STRING = "UPDATEUSER_REQ";

	@ResponseBody
	@RequestMapping("/service")
	public Map<String, Object> service(HttpServletRequest request,
			HttpServletResponse response) throws IllegalStateException,
			IOException {
		JSONObject resultJSONObject = getRequestParamsString(request);
		if (resultJSONObject == null) {
			return getResponseMessage(MESSAGEERROR_RSP_STRING,
					MESSAGEERROR_MESSAGE_STRING, VERSION_STRING,
					MESSAGEERROR_CODE_STRING, null);
		} else {
			String messageType = resultJSONObject
					.getString(MESSAGETYPE_PARAMS_STRING);
			if (messageType == null) {
				return getResponseMessage(MESSAGEERROR_RSP_STRING,
						MESSAGEERROR_MESSAGE_STRING, VERSION_STRING,
						MESSAGEERROR_CODE_STRING, null);
			} else {
				if (messageType.equals(REGISTER_PARAMS_STRING)) {
					// 注册逻辑
					return registerUser(resultJSONObject);
				} else if (messageType.equals(LOGIN_PARAMS_STRING)) {
					// 登录逻辑
					return login(resultJSONObject);
				} else if (messageType.equals(UPDATEUSER_PARAMS_STRING)) {
					// 登录逻辑
					return updateUser(resultJSONObject);
				}
			}
		}
		return null;
	}

	// 更新用户信息
	private Map<String, Object> updateUser(JSONObject jsonObject) {
		JSONObject paramsObject = jsonObject.getJSONObject(PARAMS_STRING);
		String token = paramsObject.getString("token");
		if (paramsObject == null || token == null || token.trim().length() == 0) {
			return getResponseMessage(MESSAGEERROR_RSP_STRING,
					MESSAGEERROR_MESSAGE_STRING, VERSION_STRING,
					MESSAGEERROR_CODE_STRING, null);
		} else {
			User tempUser = userService.findByToken(token);
			Map<String, Object> resultMap = null;
			String messageType = jsonObject
					.getString(MESSAGETYPE_PARAMS_STRING);
			String version = jsonObject.getString(VERSION_PARAMS_STRING);
			if (tempUser != null) {
				resultMap = new HashMap<String, Object>();
				if (paramsObject.has("address")) {
					tempUser.setAddress(paramsObject.getString("address"));
				}
				if (paramsObject.has("birthday")) {
					try {
						SimpleDateFormat format = new SimpleDateFormat(
								"yyyy-MM-dd HH:mm:dd");
						tempUser.setBirthday(paramsObject.getString("birthday")
								.trim().length() == 0 ? null
								: new java.sql.Date(format.parse(
										paramsObject.getString("birthday"))
										.getTime()));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				if (paramsObject.has("bloodtype")) {
					tempUser.setBloodtype(paramsObject.getInt("bloodtype"));
				}
				if (paramsObject.has("email")) {
					tempUser.setEmail(paramsObject.getString("email"));
				}
				if (paramsObject.has("headimageurl")) {
					tempUser.setHeadimageurl(paramsObject
							.getString("headimageurl"));
				}
				if (paramsObject.has("hobby")) {
					tempUser.setHobby(paramsObject.getString("hobby"));
				}
				if (paramsObject.has("nickname")) {
					tempUser.setNickname(paramsObject.getString("nickname"));
				}
				if (paramsObject.has("sex")) {
					tempUser.setSex(paramsObject.getInt("sex"));
				}
				tempUser.setUpdatedate(new Date(new java.util.Date().getTime()));
				userService.update(tempUser);
				return getResponseMessage(messageType, "成功", version,
						MESSAGEERROR_SUCCESS_CODE_STRING, null);
			} else {
				return getResponseMessage(messageType, "用户登录失效，请重新登录~",
						version, MESSAGEERROR_USERLONIN_TIMEOUT_CODE_STRING,
						resultMap);
			}
		}
	}

	//
	// private Map<String, Object> parseStudent(JSONObject jsonObject){
	//
	// return null;
	// }

	private Map<String, Object> login(JSONObject jsonObject) {
		JSONObject paramsObject = jsonObject.getJSONObject(PARAMS_STRING);
		if (paramsObject == null) {
			return getResponseMessage(MESSAGEERROR_RSP_STRING,
					MESSAGEERROR_MESSAGE_STRING, VERSION_STRING,
					MESSAGEERROR_CODE_STRING, null);
		} else {
			String username = paramsObject.getString("username");
			String password = paramsObject.getString("password");
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			User tempUser = userService.findByUser(user);
			Map<String, Object> resultMap = null;
			String messageType = jsonObject
					.getString(MESSAGETYPE_PARAMS_STRING);
			String version = jsonObject.getString(VERSION_PARAMS_STRING);
			if (tempUser != null) {
				resultMap = new HashMap<String, Object>();
				String token = StringUtils.getToken(username, password);
				tempUser.setToken(token);
				userService.update(tempUser);
				resultMap.put("token", token);
				resultMap.put("username", username);
				resultMap.put("password", password);
				return getResponseMessage(messageType, "成功", version,
						MESSAGEERROR_SUCCESS_CODE_STRING, resultMap);
			} else {
				return getResponseMessage(messageType, "未注册用户", version,
						MESSAGEERROR_USERLONIN_CODE_STRING, resultMap);
			}
		}
	}

	private Map<String, Object> registerUser(JSONObject jsonObject) {
		JSONObject paramsObject = jsonObject.getJSONObject(PARAMS_STRING);
		if (paramsObject == null) {
			return getResponseMessage(MESSAGEERROR_RSP_STRING,
					MESSAGEERROR_MESSAGE_STRING, VERSION_STRING,
					MESSAGEERROR_CODE_STRING, null);
		} else {
			String username = paramsObject.getString("username");
			String password = paramsObject.getString("password");
			Integer usertype = paramsObject.getInt("usertype");
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setUsertype(usertype);
			User tempUser = userService.findByUser(user);
			Map<String, Object> resultMap = null;
			String messageType = jsonObject
					.getString(MESSAGETYPE_PARAMS_STRING);
			String version = jsonObject.getString(VERSION_PARAMS_STRING);
			if (tempUser != null) {
				return getResponseMessage(messageType, "用户已存在", version,
						MESSAGEERROR_USEREXISTS_CODE_STRING, resultMap);
			} else {
				userService.save(user);
				return getResponseMessage(messageType, "成功", version,
						MESSAGEERROR_SUCCESS_CODE_STRING, resultMap);
			}
		}
	}

	private Map<String, Object> getResponseMessage(String messageTypeResponse,
			String resultMessage, String versionString, String resultCode,
			Map<String, Object> resultBody) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if (versionString == null) {
			resultMap.put(VERSION_PARAMS_STRING, VERSION_STRING);
		} else {
			resultMap.put(VERSION_PARAMS_STRING, versionString);
		}
		if (messageTypeResponse != null) {
			if (messageTypeResponse.contains(REQUEST_PARAMS_STRING)) {
				messageTypeResponse = messageTypeResponse.replaceAll(
						REQUEST_PARAMS_STRING, RESPONSE_PARAMS_STRING);
			} else {
				messageTypeResponse += RESPONSE_PARAMS_STRING;
			}
			resultMap.put(MESSAGETYPE_PARAMS_STRING, messageTypeResponse);
		} else {
			resultMap.put(MESSAGETYPE_PARAMS_STRING, MESSAGEERROR_RSP_STRING);
		}
		resultMap.put(RESULTCODE_PARAMS_STRING, resultCode);
		resultMap.put(RESULTMESSAGE_PARAMS_STRING, resultMessage);
		if (resultBody != null) {
			resultMap.put(RESULT_PARAMS_STRING, resultBody);
		}
		return resultMap;
	}

	private JSONObject getRequestParamsString(HttpServletRequest request) {
		// 取消对请求串的UTF-8编码，防止不同浏览器中发送请求时进行默认编码处理导致的转码失败
		JSONObject result = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		InputStream in = null;
		try {
			baos = new ByteArrayOutputStream();
			in = request.getInputStream();
			byte[] buffer = new byte[512];
			for (int len = 0; (len = in.read(buffer)) > 0;) {
				baos.write(buffer, 0, len);
			}
			String content = new String(baos.toByteArray(), DEFAULT_ENCODING);
			result = JSONObject.fromObject(content);
			baos.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (baos != null) {
					baos.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				baos = null;
				in = null;
			}
		}
		return result;
	}
}
