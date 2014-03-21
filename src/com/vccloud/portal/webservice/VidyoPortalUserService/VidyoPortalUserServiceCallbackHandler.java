
/**
 * VidyoPortalUserServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package com.vccloud.portal.webservice.VidyoPortalUserService;

    /**
     *  VidyoPortalUserServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class VidyoPortalUserServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public VidyoPortalUserServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public VidyoPortalUserServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for searchMyContacts method
            * override this method for handling normal response from searchMyContacts operation
            */
           public void receiveResultsearchMyContacts(
                    com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.SearchMyContactsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from searchMyContacts operation
           */
            public void receiveErrorsearchMyContacts(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getPortalVersion method
            * override this method for handling normal response from getPortalVersion operation
            */
           public void receiveResultgetPortalVersion(
                    com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.GetPortalVersionResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getPortalVersion operation
           */
            public void receiveErrorgetPortalVersion(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for createWebcastPIN method
            * override this method for handling normal response from createWebcastPIN operation
            */
           public void receiveResultcreateWebcastPIN(
                    com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.CreateWebcastPINResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from createWebcastPIN operation
           */
            public void receiveErrorcreateWebcastPIN(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for pauseRecording method
            * override this method for handling normal response from pauseRecording operation
            */
           public void receiveResultpauseRecording(
                    com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.PauseRecordingResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from pauseRecording operation
           */
            public void receiveErrorpauseRecording(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for resumeRecording method
            * override this method for handling normal response from resumeRecording operation
            */
           public void receiveResultresumeRecording(
                    com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.ResumeRecordingResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from resumeRecording operation
           */
            public void receiveErrorresumeRecording(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for startRecording method
            * override this method for handling normal response from startRecording operation
            */
           public void receiveResultstartRecording(
                    com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.StartRecordingResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from startRecording operation
           */
            public void receiveErrorstartRecording(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for linkEndpoint method
            * override this method for handling normal response from linkEndpoint operation
            */
           public void receiveResultlinkEndpoint(
                    com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.LinkEndpointResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from linkEndpoint operation
           */
            public void receiveErrorlinkEndpoint(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addToMyContacts method
            * override this method for handling normal response from addToMyContacts operation
            */
           public void receiveResultaddToMyContacts(
                    com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.AddToMyContactsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addToMyContacts operation
           */
            public void receiveErroraddToMyContacts(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for startVideo method
            * override this method for handling normal response from startVideo operation
            */
           public void receiveResultstartVideo(
                    com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.StartVideoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from startVideo operation
           */
            public void receiveErrorstartVideo(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for joinIPCConference method
            * override this method for handling normal response from joinIPCConference operation
            */
           public void receiveResultjoinIPCConference(
                    com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.JoinIPCConferenceResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from joinIPCConference operation
           */
            public void receiveErrorjoinIPCConference(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getWebcastURL method
            * override this method for handling normal response from getWebcastURL operation
            */
           public void receiveResultgetWebcastURL(
                    com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.GetWebcastURLResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getWebcastURL operation
           */
            public void receiveErrorgetWebcastURL(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for removeRoomURL method
            * override this method for handling normal response from removeRoomURL operation
            */
           public void receiveResultremoveRoomURL(
                    com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.RemoveRoomURLResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from removeRoomURL operation
           */
            public void receiveErrorremoveRoomURL(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getRoomProfile method
            * override this method for handling normal response from getRoomProfile operation
            */
           public void receiveResultgetRoomProfile(
                    com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.GetRoomProfileResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getRoomProfile operation
           */
            public void receiveErrorgetRoomProfile(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for removeWebcastPIN method
            * override this method for handling normal response from removeWebcastPIN operation
            */
           public void receiveResultremoveWebcastPIN(
                    com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.RemoveWebcastPINResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from removeWebcastPIN operation
           */
            public void receiveErrorremoveWebcastPIN(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for myEndpointStatus method
            * override this method for handling normal response from myEndpointStatus operation
            */
           public void receiveResultmyEndpointStatus(
                    com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.MyEndpointStatusResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from myEndpointStatus operation
           */
            public void receiveErrormyEndpointStatus(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for logOut method
            * override this method for handling normal response from logOut operation
            */
           public void receiveResultlogOut(
                    com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.LogOutResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from logOut operation
           */
            public void receiveErrorlogOut(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getInviteContent method
            * override this method for handling normal response from getInviteContent operation
            */
           public void receiveResultgetInviteContent(
                    com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.GetInviteContentResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getInviteContent operation
           */
            public void receiveErrorgetInviteContent(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for leaveConference method
            * override this method for handling normal response from leaveConference operation
            */
           public void receiveResultleaveConference(
                    com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.LeaveConferenceResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from leaveConference operation
           */
            public void receiveErrorleaveConference(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for inviteToConference method
            * override this method for handling normal response from inviteToConference operation
            */
           public void receiveResultinviteToConference(
                    com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.InviteToConferenceResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from inviteToConference operation
           */
            public void receiveErrorinviteToConference(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for searchByEmail method
            * override this method for handling normal response from searchByEmail operation
            */
           public void receiveResultsearchByEmail(
                    com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.SearchByEmailResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from searchByEmail operation
           */
            public void receiveErrorsearchByEmail(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getEntityByEntityID method
            * override this method for handling normal response from getEntityByEntityID operation
            */
           public void receiveResultgetEntityByEntityID(
                    com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.GetEntityByEntityIDResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getEntityByEntityID operation
           */
            public void receiveErrorgetEntityByEntityID(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for removeWebcastURL method
            * override this method for handling normal response from removeWebcastURL operation
            */
           public void receiveResultremoveWebcastURL(
                    com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.RemoveWebcastURLResponse result
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
                    com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.CreateWebcastURLResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from createWebcastURL operation
           */
            public void receiveErrorcreateWebcastURL(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getParticipants method
            * override this method for handling normal response from getParticipants operation
            */
           public void receiveResultgetParticipants(
                    com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.GetParticipantsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getParticipants operation
           */
            public void receiveErrorgetParticipants(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for logIn method
            * override this method for handling normal response from logIn operation
            */
           public void receiveResultlogIn(
                    com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.LogInResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from logIn operation
           */
            public void receiveErrorlogIn(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for unmuteAudio method
            * override this method for handling normal response from unmuteAudio operation
            */
           public void receiveResultunmuteAudio(
                    com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.UnmuteAudioResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from unmuteAudio operation
           */
            public void receiveErrorunmuteAudio(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for updatePassword method
            * override this method for handling normal response from updatePassword operation
            */
           public void receiveResultupdatePassword(
                    com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.UpdatePasswordResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from updatePassword operation
           */
            public void receiveErrorupdatePassword(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for stopVideo method
            * override this method for handling normal response from stopVideo operation
            */
           public void receiveResultstopVideo(
                    com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.StopVideoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from stopVideo operation
           */
            public void receiveErrorstopVideo(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for lockRoom method
            * override this method for handling normal response from lockRoom operation
            */
           public void receiveResultlockRoom(
                    com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.LockRoomResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from lockRoom operation
           */
            public void receiveErrorlockRoom(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getUserName method
            * override this method for handling normal response from getUserName operation
            */
           public void receiveResultgetUserName(
                    com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.GetUserNameResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getUserName operation
           */
            public void receiveErrorgetUserName(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for search method
            * override this method for handling normal response from search operation
            */
           public void receiveResultsearch(
                    com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.SearchResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from search operation
           */
            public void receiveErrorsearch(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteRoom method
            * override this method for handling normal response from deleteRoom operation
            */
           public void receiveResultdeleteRoom(
                    com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.DeleteRoomResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteRoom operation
           */
            public void receiveErrordeleteRoom(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for myAccount method
            * override this method for handling normal response from myAccount operation
            */
           public void receiveResultmyAccount(
                    com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.MyAccountResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from myAccount operation
           */
            public void receiveErrormyAccount(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getRoomProfiles method
            * override this method for handling normal response from getRoomProfiles operation
            */
           public void receiveResultgetRoomProfiles(
                    com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.GetRoomProfilesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getRoomProfiles operation
           */
            public void receiveErrorgetRoomProfiles(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for joinConference method
            * override this method for handling normal response from joinConference operation
            */
           public void receiveResultjoinConference(
                    com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.JoinConferenceResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from joinConference operation
           */
            public void receiveErrorjoinConference(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for unlockRoom method
            * override this method for handling normal response from unlockRoom operation
            */
           public void receiveResultunlockRoom(
                    com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.UnlockRoomResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from unlockRoom operation
           */
            public void receiveErrorunlockRoom(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for directCall method
            * override this method for handling normal response from directCall operation
            */
           public void receiveResultdirectCall(
                    com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.DirectCallResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from directCall operation
           */
            public void receiveErrordirectCall(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for removeRoomProfile method
            * override this method for handling normal response from removeRoomProfile operation
            */
           public void receiveResultremoveRoomProfile(
                    com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.RemoveRoomProfileResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from removeRoomProfile operation
           */
            public void receiveErrorremoveRoomProfile(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for createModeratorPIN method
            * override this method for handling normal response from createModeratorPIN operation
            */
           public void receiveResultcreateModeratorPIN(
                    com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.CreateModeratorPINResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from createModeratorPIN operation
           */
            public void receiveErrorcreateModeratorPIN(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for removeFromMyContacts method
            * override this method for handling normal response from removeFromMyContacts operation
            */
           public void receiveResultremoveFromMyContacts(
                    com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.RemoveFromMyContactsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from removeFromMyContacts operation
           */
            public void receiveErrorremoveFromMyContacts(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for setMemberMode method
            * override this method for handling normal response from setMemberMode operation
            */
           public void receiveResultsetMemberMode(
                    com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.SetMemberModeResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from setMemberMode operation
           */
            public void receiveErrorsetMemberMode(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for createRoomURL method
            * override this method for handling normal response from createRoomURL operation
            */
           public void receiveResultcreateRoomURL(
                    com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.CreateRoomURLResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from createRoomURL operation
           */
            public void receiveErrorcreateRoomURL(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getEntityByRoomKey method
            * override this method for handling normal response from getEntityByRoomKey operation
            */
           public void receiveResultgetEntityByRoomKey(
                    com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.GetEntityByRoomKeyResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getEntityByRoomKey operation
           */
            public void receiveErrorgetEntityByRoomKey(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for stopRecording method
            * override this method for handling normal response from stopRecording operation
            */
           public void receiveResultstopRecording(
                    com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.StopRecordingResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from stopRecording operation
           */
            public void receiveErrorstopRecording(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for createRoomPIN method
            * override this method for handling normal response from createRoomPIN operation
            */
           public void receiveResultcreateRoomPIN(
                    com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.CreateRoomPINResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from createRoomPIN operation
           */
            public void receiveErrorcreateRoomPIN(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for muteAudio method
            * override this method for handling normal response from muteAudio operation
            */
           public void receiveResultmuteAudio(
                    com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.MuteAudioResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from muteAudio operation
           */
            public void receiveErrormuteAudio(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for updateLanguage method
            * override this method for handling normal response from updateLanguage operation
            */
           public void receiveResultupdateLanguage(
                    com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.UpdateLanguageResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from updateLanguage operation
           */
            public void receiveErrorupdateLanguage(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for setRoomProfile method
            * override this method for handling normal response from setRoomProfile operation
            */
           public void receiveResultsetRoomProfile(
                    com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.SetRoomProfileResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from setRoomProfile operation
           */
            public void receiveErrorsetRoomProfile(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getRecordingProfiles method
            * override this method for handling normal response from getRecordingProfiles operation
            */
           public void receiveResultgetRecordingProfiles(
                    com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.GetRecordingProfilesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getRecordingProfiles operation
           */
            public void receiveErrorgetRecordingProfiles(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for removeModeratorPIN method
            * override this method for handling normal response from removeModeratorPIN operation
            */
           public void receiveResultremoveModeratorPIN(
                    com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.RemoveModeratorPINResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from removeModeratorPIN operation
           */
            public void receiveErrorremoveModeratorPIN(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for createRoom method
            * override this method for handling normal response from createRoom operation
            */
           public void receiveResultcreateRoom(
                    com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.CreateRoomResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from createRoom operation
           */
            public void receiveErrorcreateRoom(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for searchByEntityID method
            * override this method for handling normal response from searchByEntityID operation
            */
           public void receiveResultsearchByEntityID(
                    com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.SearchByEntityIDResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from searchByEntityID operation
           */
            public void receiveErrorsearchByEntityID(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for removeRoomPIN method
            * override this method for handling normal response from removeRoomPIN operation
            */
           public void receiveResultremoveRoomPIN(
                    com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.RemoveRoomPINResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from removeRoomPIN operation
           */
            public void receiveErrorremoveRoomPIN(java.lang.Exception e) {
            }
                


    }
    