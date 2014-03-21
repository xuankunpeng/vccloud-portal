
/**
 * ControlMeetingFaultException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package com.vccloud.portal.webservice.VidyoPortalUserService;

public class ControlMeetingFaultException extends java.lang.Exception{

    private static final long serialVersionUID = 1384160478704L;
    
    private com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.ControlMeetingFault faultMessage;

    
        public ControlMeetingFaultException() {
            super("ControlMeetingFaultException");
        }

        public ControlMeetingFaultException(java.lang.String s) {
           super(s);
        }

        public ControlMeetingFaultException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public ControlMeetingFaultException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.ControlMeetingFault msg){
       faultMessage = msg;
    }
    
    public com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.ControlMeetingFault getFaultMessage(){
       return faultMessage;
    }
}
    