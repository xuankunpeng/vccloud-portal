package com.vccloud.portal.db.model;

public class TReportKey {
    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column t_report.portal_id
     *
     * @ibatorgenerated Thu Feb 13 16:00:43 CST 2014
     */
    private Long portalId;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column t_report.tenant_id
     *
     * @ibatorgenerated Thu Feb 13 16:00:43 CST 2014
     */
    private Long tenantId;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column t_report.portal_id
     *
     * @return the value of t_report.portal_id
     *
     * @ibatorgenerated Thu Feb 13 16:00:43 CST 2014
     */
    public Long getPortalId() {
        return portalId;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column t_report.portal_id
     *
     * @param portalId the value for t_report.portal_id
     *
     * @ibatorgenerated Thu Feb 13 16:00:43 CST 2014
     */
    public void setPortalId(Long portalId) {
        this.portalId = portalId;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column t_report.tenant_id
     *
     * @return the value of t_report.tenant_id
     *
     * @ibatorgenerated Thu Feb 13 16:00:43 CST 2014
     */
    public Long getTenantId() {
        return tenantId;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column t_report.tenant_id
     *
     * @param tenantId the value for t_report.tenant_id
     *
     * @ibatorgenerated Thu Feb 13 16:00:43 CST 2014
     */
    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }
}