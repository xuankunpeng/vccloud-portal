
/**
 * IncorrectIpcAccessLevelFaultException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package com.vccloud.portal.webservice.VidyoPortalSuperService;

public class IncorrectIpcAccessLevelFaultException extends java.lang.Exception{

    private static final long serialVersionUID = 1380280526217L;
    
    private com.vccloud.portal.webservice.VidyoPortalSuperService.VidyoPortalSuperServiceStub.IncorrectIpcAccessLevelFault faultMessage;

    
        public IncorrectIpcAccessLevelFaultException() {
            super("IncorrectIpcAccessLevelFaultException");
        }

        public IncorrectIpcAccessLevelFaultException(java.lang.String s) {
           super(s);
        }

        public IncorrectIpcAccessLevelFaultException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public IncorrectIpcAccessLevelFaultException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(com.vccloud.portal.webservice.VidyoPortalSuperService.VidyoPortalSuperServiceStub.IncorrectIpcAccessLevelFault msg){
       faultMessage = msg;
    }
    
    public com.vccloud.portal.webservice.VidyoPortalSuperService.VidyoPortalSuperServiceStub.IncorrectIpcAccessLevelFault getFaultMessage(){
       return faultMessage;
    }
}
    