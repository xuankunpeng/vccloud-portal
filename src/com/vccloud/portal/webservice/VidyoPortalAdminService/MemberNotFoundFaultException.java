
/**
 * MemberNotFoundFaultException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package com.vccloud.portal.webservice.VidyoPortalAdminService;

public class MemberNotFoundFaultException extends java.lang.Exception{

    private static final long serialVersionUID = 1385103217345L;
    
    private com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.MemberNotFoundFault faultMessage;

    
        public MemberNotFoundFaultException() {
            super("MemberNotFoundFaultException");
        }

        public MemberNotFoundFaultException(java.lang.String s) {
           super(s);
        }

        public MemberNotFoundFaultException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public MemberNotFoundFaultException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.MemberNotFoundFault msg){
       faultMessage = msg;
    }
    
    public com.vccloud.portal.webservice.VidyoPortalAdminService.VidyoPortalAdminServiceStub.MemberNotFoundFault getFaultMessage(){
       return faultMessage;
    }
}
    