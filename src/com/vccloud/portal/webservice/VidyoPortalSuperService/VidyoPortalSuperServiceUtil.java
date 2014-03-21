package com.vccloud.portal.webservice.VidyoPortalSuperService;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.apache.axis2.AxisFault;
import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.axis2.transport.http.HttpTransportProperties.Authenticator;
import org.apache.log4j.Logger;

import com.vccloud.portal.exception.CallVidyoWebServiceException;
import com.vccloud.portal.util.CommonUtil;
import com.vccloud.portal.webservice.VidyoPortalSuperService.VidyoPortalSuperServiceStub.EntityID;
import com.vccloud.portal.webservice.VidyoPortalSuperService.VidyoPortalSuperServiceStub.GetTenantDetailsRequest;
import com.vccloud.portal.webservice.VidyoPortalSuperService.VidyoPortalSuperServiceStub.GetTenantDetailsResponse;
import com.vccloud.portal.webservice.VidyoPortalSuperService.VidyoPortalSuperServiceStub.IntHolder;
import com.vccloud.portal.webservice.VidyoPortalSuperService.VidyoPortalSuperServiceStub.ListTenantsRequest;
import com.vccloud.portal.webservice.VidyoPortalSuperService.VidyoPortalSuperServiceStub.ListTenantsResponse;
import com.vccloud.portal.webservice.VidyoPortalSuperService.VidyoPortalSuperServiceStub.SingleTenantDataType;
import com.vccloud.portal.webservice.VidyoPortalSuperService.VidyoPortalSuperServiceStub.TenantDataExtType;
import com.vccloud.portal.webservice.VidyoPortalSuperService.VidyoPortalSuperServiceStub.TenantNamePattern;
import com.vccloud.portal.webservice.VidyoPortalSuperService.VidyoPortalSuperServiceStub.UpdateTenantRequest;
import com.vccloud.portal.webservice.VidyoPortalSuperService.VidyoPortalSuperServiceStub.UpdateTenantResponse;

public class VidyoPortalSuperServiceUtil {

	private static Logger logger = Logger
			.getLogger(VidyoPortalSuperServiceUtil.class);

	private static VidyoPortalSuperServiceStub createStub(String portalURL,
			String username, String password) throws AxisFault {
		try {
			VidyoPortalSuperServiceStub stub = null;
			if (CommonUtil.isNullOrEmpty(portalURL)) {
				stub = new VidyoPortalSuperServiceStub();
			} else {
				if (portalURL.endsWith("/")) {
					portalURL = portalURL.substring(0, portalURL.length() - 1);
				}
				if (portalURL.toLowerCase().startsWith("http://")) {
					stub = new VidyoPortalSuperServiceStub(portalURL
							+ "/services/VidyoPortalSuperService/");
				} else {
					stub = new VidyoPortalSuperServiceStub("http://"
							+ portalURL + "/services/VidyoPortalSuperService/");
				}
			}
			List<String> authSchemes = new ArrayList<String>();
			authSchemes.add(Authenticator.BASIC);
			Authenticator authenticator = new Authenticator();
			authenticator.setAuthSchemes(authSchemes);
			authenticator.setUsername(username);
			authenticator.setPassword(password);
			authenticator.setPreemptiveAuthentication(true);
			stub._getServiceClient().getOptions().setProperty(
					HTTPConstants.AUTHENTICATE, authenticator);
			return stub;
		} catch (AxisFault e) {
			logger.error("", e);
			throw e;
		}
	}

	private static void clearStub(VidyoPortalSuperServiceStub stub)
			throws AxisFault {
		if (stub != null) {
			try {
				stub._getServiceClient().cleanupTransport();
				stub._getServiceClient().cleanup();
				stub.cleanup();
				stub = null;
			} catch (AxisFault e) {
				logger.error("", e);
				throw e;
			}
		}
	}

	public static TenantDataExtType getTenantDetails(String portalURL,
			String portalName, String portalPassword, int tenantID)
			throws CallVidyoWebServiceException {
		try {
			VidyoPortalSuperServiceStub stub = createStub(portalURL,
					portalName, portalPassword);

			GetTenantDetailsRequest request = new GetTenantDetailsRequest();
			EntityID entityID = new EntityID();
			entityID.setEntityID(tenantID);
			request.setTenantId(entityID);
			GetTenantDetailsResponse response = stub.getTenantDetails(request);

			clearStub(stub);
			return response.getTenantDetail();
		} catch (AxisFault e) {
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (RemoteException e) {
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (GeneralFaultException e) {
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (InvalidTenantFaultException e) {
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		}
	}

	public static boolean updateTenantName(String portalURL, String portalName,
			String portalPassword, int tenantID, String tenantName)
			throws CallVidyoWebServiceException {
		TenantDataExtType tenant = getTenantDetails(portalURL, portalName,
				portalPassword, tenantID);
		if (tenant == null) {
			return false;
		}

		try {
			VidyoPortalSuperServiceStub stub = createStub(portalURL,
					portalName, portalPassword);

			UpdateTenantRequest request = new UpdateTenantRequest();
			TenantNamePattern pattern = new TenantNamePattern();
			pattern.setTenantNamePattern(tenantName);
			tenant.setTenantName(pattern);
			request.setTenantData(tenant);
			UpdateTenantResponse response = stub.updateTenant(request);

			clearStub(stub);
			return "OK".equalsIgnoreCase(response.getOK().getValue());
		} catch (AxisFault e) {
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (RemoteException e) {
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (NotLicensedFaultException e) {
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (InvalidArgumentFaultException e) {
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (GeneralFaultException e) {
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (ExistingTenantFaultException e) {
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (InvalidTenantFaultException e) {
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		}
	}

	public static SingleTenantDataType[] getListOfTenants(String portalURL,
			String portalName, String portalPassword)
			throws CallVidyoWebServiceException {
		try {
			VidyoPortalSuperServiceStub stub = createStub(portalURL,
					portalName, portalPassword);

			ListTenantsRequest request = new ListTenantsRequest();
			IntHolder limit = new IntHolder();
			limit.setIntHolder(Integer.MAX_VALUE);
			request.setLimit(limit);
			ListTenantsResponse response = stub.getListOfTenants(request);

			clearStub(stub);
			return response.getTenant();
		} catch (AxisFault e) {
			logger
					.error("==================> VidyoPortalSuperServiceUtil.getListOfTenants() caught exception, [ portalURL: "
							+ portalURL
							+ ", portalName: "
							+ portalName
							+ ", portalPassword: " + portalPassword + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (RemoteException e) {
			logger
					.error("==================> VidyoPortalSuperServiceUtil.getListOfTenants() caught exception, [ portalURL: "
							+ portalURL
							+ ", portalName: "
							+ portalName
							+ ", portalPassword: " + portalPassword + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (GeneralFaultException e) {
			logger
					.error("==================> VidyoPortalSuperServiceUtil.getListOfTenants() caught exception, [ portalURL: "
							+ portalURL
							+ ", portalName: "
							+ portalName
							+ ", portalPassword: " + portalPassword + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		}
	}

}
