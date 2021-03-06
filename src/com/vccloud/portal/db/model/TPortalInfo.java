package com.vccloud.portal.db.model;

import java.util.Date;

public class TPortalInfo {
    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column t_portal_info.id
     *
     * @ibatorgenerated Wed Mar 19 16:42:08 CST 2014
     */
    private Long id;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column t_portal_info.portal_url
     *
     * @ibatorgenerated Wed Mar 19 16:42:08 CST 2014
     */
    private String portalUrl;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column t_portal_info.logo_url
     *
     * @ibatorgenerated Wed Mar 19 16:42:08 CST 2014
     */
    private String logoUrl;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column t_portal_info.welcome_word
     *
     * @ibatorgenerated Wed Mar 19 16:42:08 CST 2014
     */
    private String welcomeWord;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column t_portal_info.admin_name
     *
     * @ibatorgenerated Wed Mar 19 16:42:08 CST 2014
     */
    private String adminName;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column t_portal_info.admin_password
     *
     * @ibatorgenerated Wed Mar 19 16:42:08 CST 2014
     */
    private String adminPassword;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column t_portal_info.display_name
     *
     * @ibatorgenerated Wed Mar 19 16:42:08 CST 2014
     */
    private String displayName;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column t_portal_info.create_time
     *
     * @ibatorgenerated Wed Mar 19 16:42:08 CST 2014
     */
    private Date createTime;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column t_portal_info.update_time
     *
     * @ibatorgenerated Wed Mar 19 16:42:08 CST 2014
     */
    private Date updateTime;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column t_portal_info.acl
     *
     * @ibatorgenerated Wed Mar 19 16:42:08 CST 2014
     */
    private String acl;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column t_portal_info.id
     *
     * @return the value of t_portal_info.id
     *
     * @ibatorgenerated Wed Mar 19 16:42:08 CST 2014
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column t_portal_info.id
     *
     * @param id the value for t_portal_info.id
     *
     * @ibatorgenerated Wed Mar 19 16:42:08 CST 2014
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column t_portal_info.portal_url
     *
     * @return the value of t_portal_info.portal_url
     *
     * @ibatorgenerated Wed Mar 19 16:42:08 CST 2014
     */
    public String getPortalUrl() {
        return portalUrl;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column t_portal_info.portal_url
     *
     * @param portalUrl the value for t_portal_info.portal_url
     *
     * @ibatorgenerated Wed Mar 19 16:42:08 CST 2014
     */
    public void setPortalUrl(String portalUrl) {
        this.portalUrl = portalUrl == null ? null : portalUrl.trim();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column t_portal_info.logo_url
     *
     * @return the value of t_portal_info.logo_url
     *
     * @ibatorgenerated Wed Mar 19 16:42:08 CST 2014
     */
    public String getLogoUrl() {
        return logoUrl;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column t_portal_info.logo_url
     *
     * @param logoUrl the value for t_portal_info.logo_url
     *
     * @ibatorgenerated Wed Mar 19 16:42:08 CST 2014
     */
    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl == null ? null : logoUrl.trim();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column t_portal_info.welcome_word
     *
     * @return the value of t_portal_info.welcome_word
     *
     * @ibatorgenerated Wed Mar 19 16:42:08 CST 2014
     */
    public String getWelcomeWord() {
        return welcomeWord;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column t_portal_info.welcome_word
     *
     * @param welcomeWord the value for t_portal_info.welcome_word
     *
     * @ibatorgenerated Wed Mar 19 16:42:08 CST 2014
     */
    public void setWelcomeWord(String welcomeWord) {
        this.welcomeWord = welcomeWord == null ? null : welcomeWord.trim();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column t_portal_info.admin_name
     *
     * @return the value of t_portal_info.admin_name
     *
     * @ibatorgenerated Wed Mar 19 16:42:08 CST 2014
     */
    public String getAdminName() {
        return adminName;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column t_portal_info.admin_name
     *
     * @param adminName the value for t_portal_info.admin_name
     *
     * @ibatorgenerated Wed Mar 19 16:42:08 CST 2014
     */
    public void setAdminName(String adminName) {
        this.adminName = adminName == null ? null : adminName.trim();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column t_portal_info.admin_password
     *
     * @return the value of t_portal_info.admin_password
     *
     * @ibatorgenerated Wed Mar 19 16:42:08 CST 2014
     */
    public String getAdminPassword() {
        return adminPassword;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column t_portal_info.admin_password
     *
     * @param adminPassword the value for t_portal_info.admin_password
     *
     * @ibatorgenerated Wed Mar 19 16:42:08 CST 2014
     */
    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword == null ? null : adminPassword.trim();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column t_portal_info.display_name
     *
     * @return the value of t_portal_info.display_name
     *
     * @ibatorgenerated Wed Mar 19 16:42:08 CST 2014
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column t_portal_info.display_name
     *
     * @param displayName the value for t_portal_info.display_name
     *
     * @ibatorgenerated Wed Mar 19 16:42:08 CST 2014
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName == null ? null : displayName.trim();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column t_portal_info.create_time
     *
     * @return the value of t_portal_info.create_time
     *
     * @ibatorgenerated Wed Mar 19 16:42:08 CST 2014
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column t_portal_info.create_time
     *
     * @param createTime the value for t_portal_info.create_time
     *
     * @ibatorgenerated Wed Mar 19 16:42:08 CST 2014
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column t_portal_info.update_time
     *
     * @return the value of t_portal_info.update_time
     *
     * @ibatorgenerated Wed Mar 19 16:42:08 CST 2014
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column t_portal_info.update_time
     *
     * @param updateTime the value for t_portal_info.update_time
     *
     * @ibatorgenerated Wed Mar 19 16:42:08 CST 2014
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column t_portal_info.acl
     *
     * @return the value of t_portal_info.acl
     *
     * @ibatorgenerated Wed Mar 19 16:42:08 CST 2014
     */
    public String getAcl() {
        return acl;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column t_portal_info.acl
     *
     * @param acl the value for t_portal_info.acl
     *
     * @ibatorgenerated Wed Mar 19 16:42:08 CST 2014
     */
    public void setAcl(String acl) {
        this.acl = acl == null ? null : acl.trim();
    }
}