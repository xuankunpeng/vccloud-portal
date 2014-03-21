package com.wjxie.test;

import com.vccloud.portal.exception.CallVidyoWebServiceException;
import com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceUtil;

public class VidyoPortalUserServiceUtilTest {

	public static void main(String[] args) {
		try {
			com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.EntityID conferenceID = new com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.EntityID();
			conferenceID.setEntityID("916");
			com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.Entity_type0[] participants = VidyoPortalUserServiceUtil
					.getParticipants("dev1.v.seekoom.com", "admin", "password",
							conferenceID);
			System.out.println(participants.length);
			for (com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.Entity_type0 participant : participants) {
				System.out.println(participant.getEntityType().getValue());
			}
		} catch (CallVidyoWebServiceException e) {
			e.printStackTrace();
		}
	}

}
