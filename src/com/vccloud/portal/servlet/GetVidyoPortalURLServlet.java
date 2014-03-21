package com.vccloud.portal.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.vccloud.portal.exception.ServiceException;
import com.vccloud.portal.service.ServiceLocator;
import com.vccloud.portal.service.VidyoService;
import com.vccloud.portal.util.CommonUtil;

@SuppressWarnings("serial")
public class GetVidyoPortalURLServlet extends HttpServlet {

	private Logger logger = Logger.getLogger(GetVidyoPortalURLServlet.class);

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long now = System.currentTimeMillis();
		String userPortalURL = request.getParameter("userPortalURL");

		try {
			response.reset();
			response.setContentType("text/plain");

			VidyoService vidyoService = ServiceLocator.getVidyoService();
			String vidyoPortalURL = vidyoService
					.getVidyoPortalURL(userPortalURL);
			vidyoPortalURL = CommonUtil.null2Empty(vidyoPortalURL);

			response.getWriter().println(vidyoPortalURL);
			logger.debug("GetVidyoPortalURLServlet costs "
					+ (System.currentTimeMillis() - now) + " ms.");
		} catch (ServiceException e) {
			logger.error("", e);
		}
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
