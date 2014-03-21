
/**
 * RoomAlreadyExistsFaultException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package com.vccloud.portal.webservice.VidyoPortalAdminService;

public class RoomAlreadyExistsFaultException extends java.lang.Exception{

    private static final long serialVersionUID = 1385103217438L;
    
    private com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.RoomAlreadyExistsFault faultMessage;

    
        public RoomAlreadyExistsFaultException() {
            super("RoomAlreadyExistsFaultException");
        }

        public RoomAlreadyExistsFaultException(java.lang.String s) {
           super(s);
        }

        public RoomAlreadyExistsFaultException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public RoomAlreadyExistsFaultException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.RoomAlreadyExistsFault msg){
       faultMessage = msg;
    }
    
    public com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.RoomAlreadyExistsFault getFaultMessage(){
       return faultMessage;
    }
}
    