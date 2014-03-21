
/**
 * ConferenceLockedFaultException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package com.vccloud.portal.webservice.VidyoPortalUserService;

public class ConferenceLockedFaultException extends java.lang.Exception{

    private static final long serialVersionUID = 1384160478720L;
    
    private com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.ConferenceLockedFault faultMessage;

    
        public ConferenceLockedFaultException() {
            super("ConferenceLockedFaultException");
        }

        public ConferenceLockedFaultException(java.lang.String s) {
           super(s);
        }

        public ConferenceLockedFaultException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public ConferenceLockedFaultException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.ConferenceLockedFault msg){
       faultMessage = msg;
    }
    
    public com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.ConferenceLockedFault getFaultMessage(){
       return faultMessage;
    }
}
    