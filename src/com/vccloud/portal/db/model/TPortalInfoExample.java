package com.vccloud.portal.db.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TPortalInfoExample {
    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database table t_portal_info
     *
     * @ibatorgenerated Wed Mar 19 16:42:08 CST 2014
     */
    protected String orderByClause;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database table t_portal_info
     *
     * @ibatorgenerated Wed Mar 19 16:42:08 CST 2014
     */
    protected List oredCriteria;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_portal_info
     *
     * @ibatorgenerated Wed Mar 19 16:42:08 CST 2014
     */
    public TPortalInfoExample() {
        oredCriteria = new ArrayList();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_portal_info
     *
     * @ibatorgenerated Wed Mar 19 16:42:08 CST 2014
     */
    protected TPortalInfoExample(TPortalInfoExample example) {
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_portal_info
     *
     * @ibatorgenerated Wed Mar 19 16:42:08 CST 2014
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_portal_info
     *
     * @ibatorgenerated Wed Mar 19 16:42:08 CST 2014
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_portal_info
     *
     * @ibatorgenerated Wed Mar 19 16:42:08 CST 2014
     */
    public List getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_portal_info
     *
     * @ibatorgenerated Wed Mar 19 16:42:08 CST 2014
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_portal_info
     *
     * @ibatorgenerated Wed Mar 19 16:42:08 CST 2014
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_portal_info
     *
     * @ibatorgenerated Wed Mar 19 16:42:08 CST 2014
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_portal_info
     *
     * @ibatorgenerated Wed Mar 19 16:42:08 CST 2014
     */
    public void clear() {
        oredCriteria.clear();
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table t_portal_info
     *
     * @ibatorgenerated Wed Mar 19 16:42:08 CST 2014
     */
    public static class Criteria {
        protected List criteriaWithoutValue;

        protected List criteriaWithSingleValue;

        protected List criteriaWithListValue;

        protected List criteriaWithBetweenValue;

        protected Criteria() {
            super();
            criteriaWithoutValue = new ArrayList();
            criteriaWithSingleValue = new ArrayList();
            criteriaWithListValue = new ArrayList();
            criteriaWithBetweenValue = new ArrayList();
        }

        public boolean isValid() {
            return criteriaWithoutValue.size() > 0
                || criteriaWithSingleValue.size() > 0
                || criteriaWithListValue.size() > 0
                || criteriaWithBetweenValue.size() > 0;
        }

        public List getCriteriaWithoutValue() {
            return criteriaWithoutValue;
        }

        public List getCriteriaWithSingleValue() {
            return criteriaWithSingleValue;
        }

        public List getCriteriaWithListValue() {
            return criteriaWithListValue;
        }

        public List getCriteriaWithBetweenValue() {
            return criteriaWithBetweenValue;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteriaWithoutValue.add(condition);
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            Map map = new HashMap();
            map.put("condition", condition);
            map.put("value", value);
            criteriaWithSingleValue.add(map);
        }

        protected void addCriterion(String condition, List values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            Map map = new HashMap();
            map.put("condition", condition);
            map.put("values", values);
            criteriaWithListValue.add(map);
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            List list = new ArrayList();
            list.add(value1);
            list.add(value2);
            Map map = new HashMap();
            map.put("condition", condition);
            map.put("values", list);
            criteriaWithBetweenValue.add(map);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return this;
        }

        public Criteria andIdIn(List values) {
            addCriterion("id in", values, "id");
            return this;
        }

        public Criteria andIdNotIn(List values) {
            addCriterion("id not in", values, "id");
            return this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return this;
        }

        public Criteria andPortalUrlIsNull() {
            addCriterion("portal_url is null");
            return this;
        }

        public Criteria andPortalUrlIsNotNull() {
            addCriterion("portal_url is not null");
            return this;
        }

        public Criteria andPortalUrlEqualTo(String value) {
            addCriterion("portal_url =", value, "portalUrl");
            return this;
        }

        public Criteria andPortalUrlNotEqualTo(String value) {
            addCriterion("portal_url <>", value, "portalUrl");
            return this;
        }

        public Criteria andPortalUrlGreaterThan(String value) {
            addCriterion("portal_url >", value, "portalUrl");
            return this;
        }

        public Criteria andPortalUrlGreaterThanOrEqualTo(String value) {
            addCriterion("portal_url >=", value, "portalUrl");
            return this;
        }

        public Criteria andPortalUrlLessThan(String value) {
            addCriterion("portal_url <", value, "portalUrl");
            return this;
        }

        public Criteria andPortalUrlLessThanOrEqualTo(String value) {
            addCriterion("portal_url <=", value, "portalUrl");
            return this;
        }

        public Criteria andPortalUrlLike(String value) {
            addCriterion("portal_url like", value, "portalUrl");
            return this;
        }

        public Criteria andPortalUrlNotLike(String value) {
            addCriterion("portal_url not like", value, "portalUrl");
            return this;
        }

        public Criteria andPortalUrlIn(List values) {
            addCriterion("portal_url in", values, "portalUrl");
            return this;
        }

        public Criteria andPortalUrlNotIn(List values) {
            addCriterion("portal_url not in", values, "portalUrl");
            return this;
        }

        public Criteria andPortalUrlBetween(String value1, String value2) {
            addCriterion("portal_url between", value1, value2, "portalUrl");
            return this;
        }

        public Criteria andPortalUrlNotBetween(String value1, String value2) {
            addCriterion("portal_url not between", value1, value2, "portalUrl");
            return this;
        }

        public Criteria andLogoUrlIsNull() {
            addCriterion("logo_url is null");
            return this;
        }

        public Criteria andLogoUrlIsNotNull() {
            addCriterion("logo_url is not null");
            return this;
        }

        public Criteria andLogoUrlEqualTo(String value) {
            addCriterion("logo_url =", value, "logoUrl");
            return this;
        }

        public Criteria andLogoUrlNotEqualTo(String value) {
            addCriterion("logo_url <>", value, "logoUrl");
            return this;
        }

        public Criteria andLogoUrlGreaterThan(String value) {
            addCriterion("logo_url >", value, "logoUrl");
            return this;
        }

        public Criteria andLogoUrlGreaterThanOrEqualTo(String value) {
            addCriterion("logo_url >=", value, "logoUrl");
            return this;
        }

        public Criteria andLogoUrlLessThan(String value) {
            addCriterion("logo_url <", value, "logoUrl");
            return this;
        }

        public Criteria andLogoUrlLessThanOrEqualTo(String value) {
            addCriterion("logo_url <=", value, "logoUrl");
            return this;
        }

        public Criteria andLogoUrlLike(String value) {
            addCriterion("logo_url like", value, "logoUrl");
            return this;
        }

        public Criteria andLogoUrlNotLike(String value) {
            addCriterion("logo_url not like", value, "logoUrl");
            return this;
        }

        public Criteria andLogoUrlIn(List values) {
            addCriterion("logo_url in", values, "logoUrl");
            return this;
        }

        public Criteria andLogoUrlNotIn(List values) {
            addCriterion("logo_url not in", values, "logoUrl");
            return this;
        }

        public Criteria andLogoUrlBetween(String value1, String value2) {
            addCriterion("logo_url between", value1, value2, "logoUrl");
            return this;
        }

        public Criteria andLogoUrlNotBetween(String value1, String value2) {
            addCriterion("logo_url not between", value1, value2, "logoUrl");
            return this;
        }

        public Criteria andWelcomeWordIsNull() {
            addCriterion("welcome_word is null");
            return this;
        }

        public Criteria andWelcomeWordIsNotNull() {
            addCriterion("welcome_word is not null");
            return this;
        }

        public Criteria andWelcomeWordEqualTo(String value) {
            addCriterion("welcome_word =", value, "welcomeWord");
            return this;
        }

        public Criteria andWelcomeWordNotEqualTo(String value) {
            addCriterion("welcome_word <>", value, "welcomeWord");
            return this;
        }

        public Criteria andWelcomeWordGreaterThan(String value) {
            addCriterion("welcome_word >", value, "welcomeWord");
            return this;
        }

        public Criteria andWelcomeWordGreaterThanOrEqualTo(String value) {
            addCriterion("welcome_word >=", value, "welcomeWord");
            return this;
        }

        public Criteria andWelcomeWordLessThan(String value) {
            addCriterion("welcome_word <", value, "welcomeWord");
            return this;
        }

        public Criteria andWelcomeWordLessThanOrEqualTo(String value) {
            addCriterion("welcome_word <=", value, "welcomeWord");
            return this;
        }

        public Criteria andWelcomeWordLike(String value) {
            addCriterion("welcome_word like", value, "welcomeWord");
            return this;
        }

        public Criteria andWelcomeWordNotLike(String value) {
            addCriterion("welcome_word not like", value, "welcomeWord");
            return this;
        }

        public Criteria andWelcomeWordIn(List values) {
            addCriterion("welcome_word in", values, "welcomeWord");
            return this;
        }

        public Criteria andWelcomeWordNotIn(List values) {
            addCriterion("welcome_word not in", values, "welcomeWord");
            return this;
        }

        public Criteria andWelcomeWordBetween(String value1, String value2) {
            addCriterion("welcome_word between", value1, value2, "welcomeWord");
            return this;
        }

        public Criteria andWelcomeWordNotBetween(String value1, String value2) {
            addCriterion("welcome_word not between", value1, value2, "welcomeWord");
            return this;
        }

        public Criteria andAdminNameIsNull() {
            addCriterion("admin_name is null");
            return this;
        }

        public Criteria andAdminNameIsNotNull() {
            addCriterion("admin_name is not null");
            return this;
        }

        public Criteria andAdminNameEqualTo(String value) {
            addCriterion("admin_name =", value, "adminName");
            return this;
        }

        public Criteria andAdminNameNotEqualTo(String value) {
            addCriterion("admin_name <>", value, "adminName");
            return this;
        }

        public Criteria andAdminNameGreaterThan(String value) {
            addCriterion("admin_name >", value, "adminName");
            return this;
        }

        public Criteria andAdminNameGreaterThanOrEqualTo(String value) {
            addCriterion("admin_name >=", value, "adminName");
            return this;
        }

        public Criteria andAdminNameLessThan(String value) {
            addCriterion("admin_name <", value, "adminName");
            return this;
        }

        public Criteria andAdminNameLessThanOrEqualTo(String value) {
            addCriterion("admin_name <=", value, "adminName");
            return this;
        }

        public Criteria andAdminNameLike(String value) {
            addCriterion("admin_name like", value, "adminName");
            return this;
        }

        public Criteria andAdminNameNotLike(String value) {
            addCriterion("admin_name not like", value, "adminName");
            return this;
        }

        public Criteria andAdminNameIn(List values) {
            addCriterion("admin_name in", values, "adminName");
            return this;
        }

        public Criteria andAdminNameNotIn(List values) {
            addCriterion("admin_name not in", values, "adminName");
            return this;
        }

        public Criteria andAdminNameBetween(String value1, String value2) {
            addCriterion("admin_name between", value1, value2, "adminName");
            return this;
        }

        public Criteria andAdminNameNotBetween(String value1, String value2) {
            addCriterion("admin_name not between", value1, value2, "adminName");
            return this;
        }

        public Criteria andAdminPasswordIsNull() {
            addCriterion("admin_password is null");
            return this;
        }

        public Criteria andAdminPasswordIsNotNull() {
            addCriterion("admin_password is not null");
            return this;
        }

        public Criteria andAdminPasswordEqualTo(String value) {
            addCriterion("admin_password =", value, "adminPassword");
            return this;
        }

        public Criteria andAdminPasswordNotEqualTo(String value) {
            addCriterion("admin_password <>", value, "adminPassword");
            return this;
        }

        public Criteria andAdminPasswordGreaterThan(String value) {
            addCriterion("admin_password >", value, "adminPassword");
            return this;
        }

        public Criteria andAdminPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("admin_password >=", value, "adminPassword");
            return this;
        }

        public Criteria andAdminPasswordLessThan(String value) {
            addCriterion("admin_password <", value, "adminPassword");
            return this;
        }

        public Criteria andAdminPasswordLessThanOrEqualTo(String value) {
            addCriterion("admin_password <=", value, "adminPassword");
            return this;
        }

        public Criteria andAdminPasswordLike(String value) {
            addCriterion("admin_password like", value, "adminPassword");
            return this;
        }

        public Criteria andAdminPasswordNotLike(String value) {
            addCriterion("admin_password not like", value, "adminPassword");
            return this;
        }

        public Criteria andAdminPasswordIn(List values) {
            addCriterion("admin_password in", values, "adminPassword");
            return this;
        }

        public Criteria andAdminPasswordNotIn(List values) {
            addCriterion("admin_password not in", values, "adminPassword");
            return this;
        }

        public Criteria andAdminPasswordBetween(String value1, String value2) {
            addCriterion("admin_password between", value1, value2, "adminPassword");
            return this;
        }

        public Criteria andAdminPasswordNotBetween(String value1, String value2) {
            addCriterion("admin_password not between", value1, value2, "adminPassword");
            return this;
        }

        public Criteria andDisplayNameIsNull() {
            addCriterion("display_name is null");
            return this;
        }

        public Criteria andDisplayNameIsNotNull() {
            addCriterion("display_name is not null");
            return this;
        }

        public Criteria andDisplayNameEqualTo(String value) {
            addCriterion("display_name =", value, "displayName");
            return this;
        }

        public Criteria andDisplayNameNotEqualTo(String value) {
            addCriterion("display_name <>", value, "displayName");
            return this;
        }

        public Criteria andDisplayNameGreaterThan(String value) {
            addCriterion("display_name >", value, "displayName");
            return this;
        }

        public Criteria andDisplayNameGreaterThanOrEqualTo(String value) {
            addCriterion("display_name >=", value, "displayName");
            return this;
        }

        public Criteria andDisplayNameLessThan(String value) {
            addCriterion("display_name <", value, "displayName");
            return this;
        }

        public Criteria andDisplayNameLessThanOrEqualTo(String value) {
            addCriterion("display_name <=", value, "displayName");
            return this;
        }

        public Criteria andDisplayNameLike(String value) {
            addCriterion("display_name like", value, "displayName");
            return this;
        }

        public Criteria andDisplayNameNotLike(String value) {
            addCriterion("display_name not like", value, "displayName");
            return this;
        }

        public Criteria andDisplayNameIn(List values) {
            addCriterion("display_name in", values, "displayName");
            return this;
        }

        public Criteria andDisplayNameNotIn(List values) {
            addCriterion("display_name not in", values, "displayName");
            return this;
        }

        public Criteria andDisplayNameBetween(String value1, String value2) {
            addCriterion("display_name between", value1, value2, "displayName");
            return this;
        }

        public Criteria andDisplayNameNotBetween(String value1, String value2) {
            addCriterion("display_name not between", value1, value2, "displayName");
            return this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return this;
        }

        public Criteria andCreateTimeIn(List values) {
            addCriterion("create_time in", values, "createTime");
            return this;
        }

        public Criteria andCreateTimeNotIn(List values) {
            addCriterion("create_time not in", values, "createTime");
            return this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return this;
        }

        public Criteria andUpdateTimeIn(List values) {
            addCriterion("update_time in", values, "updateTime");
            return this;
        }

        public Criteria andUpdateTimeNotIn(List values) {
            addCriterion("update_time not in", values, "updateTime");
            return this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return this;
        }

        public Criteria andAclIsNull() {
            addCriterion("acl is null");
            return this;
        }

        public Criteria andAclIsNotNull() {
            addCriterion("acl is not null");
            return this;
        }

        public Criteria andAclEqualTo(String value) {
            addCriterion("acl =", value, "acl");
            return this;
        }

        public Criteria andAclNotEqualTo(String value) {
            addCriterion("acl <>", value, "acl");
            return this;
        }

        public Criteria andAclGreaterThan(String value) {
            addCriterion("acl >", value, "acl");
            return this;
        }

        public Criteria andAclGreaterThanOrEqualTo(String value) {
            addCriterion("acl >=", value, "acl");
            return this;
        }

        public Criteria andAclLessThan(String value) {
            addCriterion("acl <", value, "acl");
            return this;
        }

        public Criteria andAclLessThanOrEqualTo(String value) {
            addCriterion("acl <=", value, "acl");
            return this;
        }

        public Criteria andAclLike(String value) {
            addCriterion("acl like", value, "acl");
            return this;
        }

        public Criteria andAclNotLike(String value) {
            addCriterion("acl not like", value, "acl");
            return this;
        }

        public Criteria andAclIn(List values) {
            addCriterion("acl in", values, "acl");
            return this;
        }

        public Criteria andAclNotIn(List values) {
            addCriterion("acl not in", values, "acl");
            return this;
        }

        public Criteria andAclBetween(String value1, String value2) {
            addCriterion("acl between", value1, value2, "acl");
            return this;
        }

        public Criteria andAclNotBetween(String value1, String value2) {
            addCriterion("acl not between", value1, value2, "acl");
            return this;
        }
    }
}