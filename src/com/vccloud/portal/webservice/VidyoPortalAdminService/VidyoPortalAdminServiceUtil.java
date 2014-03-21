package com.vccloud.portal.webservice.VidyoPortalAdminService;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.axis2.AxisFault;
import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.axis2.transport.http.HttpTransportProperties.Authenticator;
import org.apache.log4j.Logger;

import com.vccloud.portal.exception.CallVidyoWebServiceException;
import com.vccloud.portal.util.CommonUtil;
import com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.AddMemberRequest;
import com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.AddMemberResponse;
import com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.AddRoomRequest;
import com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.AddRoomResponse;
import com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.CreateRoomPINRequest;
import com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.CreateRoomPINResponse;
import com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.CreateRoomURLRequest;
import com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.CreateRoomURLResponse;
import com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.DeleteMemberRequest;
import com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.DeleteMemberResponse;
import com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.DeleteRoomRequest;
import com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.DeleteRoomResponse;
import com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.EntityID;
import com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.Entity_type0;
import com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.Filter_type0;
import com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.GetMemberRequest;
import com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.GetMemberResponse;
import com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.GetMembersRequest;
import com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.GetMembersResponse;
import com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.GetParticipantsRequest;
import com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.GetParticipantsResponse;
import com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.GetRoomProfileRequest;
import com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.GetRoomProfileResponse;
import com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.GetRoomRequest;
import com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.GetRoomResponse;
import com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.GetRoomsRequest;
import com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.GetRoomsResponse;
import com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.Language_type0;
import com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.LeaveConferenceRequest;
import com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.LeaveConferenceResponse;
import com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.Member;
import com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.MuteAudioRequest;
import com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.MuteAudioResponse;
import com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.RemoveRoomPINRequest;
import com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.RemoveRoomPINResponse;
import com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.RemoveRoomProfileRequest;
import com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.RemoveRoomProfileResponse;
import com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.RemoveRoomURLRequest;
import com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.RemoveRoomURLResponse;
import com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.RoleName_type0;
import com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.Room;
import com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.RoomMode_type0;
import com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.RoomProfile;
import com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.RoomType_type0;
import com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.SetRoomProfileRequest;
import com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.SetRoomProfileResponse;
import com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.StopVideoRequest;
import com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.StopVideoResponse;
import com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.UpdateMemberRequest;
import com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.UpdateMemberResponse;
import com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.UpdateRoomRequest;
import com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.UpdateRoomResponse;

public class VidyoPortalAdminServiceUtil {

	private static Logger logger = Logger
			.getLogger(VidyoPortalAdminServiceUtil.class);

	private static VidyoPortalAdminServiceStub createStub(String portalURL,
			String username, String password) throws AxisFault {
		try {
			VidyoPortalAdminServiceStub stub = null;
			if (CommonUtil.isNullOrEmpty(portalURL)) {
				stub = new VidyoPortalAdminServiceStub();
			} else {
				if (portalURL.endsWith("/")) {
					portalURL = portalURL.substring(0, portalURL.length() - 1);
				}
				if (portalURL.toLowerCase().startsWith("http://")) {
					stub = new VidyoPortalAdminServiceStub(portalURL
							+ "/services/v1_1/VidyoPortalAdminService/");
				} else {
					stub = new VidyoPortalAdminServiceStub("http://"
							+ portalURL
							+ "/services/v1_1/VidyoPortalAdminService/");
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

	private static void clearStub(VidyoPortalAdminServiceStub stub)
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

	public static Room[] getRooms(String portalURL, String username,
			String password) throws CallVidyoWebServiceException {
		try {
			VidyoPortalAdminServiceStub stub = createStub(portalURL, username,
					password);

			GetRoomsRequest request = new GetRoomsRequest();
			GetRoomsResponse response = stub.getRooms(request);

			clearStub(stub);
			return response.getRoom();
		} catch (AxisFault e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.getRooms() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: " + password + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (RemoteException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.getRooms() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: " + password + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (NotLicensedFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.getRooms() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: " + password + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (InvalidArgumentFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.getRooms() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: " + password + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (GeneralFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.getRooms() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: " + password + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		}
	}

	public static Room getRoom(String portalURL, String username,
			String password, int roomID) throws CallVidyoWebServiceException {
		try {
			VidyoPortalAdminServiceStub stub = createStub(portalURL, username,
					password);

			GetRoomRequest request = new GetRoomRequest();
			EntityID entityID = new EntityID();
			entityID.setEntityID(roomID);
			request.setRoomID(entityID);
			GetRoomResponse response = stub.getRoom(request);

			clearStub(stub);
			return response.getRoom();
		} catch (AxisFault e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.getRoom() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", roomID: "
							+ roomID
							+ " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (RemoteException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.getRoom() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", roomID: "
							+ roomID
							+ " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (NotLicensedFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.getRoom() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", roomID: "
							+ roomID
							+ " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (RoomNotFoundFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.getRoom() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", roomID: "
							+ roomID
							+ " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (InvalidArgumentFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.getRoom() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", roomID: "
							+ roomID
							+ " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (GeneralFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.getRoom() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", roomID: "
							+ roomID
							+ " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		}
	}

	public static boolean updateRoomName(String portalURL, String username,
			String password, String name, Room room)
			throws CallVidyoWebServiceException {
		try {
			VidyoPortalAdminServiceStub stub = createStub(portalURL, username,
					password);

			UpdateRoomRequest request = new UpdateRoomRequest();
			room.setName(name);
			request.setRoom(room);
			request.setRoomID(room.getRoomID());
			UpdateRoomResponse response2 = stub.updateRoom(request);

			clearStub(stub);
			return "OK".equalsIgnoreCase(response2.getOK().getValue());
		} catch (AxisFault e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.updateRoomName() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", roomID: "
							+ room.getRoomID().getEntityID()
							+ ", name: "
							+ name + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (RemoteException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.updateRoomName() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", roomID: "
							+ room.getRoomID().getEntityID()
							+ ", name: "
							+ name + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (NotLicensedFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.updateRoomName() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", roomID: "
							+ room.getRoomID().getEntityID()
							+ ", name: "
							+ name + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (RoomNotFoundFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.updateRoomName() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", roomID: "
							+ room.getRoomID().getEntityID()
							+ ", name: "
							+ name + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (InvalidArgumentFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.updateRoomName() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", roomID: "
							+ room.getRoomID().getEntityID()
							+ ", name: "
							+ name + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (GeneralFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.updateRoomName() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", roomID: "
							+ room.getRoomID().getEntityID()
							+ ", name: "
							+ name + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (InvalidModeratorPINFormatFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.updateRoomName() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", roomID: "
							+ room.getRoomID().getEntityID()
							+ ", name: "
							+ name + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (RoomAlreadyExistsFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.updateRoomName() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", roomID: "
							+ room.getRoomID().getEntityID()
							+ ", name: "
							+ name + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		}
	}

	public static boolean createRoomPIN(String portalURL, String username,
			String password, int roomID, String pinCode)
			throws CallVidyoWebServiceException {
		try {
			VidyoPortalAdminServiceStub stub = createStub(portalURL, username,
					password);

			CreateRoomPINRequest request = new CreateRoomPINRequest();
			request.setPIN(pinCode);
			EntityID entityID = new EntityID();
			entityID.setEntityID(roomID);
			request.setRoomID(entityID);
			CreateRoomPINResponse response = stub.createRoomPIN(request);

			clearStub(stub);
			return "OK".equalsIgnoreCase(response.getOK().getValue());
		} catch (AxisFault e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.createRoomPIN() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", roomID: "
							+ roomID
							+ ", pinCode: " + pinCode + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (RemoteException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.createRoomPIN() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", roomID: "
							+ roomID
							+ ", pinCode: " + pinCode + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (NotLicensedFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.createRoomPIN() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", roomID: "
							+ roomID
							+ ", pinCode: " + pinCode + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (InvalidArgumentFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.createRoomPIN() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", roomID: "
							+ roomID
							+ ", pinCode: " + pinCode + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (GeneralFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.createRoomPIN() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", roomID: "
							+ roomID
							+ ", pinCode: " + pinCode + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		}
	}

	public static boolean removeRoomPIN(String portalURL, String username,
			String password, int roomID) throws CallVidyoWebServiceException {
		try {
			VidyoPortalAdminServiceStub stub = createStub(portalURL, username,
					password);

			RemoveRoomPINRequest request = new RemoveRoomPINRequest();
			EntityID entityID = new EntityID();
			entityID.setEntityID(roomID);
			request.setRoomID(entityID);
			RemoveRoomPINResponse response = stub.removeRoomPIN(request);

			clearStub(stub);
			return "OK".equalsIgnoreCase(response.getOK().getValue());
		} catch (AxisFault e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.removeRoomPIN() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", roomID: "
							+ roomID
							+ " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (RemoteException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.removeRoomPIN() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", roomID: "
							+ roomID
							+ " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (NotLicensedFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.removeRoomPIN() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", roomID: "
							+ roomID
							+ " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (InvalidArgumentFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.removeRoomPIN() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", roomID: "
							+ roomID
							+ " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (GeneralFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.removeRoomPIN() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", roomID: "
							+ roomID
							+ " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		}
	}

	public static boolean leaveConference(String portalURL, String username,
			String password, int roomID, int participantID)
			throws CallVidyoWebServiceException {
		try {
			VidyoPortalAdminServiceStub stub = createStub(portalURL, username,
					password);

			LeaveConferenceRequest request = new LeaveConferenceRequest();
			EntityID roomID2 = new EntityID();
			roomID2.setEntityID(roomID);
			EntityID participantID2 = new EntityID();
			participantID2.setEntityID(participantID);
			request.setConferenceID(roomID2);
			request.setParticipantID(participantID2);
			LeaveConferenceResponse response = stub.leaveConference(request);

			clearStub(stub);
			return "OK".equalsIgnoreCase(response.getOK().getValue());
		} catch (AxisFault e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.leaveConference() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", roomID: "
							+ roomID
							+ ", participantID: " + participantID + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (RemoteException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.leaveConference() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", roomID: "
							+ roomID
							+ ", participantID: " + participantID + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (NotLicensedFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.leaveConference() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", roomID: "
							+ roomID
							+ ", participantID: " + participantID + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (InvalidArgumentFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.leaveConference() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", roomID: "
							+ roomID
							+ ", participantID: " + participantID + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (GeneralFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.leaveConference() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", roomID: "
							+ roomID
							+ ", participantID: " + participantID + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		}
	}

	public static Entity_type0[] getParticipants(String portalURL,
			String username, String password, int roomID)
			throws CallVidyoWebServiceException {
		try {
			VidyoPortalAdminServiceStub stub = createStub(portalURL, username,
					password);

			GetParticipantsRequest request = new GetParticipantsRequest();
			EntityID entityID = new EntityID();
			entityID.setEntityID(roomID);
			request.setConferenceID(entityID);
			GetParticipantsResponse response = stub.getParticipants(request);

			clearStub(stub);
			return response.getEntity();
		} catch (AxisFault e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.getParticipants() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", roomID: "
							+ roomID
							+ " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (RemoteException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.getParticipants() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", roomID: "
							+ roomID
							+ " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (NotLicensedFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.getParticipants() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", roomID: "
							+ roomID
							+ " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (InvalidArgumentFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.getParticipants() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", roomID: "
							+ roomID
							+ " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (GeneralFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.getParticipants() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", roomID: "
							+ roomID
							+ " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		}
	}

	public static Member getMember(String portalURL, String username,
			String password, int memberID) throws CallVidyoWebServiceException {
		try {
			VidyoPortalAdminServiceStub stub = createStub(portalURL, username,
					password);

			GetMemberRequest request = new GetMemberRequest();
			EntityID entityID = new EntityID();
			entityID.setEntityID(memberID);
			request.setMemberID(entityID);
			GetMemberResponse response = stub.getMember(request);

			clearStub(stub);
			return response.getMember();
		} catch (AxisFault e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.getMember() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", memberID: "
							+ memberID + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (RemoteException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.getMember() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", memberID: "
							+ memberID + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (NotLicensedFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.getMember() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", memberID: "
							+ memberID + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (MemberNotFoundFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.getMember() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", memberID: "
							+ memberID + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (InvalidArgumentFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.getMember() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", memberID: "
							+ memberID + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (GeneralFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.getMember() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", memberID: "
							+ memberID + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		}
	}

	public static boolean updateMemberPassword(String portalURL,
			String username, String password, String newPassword, Member member)
			throws CallVidyoWebServiceException {
		try {
			VidyoPortalAdminServiceStub stub = createStub(portalURL, username,
					password);

			UpdateMemberRequest request = new UpdateMemberRequest();
			member.setPassword(newPassword);
			request.setMember(member);
			request.setMemberID(member.getMemberID());
			UpdateMemberResponse response = stub.updateMember(request);

			clearStub(stub);
			return "OK".equalsIgnoreCase(response.getOK().getValue());
		} catch (AxisFault e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.updateMemberPassword() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", memberID: "
							+ member.getMemberID().getEntityID()
							+ ", newPassword: " + newPassword + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (RemoteException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.updateMemberPassword() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", memberID: "
							+ member.getMemberID().getEntityID()
							+ ", newPassword: " + newPassword + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (NotLicensedFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.updateMemberPassword() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", memberID: "
							+ member.getMemberID().getEntityID()
							+ ", newPassword: " + newPassword + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (MemberNotFoundFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.updateMemberPassword() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", memberID: "
							+ member.getMemberID().getEntityID()
							+ ", newPassword: " + newPassword + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (InvalidArgumentFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.updateMemberPassword() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", memberID: "
							+ member.getMemberID().getEntityID()
							+ ", newPassword: " + newPassword + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (GeneralFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.updateMemberPassword() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", memberID: "
							+ member.getMemberID().getEntityID()
							+ ", newPassword: " + newPassword + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		}
	}

	public static boolean updateMemberDisplayName(String portalURL,
			String username, String password, String displayName, Member member)
			throws CallVidyoWebServiceException {
		try {
			VidyoPortalAdminServiceStub stub = createStub(portalURL, username,
					password);

			UpdateMemberRequest request = new UpdateMemberRequest();
			member.setDisplayName(displayName);
			request.setMember(member);
			request.setMemberID(member.getMemberID());
			UpdateMemberResponse response = stub.updateMember(request);

			clearStub(stub);
			return "OK".equalsIgnoreCase(response.getOK().getValue());
		} catch (AxisFault e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.updateMemberDisplayName() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", memberID: "
							+ member.getMemberID().getEntityID()
							+ ", displayName: " + displayName + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (RemoteException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.updateMemberDisplayName() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", memberID: "
							+ member.getMemberID().getEntityID()
							+ ", displayName: " + displayName + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (NotLicensedFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.updateMemberDisplayName() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", memberID: "
							+ member.getMemberID().getEntityID()
							+ ", displayName: " + displayName + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (MemberNotFoundFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.updateMemberDisplayName() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", memberID: "
							+ member.getMemberID().getEntityID()
							+ ", displayName: " + displayName + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (InvalidArgumentFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.updateMemberDisplayName() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", memberID: "
							+ member.getMemberID().getEntityID()
							+ ", displayName: " + displayName + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (GeneralFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.updateMemberDisplayName() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", memberID: "
							+ member.getMemberID().getEntityID()
							+ ", displayName: " + displayName + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		}
	}

	public static boolean addLegacy(String portalURL, String username,
			String password, String name, String extension)
			throws CallVidyoWebServiceException {
		try {
			VidyoPortalAdminServiceStub stub = createStub(portalURL, username,
					password);

			AddMemberRequest request = new AddMemberRequest();
			Member member = new Member();
			member.setName(name);
			member.setDisplayName(name);
			member.setExtension(extension);
			member.setLanguage(Language_type0.zh_CN);
			member.setRoleName(RoleName_type0.Legacy);
			member.setGroupName("Default");
			member.setLocationTag("Default");
			member.setEmailAddress(CommonUtil.genEmail4Legacy(name));
			Date now = new Date();
			member.setCreated(now);
			member.setDescription("Legacy");
			request.setMember(member);
			AddMemberResponse response = stub.addMember(request);

			clearStub(stub);
			return "OK".equalsIgnoreCase(response.getOK().getValue());
		} catch (AxisFault e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.addLegacy() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", name: "
							+ name
							+ ", extension: " + extension + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (RemoteException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.addLegacy() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", name: "
							+ name
							+ ", extension: " + extension + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (NotLicensedFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.addLegacy() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", name: "
							+ name
							+ ", extension: " + extension + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (InvalidArgumentFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.addLegacy() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", name: "
							+ name
							+ ", extension: " + extension + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (MemberAlreadyExistsFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.addLegacy() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", name: "
							+ name
							+ ", extension: " + extension + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (GeneralFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.addLegacy() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", name: "
							+ name
							+ ", extension: " + extension + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		}
	}

	public static Member[] getMembers(String portalURL, String username,
			String password, String query) throws CallVidyoWebServiceException {
		try {
			VidyoPortalAdminServiceStub stub = createStub(portalURL, username,
					password);

			GetMembersRequest request = new GetMembersRequest();
			Filter_type0 filter = new Filter_type0();
			filter.setLimit(Integer.MAX_VALUE);
			request.setFilter(filter);
			if (!CommonUtil.isNullOrEmpty(query)) {
				filter.setQuery(query);
			}
			GetMembersResponse response = stub.getMembers(request);

			clearStub(stub);
			return response.getMember();
		} catch (AxisFault e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.getMembers() caught exception, [ portalURL: "
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
					.error("==================> VidyoPortalAdminServiceUtil.getMembers() caught exception, [ portalURL: "
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
					.error("==================> VidyoPortalAdminServiceUtil.getMembers() caught exception, [ portalURL: "
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
					.error("==================> VidyoPortalAdminServiceUtil.getMembers() caught exception, [ portalURL: "
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
					.error("==================> VidyoPortalAdminServiceUtil.getMembers() caught exception, [ portalURL: "
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

	public static boolean updateLegacy(String portalURL, String username,
			String password, EntityID memberID, Member member)
			throws CallVidyoWebServiceException {
		try {
			VidyoPortalAdminServiceStub stub = createStub(portalURL, username,
					password);

			UpdateMemberRequest request = new UpdateMemberRequest();
			request.setMemberID(memberID);
			request.setMember(member);
			UpdateMemberResponse response = stub.updateMember(request);

			clearStub(stub);
			return "OK".equalsIgnoreCase(response.getOK().getValue());
		} catch (AxisFault e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.updateLegacy() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", memberID: "
							+ memberID.getEntityID() + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (RemoteException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.updateLegacy() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", memberID: "
							+ memberID.getEntityID() + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (NotLicensedFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.updateLegacy() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", memberID: "
							+ memberID.getEntityID() + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (MemberNotFoundFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.updateLegacy() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", memberID: "
							+ memberID.getEntityID() + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (InvalidArgumentFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.updateLegacy() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", memberID: "
							+ memberID.getEntityID() + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (GeneralFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.updateLegacy() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", memberID: "
							+ memberID.getEntityID() + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		}
	}

	public static boolean deleteMember(String portalURL, String username,
			String password, int memberID) throws CallVidyoWebServiceException {
		try {
			VidyoPortalAdminServiceStub stub = createStub(portalURL, username,
					password);

			DeleteMemberRequest request = new DeleteMemberRequest();
			EntityID entityID = new EntityID();
			entityID.setEntityID(memberID);
			request.setMemberID(entityID);
			DeleteMemberResponse response = stub.deleteMember(request);

			clearStub(stub);
			return "OK".equalsIgnoreCase(response.getOK().getValue());
		} catch (AxisFault e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.deleteMember() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", memberID: "
							+ memberID + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (RemoteException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.deleteMember() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", memberID: "
							+ memberID + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (NotLicensedFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.deleteMember() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", memberID: "
							+ memberID + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (MemberNotFoundFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.deleteMember() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", memberID: "
							+ memberID + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (InvalidArgumentFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.deleteMember() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", memberID: "
							+ memberID + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (GeneralFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.deleteMember() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", memberID: "
							+ memberID + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		}
	}

	public static RoomProfile getRoomProfile(String portalURL, String username,
			String password, EntityID roomID)
			throws CallVidyoWebServiceException {
		try {
			VidyoPortalAdminServiceStub stub = createStub(portalURL, username,
					password);

			GetRoomProfileRequest request = new GetRoomProfileRequest();
			request.setRoomID(roomID);
			GetRoomProfileResponse response = stub.getRoomProfile(request);

			clearStub(stub);
			return response.getRoomProfile();
		} catch (AxisFault e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.getRoomProfile() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", roomID: "
							+ roomID.getEntityID() + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (RemoteException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.getRoomProfile() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", roomID: "
							+ roomID.getEntityID() + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (NotLicensedFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.getRoomProfile() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", roomID: "
							+ roomID.getEntityID() + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (InvalidArgumentFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.getRoomProfile() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", roomID: "
							+ roomID.getEntityID() + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (GeneralFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.getRoomProfile() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", roomID: "
							+ roomID.getEntityID() + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		}
	}

	public static boolean setRoomProfile(String portalURL, String username,
			String password, EntityID roomID, String roomProfileName)
			throws CallVidyoWebServiceException {
		try {
			VidyoPortalAdminServiceStub stub = createStub(portalURL, username,
					password);

			SetRoomProfileRequest request = new SetRoomProfileRequest();
			request.setRoomID(roomID);
			request.setRoomProfileName(roomProfileName);
			SetRoomProfileResponse response = stub.setRoomProfile(request);

			clearStub(stub);
			return "OK".equalsIgnoreCase(response.getOK().getValue());
		} catch (AxisFault e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.setRoomProfile() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", roomID: "
							+ roomID.getEntityID()
							+ ", roomProfileName: "
							+ roomProfileName + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (RemoteException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.setRoomProfile() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", roomID: "
							+ roomID.getEntityID()
							+ ", roomProfileName: "
							+ roomProfileName + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (NotLicensedFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.setRoomProfile() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", roomID: "
							+ roomID.getEntityID()
							+ ", roomProfileName: "
							+ roomProfileName + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (InvalidArgumentFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.setRoomProfile() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", roomID: "
							+ roomID.getEntityID()
							+ ", roomProfileName: "
							+ roomProfileName + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (GeneralFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.setRoomProfile() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", roomID: "
							+ roomID.getEntityID()
							+ ", roomProfileName: "
							+ roomProfileName + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		}
	}

	public static boolean removeRoomProfile(String portalURL, String username,
			String password, EntityID roomID)
			throws CallVidyoWebServiceException {
		try {
			VidyoPortalAdminServiceStub stub = createStub(portalURL, username,
					password);

			RemoveRoomProfileRequest request = new RemoveRoomProfileRequest();
			request.setRoomID(roomID);
			RemoveRoomProfileResponse response = stub
					.removeRoomProfile(request);

			clearStub(stub);
			return "OK".equalsIgnoreCase(response.getOK().getValue());
		} catch (AxisFault e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.removeRoomProfile() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", roomID: "
							+ roomID.getEntityID() + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (RemoteException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.removeRoomProfile() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", roomID: "
							+ roomID.getEntityID() + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (NotLicensedFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.removeRoomProfile() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", roomID: "
							+ roomID.getEntityID() + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (InvalidArgumentFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.removeRoomProfile() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", roomID: "
							+ roomID.getEntityID() + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (GeneralFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.removeRoomProfile() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", roomID: "
							+ roomID.getEntityID() + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		}
	}

	public static boolean removeRoomURL(String portalURL, String username,
			String password, EntityID roomID)
			throws CallVidyoWebServiceException {
		try {
			VidyoPortalAdminServiceStub stub = createStub(portalURL, username,
					password);

			RemoveRoomURLRequest request = new RemoveRoomURLRequest();
			request.setRoomID(roomID);
			RemoveRoomURLResponse response = stub.removeRoomURL(request);

			clearStub(stub);
			return "OK".equalsIgnoreCase(response.getOK().getValue());
		} catch (AxisFault e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.removeRoomURL() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", roomID: "
							+ roomID.getEntityID() + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (RemoteException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.removeRoomURL() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", roomID: "
							+ roomID.getEntityID() + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (NotLicensedFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.removeRoomURL() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", roomID: "
							+ roomID.getEntityID() + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (InvalidArgumentFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.removeRoomURL() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", roomID: "
							+ roomID.getEntityID() + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (GeneralFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.removeRoomURL() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", roomID: "
							+ roomID.getEntityID() + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		}
	}

	public static boolean createRoomURL(String portalURL, String username,
			String password, EntityID roomID)
			throws CallVidyoWebServiceException {
		try {
			VidyoPortalAdminServiceStub stub = createStub(portalURL, username,
					password);

			CreateRoomURLRequest request = new CreateRoomURLRequest();
			request.setRoomID(roomID);
			CreateRoomURLResponse response = stub.createRoomURL(request);

			clearStub(stub);
			return "OK".equalsIgnoreCase(response.getOK().getValue());
		} catch (AxisFault e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.createRoomURL() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", roomID: "
							+ roomID.getEntityID() + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (RemoteException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.createRoomURL() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", roomID: "
							+ roomID.getEntityID() + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (NotLicensedFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.createRoomURL() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", roomID: "
							+ roomID.getEntityID() + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (InvalidArgumentFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.createRoomURL() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", roomID: "
							+ roomID.getEntityID() + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (GeneralFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.createRoomURL() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", roomID: "
							+ roomID.getEntityID() + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		}
	}

	public static boolean muteAudio(String portalURL, String username,
			String password, int conferenceID, int participantID)
			throws CallVidyoWebServiceException {
		try {
			VidyoPortalAdminServiceStub stub = createStub(portalURL, username,
					password);

			MuteAudioRequest request = new MuteAudioRequest();
			com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.EntityID conferenceID2 = new com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.EntityID();
			conferenceID2.setEntityID(conferenceID);
			com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.EntityID participantID2 = new com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.EntityID();
			participantID2.setEntityID(participantID);
			request.setConferenceID(conferenceID2);
			request.setParticipantID(participantID2);
			MuteAudioResponse response = stub.muteAudio(request);

			clearStub(stub);
			return "OK".equalsIgnoreCase(response.getOK().getValue());
		} catch (AxisFault e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.muteAudio() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", conferenceID: "
							+ conferenceID
							+ ", participantID: "
							+ participantID + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (RemoteException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.muteAudio() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", conferenceID: "
							+ conferenceID
							+ ", participantID: "
							+ participantID + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (NotLicensedFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.muteAudio() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", conferenceID: "
							+ conferenceID
							+ ", participantID: "
							+ participantID + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (InvalidArgumentFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.muteAudio() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", conferenceID: "
							+ conferenceID
							+ ", participantID: "
							+ participantID + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (GeneralFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.muteAudio() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", conferenceID: "
							+ conferenceID
							+ ", participantID: "
							+ participantID + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		}
	}

	public static boolean stopVideo(String portalURL, String username,
			String password, int conferenceID, int participantID)
			throws CallVidyoWebServiceException {
		try {
			VidyoPortalAdminServiceStub stub = createStub(portalURL, username,
					password);

			StopVideoRequest request = new StopVideoRequest();
			com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.EntityID conferenceID2 = new com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.EntityID();
			conferenceID2.setEntityID(conferenceID);
			com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.EntityID participantID2 = new com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.EntityID();
			participantID2.setEntityID(participantID);
			request.setConferenceID(conferenceID2);
			request.setParticipantID(participantID2);
			StopVideoResponse response = stub.stopVideo(request);

			clearStub(stub);
			return "OK".equalsIgnoreCase(response.getOK().getValue());
		} catch (AxisFault e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.stopVideo() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", conferenceID: "
							+ conferenceID
							+ ", participantID: "
							+ participantID + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (RemoteException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.stopVideo() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", conferenceID: "
							+ conferenceID
							+ ", participantID: "
							+ participantID + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (NotLicensedFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.stopVideo() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", conferenceID: "
							+ conferenceID
							+ ", participantID: "
							+ participantID + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (InvalidArgumentFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.stopVideo() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", conferenceID: "
							+ conferenceID
							+ ", participantID: "
							+ participantID + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (GeneralFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.stopVideo() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", conferenceID: "
							+ conferenceID
							+ ", participantID: "
							+ participantID + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		}
	}

	/**
	 * 
	 * @param portalURL
	 * @param username
	 * @param password
	 * @param description
	 * @param extension
	 * @param groupName
	 * @param name
	 * @param ownerName
	 * @param roomType
	 * @param roomPIN
	 * @param moderatorPIN
	 * @return
	 * @throws CallVidyoWebServiceException
	 * @author copy by xuan
	 */
	public static boolean addRoom(String portalURL, String username,
			String password, String description, String extension,
			String groupName, String name, String ownerName, String roomType,
			String roomPIN, String moderatorPIN)
			throws CallVidyoWebServiceException {
		try {
			VidyoPortalAdminServiceStub stub = createStub(portalURL, username,
					password);

			AddRoomRequest request = new AddRoomRequest();
			Room room = new Room();
			room.setDescription(description);
			room.setExtension(extension);
			room.setGroupName(groupName);
			room.setName(name);
			room.setOwnerName(ownerName);
			RoomMode_type0 roomMode = new RoomMode_type0();
			if (!CommonUtil.isNullOrEmpty(roomPIN)) {
				roomMode.setHasPIN(true);
				roomMode.setRoomPIN(roomPIN);
			} else {
				roomMode.setHasPIN(false);
			}
			if (!CommonUtil.isNullOrEmpty(moderatorPIN)) {
				roomMode.setHasModeratorPIN(true);
				roomMode.setModeratorPIN(moderatorPIN);
			} else {
				roomMode.setHasModeratorPIN(false);
			}
			roomMode.setIsLocked(false);
			room.setRoomMode(roomMode);
			if (RoomType_type0.Personal.getValue().equalsIgnoreCase(roomType)) {
				room.setRoomType(RoomType_type0.Personal);
			} else {
				room.setRoomType(RoomType_type0.Public);
			}
			request.setRoom(room);
			AddRoomResponse response = stub.addRoom(request);

			clearStub(stub);
			return "OK".equalsIgnoreCase(response.getOK().getValue());
		} catch (AxisFault e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.addRoom() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: " + password + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (RemoteException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.addRoom() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: " + password + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (NotLicensedFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.addRoom() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: " + password + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (InvalidArgumentFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.addRoom() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: " + password + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (InvalidModeratorPINFormatFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.addRoom() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: " + password + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (GeneralFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.addRoom() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: " + password + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (RoomAlreadyExistsFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.addRoom() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: " + password + " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		}
	}

	/**
	 * 
	 * @param portalURL
	 * @param username
	 * @param password
	 * @param roomID
	 * @return
	 * @throws CallVidyoWebServiceException
	 * @author copy by xuan
	 */
	public static boolean deleteRoom(String portalURL, String username,
			String password, int roomID) throws CallVidyoWebServiceException {
		try {
			VidyoPortalAdminServiceStub stub = createStub(portalURL, username,
					password);

			DeleteRoomRequest request = new DeleteRoomRequest();
			EntityID entityID = new EntityID();
			entityID.setEntityID(roomID);
			request.setRoomID(entityID);
			DeleteRoomResponse response = stub.deleteRoom(request);

			clearStub(stub);
			return "OK".equalsIgnoreCase(response.getOK().getValue());
		} catch (AxisFault e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.deleteRoom() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", roomID: "
							+ roomID
							+ " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (RemoteException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.deleteRoom() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", roomID: "
							+ roomID
							+ " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (NotLicensedFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.deleteRoom() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", roomID: "
							+ roomID
							+ " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (RoomNotFoundFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.deleteRoom() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", roomID: "
							+ roomID
							+ " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (InvalidArgumentFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.deleteRoom() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", roomID: "
							+ roomID
							+ " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		} catch (GeneralFaultException e) {
			logger
					.error("==================> VidyoPortalAdminServiceUtil.deleteRoom() caught exception, [ portalURL: "
							+ portalURL
							+ ", username: "
							+ username
							+ ", password: "
							+ password
							+ ", roomID: "
							+ roomID
							+ " ]");
			logger.error("", e);
			throw new CallVidyoWebServiceException("");
		}
	}
}
