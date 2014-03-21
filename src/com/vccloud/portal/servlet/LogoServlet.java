package com.vccloud.portal.servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.vccloud.portal.db.model.TPortalInfo;
import com.vccloud.portal.exception.ServiceException;
import com.vccloud.portal.service.ServiceLocator;
import com.vccloud.portal.service.VidyoService;
import com.vccloud.portal.util.UploadUtil;

@SuppressWarnings("serial")
public class LogoServlet extends HttpServlet {

	private Logger logger = Logger.getLogger(LogoServlet.class);

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long now = System.currentTimeMillis();
		String portalUrl = request.getParameter("portalUrl");

		try {
			response.reset();
			response.setContentType("image/jpeg");

			VidyoService vidyoService = ServiceLocator.getVidyoService();
			TPortalInfo portalInfo = vidyoService.getPortalInfo(portalUrl);
			String filePath = null;
			File file = null;
			if (portalInfo != null) {
				filePath = UploadUtil.getLogoFilePathByLogoUrl(portalInfo
						.getId(), portalInfo.getLogoUrl());
				file = new File(filePath);
			}
			if (file == null || !file.exists()) {
				String dir = request.getSession().getServletContext()
						.getRealPath("/");
				filePath = dir + "/images/default_logo.png";
				file = new File(filePath);
			}
			OutputStream output = response.getOutputStream();
			InputStream input = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(input);
			BufferedOutputStream bos = new BufferedOutputStream(output);
			byte data[] = new byte[4096];
			int size = bis.read(data);
			while (size != -1) {
				bos.write(data, 0, size);
				size = bis.read(data);
			}
			bis.close();
			input.close();
			bos.flush();
			bos.close();
			output.close();
			logger.debug("LogoServlet costs "
					+ (System.currentTimeMillis() - now) + " ms.");
		} catch (ServiceException e) {
			logger.error("", e);
		} catch (Exception e) {
			logger.error("", e);
		}
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
