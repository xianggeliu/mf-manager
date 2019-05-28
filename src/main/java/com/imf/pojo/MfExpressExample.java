package com.imf.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MfExpressExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MfExpressExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andExpressNumberIsNull() {
            addCriterion("express_number is null");
            return (Criteria) this;
        }

        public Criteria andExpressNumberIsNotNull() {
            addCriterion("express_number is not null");
            return (Criteria) this;
        }

        public Criteria andExpressNumberEqualTo(String value) {
            addCriterion("express_number =", value, "expressNumber");
            return (Criteria) this;
        }

        public Criteria andExpressNumberNotEqualTo(String value) {
            addCriterion("express_number <>", value, "expressNumber");
            return (Criteria) this;
        }

        public Criteria andExpressNumberGreaterThan(String value) {
            addCriterion("express_number >", value, "expressNumber");
            return (Criteria) this;
        }

        public Criteria andExpressNumberGreaterThanOrEqualTo(String value) {
            addCriterion("express_number >=", value, "expressNumber");
            return (Criteria) this;
        }

        public Criteria andExpressNumberLessThan(String value) {
            addCriterion("express_number <", value, "expressNumber");
            return (Criteria) this;
        }

        public Criteria andExpressNumberLessThanOrEqualTo(String value) {
            addCriterion("express_number <=", value, "expressNumber");
            return (Criteria) this;
        }

        public Criteria andExpressNumberLike(String value) {
            addCriterion("express_number like", value, "expressNumber");
            return (Criteria) this;
        }

        public Criteria andExpressNumberNotLike(String value) {
            addCriterion("express_number not like", value, "expressNumber");
            return (Criteria) this;
        }

        public Criteria andExpressNumberIn(List<String> values) {
            addCriterion("express_number in", values, "expressNumber");
            return (Criteria) this;
        }

        public Criteria andExpressNumberNotIn(List<String> values) {
            addCriterion("express_number not in", values, "expressNumber");
            return (Criteria) this;
        }

        public Criteria andExpressNumberBetween(String value1, String value2) {
            addCriterion("express_number between", value1, value2, "expressNumber");
            return (Criteria) this;
        }

        public Criteria andExpressNumberNotBetween(String value1, String value2) {
            addCriterion("express_number not between", value1, value2, "expressNumber");
            return (Criteria) this;
        }

        public Criteria andECompanyIsNull() {
            addCriterion("e_company is null");
            return (Criteria) this;
        }

        public Criteria andECompanyIsNotNull() {
            addCriterion("e_company is not null");
            return (Criteria) this;
        }

        public Criteria andECompanyEqualTo(String value) {
            addCriterion("e_company =", value, "eCompany");
            return (Criteria) this;
        }

        public Criteria andECompanyNotEqualTo(String value) {
            addCriterion("e_company <>", value, "eCompany");
            return (Criteria) this;
        }

        public Criteria andECompanyGreaterThan(String value) {
            addCriterion("e_company >", value, "eCompany");
            return (Criteria) this;
        }

        public Criteria andECompanyGreaterThanOrEqualTo(String value) {
            addCriterion("e_company >=", value, "eCompany");
            return (Criteria) this;
        }

        public Criteria andECompanyLessThan(String value) {
            addCriterion("e_company <", value, "eCompany");
            return (Criteria) this;
        }

        public Criteria andECompanyLessThanOrEqualTo(String value) {
            addCriterion("e_company <=", value, "eCompany");
            return (Criteria) this;
        }

        public Criteria andECompanyLike(String value) {
            addCriterion("e_company like", value, "eCompany");
            return (Criteria) this;
        }

        public Criteria andECompanyNotLike(String value) {
            addCriterion("e_company not like", value, "eCompany");
            return (Criteria) this;
        }

        public Criteria andECompanyIn(List<String> values) {
            addCriterion("e_company in", values, "eCompany");
            return (Criteria) this;
        }

        public Criteria andECompanyNotIn(List<String> values) {
            addCriterion("e_company not in", values, "eCompany");
            return (Criteria) this;
        }

        public Criteria andECompanyBetween(String value1, String value2) {
            addCriterion("e_company between", value1, value2, "eCompany");
            return (Criteria) this;
        }

        public Criteria andECompanyNotBetween(String value1, String value2) {
            addCriterion("e_company not between", value1, value2, "eCompany");
            return (Criteria) this;
        }

        public Criteria andECompanyCodeIsNull() {
            addCriterion("e_company_code is null");
            return (Criteria) this;
        }

        public Criteria andECompanyCodeIsNotNull() {
            addCriterion("e_company_code is not null");
            return (Criteria) this;
        }

        public Criteria andECompanyCodeEqualTo(Boolean value) {
            addCriterion("e_company_code =", value, "eCompanyCode");
            return (Criteria) this;
        }

        public Criteria andECompanyCodeNotEqualTo(Boolean value) {
            addCriterion("e_company_code <>", value, "eCompanyCode");
            return (Criteria) this;
        }

        public Criteria andECompanyCodeGreaterThan(Boolean value) {
            addCriterion("e_company_code >", value, "eCompanyCode");
            return (Criteria) this;
        }

        public Criteria andECompanyCodeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("e_company_code >=", value, "eCompanyCode");
            return (Criteria) this;
        }

        public Criteria andECompanyCodeLessThan(Boolean value) {
            addCriterion("e_company_code <", value, "eCompanyCode");
            return (Criteria) this;
        }

        public Criteria andECompanyCodeLessThanOrEqualTo(Boolean value) {
            addCriterion("e_company_code <=", value, "eCompanyCode");
            return (Criteria) this;
        }

        public Criteria andECompanyCodeIn(List<Boolean> values) {
            addCriterion("e_company_code in", values, "eCompanyCode");
            return (Criteria) this;
        }

        public Criteria andECompanyCodeNotIn(List<Boolean> values) {
            addCriterion("e_company_code not in", values, "eCompanyCode");
            return (Criteria) this;
        }

        public Criteria andECompanyCodeBetween(Boolean value1, Boolean value2) {
            addCriterion("e_company_code between", value1, value2, "eCompanyCode");
            return (Criteria) this;
        }

        public Criteria andECompanyCodeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("e_company_code not between", value1, value2, "eCompanyCode");
            return (Criteria) this;
        }

        public Criteria andEnteringTimeIsNull() {
            addCriterion("entering_time is null");
            return (Criteria) this;
        }

        public Criteria andEnteringTimeIsNotNull() {
            addCriterion("entering_time is not null");
            return (Criteria) this;
        }

        public Criteria andEnteringTimeEqualTo(Date value) {
            addCriterion("entering_time =", value, "enteringTime");
            return (Criteria) this;
        }

        public Criteria andEnteringTimeNotEqualTo(Date value) {
            addCriterion("entering_time <>", value, "enteringTime");
            return (Criteria) this;
        }

        public Criteria andEnteringTimeGreaterThan(Date value) {
            addCriterion("entering_time >", value, "enteringTime");
            return (Criteria) this;
        }

        public Criteria andEnteringTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("entering_time >=", value, "enteringTime");
            return (Criteria) this;
        }

        public Criteria andEnteringTimeLessThan(Date value) {
            addCriterion("entering_time <", value, "enteringTime");
            return (Criteria) this;
        }

        public Criteria andEnteringTimeLessThanOrEqualTo(Date value) {
            addCriterion("entering_time <=", value, "enteringTime");
            return (Criteria) this;
        }

        public Criteria andEnteringTimeIn(List<Date> values) {
            addCriterion("entering_time in", values, "enteringTime");
            return (Criteria) this;
        }

        public Criteria andEnteringTimeNotIn(List<Date> values) {
            addCriterion("entering_time not in", values, "enteringTime");
            return (Criteria) this;
        }

        public Criteria andEnteringTimeBetween(Date value1, Date value2) {
            addCriterion("entering_time between", value1, value2, "enteringTime");
            return (Criteria) this;
        }

        public Criteria andEnteringTimeNotBetween(Date value1, Date value2) {
            addCriterion("entering_time not between", value1, value2, "enteringTime");
            return (Criteria) this;
        }

        public Criteria andEPhoneIsNull() {
            addCriterion("e_phone is null");
            return (Criteria) this;
        }

        public Criteria andEPhoneIsNotNull() {
            addCriterion("e_phone is not null");
            return (Criteria) this;
        }

        public Criteria andEPhoneEqualTo(String value) {
            addCriterion("e_phone =", value, "ePhone");
            return (Criteria) this;
        }

        public Criteria andEPhoneNotEqualTo(String value) {
            addCriterion("e_phone <>", value, "ePhone");
            return (Criteria) this;
        }

        public Criteria andEPhoneGreaterThan(String value) {
            addCriterion("e_phone >", value, "ePhone");
            return (Criteria) this;
        }

        public Criteria andEPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("e_phone >=", value, "ePhone");
            return (Criteria) this;
        }

        public Criteria andEPhoneLessThan(String value) {
            addCriterion("e_phone <", value, "ePhone");
            return (Criteria) this;
        }

        public Criteria andEPhoneLessThanOrEqualTo(String value) {
            addCriterion("e_phone <=", value, "ePhone");
            return (Criteria) this;
        }

        public Criteria andEPhoneLike(String value) {
            addCriterion("e_phone like", value, "ePhone");
            return (Criteria) this;
        }

        public Criteria andEPhoneNotLike(String value) {
            addCriterion("e_phone not like", value, "ePhone");
            return (Criteria) this;
        }

        public Criteria andEPhoneIn(List<String> values) {
            addCriterion("e_phone in", values, "ePhone");
            return (Criteria) this;
        }

        public Criteria andEPhoneNotIn(List<String> values) {
            addCriterion("e_phone not in", values, "ePhone");
            return (Criteria) this;
        }

        public Criteria andEPhoneBetween(String value1, String value2) {
            addCriterion("e_phone between", value1, value2, "ePhone");
            return (Criteria) this;
        }

        public Criteria andEPhoneNotBetween(String value1, String value2) {
            addCriterion("e_phone not between", value1, value2, "ePhone");
            return (Criteria) this;
        }

        public Criteria andGetTimeIsNull() {
            addCriterion("get_time is null");
            return (Criteria) this;
        }

        public Criteria andGetTimeIsNotNull() {
            addCriterion("get_time is not null");
            return (Criteria) this;
        }

        public Criteria andGetTimeEqualTo(Date value) {
            addCriterion("get_time =", value, "getTime");
            return (Criteria) this;
        }

        public Criteria andGetTimeNotEqualTo(Date value) {
            addCriterion("get_time <>", value, "getTime");
            return (Criteria) this;
        }

        public Criteria andGetTimeGreaterThan(Date value) {
            addCriterion("get_time >", value, "getTime");
            return (Criteria) this;
        }

        public Criteria andGetTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("get_time >=", value, "getTime");
            return (Criteria) this;
        }

        public Criteria andGetTimeLessThan(Date value) {
            addCriterion("get_time <", value, "getTime");
            return (Criteria) this;
        }

        public Criteria andGetTimeLessThanOrEqualTo(Date value) {
            addCriterion("get_time <=", value, "getTime");
            return (Criteria) this;
        }

        public Criteria andGetTimeIn(List<Date> values) {
            addCriterion("get_time in", values, "getTime");
            return (Criteria) this;
        }

        public Criteria andGetTimeNotIn(List<Date> values) {
            addCriterion("get_time not in", values, "getTime");
            return (Criteria) this;
        }

        public Criteria andGetTimeBetween(Date value1, Date value2) {
            addCriterion("get_time between", value1, value2, "getTime");
            return (Criteria) this;
        }

        public Criteria andGetTimeNotBetween(Date value1, Date value2) {
            addCriterion("get_time not between", value1, value2, "getTime");
            return (Criteria) this;
        }

        public Criteria andENameIsNull() {
            addCriterion("e_name is null");
            return (Criteria) this;
        }

        public Criteria andENameIsNotNull() {
            addCriterion("e_name is not null");
            return (Criteria) this;
        }

        public Criteria andENameEqualTo(String value) {
            addCriterion("e_name =", value, "eName");
            return (Criteria) this;
        }

        public Criteria andENameNotEqualTo(String value) {
            addCriterion("e_name <>", value, "eName");
            return (Criteria) this;
        }

        public Criteria andENameGreaterThan(String value) {
            addCriterion("e_name >", value, "eName");
            return (Criteria) this;
        }

        public Criteria andENameGreaterThanOrEqualTo(String value) {
            addCriterion("e_name >=", value, "eName");
            return (Criteria) this;
        }

        public Criteria andENameLessThan(String value) {
            addCriterion("e_name <", value, "eName");
            return (Criteria) this;
        }

        public Criteria andENameLessThanOrEqualTo(String value) {
            addCriterion("e_name <=", value, "eName");
            return (Criteria) this;
        }

        public Criteria andENameLike(String value) {
            addCriterion("e_name like", value, "eName");
            return (Criteria) this;
        }

        public Criteria andENameNotLike(String value) {
            addCriterion("e_name not like", value, "eName");
            return (Criteria) this;
        }

        public Criteria andENameIn(List<String> values) {
            addCriterion("e_name in", values, "eName");
            return (Criteria) this;
        }

        public Criteria andENameNotIn(List<String> values) {
            addCriterion("e_name not in", values, "eName");
            return (Criteria) this;
        }

        public Criteria andENameBetween(String value1, String value2) {
            addCriterion("e_name between", value1, value2, "eName");
            return (Criteria) this;
        }

        public Criteria andENameNotBetween(String value1, String value2) {
            addCriterion("e_name not between", value1, value2, "eName");
            return (Criteria) this;
        }

        public Criteria andEMarkIsNull() {
            addCriterion("e_mark is null");
            return (Criteria) this;
        }

        public Criteria andEMarkIsNotNull() {
            addCriterion("e_mark is not null");
            return (Criteria) this;
        }

        public Criteria andEMarkEqualTo(Boolean value) {
            addCriterion("e_mark =", value, "eMark");
            return (Criteria) this;
        }

        public Criteria andEMarkNotEqualTo(Boolean value) {
            addCriterion("e_mark <>", value, "eMark");
            return (Criteria) this;
        }

        public Criteria andEMarkGreaterThan(Boolean value) {
            addCriterion("e_mark >", value, "eMark");
            return (Criteria) this;
        }

        public Criteria andEMarkGreaterThanOrEqualTo(Boolean value) {
            addCriterion("e_mark >=", value, "eMark");
            return (Criteria) this;
        }

        public Criteria andEMarkLessThan(Boolean value) {
            addCriterion("e_mark <", value, "eMark");
            return (Criteria) this;
        }

        public Criteria andEMarkLessThanOrEqualTo(Boolean value) {
            addCriterion("e_mark <=", value, "eMark");
            return (Criteria) this;
        }

        public Criteria andEMarkIn(List<Boolean> values) {
            addCriterion("e_mark in", values, "eMark");
            return (Criteria) this;
        }

        public Criteria andEMarkNotIn(List<Boolean> values) {
            addCriterion("e_mark not in", values, "eMark");
            return (Criteria) this;
        }

        public Criteria andEMarkBetween(Boolean value1, Boolean value2) {
            addCriterion("e_mark between", value1, value2, "eMark");
            return (Criteria) this;
        }

        public Criteria andEMarkNotBetween(Boolean value1, Boolean value2) {
            addCriterion("e_mark not between", value1, value2, "eMark");
            return (Criteria) this;
        }

        public Criteria andEStateIsNull() {
            addCriterion("e_state is null");
            return (Criteria) this;
        }

        public Criteria andEStateIsNotNull() {
            addCriterion("e_state is not null");
            return (Criteria) this;
        }

        public Criteria andEStateEqualTo(Boolean value) {
            addCriterion("e_state =", value, "eState");
            return (Criteria) this;
        }

        public Criteria andEStateNotEqualTo(Boolean value) {
            addCriterion("e_state <>", value, "eState");
            return (Criteria) this;
        }

        public Criteria andEStateGreaterThan(Boolean value) {
            addCriterion("e_state >", value, "eState");
            return (Criteria) this;
        }

        public Criteria andEStateGreaterThanOrEqualTo(Boolean value) {
            addCriterion("e_state >=", value, "eState");
            return (Criteria) this;
        }

        public Criteria andEStateLessThan(Boolean value) {
            addCriterion("e_state <", value, "eState");
            return (Criteria) this;
        }

        public Criteria andEStateLessThanOrEqualTo(Boolean value) {
            addCriterion("e_state <=", value, "eState");
            return (Criteria) this;
        }

        public Criteria andEStateIn(List<Boolean> values) {
            addCriterion("e_state in", values, "eState");
            return (Criteria) this;
        }

        public Criteria andEStateNotIn(List<Boolean> values) {
            addCriterion("e_state not in", values, "eState");
            return (Criteria) this;
        }

        public Criteria andEStateBetween(Boolean value1, Boolean value2) {
            addCriterion("e_state between", value1, value2, "eState");
            return (Criteria) this;
        }

        public Criteria andEStateNotBetween(Boolean value1, Boolean value2) {
            addCriterion("e_state not between", value1, value2, "eState");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}