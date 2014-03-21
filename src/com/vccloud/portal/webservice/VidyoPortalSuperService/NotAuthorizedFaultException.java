
/**
 * NotAuthorizedFaultException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package com.vccloud.portal.webservice.VidyoPortalSuperService;

public class NotAuthorizedFaultException extends java.lang.Exception{

    private static final long serialVersionUID = 1380280526233L;
    
    private com.vccloud.portal.webservice.VidyoPortalSuperService.VidyoPortalSuperServiceStub.NotAuthorizedFault faultMessage;

    
        public NotAuthorizedFaultException() {
            super("NotAuthorizedFaultException");
        }

        public NotAuthorizedFaultException(java.lang.String s) {
           super(s);
        }

        public NotAuthorizedFaultException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public NotAuthorizedFaultException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(com.vccloud.portal.webservice.VidyoPortalSuperService.VidyoPortalSuperServiceStub.NotAuthorizedFault msg){
       faultMessage = msg;
    }
    
    public com.vccloud.portal.webservice.VidyoPortalSuperService.VidyoPortalSuperServiceStub.NotAuthorizedFault getFaultMessage(){
       return faultMessage;
    }
}
    