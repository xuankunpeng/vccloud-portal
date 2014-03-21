
/**
 * InvalidTenantFaultException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package com.vccloud.portal.webservice.VidyoPortalSuperService;

public class InvalidTenantFaultException extends java.lang.Exception{

    private static final long serialVersionUID = 1380280526249L;
    
    private com.vccloud.portal.webservice.VidyoPortalSuperService.VidyoPortalSuperServiceStub.InvalidTenantFault faultMessage;

    
        public InvalidTenantFaultException() {
            super("InvalidTenantFaultException");
        }

        public InvalidTenantFaultException(java.lang.String s) {
           super(s);
        }

        public InvalidTenantFaultException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public InvalidTenantFaultException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(com.vccloud.portal.webservice.VidyoPortalSuperService.VidyoPortalSuperServiceStub.InvalidTenantFault msg){
       faultMessage = msg;
    }
    
    public com.vccloud.portal.webservice.VidyoPortalSuperService.VidyoPortalSuperServiceStub.InvalidTenantFault getFaultMessage(){
       return faultMessage;
    }
}
    