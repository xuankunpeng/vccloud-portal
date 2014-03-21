package com.vccloud.portal.db.dao;

import com.vccloud.portal.db.model.TPortalInfo;
import com.vccloud.portal.db.model.TPortalInfoExample;
import java.util.List;

public interface TPortalInfoDAO {
    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_portal_info
     *
     * @ibatorgenerated Wed Mar 19 16:42:08 CST 2014
     */
    int countByExample(TPortalInfoExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_portal_info
     *
     * @ibatorgenerated Wed Mar 19 16:42:08 CST 2014
     */
    int deleteByExample(TPortalInfoExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_portal_info
     *
     * @ibatorgenerated Wed Mar 19 16:42:08 CST 2014
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_portal_info
     *
     * @ibatorgenerated Wed Mar 19 16:42:08 CST 2014
     */
    Long insert(TPortalInfo record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_portal_info
     *
     * @ibatorgenerated Wed Mar 19 16:42:08 CST 2014
     */
    Long insertSelective(TPortalInfo record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_portal_info
     *
     * @ibatorgenerated Wed Mar 19 16:42:08 CST 2014
     */
    List selectByExample(TPortalInfoExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_portal_info
     *
     * @ibatorgenerated Wed Mar 19 16:42:08 CST 2014
     */
    TPortalInfo selectByPrimaryKey(Long id);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_portal_info
     *
     * @ibatorgenerated Wed Mar 19 16:42:08 CST 2014
     */
    int updateByExampleSelective(TPortalInfo record, TPortalInfoExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_portal_info
     *
     * @ibatorgenerated Wed Mar 19 16:42:08 CST 2014
     */
    int updateByExample(TPortalInfo record, TPortalInfoExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_portal_info
     *
     * @ibatorgenerated Wed Mar 19 16:42:08 CST 2014
     */
    int updateByPrimaryKeySelective(TPortalInfo record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_portal_info
     *
     * @ibatorgenerated Wed Mar 19 16:42:08 CST 2014
     */
    int updateByPrimaryKey(TPortalInfo record);
}