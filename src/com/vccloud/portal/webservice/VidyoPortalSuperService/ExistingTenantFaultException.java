
/**
 * ExistingTenantFaultException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package com.vccloud.portal.webservice.VidyoPortalSuperService;

public class ExistingTenantFaultException extends java.lang.Exception{

    private static final long serialVersionUID = 1380280526202L;
    
    private com.vccloud.portal.webservice.VidyoPortalSuperService.VidyoPortalSuperServiceStub.ExistingTenantFault faultMessage;

    
        public ExistingTenantFaultException() {
            super("ExistingTenantFaultException");
        }

        public ExistingTenantFaultException(java.lang.String s) {
           super(s);
        }

        public ExistingTenantFaultException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public ExistingTenantFaultException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(com.vccloud.portal.webservice.VidyoPortalSuperService.VidyoPortalSuperServiceStub.ExistingTenantFault msg){
       faultMessage = msg;
    }
    
    public com.vccloud.portal.webservice.VidyoPortalSuperService.VidyoPortalSuperServiceStub.ExistingTenantFault getFaultMessage(){
       return faultMessage;
    }
}
    