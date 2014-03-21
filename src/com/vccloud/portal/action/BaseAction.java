package com.vccloud.portal.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.axiom.util.base64.Base64Utils;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.util.HtmlUtils;

import com.vccloud.portal.constant.Constants;
import com.vccloud.portal.util.CommonUtil;

public abstract class BaseAction extends Action {

	protected static Logger logger = Logger.getLogger(BaseAction.class);

	protected static JSONObject RESULT_OK = new JSONObject();
	protected static JSONObject RESULT_ERR_SYS = new JSONObject();
	protected static JSONObject RESULT_ERR_PARAMS_INVALID = new JSONObject();
	protected static JSONObject RESULT_ERR_LOGIN_REQUIRED = new JSONObject();
	protected static JSONObject RESULT_ERR_MEMBER_ROLE_REQUIRED = new JSONObject();
	protected static JSONObject RESULT_ERR_TENANT_ROLE_REQUIRED = new JSONObject();
	protected static JSONObject RESULT_ERR_AUTHN_FAILED = new JSONObject();
	protected static JSONObject RESULT_ERR_FILE_TYPE_INVALID = new JSONObject();
	protected static JSONObject RESULT_ERR_FILE_SIZE_EXCEEDED = new JSONObject();
	protected static JSONObject RESULT_ERR_LOGO_SIZE_EXCEEDED = new JSONObject();
	protected static JSONObject RESULT_ERR_OPERATION_REJECTED = new JSONObject();
	protected static JSONObject RESULT_ERR_VIDYO = new JSONObject();
	protected static JSONObject RESULT_ERR_PASSWORD_NOT_MATCHES = new JSONObject();
	protected static JSONObject RESULT_ERR_DUPLICATE_LEGACY_NAME = new JSONObject();
	protected static JSONObject RESULT_ERR_DUPLICATE_ROOM_NAME = new JSONObject();
	protected static JSONObject RESULT_ERR_DUPLICATE_ROOM_EXTENSION = new JSONObject();
	static {
		RESULT_OK.put("result", "ok");
		RESULT_ERR_SYS.put("result", "err_sys");
		RESULT_ERR_PARAMS_INVALID.put("result", "err_params_invalid");
		RESULT_ERR_LOGIN_REQUIRED.put("result", "err_login_required");
		RESULT_ERR_MEMBER_ROLE_REQUIRED.put("result",
				"err_member_role_required");
		RESULT_ERR_TENANT_ROLE_REQUIRED.put("result",
				"err_tenant_role_required");
		RESULT_ERR_AUTHN_FAILED.put("result", "err_authn_failed");
		RESULT_ERR_FILE_TYPE_INVALID.put("result", "err_file_type_invalid");
		RESULT_ERR_FILE_SIZE_EXCEEDED.put("result", "err_file_size_exceeded");
		RESULT_ERR_LOGO_SIZE_EXCEEDED.put("result", "err_logo_size_exceeded");
		RESULT_ERR_OPERATION_REJECTED.put("result", "err_operation_rejected");
		RESULT_ERR_VIDYO.put("result", "err_vidyo");
		RESULT_ERR_PASSWORD_NOT_MATCHES.put("result",
				"err_password_not_matches");
		RESULT_ERR_DUPLICATE_LEGACY_NAME.put("result",
				"err_duplicate_legacy_name");
		RESULT_ERR_DUPLICATE_ROOM_NAME.put("result", "err_duplicate_room_name");
		RESULT_ERR_DUPLICATE_ROOM_EXTENSION.put("result",
				"err_duplicate_room_extension");
	}

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		long startTime = System.currentTimeMillis();
		try {
			return doAction(mapping, form, request, response);
		} catch (Throwable t) {
			logger.error("Got throwable in " + this.getClass(), t);
			return null;
		} finally {
			long costTime = System.currentTimeMillis() - startTime;
			if (costTime > 1000) {
				logger.warn(request.getServletPath() + " cost " + costTime
						+ " ms. =========== check my cost ========= ");
			} else {
				logger.debug(request.getServletPath() + " cost " + costTime
						+ " ms.");
			}
		}
	}

	@SuppressWarnings("unchecked")
	public ActionForward doAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Throwable {
		JSONObject result = new JSONObject();

		String encode = request.getCharacterEncoding();
		response.setCharacterEncoding(encode);
		// To resolve IE session lost (cross-domain + ajax).
		response
				.setHeader(
						"P3P",
						"CP=CURa ADMa DEVa PSAo PSDo OUR BUS UNI PUR INT DEM STA PRE COM NAV OTC NOI DSP COR");

		Map<String, String> params = new HashMap<String, String>();
		List<DiskFileItem> diskFiles = new ArrayList<DiskFileItem>();

		try {
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			if (isMultipart) {
				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				upload.setHeaderEncoding(encode);

				long fileSizeMax = Constants.FileUploadParams.MAX_SIZE;
				// If fileSizeMax == 0, not limit of file size.
				if (fileSizeMax > 0) {
					upload.setFileSizeMax(Constants.FileUploadParams.MAX_COUNT
							* fileSizeMax);
					// upload.setSizeMax(Constants.FileUploadParams.MAX_COUNT *
					// fileSizeMax);
				}

				List<DiskFileItem> items = null;
				try {
					items = upload.parseRequest(request);
				} catch (Exception e) {
					logger
							.error(
									"Can't parse upload files, maybe files size out of limit.",
									e);
					writeBack(request, response, params,
							RESULT_ERR_PARAMS_INVALID);
					return null;
				}

				if (!CommonUtil.isNullOrEmpty(items)) {
					for (DiskFileItem item : items) {
						if (item.isFormField()) {
							String key = item.getFieldName();
							String value = StringUtils.trim(item
									.getString(encode));
							value = CommonUtil.decode(value, "utf-8");
							value = CommonUtil.decode(value, "utf-8");
							value = HtmlUtils.htmlEscape(value);
							params.put(key, value);
						} else {
							diskFiles.add(item);
						}
					}
				}

			} else {
				Enumeration<String> paramNames = request.getParameterNames();
				if (paramNames != null) {
					while (paramNames.hasMoreElements()) {
						String key = paramNames.nextElement();
						String value = StringUtils.trim(request
								.getParameter(key));
						value = CommonUtil.decode(value, "utf-8");
						value = CommonUtil.decode(value, "utf-8");
						value = HtmlUtils.htmlEscape(value);
						params.put(key, value);
					}
				}
			}
			request.setAttribute("params", params);

			if (isAuthnRequired() && !isLogon(request)) {
				writeBack(request, response, params, RESULT_ERR_LOGIN_REQUIRED);
				return null;
			} else if (isMemberRoleRequired() && !isMember(request)) {
				writeBack(request, response, params,
						RESULT_ERR_MEMBER_ROLE_REQUIRED);
				return null;
			} else if (isTenantRoleRequired() && !isTenant(request)) {
				writeBack(request, response, params,
						RESULT_ERR_TENANT_ROLE_REQUIRED);
				return null;
			} else if (!validateInputs(params)) {
				writeBack(request, response, params, RESULT_ERR_PARAMS_INVALID);
				return null;
			} else {
				result = doApiAction(request, response, params, diskFiles);
			}

		} catch (Throwable t) {
			logger.error("Got throwable in api " + request.getServletPath(), t);
			writeBack(request, response, params, RESULT_ERR_SYS);
			return null;
		}

		logger.debug("Request " + request.getServletPath() + ", response: "
				+ result.toString());
		writeBack(request, response, params, result);
		return null;
	}

	private boolean isLogon(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			JSONObject json = (JSONObject) session.getAttribute("isLogon");
			if (json != null) {
				String domain = getDomain(request);
				boolean isLogon = false;
				try {
					isLogon = json.getBoolean(domain);
				} catch (Throwable e) {
					// ignore.
				}
				if (isLogon) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean isMember(HttpServletRequest request) {
		long memberId = getMemberId(request);
		if (memberId > 0) {
			return true;
		}
		return false;
	}

	private boolean isTenant(HttpServletRequest request) {
		long tenantId = getTenantId(request);
		if (tenantId > 0) {
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	protected String getDomain(HttpServletRequest request) {
		Map<String, String> params = (Map<String, String>) request
				.getAttribute("params");
		return params.get("domain");
	}

	protected long getMemberId(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			JSONObject json = (JSONObject) session.getAttribute("memberId");
			if (json != null) {
				String domain = getDomain(request);
				long memberId = 0;
				try {
					memberId = json.getLong(domain);
				} catch (Throwable e) {
					// ignore.
				}
				if (memberId > 0) {
					return memberId;
				}
			}
		}
		return 0;
	}

	protected long getTenantId(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			JSONObject json = (JSONObject) session.getAttribute("tenantId");
			if (json != null) {
				String domain = getDomain(request);
				long tenantId = 0;
				try {
					tenantId = json.getLong(domain);
				} catch (Throwable e) {
					// ignore.
				}
				if (tenantId > 0) {
					return tenantId;
				}
			}
		}
		return 0;
	}

	private void writeBack(HttpServletRequest request,
			HttpServletResponse response, Map<String, String> params,
			JSONObject json) throws IOException {
		if (CommonUtil.isNullOrEmpty(params)) {
			String requestURL = request.getRequestURL().toString();
			String callbackURL = CommonUtil.contactURL(requestURL, "json", json
					.toString());
			response.sendRedirect(callbackURL);
			return;
		}
		String client = params.get("client");
		if ("callback".equals(client)) {
			String callbackURL = params.get("callbackURL");
			String encodedJson = Base64Utils.encode(json.toString().getBytes(
					"utf-8"));
			String callbackURL2 = CommonUtil.contactURL(callbackURL, "json",
					encodedJson);
			response.sendRedirect(callbackURL2);
		} else if ("jsonp".equals(client)) {
			writeJsonP(request, response, json);
		} else if ("json".equals(client)) {
			writeJson(request, response, json);
		} else {
			writeJson(request, response, json);
		}
	}

	private void writeJsonP(HttpServletRequest request,
			HttpServletResponse response, JSONObject json) throws IOException {
		String output = request.getParameter("callback") + "(" + json + ");";
		response.setContentType("text/javascript");
		response.getWriter().println(output);
	}

	private void writeJson(HttpServletRequest request,
			HttpServletResponse response, JSONObject json) throws IOException {
		String output = json.toString();
		response.setContentType("application/json");
		response.getWriter().println(output);
	}

	protected boolean isAuthnRequired() {
		return true;
	}

	protected boolean isMemberRoleRequired() {
		return false;
	}

	protected boolean isTenantRoleRequired() {
		return false;
	}

	protected boolean validateInputs(Map<String, String> params) {
		return true;
	}

	public abstract JSONObject doApiAction(HttpServletRequest request,
			HttpServletResponse response, Map<String, String> params,
			List<DiskFileItem> diskFiles) throws Throwable;

}
