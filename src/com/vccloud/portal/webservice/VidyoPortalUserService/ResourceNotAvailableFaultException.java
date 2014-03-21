
/**
 * ResourceNotAvailableFaultException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package com.vccloud.portal.webservice.VidyoPortalUserService;

public class ResourceNotAvailableFaultException extends java.lang.Exception{

    private static final long serialVersionUID = 1384160478673L;
    
    private com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.ResourceNotAvailableFault faultMessage;

    
        public ResourceNotAvailableFaultException() {
            super("ResourceNotAvailableFaultException");
        }

        public ResourceNotAvailableFaultException(java.lang.String s) {
           super(s);
        }

        public ResourceNotAvailableFaultException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public ResourceNotAvailableFaultException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.ResourceNotAvailableFault msg){
       faultMessage = msg;
    }
    
    public com.vccloud.portal.webservice.VidyoPortalUserService.VidyoPortalUserServiceStub.ResourceNotAvailableFault getFaultMessage(){
       return faultMessage;
    }
}
    