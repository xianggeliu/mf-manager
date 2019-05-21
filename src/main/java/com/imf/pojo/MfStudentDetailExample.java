package com.imf.pojo;

import java.util.ArrayList;
import java.util.List;

public class MfStudentDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MfStudentDetailExample() {
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

        public Criteria andStuUuidIsNull() {
            addCriterion("stu_uuid is null");
            return (Criteria) this;
        }

        public Criteria andStuUuidIsNotNull() {
            addCriterion("stu_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andStuUuidEqualTo(String value) {
            addCriterion("stu_uuid =", value, "stuUuid");
            return (Criteria) this;
        }

        public Criteria andStuUuidNotEqualTo(String value) {
            addCriterion("stu_uuid <>", value, "stuUuid");
            return (Criteria) this;
        }

        public Criteria andStuUuidGreaterThan(String value) {
            addCriterion("stu_uuid >", value, "stuUuid");
            return (Criteria) this;
        }

        public Criteria andStuUuidGreaterThanOrEqualTo(String value) {
            addCriterion("stu_uuid >=", value, "stuUuid");
            return (Criteria) this;
        }

        public Criteria andStuUuidLessThan(String value) {
            addCriterion("stu_uuid <", value, "stuUuid");
            return (Criteria) this;
        }

        public Criteria andStuUuidLessThanOrEqualTo(String value) {
            addCriterion("stu_uuid <=", value, "stuUuid");
            return (Criteria) this;
        }

        public Criteria andStuUuidLike(String value) {
            addCriterion("stu_uuid like", value, "stuUuid");
            return (Criteria) this;
        }

        public Criteria andStuUuidNotLike(String value) {
            addCriterion("stu_uuid not like", value, "stuUuid");
            return (Criteria) this;
        }

        public Criteria andStuUuidIn(List<String> values) {
            addCriterion("stu_uuid in", values, "stuUuid");
            return (Criteria) this;
        }

        public Criteria andStuUuidNotIn(List<String> values) {
            addCriterion("stu_uuid not in", values, "stuUuid");
            return (Criteria) this;
        }

        public Criteria andStuUuidBetween(String value1, String value2) {
            addCriterion("stu_uuid between", value1, value2, "stuUuid");
            return (Criteria) this;
        }

        public Criteria andStuUuidNotBetween(String value1, String value2) {
            addCriterion("stu_uuid not between", value1, value2, "stuUuid");
            return (Criteria) this;
        }

        public Criteria andStuParentNameIsNull() {
            addCriterion("stu_parent_name is null");
            return (Criteria) this;
        }

        public Criteria andStuParentNameIsNotNull() {
            addCriterion("stu_parent_name is not null");
            return (Criteria) this;
        }

        public Criteria andStuParentNameEqualTo(String value) {
            addCriterion("stu_parent_name =", value, "stuParentName");
            return (Criteria) this;
        }

        public Criteria andStuParentNameNotEqualTo(String value) {
            addCriterion("stu_parent_name <>", value, "stuParentName");
            return (Criteria) this;
        }

        public Criteria andStuParentNameGreaterThan(String value) {
            addCriterion("stu_parent_name >", value, "stuParentName");
            return (Criteria) this;
        }

        public Criteria andStuParentNameGreaterThanOrEqualTo(String value) {
            addCriterion("stu_parent_name >=", value, "stuParentName");
            return (Criteria) this;
        }

        public Criteria andStuParentNameLessThan(String value) {
            addCriterion("stu_parent_name <", value, "stuParentName");
            return (Criteria) this;
        }

        public Criteria andStuParentNameLessThanOrEqualTo(String value) {
            addCriterion("stu_parent_name <=", value, "stuParentName");
            return (Criteria) this;
        }

        public Criteria andStuParentNameLike(String value) {
            addCriterion("stu_parent_name like", value, "stuParentName");
            return (Criteria) this;
        }

        public Criteria andStuParentNameNotLike(String value) {
            addCriterion("stu_parent_name not like", value, "stuParentName");
            return (Criteria) this;
        }

        public Criteria andStuParentNameIn(List<String> values) {
            addCriterion("stu_parent_name in", values, "stuParentName");
            return (Criteria) this;
        }

        public Criteria andStuParentNameNotIn(List<String> values) {
            addCriterion("stu_parent_name not in", values, "stuParentName");
            return (Criteria) this;
        }

        public Criteria andStuParentNameBetween(String value1, String value2) {
            addCriterion("stu_parent_name between", value1, value2, "stuParentName");
            return (Criteria) this;
        }

        public Criteria andStuParentNameNotBetween(String value1, String value2) {
            addCriterion("stu_parent_name not between", value1, value2, "stuParentName");
            return (Criteria) this;
        }

        public Criteria andStuAddressIsNull() {
            addCriterion("stu_address is null");
            return (Criteria) this;
        }

        public Criteria andStuAddressIsNotNull() {
            addCriterion("stu_address is not null");
            return (Criteria) this;
        }

        public Criteria andStuAddressEqualTo(String value) {
            addCriterion("stu_address =", value, "stuAddress");
            return (Criteria) this;
        }

        public Criteria andStuAddressNotEqualTo(String value) {
            addCriterion("stu_address <>", value, "stuAddress");
            return (Criteria) this;
        }

        public Criteria andStuAddressGreaterThan(String value) {
            addCriterion("stu_address >", value, "stuAddress");
            return (Criteria) this;
        }

        public Criteria andStuAddressGreaterThanOrEqualTo(String value) {
            addCriterion("stu_address >=", value, "stuAddress");
            return (Criteria) this;
        }

        public Criteria andStuAddressLessThan(String value) {
            addCriterion("stu_address <", value, "stuAddress");
            return (Criteria) this;
        }

        public Criteria andStuAddressLessThanOrEqualTo(String value) {
            addCriterion("stu_address <=", value, "stuAddress");
            return (Criteria) this;
        }

        public Criteria andStuAddressLike(String value) {
            addCriterion("stu_address like", value, "stuAddress");
            return (Criteria) this;
        }

        public Criteria andStuAddressNotLike(String value) {
            addCriterion("stu_address not like", value, "stuAddress");
            return (Criteria) this;
        }

        public Criteria andStuAddressIn(List<String> values) {
            addCriterion("stu_address in", values, "stuAddress");
            return (Criteria) this;
        }

        public Criteria andStuAddressNotIn(List<String> values) {
            addCriterion("stu_address not in", values, "stuAddress");
            return (Criteria) this;
        }

        public Criteria andStuAddressBetween(String value1, String value2) {
            addCriterion("stu_address between", value1, value2, "stuAddress");
            return (Criteria) this;
        }

        public Criteria andStuAddressNotBetween(String value1, String value2) {
            addCriterion("stu_address not between", value1, value2, "stuAddress");
            return (Criteria) this;
        }

        public Criteria andStuPhoneNumIsNull() {
            addCriterion("stu_phone_num is null");
            return (Criteria) this;
        }

        public Criteria andStuPhoneNumIsNotNull() {
            addCriterion("stu_phone_num is not null");
            return (Criteria) this;
        }

        public Criteria andStuPhoneNumEqualTo(String value) {
            addCriterion("stu_phone_num =", value, "stuPhoneNum");
            return (Criteria) this;
        }

        public Criteria andStuPhoneNumNotEqualTo(String value) {
            addCriterion("stu_phone_num <>", value, "stuPhoneNum");
            return (Criteria) this;
        }

        public Criteria andStuPhoneNumGreaterThan(String value) {
            addCriterion("stu_phone_num >", value, "stuPhoneNum");
            return (Criteria) this;
        }

        public Criteria andStuPhoneNumGreaterThanOrEqualTo(String value) {
            addCriterion("stu_phone_num >=", value, "stuPhoneNum");
            return (Criteria) this;
        }

        public Criteria andStuPhoneNumLessThan(String value) {
            addCriterion("stu_phone_num <", value, "stuPhoneNum");
            return (Criteria) this;
        }

        public Criteria andStuPhoneNumLessThanOrEqualTo(String value) {
            addCriterion("stu_phone_num <=", value, "stuPhoneNum");
            return (Criteria) this;
        }

        public Criteria andStuPhoneNumLike(String value) {
            addCriterion("stu_phone_num like", value, "stuPhoneNum");
            return (Criteria) this;
        }

        public Criteria andStuPhoneNumNotLike(String value) {
            addCriterion("stu_phone_num not like", value, "stuPhoneNum");
            return (Criteria) this;
        }

        public Criteria andStuPhoneNumIn(List<String> values) {
            addCriterion("stu_phone_num in", values, "stuPhoneNum");
            return (Criteria) this;
        }

        public Criteria andStuPhoneNumNotIn(List<String> values) {
            addCriterion("stu_phone_num not in", values, "stuPhoneNum");
            return (Criteria) this;
        }

        public Criteria andStuPhoneNumBetween(String value1, String value2) {
            addCriterion("stu_phone_num between", value1, value2, "stuPhoneNum");
            return (Criteria) this;
        }

        public Criteria andStuPhoneNumNotBetween(String value1, String value2) {
            addCriterion("stu_phone_num not between", value1, value2, "stuPhoneNum");
            return (Criteria) this;
        }

        public Criteria andStuYearIsNull() {
            addCriterion("stu_year is null");
            return (Criteria) this;
        }

        public Criteria andStuYearIsNotNull() {
            addCriterion("stu_year is not null");
            return (Criteria) this;
        }

        public Criteria andStuYearEqualTo(Integer value) {
            addCriterion("stu_year =", value, "stuYear");
            return (Criteria) this;
        }

        public Criteria andStuYearNotEqualTo(Integer value) {
            addCriterion("stu_year <>", value, "stuYear");
            return (Criteria) this;
        }

        public Criteria andStuYearGreaterThan(Integer value) {
            addCriterion("stu_year >", value, "stuYear");
            return (Criteria) this;
        }

        public Criteria andStuYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("stu_year >=", value, "stuYear");
            return (Criteria) this;
        }

        public Criteria andStuYearLessThan(Integer value) {
            addCriterion("stu_year <", value, "stuYear");
            return (Criteria) this;
        }

        public Criteria andStuYearLessThanOrEqualTo(Integer value) {
            addCriterion("stu_year <=", value, "stuYear");
            return (Criteria) this;
        }

        public Criteria andStuYearIn(List<Integer> values) {
            addCriterion("stu_year in", values, "stuYear");
            return (Criteria) this;
        }

        public Criteria andStuYearNotIn(List<Integer> values) {
            addCriterion("stu_year not in", values, "stuYear");
            return (Criteria) this;
        }

        public Criteria andStuYearBetween(Integer value1, Integer value2) {
            addCriterion("stu_year between", value1, value2, "stuYear");
            return (Criteria) this;
        }

        public Criteria andStuYearNotBetween(Integer value1, Integer value2) {
            addCriterion("stu_year not between", value1, value2, "stuYear");
            return (Criteria) this;
        }

        public Criteria andStuMonthIsNull() {
            addCriterion("stu_month is null");
            return (Criteria) this;
        }

        public Criteria andStuMonthIsNotNull() {
            addCriterion("stu_month is not null");
            return (Criteria) this;
        }

        public Criteria andStuMonthEqualTo(Integer value) {
            addCriterion("stu_month =", value, "stuMonth");
            return (Criteria) this;
        }

        public Criteria andStuMonthNotEqualTo(Integer value) {
            addCriterion("stu_month <>", value, "stuMonth");
            return (Criteria) this;
        }

        public Criteria andStuMonthGreaterThan(Integer value) {
            addCriterion("stu_month >", value, "stuMonth");
            return (Criteria) this;
        }

        public Criteria andStuMonthGreaterThanOrEqualTo(Integer value) {
            addCriterion("stu_month >=", value, "stuMonth");
            return (Criteria) this;
        }

        public Criteria andStuMonthLessThan(Integer value) {
            addCriterion("stu_month <", value, "stuMonth");
            return (Criteria) this;
        }

        public Criteria andStuMonthLessThanOrEqualTo(Integer value) {
            addCriterion("stu_month <=", value, "stuMonth");
            return (Criteria) this;
        }

        public Criteria andStuMonthIn(List<Integer> values) {
            addCriterion("stu_month in", values, "stuMonth");
            return (Criteria) this;
        }

        public Criteria andStuMonthNotIn(List<Integer> values) {
            addCriterion("stu_month not in", values, "stuMonth");
            return (Criteria) this;
        }

        public Criteria andStuMonthBetween(Integer value1, Integer value2) {
            addCriterion("stu_month between", value1, value2, "stuMonth");
            return (Criteria) this;
        }

        public Criteria andStuMonthNotBetween(Integer value1, Integer value2) {
            addCriterion("stu_month not between", value1, value2, "stuMonth");
            return (Criteria) this;
        }

        public Criteria andStuDayIsNull() {
            addCriterion("stu_day is null");
            return (Criteria) this;
        }

        public Criteria andStuDayIsNotNull() {
            addCriterion("stu_day is not null");
            return (Criteria) this;
        }

        public Criteria andStuDayEqualTo(Integer value) {
            addCriterion("stu_day =", value, "stuDay");
            return (Criteria) this;
        }

        public Criteria andStuDayNotEqualTo(Integer value) {
            addCriterion("stu_day <>", value, "stuDay");
            return (Criteria) this;
        }

        public Criteria andStuDayGreaterThan(Integer value) {
            addCriterion("stu_day >", value, "stuDay");
            return (Criteria) this;
        }

        public Criteria andStuDayGreaterThanOrEqualTo(Integer value) {
            addCriterion("stu_day >=", value, "stuDay");
            return (Criteria) this;
        }

        public Criteria andStuDayLessThan(Integer value) {
            addCriterion("stu_day <", value, "stuDay");
            return (Criteria) this;
        }

        public Criteria andStuDayLessThanOrEqualTo(Integer value) {
            addCriterion("stu_day <=", value, "stuDay");
            return (Criteria) this;
        }

        public Criteria andStuDayIn(List<Integer> values) {
            addCriterion("stu_day in", values, "stuDay");
            return (Criteria) this;
        }

        public Criteria andStuDayNotIn(List<Integer> values) {
            addCriterion("stu_day not in", values, "stuDay");
            return (Criteria) this;
        }

        public Criteria andStuDayBetween(Integer value1, Integer value2) {
            addCriterion("stu_day between", value1, value2, "stuDay");
            return (Criteria) this;
        }

        public Criteria andStuDayNotBetween(Integer value1, Integer value2) {
            addCriterion("stu_day not between", value1, value2, "stuDay");
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