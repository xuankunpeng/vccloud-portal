package com.vccloud.portal.db.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.vccloud.portal.db.model.TLegacy;
import com.vccloud.portal.db.model.TLegacyExample;
import com.vccloud.portal.util.CommonUtil;

public class TLegacyDAOImpl extends SqlMapClientDaoSupport implements TLegacyDAO {

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_legacy
     *
     * @ibatorgenerated Mon Nov 11 11:18:59 CST 2013
     */
    public TLegacyDAOImpl() {
        super();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_legacy
     *
     * @ibatorgenerated Mon Nov 11 11:18:59 CST 2013
     */
    public int countByExample(TLegacyExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("t_legacy.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_legacy
     *
     * @ibatorgenerated Mon Nov 11 11:18:59 CST 2013
     */
    public int deleteByExample(TLegacyExample example) {
        int rows = getSqlMapClientTemplate().delete("t_legacy.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_legacy
     *
     * @ibatorgenerated Mon Nov 11 11:18:59 CST 2013
     */
    public int deleteByPrimaryKey(Long id) {
        TLegacy key = new TLegacy();
        key.setId(id);
        int rows = getSqlMapClientTemplate().delete("t_legacy.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_legacy
     *
     * @ibatorgenerated Mon Nov 11 11:18:59 CST 2013
     */
    public Long insert(TLegacy record) {
        Object newKey = getSqlMapClientTemplate().insert("t_legacy.ibatorgenerated_insert", record);
        return (Long) newKey;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_legacy
     *
     * @ibatorgenerated Mon Nov 11 11:18:59 CST 2013
     */
    public Long insertSelective(TLegacy record) {
        Object newKey = getSqlMapClientTemplate().insert("t_legacy.ibatorgenerated_insertSelective", record);
        return (Long) newKey;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_legacy
     *
     * @ibatorgenerated Mon Nov 11 11:18:59 CST 2013
     */
    public List selectByExample(TLegacyExample example) {
        List list = getSqlMapClientTemplate().queryForList("t_legacy.ibatorgenerated_selectByExample", example);
        return list;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_legacy
     *
     * @ibatorgenerated Mon Nov 11 11:18:59 CST 2013
     */
    public TLegacy selectByPrimaryKey(Long id) {
        TLegacy key = new TLegacy();
        key.setId(id);
        TLegacy record = (TLegacy) getSqlMapClientTemplate().queryForObject("t_legacy.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_legacy
     *
     * @ibatorgenerated Mon Nov 11 11:18:59 CST 2013
     */
    public int updateByExampleSelective(TLegacy record, TLegacyExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("t_legacy.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_legacy
     *
     * @ibatorgenerated Mon Nov 11 11:18:59 CST 2013
     */
    public int updateByExample(TLegacy record, TLegacyExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("t_legacy.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_legacy
     *
     * @ibatorgenerated Mon Nov 11 11:18:59 CST 2013
     */
    public int updateByPrimaryKeySelective(TLegacy record) {
        int rows = getSqlMapClientTemplate().update("t_legacy.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_legacy
     *
     * @ibatorgenerated Mon Nov 11 11:18:59 CST 2013
     */
    public int updateByPrimaryKey(TLegacy record) {
        int rows = getSqlMapClientTemplate().update("t_legacy.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table t_legacy
     *
     * @ibatorgenerated Mon Nov 11 11:18:59 CST 2013
     */
    private static class UpdateByExampleParms extends TLegacyExample {
        private Object record;

        public UpdateByExampleParms(Object record, TLegacyExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }

	public List<TLegacy> searchLegacies(long tenantId, String keyword,
			int startIndex, int pageSize) {
		Map params = new HashMap();
		if (!CommonUtil.isNullOrEmpty(keyword)) {
			params.put("keyword", keyword);
		}
		params.put("tenantId", tenantId);
		params.put("startIndex", startIndex);
		params.put("pageSize", pageSize);
		List<TLegacy> resultList = getSqlMapClientTemplate()
				.queryForList("t_legacy.searchLegacies", params);
		return resultList;
	}

	public int countLegacies(long tenantId, String keyword) {
		Map params = new HashMap();
		if (!CommonUtil.isNullOrEmpty(keyword)) {
			params.put("keyword", keyword);
		}
		params.put("tenantId", tenantId);
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject(
				"t_legacy.countLegacies", params);
		return count.intValue();
	}
}