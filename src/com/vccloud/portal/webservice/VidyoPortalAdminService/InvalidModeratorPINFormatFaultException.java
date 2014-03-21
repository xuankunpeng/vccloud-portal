
/**
 * InvalidModeratorPINFormatFaultException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package com.vccloud.portal.webservice.VidyoPortalAdminService;

public class InvalidModeratorPINFormatFaultException extends java.lang.Exception{

    private static final long serialVersionUID = 1385103217423L;
    
    private com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.InvalidModeratorPINFormatFault faultMessage;

    
        public InvalidModeratorPINFormatFaultException() {
            super("InvalidModeratorPINFormatFaultException");
        }

        public InvalidModeratorPINFormatFaultException(java.lang.String s) {
           super(s);
        }

        public InvalidModeratorPINFormatFaultException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public InvalidModeratorPINFormatFaultException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.InvalidModeratorPINFormatFault msg){
       faultMessage = msg;
    }
    
    public com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.InvalidModeratorPINFormatFault getFaultMessage(){
       return faultMessage;
    }
}
    