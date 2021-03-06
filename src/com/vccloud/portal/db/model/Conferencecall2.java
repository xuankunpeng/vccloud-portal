package com.vccloud.portal.db.model;

import java.util.Date;

public class Conferencecall2 {
    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column ConferenceCall2.CallID
     *
     * @ibatorgenerated Thu Sep 05 15:50:58 CST 2013
     */
    private Integer callid;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column ConferenceCall2.UniqueCallID
     *
     * @ibatorgenerated Thu Sep 05 15:50:58 CST 2013
     */
    private String uniquecallid;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column ConferenceCall2.ConferenceName
     *
     * @ibatorgenerated Thu Sep 05 15:50:58 CST 2013
     */
    private String conferencename;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column ConferenceCall2.TenantName
     *
     * @ibatorgenerated Thu Sep 05 15:50:58 CST 2013
     */
    private String tenantname;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column ConferenceCall2.ConferenceType
     *
     * @ibatorgenerated Thu Sep 05 15:50:58 CST 2013
     */
    private String conferencetype;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column ConferenceCall2.EndpointType
     *
     * @ibatorgenerated Thu Sep 05 15:50:58 CST 2013
     */
    private String endpointtype;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column ConferenceCall2.CallerID
     *
     * @ibatorgenerated Thu Sep 05 15:50:58 CST 2013
     */
    private String callerid;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column ConferenceCall2.CallerName
     *
     * @ibatorgenerated Thu Sep 05 15:50:58 CST 2013
     */
    private String callername;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column ConferenceCall2.JoinTime
     *
     * @ibatorgenerated Thu Sep 05 15:50:58 CST 2013
     */
    private Date jointime;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column ConferenceCall2.LeaveTime
     *
     * @ibatorgenerated Thu Sep 05 15:50:58 CST 2013
     */
    private Date leavetime;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column ConferenceCall2.CallState
     *
     * @ibatorgenerated Thu Sep 05 15:50:58 CST 2013
     */
    private String callstate;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column ConferenceCall2.Direction
     *
     * @ibatorgenerated Thu Sep 05 15:50:58 CST 2013
     */
    private String direction;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column ConferenceCall2.RouterID
     *
     * @ibatorgenerated Thu Sep 05 15:50:58 CST 2013
     */
    private String routerid;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column ConferenceCall2.GWID
     *
     * @ibatorgenerated Thu Sep 05 15:50:58 CST 2013
     */
    private String gwid;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column ConferenceCall2.GWPrefix
     *
     * @ibatorgenerated Thu Sep 05 15:50:58 CST 2013
     */
    private String gwprefix;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column ConferenceCall2.CallID
     *
     * @return the value of ConferenceCall2.CallID
     *
     * @ibatorgenerated Thu Sep 05 15:50:58 CST 2013
     */
    public Integer getCallid() {
        return callid;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column ConferenceCall2.CallID
     *
     * @param callid the value for ConferenceCall2.CallID
     *
     * @ibatorgenerated Thu Sep 05 15:50:58 CST 2013
     */
    public void setCallid(Integer callid) {
        this.callid = callid;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column ConferenceCall2.UniqueCallID
     *
     * @return the value of ConferenceCall2.UniqueCallID
     *
     * @ibatorgenerated Thu Sep 05 15:50:58 CST 2013
     */
    public String getUniquecallid() {
        return uniquecallid;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column ConferenceCall2.UniqueCallID
     *
     * @param uniquecallid the value for ConferenceCall2.UniqueCallID
     *
     * @ibatorgenerated Thu Sep 05 15:50:58 CST 2013
     */
    public void setUniquecallid(String uniquecallid) {
        this.uniquecallid = uniquecallid == null ? null : uniquecallid.trim();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column ConferenceCall2.ConferenceName
     *
     * @return the value of ConferenceCall2.ConferenceName
     *
     * @ibatorgenerated Thu Sep 05 15:50:58 CST 2013
     */
    public String getConferencename() {
        return conferencename;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column ConferenceCall2.ConferenceName
     *
     * @param conferencename the value for ConferenceCall2.ConferenceName
     *
     * @ibatorgenerated Thu Sep 05 15:50:58 CST 2013
     */
    public void setConferencename(String conferencename) {
        this.conferencename = conferencename == null ? null : conferencename.trim();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column ConferenceCall2.TenantName
     *
     * @return the value of ConferenceCall2.TenantName
     *
     * @ibatorgenerated Thu Sep 05 15:50:58 CST 2013
     */
    public String getTenantname() {
        return tenantname;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column ConferenceCall2.TenantName
     *
     * @param tenantname the value for ConferenceCall2.TenantName
     *
     * @ibatorgenerated Thu Sep 05 15:50:58 CST 2013
     */
    public void setTenantname(String tenantname) {
        this.tenantname = tenantname == null ? null : tenantname.trim();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column ConferenceCall2.ConferenceType
     *
     * @return the value of ConferenceCall2.ConferenceType
     *
     * @ibatorgenerated Thu Sep 05 15:50:58 CST 2013
     */
    public String getConferencetype() {
        return conferencetype;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column ConferenceCall2.ConferenceType
     *
     * @param conferencetype the value for ConferenceCall2.ConferenceType
     *
     * @ibatorgenerated Thu Sep 05 15:50:58 CST 2013
     */
    public void setConferencetype(String conferencetype) {
        this.conferencetype = conferencetype == null ? null : conferencetype.trim();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column ConferenceCall2.EndpointType
     *
     * @return the value of ConferenceCall2.EndpointType
     *
     * @ibatorgenerated Thu Sep 05 15:50:58 CST 2013
     */
    public String getEndpointtype() {
        return endpointtype;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column ConferenceCall2.EndpointType
     *
     * @param endpointtype the value for ConferenceCall2.EndpointType
     *
     * @ibatorgenerated Thu Sep 05 15:50:58 CST 2013
     */
    public void setEndpointtype(String endpointtype) {
        this.endpointtype = endpointtype == null ? null : endpointtype.trim();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column ConferenceCall2.CallerID
     *
     * @return the value of ConferenceCall2.CallerID
     *
     * @ibatorgenerated Thu Sep 05 15:50:58 CST 2013
     */
    public String getCallerid() {
        return callerid;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column ConferenceCall2.CallerID
     *
     * @param callerid the value for ConferenceCall2.CallerID
     *
     * @ibatorgenerated Thu Sep 05 15:50:58 CST 2013
     */
    public void setCallerid(String callerid) {
        this.callerid = callerid == null ? null : callerid.trim();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column ConferenceCall2.CallerName
     *
     * @return the value of ConferenceCall2.CallerName
     *
     * @ibatorgenerated Thu Sep 05 15:50:58 CST 2013
     */
    public String getCallername() {
        return callername;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column ConferenceCall2.CallerName
     *
     * @param callername the value for ConferenceCall2.CallerName
     *
     * @ibatorgenerated Thu Sep 05 15:50:58 CST 2013
     */
    public void setCallername(String callername) {
        this.callername = callername == null ? null : callername.trim();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column ConferenceCall2.JoinTime
     *
     * @return the value of ConferenceCall2.JoinTime
     *
     * @ibatorgenerated Thu Sep 05 15:50:58 CST 2013
     */
    public Date getJointime() {
        return jointime;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column ConferenceCall2.JoinTime
     *
     * @param jointime the value for ConferenceCall2.JoinTime
     *
     * @ibatorgenerated Thu Sep 05 15:50:58 CST 2013
     */
    public void setJointime(Date jointime) {
        this.jointime = jointime;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column ConferenceCall2.LeaveTime
     *
     * @return the value of ConferenceCall2.LeaveTime
     *
     * @ibatorgenerated Thu Sep 05 15:50:58 CST 2013
     */
    public Date getLeavetime() {
        return leavetime;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column ConferenceCall2.LeaveTime
     *
     * @param leavetime the value for ConferenceCall2.LeaveTime
     *
     * @ibatorgenerated Thu Sep 05 15:50:58 CST 2013
     */
    public void setLeavetime(Date leavetime) {
        this.leavetime = leavetime;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column ConferenceCall2.CallState
     *
     * @return the value of ConferenceCall2.CallState
     *
     * @ibatorgenerated Thu Sep 05 15:50:58 CST 2013
     */
    public String getCallstate() {
        return callstate;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column ConferenceCall2.CallState
     *
     * @param callstate the value for ConferenceCall2.CallState
     *
     * @ibatorgenerated Thu Sep 05 15:50:58 CST 2013
     */
    public void setCallstate(String callstate) {
        this.callstate = callstate == null ? null : callstate.trim();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column ConferenceCall2.Direction
     *
     * @return the value of ConferenceCall2.Direction
     *
     * @ibatorgenerated Thu Sep 05 15:50:58 CST 2013
     */
    public String getDirection() {
        return direction;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column ConferenceCall2.Direction
     *
     * @param direction the value for ConferenceCall2.Direction
     *
     * @ibatorgenerated Thu Sep 05 15:50:58 CST 2013
     */
    public void setDirection(String direction) {
        this.direction = direction == null ? null : direction.trim();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column ConferenceCall2.RouterID
     *
     * @return the value of ConferenceCall2.RouterID
     *
     * @ibatorgenerated Thu Sep 05 15:50:58 CST 2013
     */
    public String getRouterid() {
        return routerid;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column ConferenceCall2.RouterID
     *
     * @param routerid the value for ConferenceCall2.RouterID
     *
     * @ibatorgenerated Thu Sep 05 15:50:58 CST 2013
     */
    public void setRouterid(String routerid) {
        this.routerid = routerid == null ? null : routerid.trim();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column ConferenceCall2.GWID
     *
     * @return the value of ConferenceCall2.GWID
     *
     * @ibatorgenerated Thu Sep 05 15:50:58 CST 2013
     */
    public String getGwid() {
        return gwid;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column ConferenceCall2.GWID
     *
     * @param gwid the value for ConferenceCall2.GWID
     *
     * @ibatorgenerated Thu Sep 05 15:50:58 CST 2013
     */
    public void setGwid(String gwid) {
        this.gwid = gwid == null ? null : gwid.trim();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column ConferenceCall2.GWPrefix
     *
     * @return the value of ConferenceCall2.GWPrefix
     *
     * @ibatorgenerated Thu Sep 05 15:50:58 CST 2013
     */
    public String getGwprefix() {
        return gwprefix;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column ConferenceCall2.GWPrefix
     *
     * @param gwprefix the value for ConferenceCall2.GWPrefix
     *
     * @ibatorgenerated Thu Sep 05 15:50:58 CST 2013
     */
    public void setGwprefix(String gwprefix) {
        this.gwprefix = gwprefix == null ? null : gwprefix.trim();
    }
}