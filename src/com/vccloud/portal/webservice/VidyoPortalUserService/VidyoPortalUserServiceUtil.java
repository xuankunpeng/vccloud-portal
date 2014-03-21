package com.vccloud.portal.webservice.VidyoPortalUserService;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.apache.axis2.AxisFault;
import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.axis2.transport.http.HttpTransportProperties.Authenticator;
import org.apache.log4j.Logger;

import com.vccloud.portal.exception.CallVidyoWebServiceException;
import com.vccloud.portal.util.CommonUtil;
import com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.EntityID;
import com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.EntityType_type0;
import com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.Entity_type0;
import com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.Filter_type0;
import com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.GetParticipantsRequest;
import com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.GetParticipantsResponse;
import com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.InviteToConferenceRequest;
import com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.InviteToConferenceRequestChoice_type0;
import com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.InviteToConferenceResponse;
import com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.LeaveConferenceRequest;
import com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.LeaveConferenceResponse;
import com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.SearchByEmailRequest;
import com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.SearchByEmailResponse;
import com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.SearchRequest;
import com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.SearchResponse;

public class VidyoPortalUserServiceUtil {

	private static Logger logger = Logger
			.getLogger(VidyoPortalUserServiceUtil.class);

	private static VidyoPortalUserServiceStub createStub(String portalURL,
			String username, String password) throws AxisFault {
		try {
			VidyoPortalUserServiceStub stub = null;
			if (CommonUtil.isNullOrEmpty(portalURL)) {
				stub = new VidyoPortalUserServiceStub();
			} else {
				if (portalURL.endsWith("/")) {
					portalURL = portalURL.substring(0, portalURL.length() - 1);
				}
				if (portalURL.toLowerCase().startsWith("http://")) {
					stub = new VidyoPortalUserServiceStub(portalURL
							+ "/services/v1_1/VidyoPortalUserService/");
				} else {
					stub = new VidyoPortalUserServiceStub("http://" + portalURL
							+ "/services/v1_1/VidyoPortalUserService/");
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

	private static void clearStub(VidyoPortalUserServiceStub stub)
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

	public static Entity_type0[] searchPublicRooms(String portalURL,
			String username, String password)
			throws CallVidyoWebServiceException {
		try {
			VidyoPortalUserServiceStub stub = createStub(portalURL, username,
					password);

			SearchRequest request = new SearchRequest();
			Filter_type0 filter = new Filter_type0();
			filter.setEntityType(EntityType_type0.Room);
			request.setFilter(filter);
			SearchResponse response = stub.search(request);
			clearStub(stub);
			return response.getEntity();
		} catch (AxisFault e) {
			logger
					.error("==================> VidyoPortalUserServiceUtil.searchPublicRooms() caught exception1, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: " + password + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (RemoteException e) {
			logger
					.error("==================> VidyoPortalUserServiceUtil.searchPublicRooms() caught exception2, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: " + password + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (NotLicensedFaultException e) {
			logger
					.error("==================> VidyoPortalUserServiceUtil.searchPublicRooms() caught exception3, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: " + password + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (InvalidArgumentFaultException e) {
			logger
					.error("==================> VidyoPortalUserServiceUtil.searchPublicRooms() caught exception4, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: " + password + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (GeneralFaultException e) {
			logger
					.error("==================> VidyoPortalUserServiceUtil.searchPublicRooms() caught exception5, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: " + password + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (SeatLicenseExpiredFaultException e) {
			logger
					.error("==================> VidyoPortalUserServiceUtil.searchPublicRooms() caught exception6, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: " + password + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		}
	}

	public static Entity_type0[] searchLegacies(String portalURL,
			String username, String password, String query)
			throws CallVidyoWebServiceException {
		try {
			VidyoPortalUserServiceStub stub = createStub(portalURL, username,
					password);

			SearchRequest request = new SearchRequest();
			Filter_type0 filter = new Filter_type0();
			filter.setEntityType(EntityType_type0.Legacy);
			filter.setQuery(query);
			request.setFilter(filter);
			SearchResponse response = stub.search(request);

			clearStub(stub);
			return response.getEntity();
		} catch (AxisFault e) {
			logger
					.error("==================> VidyoPortalUserServiceUtil.searchLegacies() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", query: "
							+ query
							+ " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (RemoteException e) {
			logger
					.error("==================> VidyoPortalUserServiceUtil.searchLegacies() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", query: "
							+ query
							+ " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (NotLicensedFaultException e) {
			logger
					.error("==================> VidyoPortalUserServiceUtil.searchLegacies() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", query: "
							+ query
							+ " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (InvalidArgumentFaultException e) {
			logger
					.error("==================> VidyoPortalUserServiceUtil.searchLegacies() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", query: "
							+ query
							+ " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (GeneralFaultException e) {
			logger
					.error("==================> VidyoPortalUserServiceUtil.searchLegacies() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", query: "
							+ query
							+ " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (SeatLicenseExpiredFaultException e) {
			logger
					.error("==================> VidyoPortalUserServiceUtil.searchLegacies() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", query: "
							+ query
							+ " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		}
	}

	public static boolean inviteToConference(String portalURL, String username,
			String password, EntityID conferenceID, EntityID entityID,
			String extention) throws CallVidyoWebServiceException {
		try {
			VidyoPortalUserServiceStub stub = createStub(portalURL, username,
					password);

			InviteToConferenceRequest request = new InviteToConferenceRequest();
			request.setConferenceID(conferenceID);
			InviteToConferenceRequestChoice_type0 choice = new InviteToConferenceRequestChoice_type0();
			choice.setEntityID(entityID);
			choice.setInvite(extention);
			request.setInviteToConferenceRequestChoice_type0(choice);
			InviteToConferenceResponse response = stub
					.inviteToConference(request);

			clearStub(stub);
			return "OK".equalsIgnoreCase(response.getOK().getValue());
		} catch (AxisFault e) {
			logger
					.error("==================> VidyoPortalUserServiceUtil.inviteToConference() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", conferenceID: "
							+ conferenceID.getEntityID()
							+ ", entityID: "
							+ entityID.getEntityID()
							+ ", extention: "
							+ extention + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (RemoteException e) {
			logger
					.error("==================> VidyoPortalUserServiceUtil.inviteToConference() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", conferenceID: "
							+ conferenceID.getEntityID()
							+ ", entityID: "
							+ entityID.getEntityID()
							+ ", extention: "
							+ extention + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (NotLicensedFaultException e) {
			logger
					.error("==================> VidyoPortalUserServiceUtil.inviteToConference() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", conferenceID: "
							+ conferenceID.getEntityID()
							+ ", entityID: "
							+ entityID.getEntityID()
							+ ", extention: "
							+ extention + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (InvalidArgumentFaultException e) {
			logger
					.error("==================> VidyoPortalUserServiceUtil.inviteToConference() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", conferenceID: "
							+ conferenceID.getEntityID()
							+ ", entityID: "
							+ entityID.getEntityID()
							+ ", extention: "
							+ extention + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (GeneralFaultException e) {
			logger
					.error("==================> VidyoPortalUserServiceUtil.inviteToConference() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", conferenceID: "
							+ conferenceID.getEntityID()
							+ ", entityID: "
							+ entityID.getEntityID()
							+ ", extention: "
							+ extention + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (ControlMeetingFaultException e) {
			logger
					.error("==================> VidyoPortalUserServiceUtil.inviteToConference() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", conferenceID: "
							+ conferenceID.getEntityID()
							+ ", entityID: "
							+ entityID.getEntityID()
							+ ", extention: "
							+ extention + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (SeatLicenseExpiredFaultException e) {
			logger
					.error("==================> VidyoPortalUserServiceUtil.inviteToConference() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", conferenceID: "
							+ conferenceID.getEntityID()
							+ ", entityID: "
							+ entityID.getEntityID()
							+ ", extention: "
							+ extention + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		}
	}

	public static boolean leaveConference(String portalURL, String username,
			String password, EntityID conferenceID, EntityID participantID)
			throws CallVidyoWebServiceException {
		try {
			VidyoPortalUserServiceStub stub = createStub(portalURL, username,
					password);

			LeaveConferenceRequest request = new LeaveConferenceRequest();
			request.setConferenceID(conferenceID);
			request.setParticipantID(participantID);
			LeaveConferenceResponse response = stub.leaveConference(request);

			clearStub(stub);
			return "OK".equalsIgnoreCase(response.getOK().getValue());
		} catch (AxisFault e) {
			logger
					.error("==================> VidyoPortalUserServiceUtil.leaveConference() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", conferenceID: "
							+ conferenceID.getEntityID()
							+ ", participantID: "
							+ participantID.getEntityID() + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (RemoteException e) {
			logger
					.error("==================> VidyoPortalUserServiceUtil.leaveConference() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", conferenceID: "
							+ conferenceID.getEntityID()
							+ ", participantID: "
							+ participantID.getEntityID() + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (NotLicensedFaultException e) {
			logger
					.error("==================> VidyoPortalUserServiceUtil.leaveConference() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", conferenceID: "
							+ conferenceID.getEntityID()
							+ ", participantID: "
							+ participantID.getEntityID() + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (InvalidArgumentFaultException e) {
			logger
					.error("==================> VidyoPortalUserServiceUtil.leaveConference() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", conferenceID: "
							+ conferenceID.getEntityID()
							+ ", participantID: "
							+ participantID.getEntityID() + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (GeneralFaultException e) {
			logger
					.error("==================> VidyoPortalUserServiceUtil.leaveConference() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", conferenceID: "
							+ conferenceID.getEntityID()
							+ ", participantID: "
							+ participantID.getEntityID() + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (ControlMeetingFaultException e) {
			logger
					.error("==================> VidyoPortalUserServiceUtil.leaveConference() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", conferenceID: "
							+ conferenceID.getEntityID()
							+ ", participantID: "
							+ participantID.getEntityID() + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (SeatLicenseExpiredFaultException e) {
			logger
					.error("==================> VidyoPortalUserServiceUtil.leaveConference() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", conferenceID: "
							+ conferenceID.getEntityID()
							+ ", participantID: "
							+ participantID.getEntityID() + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		}
	}

	public static Entity_type0[] searchLegaciesByEmail(String portalURL,
			String username, String password, String email)
			throws CallVidyoWebServiceException {
		try {
			VidyoPortalUserServiceStub stub = createStub(portalURL, username,
					password);

			SearchByEmailRequest request = new SearchByEmailRequest();
			request.setEmailAddress(email);
			Filter_type0 filter = new Filter_type0();
			filter.setEntityType(EntityType_type0.Legacy);
			filter.setLimit(Integer.MAX_VALUE);
			request.setFilter(filter);
			SearchByEmailResponse response = stub.searchByEmail(request);

			clearStub(stub);
			return response.getEntity();
		} catch (AxisFault e) {
			logger
					.error("==================> VidyoPortalUserServiceUtil.searchLegaciesByEmail() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", email: "
							+ email
							+ " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (RemoteException e) {
			logger
					.error("==================> VidyoPortalUserServiceUtil.searchLegaciesByEmail() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", email: "
							+ email
							+ " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (NotLicensedFaultException e) {
			logger
					.error("==================> VidyoPortalUserServiceUtil.searchLegaciesByEmail() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", email: "
							+ email
							+ " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (InvalidArgumentFaultException e) {
			logger
					.error("==================> VidyoPortalUserServiceUtil.searchLegaciesByEmail() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", email: "
							+ email
							+ " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (GeneralFaultException e) {
			logger
					.error("==================> VidyoPortalUserServiceUtil.searchLegaciesByEmail() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", email: "
							+ email
							+ " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (SeatLicenseExpiredFaultException e) {
			logger
					.error("==================> VidyoPortalUserServiceUtil.searchLegaciesByEmail() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", email: "
							+ email
							+ " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		}
	}

	public static Entity_type0[] getParticipants(String portalURL,
			String username, String password, EntityID conferenceID)
			throws CallVidyoWebServiceException {
		try {
			VidyoPortalUserServiceStub stub = createStub(portalURL, username,
					password);

			GetParticipantsRequest request = new GetParticipantsRequest();
			request.setConferenceID(conferenceID);
			Filter_type0 filter = new Filter_type0();
			filter.setLimit(Integer.MAX_VALUE);
			request.setFilter(filter);
			GetParticipantsResponse response = stub.getParticipants(request);

			clearStub(stub);
			return response.getEntity();
		} catch (AxisFault e) {
			logger
					.error("==================> VidyoPortalUserServiceUtil.getParticipants() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", conferenceID: "
							+ conferenceID.getEntityID() + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (RemoteException e) {
			logger
					.error("==================> VidyoPortalUserServiceUtil.getParticipants() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", conferenceID: "
							+ conferenceID.getEntityID() + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (NotLicensedFaultException e) {
			logger
					.error("==================> VidyoPortalUserServiceUtil.getParticipants() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", conferenceID: "
							+ conferenceID.getEntityID() + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (InvalidArgumentFaultException e) {
			logger
					.error("==================> VidyoPortalUserServiceUtil.getParticipants() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", conferenceID: "
							+ conferenceID.getEntityID() + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (GeneralFaultException e) {
			logger
					.error("==================> VidyoPortalUserServiceUtil.getParticipants() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", conferenceID: "
							+ conferenceID.getEntityID() + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (ControlMeetingFaultException e) {
			logger
					.error("==================> VidyoPortalUserServiceUtil.getParticipants() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", conferenceID: "
							+ conferenceID.getEntityID() + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (SeatLicenseExpiredFaultException e) {
			logger
					.error("==================> VidyoPortalUserServiceUtil.getParticipants() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", conferenceID: "
							+ conferenceID.getEntityID() + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		}
	}

}
