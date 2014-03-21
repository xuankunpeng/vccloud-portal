package com.vccloud.portal.db.dao;

import com.vccloud.portal.db.model.TExtVidyoPortalConfig;
import com.vccloud.portal.db.model.TExtVidyoPortalConfigExample;
import java.util.List;

public interface TExtVidyoPortalConfigDAO {
    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_ext_vidyo_portal_config
     *
     * @ibatorgenerated Fri Feb 28 11:49:46 CST 2014
     */
    int countByExample(TExtVidyoPortalConfigExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_ext_vidyo_portal_config
     *
     * @ibatorgenerated Fri Feb 28 11:49:46 CST 2014
     */
    int deleteByExample(TExtVidyoPortalConfigExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_ext_vidyo_portal_config
     *
     * @ibatorgenerated Fri Feb 28 11:49:46 CST 2014
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_ext_vidyo_portal_config
     *
     * @ibatorgenerated Fri Feb 28 11:49:46 CST 2014
     */
    Long insert(TExtVidyoPortalConfig record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_ext_vidyo_portal_config
     *
     * @ibatorgenerated Fri Feb 28 11:49:46 CST 2014
     */
    Long insertSelective(TExtVidyoPortalConfig record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_ext_vidyo_portal_config
     *
     * @ibatorgenerated Fri Feb 28 11:49:46 CST 2014
     */
    List selectByExample(TExtVidyoPortalConfigExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_ext_vidyo_portal_config
     *
     * @ibatorgenerated Fri Feb 28 11:49:46 CST 2014
     */
    TExtVidyoPortalConfig selectByPrimaryKey(Long id);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_ext_vidyo_portal_config
     *
     * @ibatorgenerated Fri Feb 28 11:49:46 CST 2014
     */
    int updateByExampleSelective(TExtVidyoPortalConfig record, TExtVidyoPortalConfigExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_ext_vidyo_portal_config
     *
     * @ibatorgenerated Fri Feb 28 11:49:46 CST 2014
     */
    int updateByExample(TExtVidyoPortalConfig record, TExtVidyoPortalConfigExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_ext_vidyo_portal_config
     *
     * @ibatorgenerated Fri Feb 28 11:49:46 CST 2014
     */
    int updateByPrimaryKeySelective(TExtVidyoPortalConfig record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_ext_vidyo_portal_config
     *
     * @ibatorgenerated Fri Feb 28 11:49:46 CST 2014
     */
    int updateByPrimaryKey(TExtVidyoPortalConfig record);
}