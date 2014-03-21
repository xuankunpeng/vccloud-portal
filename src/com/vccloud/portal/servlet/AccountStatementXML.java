package com.vccloud.portal.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.vccloud.portal.util.DBConnectionUtil;

/**
 * 
 * @author Created by Weijia, Li
 * @author Review and refactor by Wenjing, Xie
 * 
 */
@SuppressWarnings("serial")
public class AccountStatementXML extends HttpServlet {

	private Logger logger = Logger.getLogger(AccountStatementXML.class);

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String tenant = request.getParameter("tenant");
		String sortColumn = request.getParameter("sortColumn");
		String sortType = request.getParameter("sortType");
		String pageNum = request.getParameter("pageNum");
		String pageSize = request.getParameter("pageSize");
		String strXML = "";
		String strXMLHead = "";
		String strXMLEnd = "";
		String strXMLElements = "";
		String strXMLProperties = "";
		long totalDuration = 0;
		long totalDownloadTimes = 0;
		long startIndex = 0;
		long endIndex = 0;
		long rowIndex = 0;
		if (pageNum == null) {
			startIndex = 1;
		} else {
			startIndex = 1 + (Long.parseLong(pageNum) - 1)
					* Long.parseLong(pageSize);
		}
		if (pageSize == null) {
			endIndex = 999999999;
		} else {
			endIndex = Long.parseLong(pageNum) * Long.parseLong(pageSize);
		}

		String query = "select TenantName,CallerID,COUNT(*) AS Count,SUM(CEIL(TIMESTAMPDIFF(SECOND,JoinTime, LeaveTime)/60)) as Duration ,(Select Count(*) from ClientInstallations2 where ";
		if (tenant != null) {
			query += "Upper(ClientInstallations2.tenantName)=Upper('" + tenant
					+ "') AND ";
		}
		query += "ClientInstallations2.userName = ConferenceCall2.CallerID) as DOWNLOADTIMES FROM ConferenceCall2 where CallState='COMPLETED' AND ";
		if (tenant != null) {
			query += "Upper(ConferenceCall2.TenantName)=Upper('" + tenant
					+ "') AND ";
		}
		if (startDate != null) {
			query += "TIMESTAMPDIFF(DAY,'" + startDate + "',JoinTime)>=0 AND ";
		}
		if (endDate != null) {
			query += "TIMESTAMPDIFF(DAY,'" + endDate + "',JoinTime)<0 AND ";
		}
		query += "True=True GROUP BY CallerID";
		if (sortColumn != null) {
			query += " ORDER BY " + sortColumn + " ";
			if (sortType != null) {
				query += sortType;
			}
		}
		logger.debug("====== SQL: [" + query + "] ======");

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnectionUtil.openBusinessDBConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				rowIndex++;
				if (rowIndex >= startIndex && rowIndex <= endIndex) {
					strXMLElements += "<ELEMENT>";
					strXMLElements += "<ROWINDEX>" + rowIndex + "</ROWINDEX>";
					strXMLElements += "<TENANT>" + rs.getString(1)
							+ "</TENANT>";
					strXMLElements += "<CALLERID>" + rs.getString(2)
							+ "</CALLERID>";
					strXMLElements += "<COUNT>" + rs.getString(3) + "</COUNT>";
					strXMLElements += "<DURATION>" + rs.getString(4)
							+ "</DURATION>";
					strXMLElements += "<DOWNLOADTIMES>" + rs.getString(5)
							+ "</DOWNLOADTIMES>";
					strXMLElements += "</ELEMENT>";
				}
				totalDuration += Long.parseLong(rs.getString(4));
				totalDownloadTimes += Long.parseLong(rs.getString(5));
			}
			if (rowIndex < endIndex) {
				endIndex = rowIndex;
			}
			strXMLProperties = "<PROPERTIES><TOTAL>" + rowIndex
					+ "</TOTAL><STARTINDEX>" + startIndex
					+ "</STARTINDEX><ENDINDEX>" + endIndex
					+ "</ENDINDEX><TOTALDURATION>" + totalDuration
					+ "</TOTALDURATION><TOTALDOWNLOADTIMES>"
					+ totalDownloadTimes + "</TOTALDOWNLOADTIMES></PROPERTIES>";
		} catch (SQLException e) {
			logger.error("", e);
		} catch (Exception e) {
			logger.error("", e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				logger.error("", e);
			} catch (Exception e) {
				logger.error("", e);
			}
		}

		PrintWriter out = response.getWriter();
		strXMLHead = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";
		strXMLHead = strXMLHead + "<DATA>";
		strXMLEnd = strXMLEnd + "</DATA>";
		strXML = strXMLHead + strXMLProperties + strXMLElements + strXMLEnd;
		out.println(strXML);
		out.flush();
		out.close();
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
