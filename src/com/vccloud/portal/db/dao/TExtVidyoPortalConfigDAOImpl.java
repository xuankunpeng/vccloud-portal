package com.vccloud.portal.db.dao;

import com.vccloud.portal.db.model.TExtVidyoPortalConfig;
import com.vccloud.portal.db.model.TExtVidyoPortalConfigExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class TExtVidyoPortalConfigDAOImpl extends SqlMapClientDaoSupport implements TExtVidyoPortalConfigDAO {

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_ext_vidyo_portal_config
     *
     * @ibatorgenerated Fri Feb 28 11:49:46 CST 2014
     */
    public TExtVidyoPortalConfigDAOImpl() {
        super();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_ext_vidyo_portal_config
     *
     * @ibatorgenerated Fri Feb 28 11:49:46 CST 2014
     */
    public int countByExample(TExtVidyoPortalConfigExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("t_ext_vidyo_portal_config.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_ext_vidyo_portal_config
     *
     * @ibatorgenerated Fri Feb 28 11:49:46 CST 2014
     */
    public int deleteByExample(TExtVidyoPortalConfigExample example) {
        int rows = getSqlMapClientTemplate().delete("t_ext_vidyo_portal_config.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_ext_vidyo_portal_config
     *
     * @ibatorgenerated Fri Feb 28 11:49:46 CST 2014
     */
    public int deleteByPrimaryKey(Long id) {
        TExtVidyoPortalConfig key = new TExtVidyoPortalConfig();
        key.setId(id);
        int rows = getSqlMapClientTemplate().delete("t_ext_vidyo_portal_config.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_ext_vidyo_portal_config
     *
     * @ibatorgenerated Fri Feb 28 11:49:46 CST 2014
     */
    public Long insert(TExtVidyoPortalConfig record) {
        Object newKey = getSqlMapClientTemplate().insert("t_ext_vidyo_portal_config.ibatorgenerated_insert", record);
        return (Long) newKey;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_ext_vidyo_portal_config
     *
     * @ibatorgenerated Fri Feb 28 11:49:46 CST 2014
     */
    public Long insertSelective(TExtVidyoPortalConfig record) {
        Object newKey = getSqlMapClientTemplate().insert("t_ext_vidyo_portal_config.ibatorgenerated_insertSelective", record);
        return (Long) newKey;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_ext_vidyo_portal_config
     *
     * @ibatorgenerated Fri Feb 28 11:49:46 CST 2014
     */
    public List selectByExample(TExtVidyoPortalConfigExample example) {
        List list = getSqlMapClientTemplate().queryForList("t_ext_vidyo_portal_config.ibatorgenerated_selectByExample", example);
        return list;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_ext_vidyo_portal_config
     *
     * @ibatorgenerated Fri Feb 28 11:49:46 CST 2014
     */
    public TExtVidyoPortalConfig selectByPrimaryKey(Long id) {
        TExtVidyoPortalConfig key = new TExtVidyoPortalConfig();
        key.setId(id);
        TExtVidyoPortalConfig record = (TExtVidyoPortalConfig) getSqlMapClientTemplate().queryForObject("t_ext_vidyo_portal_config.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_ext_vidyo_portal_config
     *
     * @ibatorgenerated Fri Feb 28 11:49:46 CST 2014
     */
    public int updateByExampleSelective(TExtVidyoPortalConfig record, TExtVidyoPortalConfigExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("t_ext_vidyo_portal_config.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_ext_vidyo_portal_config
     *
     * @ibatorgenerated Fri Feb 28 11:49:46 CST 2014
     */
    public int updateByExample(TExtVidyoPortalConfig record, TExtVidyoPortalConfigExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("t_ext_vidyo_portal_config.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_ext_vidyo_portal_config
     *
     * @ibatorgenerated Fri Feb 28 11:49:46 CST 2014
     */
    public int updateByPrimaryKeySelective(TExtVidyoPortalConfig record) {
        int rows = getSqlMapClientTemplate().update("t_ext_vidyo_portal_config.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_ext_vidyo_portal_config
     *
     * @ibatorgenerated Fri Feb 28 11:49:46 CST 2014
     */
    public int updateByPrimaryKey(TExtVidyoPortalConfig record) {
        int rows = getSqlMapClientTemplate().update("t_ext_vidyo_portal_config.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table t_ext_vidyo_portal_config
     *
     * @ibatorgenerated Fri Feb 28 11:49:46 CST 2014
     */
    private static class UpdateByExampleParms extends TExtVidyoPortalConfigExample {
        private Object record;

        public UpdateByExampleParms(Object record, TExtVidyoPortalConfigExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}