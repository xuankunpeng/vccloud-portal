
/**
 * VidyoPortalAdminServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package com.vccloud.portal.webservice.VidyoPortalAdminService;

    /**
     *  VidyoPortalAdminServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class VidyoPortalAdminServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public VidyoPortalAdminServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public VidyoPortalAdminServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for startRecording method
            * override this method for handling normal response from startRecording operation
            */
           public void receiveResultstartRecording(
                    com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.StartRecordingResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from startRecording operation
           */
            public void receiveErrorstartRecording(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getParticipants method
            * override this method for handling normal response from getParticipants operation
            */
           public void receiveResultgetParticipants(
                    com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.GetParticipantsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getParticipants operation
           */
            public void receiveErrorgetParticipants(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for removeRoomProfile method
            * override this method for handling normal response from removeRoomProfile operation
            */
           public void receiveResultremoveRoomProfile(
                    com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.RemoveRoomProfileResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from removeRoomProfile operation
           */
            public void receiveErrorremoveRoomProfile(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getRoomProfile method
            * override this method for handling normal response from getRoomProfile operation
            */
           public void receiveResultgetRoomProfile(
                    com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.GetRoomProfileResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getRoomProfile operation
           */
            public void receiveErrorgetRoomProfile(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getLocationTags method
            * override this method for handling normal response from getLocationTags operation
            */
           public void receiveResultgetLocationTags(
                    com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.GetLocationTagsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getLocationTags operation
           */
            public void receiveErrorgetLocationTags(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for leaveConference method
            * override this method for handling normal response from leaveConference operation
            */
           public void receiveResultleaveConference(
                    com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.LeaveConferenceResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from leaveConference operation
           */
            public void receiveErrorleaveConference(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getRoom method
            * override this method for handling normal response from getRoom operation
            */
           public void receiveResultgetRoom(
                    com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.GetRoomResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getRoom operation
           */
            public void receiveErrorgetRoom(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for setRoomProfile method
            * override this method for handling normal response from setRoomProfile operation
            */
           public void receiveResultsetRoomProfile(
                    com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.SetRoomProfileResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from setRoomProfile operation
           */
            public void receiveErrorsetRoomProfile(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for updateRoom method
            * override this method for handling normal response from updateRoom operation
            */
           public void receiveResultupdateRoom(
                    com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.UpdateRoomResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from updateRoom operation
           */
            public void receiveErrorupdateRoom(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getWebcastURL method
            * override this method for handling normal response from getWebcastURL operation
            */
           public void receiveResultgetWebcastURL(
                    com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.GetWebcastURLResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getWebcastURL operation
           */
            public void receiveErrorgetWebcastURL(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for stopRecording method
            * override this method for handling normal response from stopRecording operation
            */
           public void receiveResultstopRecording(
                    com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.StopRecordingResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from stopRecording operation
           */
            public void receiveErrorstopRecording(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getGroups method
            * override this method for handling normal response from getGroups operation
            */
           public void receiveResultgetGroups(
                    com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.GetGroupsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getGroups operation
           */
            public void receiveErrorgetGroups(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteMember method
            * override this method for handling normal response from deleteMember operation
            */
           public void receiveResultdeleteMember(
                    com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.DeleteMemberResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteMember operation
           */
            public void receiveErrordeleteMember(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for removeModeratorPIN method
            * override this method for handling normal response from removeModeratorPIN operation
            */
           public void receiveResultremoveModeratorPIN(
                    com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.RemoveModeratorPINResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from removeModeratorPIN operation
           */
            public void receiveErrorremoveModeratorPIN(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for updateMember method
            * override this method for handling normal response from updateMember operation
            */
           public void receiveResultupdateMember(
                    com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.UpdateMemberResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from updateMember operation
           */
            public void receiveErrorupdateMember(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for removeWebcastURL method
            * override this method for handling normal response from removeWebcastURL operation
            */
           public void receiveResultremoveWebcastURL(
                    com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.RemoveWebcastURLResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from removeWebcastURL operation
           */
            public void receiveErrorremoveWebcastURL(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for createWebcastURL method
            * override this method for handling normal response from createWebcastURL operation
            */
           public void receiveResultcreateWebcastURL(
                    com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.CreateWebcastURLResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from createWebcastURL operation
           */
            public void receiveErrorcreateWebcastURL(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteRoom method
            * override this method for handling normal response from deleteRoom operation
            */
           public void receiveResultdeleteRoom(
                    com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.DeleteRoomResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteRoom operation
           */
            public void receiveErrordeleteRoom(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getConferenceID method
            * override this method for handling normal response from getConferenceID operation
            */
           public void receiveResultgetConferenceID(
                    com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.GetConferenceIDResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getConferenceID operation
           */
            public void receiveErrorgetConferenceID(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for unmuteAudio method
            * override this method for handling normal response from unmuteAudio operation
            */
           public void receiveResultunmuteAudio(
                    com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.UnmuteAudioResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from unmuteAudio operation
           */
            public void receiveErrorunmuteAudio(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for resumeRecording method
            * override this method for handling normal response from resumeRecording operation
            */
           public void receiveResultresumeRecording(
                    com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.ResumeRecordingResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from resumeRecording operation
           */
            public void receiveErrorresumeRecording(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for inviteToConference method
            * override this method for handling normal response from inviteToConference operation
            */
           public void receiveResultinviteToConference(
                    com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.InviteToConferenceResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from inviteToConference operation
           */
            public void receiveErrorinviteToConference(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteGroup method
            * override this method for handling normal response from deleteGroup operation
            */
           public void receiveResultdeleteGroup(
                    com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.DeleteGroupResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteGroup operation
           */
            public void receiveErrordeleteGroup(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for createRoomURL method
            * override this method for handling normal response from createRoomURL operation
            */
           public void receiveResultcreateRoomURL(
                    com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.CreateRoomURLResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from createRoomURL operation
           */
            public void receiveErrorcreateRoomURL(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getMember method
            * override this method for handling normal response from getMember operation
            */
           public void receiveResultgetMember(
                    com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.GetMemberResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getMember operation
           */
            public void receiveErrorgetMember(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for updateGroup method
            * override this method for handling normal response from updateGroup operation
            */
           public void receiveResultupdateGroup(
                    com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.UpdateGroupResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from updateGroup operation
           */
            public void receiveErrorupdateGroup(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for removeWebcastPIN method
            * override this method for handling normal response from removeWebcastPIN operation
            */
           public void receiveResultremoveWebcastPIN(
                    com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.RemoveWebcastPINResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from removeWebcastPIN operation
           */
            public void receiveErrorremoveWebcastPIN(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addMember method
            * override this method for handling normal response from addMember operation
            */
           public void receiveResultaddMember(
                    com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.AddMemberResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addMember operation
           */
            public void receiveErroraddMember(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addGroup method
            * override this method for handling normal response from addGroup operation
            */
           public void receiveResultaddGroup(
                    com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.AddGroupResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addGroup operation
           */
            public void receiveErroraddGroup(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for stopVideo method
            * override this method for handling normal response from stopVideo operation
            */
           public void receiveResultstopVideo(
                    com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.StopVideoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from stopVideo operation
           */
            public void receiveErrorstopVideo(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getPortalVersion method
            * override this method for handling normal response from getPortalVersion operation
            */
           public void receiveResultgetPortalVersion(
                    com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.GetPortalVersionResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getPortalVersion operation
           */
            public void receiveErrorgetPortalVersion(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getMembers method
            * override this method for handling normal response from getMembers operation
            */
           public void receiveResultgetMembers(
                    com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.GetMembersResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getMembers operation
           */
            public void receiveErrorgetMembers(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for startVideo method
            * override this method for handling normal response from startVideo operation
            */
           public void receiveResultstartVideo(
                    com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.StartVideoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from startVideo operation
           */
            public void receiveErrorstartVideo(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getRecordingProfiles method
            * override this method for handling normal response from getRecordingProfiles operation
            */
           public void receiveResultgetRecordingProfiles(
                    com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.GetRecordingProfilesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getRecordingProfiles operation
           */
            public void receiveErrorgetRecordingProfiles(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getRoomProfiles method
            * override this method for handling normal response from getRoomProfiles operation
            */
           public void receiveResultgetRoomProfiles(
                    com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.GetRoomProfilesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getRoomProfiles operation
           */
            public void receiveErrorgetRoomProfiles(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getRooms method
            * override this method for handling normal response from getRooms operation
            */
           public void receiveResultgetRooms(
                    com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.GetRoomsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getRooms operation
           */
            public void receiveErrorgetRooms(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for removeRoomURL method
            * override this method for handling normal response from removeRoomURL operation
            */
           public void receiveResultremoveRoomURL(
                    com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.RemoveRoomURLResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from removeRoomURL operation
           */
            public void receiveErrorremoveRoomURL(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for pauseRecording method
            * override this method for handling normal response from pauseRecording operation
            */
           public void receiveResultpauseRecording(
                    com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.PauseRecordingResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from pauseRecording operation
           */
            public void receiveErrorpauseRecording(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for muteAudio method
            * override this method for handling normal response from muteAudio operation
            */
           public void receiveResultmuteAudio(
                    com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.MuteAudioResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from muteAudio operation
           */
            public void receiveErrormuteAudio(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addRoom method
            * override this method for handling normal response from addRoom operation
            */
           public void receiveResultaddRoom(
                    com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.AddRoomResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addRoom operation
           */
            public void receiveErroraddRoom(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for removeRoomPIN method
            * override this method for handling normal response from removeRoomPIN operation
            */
           public void receiveResultremoveRoomPIN(
                    com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.RemoveRoomPINResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from removeRoomPIN operation
           */
            public void receiveErrorremoveRoomPIN(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for createRoomPIN method
            * override this method for handling normal response from createRoomPIN operation
            */
           public void receiveResultcreateRoomPIN(
                    com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.CreateRoomPINResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from createRoomPIN operation
           */
            public void receiveErrorcreateRoomPIN(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getGroup method
            * override this method for handling normal response from getGroup operation
            */
           public void receiveResultgetGroup(
                    com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.GetGroupResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getGroup operation
           */
            public void receiveErrorgetGroup(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for createWebcastPIN method
            * override this method for handling normal response from createWebcastPIN operation
            */
           public void receiveResultcreateWebcastPIN(
                    com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.CreateWebcastPINResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from createWebcastPIN operation
           */
            public void receiveErrorcreateWebcastPIN(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getLicenseData method
            * override this method for handling normal response from getLicenseData operation
            */
           public void receiveResultgetLicenseData(
                    com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.GetLicenseDataResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getLicenseData operation
           */
            public void receiveErrorgetLicenseData(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for createModeratorPIN method
            * override this method for handling normal response from createModeratorPIN operation
            */
           public void receiveResultcreateModeratorPIN(
                    com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.CreateModeratorPINResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from createModeratorPIN operation
           */
            public void receiveErrorcreateModeratorPIN(java.lang.Exception e) {
            }
                


    }
    