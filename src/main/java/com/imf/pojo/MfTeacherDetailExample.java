package com.imf.pojo;

import java.util.ArrayList;
import java.util.List;

public class MfTeacherDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MfTeacherDetailExample() {
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

        public Criteria andTeachIdIsNull() {
            addCriterion("teach_id is null");
            return (Criteria) this;
        }

        public Criteria andTeachIdIsNotNull() {
            addCriterion("teach_id is not null");
            return (Criteria) this;
        }

        public Criteria andTeachIdEqualTo(String value) {
            addCriterion("teach_id =", value, "teachId");
            return (Criteria) this;
        }

        public Criteria andTeachIdNotEqualTo(String value) {
            addCriterion("teach_id <>", value, "teachId");
            return (Criteria) this;
        }

        public Criteria andTeachIdGreaterThan(String value) {
            addCriterion("teach_id >", value, "teachId");
            return (Criteria) this;
        }

        public Criteria andTeachIdGreaterThanOrEqualTo(String value) {
            addCriterion("teach_id >=", value, "teachId");
            return (Criteria) this;
        }

        public Criteria andTeachIdLessThan(String value) {
            addCriterion("teach_id <", value, "teachId");
            return (Criteria) this;
        }

        public Criteria andTeachIdLessThanOrEqualTo(String value) {
            addCriterion("teach_id <=", value, "teachId");
            return (Criteria) this;
        }

        public Criteria andTeachIdLike(String value) {
            addCriterion("teach_id like", value, "teachId");
            return (Criteria) this;
        }

        public Criteria andTeachIdNotLike(String value) {
            addCriterion("teach_id not like", value, "teachId");
            return (Criteria) this;
        }

        public Criteria andTeachIdIn(List<String> values) {
            addCriterion("teach_id in", values, "teachId");
            return (Criteria) this;
        }

        public Criteria andTeachIdNotIn(List<String> values) {
            addCriterion("teach_id not in", values, "teachId");
            return (Criteria) this;
        }

        public Criteria andTeachIdBetween(String value1, String value2) {
            addCriterion("teach_id between", value1, value2, "teachId");
            return (Criteria) this;
        }

        public Criteria andTeachIdNotBetween(String value1, String value2) {
            addCriterion("teach_id not between", value1, value2, "teachId");
            return (Criteria) this;
        }

        public Criteria andTeachIdnumIsNull() {
            addCriterion("teach_idnum is null");
            return (Criteria) this;
        }

        public Criteria andTeachIdnumIsNotNull() {
            addCriterion("teach_idnum is not null");
            return (Criteria) this;
        }

        public Criteria andTeachIdnumEqualTo(String value) {
            addCriterion("teach_idnum =", value, "teachIdnum");
            return (Criteria) this;
        }

        public Criteria andTeachIdnumNotEqualTo(String value) {
            addCriterion("teach_idnum <>", value, "teachIdnum");
            return (Criteria) this;
        }

        public Criteria andTeachIdnumGreaterThan(String value) {
            addCriterion("teach_idnum >", value, "teachIdnum");
            return (Criteria) this;
        }

        public Criteria andTeachIdnumGreaterThanOrEqualTo(String value) {
            addCriterion("teach_idnum >=", value, "teachIdnum");
            return (Criteria) this;
        }

        public Criteria andTeachIdnumLessThan(String value) {
            addCriterion("teach_idnum <", value, "teachIdnum");
            return (Criteria) this;
        }

        public Criteria andTeachIdnumLessThanOrEqualTo(String value) {
            addCriterion("teach_idnum <=", value, "teachIdnum");
            return (Criteria) this;
        }

        public Criteria andTeachIdnumLike(String value) {
            addCriterion("teach_idnum like", value, "teachIdnum");
            return (Criteria) this;
        }

        public Criteria andTeachIdnumNotLike(String value) {
            addCriterion("teach_idnum not like", value, "teachIdnum");
            return (Criteria) this;
        }

        public Criteria andTeachIdnumIn(List<String> values) {
            addCriterion("teach_idnum in", values, "teachIdnum");
            return (Criteria) this;
        }

        public Criteria andTeachIdnumNotIn(List<String> values) {
            addCriterion("teach_idnum not in", values, "teachIdnum");
            return (Criteria) this;
        }

        public Criteria andTeachIdnumBetween(String value1, String value2) {
            addCriterion("teach_idnum between", value1, value2, "teachIdnum");
            return (Criteria) this;
        }

        public Criteria andTeachIdnumNotBetween(String value1, String value2) {
            addCriterion("teach_idnum not between", value1, value2, "teachIdnum");
            return (Criteria) this;
        }

        public Criteria andTeachEduIsNull() {
            addCriterion("teach_edu is null");
            return (Criteria) this;
        }

        public Criteria andTeachEduIsNotNull() {
            addCriterion("teach_edu is not null");
            return (Criteria) this;
        }

        public Criteria andTeachEduEqualTo(String value) {
            addCriterion("teach_edu =", value, "teachEdu");
            return (Criteria) this;
        }

        public Criteria andTeachEduNotEqualTo(String value) {
            addCriterion("teach_edu <>", value, "teachEdu");
            return (Criteria) this;
        }

        public Criteria andTeachEduGreaterThan(String value) {
            addCriterion("teach_edu >", value, "teachEdu");
            return (Criteria) this;
        }

        public Criteria andTeachEduGreaterThanOrEqualTo(String value) {
            addCriterion("teach_edu >=", value, "teachEdu");
            return (Criteria) this;
        }

        public Criteria andTeachEduLessThan(String value) {
            addCriterion("teach_edu <", value, "teachEdu");
            return (Criteria) this;
        }

        public Criteria andTeachEduLessThanOrEqualTo(String value) {
            addCriterion("teach_edu <=", value, "teachEdu");
            return (Criteria) this;
        }

        public Criteria andTeachEduLike(String value) {
            addCriterion("teach_edu like", value, "teachEdu");
            return (Criteria) this;
        }

        public Criteria andTeachEduNotLike(String value) {
            addCriterion("teach_edu not like", value, "teachEdu");
            return (Criteria) this;
        }

        public Criteria andTeachEduIn(List<String> values) {
            addCriterion("teach_edu in", values, "teachEdu");
            return (Criteria) this;
        }

        public Criteria andTeachEduNotIn(List<String> values) {
            addCriterion("teach_edu not in", values, "teachEdu");
            return (Criteria) this;
        }

        public Criteria andTeachEduBetween(String value1, String value2) {
            addCriterion("teach_edu between", value1, value2, "teachEdu");
            return (Criteria) this;
        }

        public Criteria andTeachEduNotBetween(String value1, String value2) {
            addCriterion("teach_edu not between", value1, value2, "teachEdu");
            return (Criteria) this;
        }

        public Criteria andTeachEduSchoolIsNull() {
            addCriterion("teach_edu_school is null");
            return (Criteria) this;
        }

        public Criteria andTeachEduSchoolIsNotNull() {
            addCriterion("teach_edu_school is not null");
            return (Criteria) this;
        }

        public Criteria andTeachEduSchoolEqualTo(String value) {
            addCriterion("teach_edu_school =", value, "teachEduSchool");
            return (Criteria) this;
        }

        public Criteria andTeachEduSchoolNotEqualTo(String value) {
            addCriterion("teach_edu_school <>", value, "teachEduSchool");
            return (Criteria) this;
        }

        public Criteria andTeachEduSchoolGreaterThan(String value) {
            addCriterion("teach_edu_school >", value, "teachEduSchool");
            return (Criteria) this;
        }

        public Criteria andTeachEduSchoolGreaterThanOrEqualTo(String value) {
            addCriterion("teach_edu_school >=", value, "teachEduSchool");
            return (Criteria) this;
        }

        public Criteria andTeachEduSchoolLessThan(String value) {
            addCriterion("teach_edu_school <", value, "teachEduSchool");
            return (Criteria) this;
        }

        public Criteria andTeachEduSchoolLessThanOrEqualTo(String value) {
            addCriterion("teach_edu_school <=", value, "teachEduSchool");
            return (Criteria) this;
        }

        public Criteria andTeachEduSchoolLike(String value) {
            addCriterion("teach_edu_school like", value, "teachEduSchool");
            return (Criteria) this;
        }

        public Criteria andTeachEduSchoolNotLike(String value) {
            addCriterion("teach_edu_school not like", value, "teachEduSchool");
            return (Criteria) this;
        }

        public Criteria andTeachEduSchoolIn(List<String> values) {
            addCriterion("teach_edu_school in", values, "teachEduSchool");
            return (Criteria) this;
        }

        public Criteria andTeachEduSchoolNotIn(List<String> values) {
            addCriterion("teach_edu_school not in", values, "teachEduSchool");
            return (Criteria) this;
        }

        public Criteria andTeachEduSchoolBetween(String value1, String value2) {
            addCriterion("teach_edu_school between", value1, value2, "teachEduSchool");
            return (Criteria) this;
        }

        public Criteria andTeachEduSchoolNotBetween(String value1, String value2) {
            addCriterion("teach_edu_school not between", value1, value2, "teachEduSchool");
            return (Criteria) this;
        }

        public Criteria andTeachEduTimeIsNull() {
            addCriterion("teach_edu_time is null");
            return (Criteria) this;
        }

        public Criteria andTeachEduTimeIsNotNull() {
            addCriterion("teach_edu_time is not null");
            return (Criteria) this;
        }

        public Criteria andTeachEduTimeEqualTo(String value) {
            addCriterion("teach_edu_time =", value, "teachEduTime");
            return (Criteria) this;
        }

        public Criteria andTeachEduTimeNotEqualTo(String value) {
            addCriterion("teach_edu_time <>", value, "teachEduTime");
            return (Criteria) this;
        }

        public Criteria andTeachEduTimeGreaterThan(String value) {
            addCriterion("teach_edu_time >", value, "teachEduTime");
            return (Criteria) this;
        }

        public Criteria andTeachEduTimeGreaterThanOrEqualTo(String value) {
            addCriterion("teach_edu_time >=", value, "teachEduTime");
            return (Criteria) this;
        }

        public Criteria andTeachEduTimeLessThan(String value) {
            addCriterion("teach_edu_time <", value, "teachEduTime");
            return (Criteria) this;
        }

        public Criteria andTeachEduTimeLessThanOrEqualTo(String value) {
            addCriterion("teach_edu_time <=", value, "teachEduTime");
            return (Criteria) this;
        }

        public Criteria andTeachEduTimeLike(String value) {
            addCriterion("teach_edu_time like", value, "teachEduTime");
            return (Criteria) this;
        }

        public Criteria andTeachEduTimeNotLike(String value) {
            addCriterion("teach_edu_time not like", value, "teachEduTime");
            return (Criteria) this;
        }

        public Criteria andTeachEduTimeIn(List<String> values) {
            addCriterion("teach_edu_time in", values, "teachEduTime");
            return (Criteria) this;
        }

        public Criteria andTeachEduTimeNotIn(List<String> values) {
            addCriterion("teach_edu_time not in", values, "teachEduTime");
            return (Criteria) this;
        }

        public Criteria andTeachEduTimeBetween(String value1, String value2) {
            addCriterion("teach_edu_time between", value1, value2, "teachEduTime");
            return (Criteria) this;
        }

        public Criteria andTeachEduTimeNotBetween(String value1, String value2) {
            addCriterion("teach_edu_time not between", value1, value2, "teachEduTime");
            return (Criteria) this;
        }

        public Criteria andTeachAddressIsNull() {
            addCriterion("teach_address is null");
            return (Criteria) this;
        }

        public Criteria andTeachAddressIsNotNull() {
            addCriterion("teach_address is not null");
            return (Criteria) this;
        }

        public Criteria andTeachAddressEqualTo(String value) {
            addCriterion("teach_address =", value, "teachAddress");
            return (Criteria) this;
        }

        public Criteria andTeachAddressNotEqualTo(String value) {
            addCriterion("teach_address <>", value, "teachAddress");
            return (Criteria) this;
        }

        public Criteria andTeachAddressGreaterThan(String value) {
            addCriterion("teach_address >", value, "teachAddress");
            return (Criteria) this;
        }

        public Criteria andTeachAddressGreaterThanOrEqualTo(String value) {
            addCriterion("teach_address >=", value, "teachAddress");
            return (Criteria) this;
        }

        public Criteria andTeachAddressLessThan(String value) {
            addCriterion("teach_address <", value, "teachAddress");
            return (Criteria) this;
        }

        public Criteria andTeachAddressLessThanOrEqualTo(String value) {
            addCriterion("teach_address <=", value, "teachAddress");
            return (Criteria) this;
        }

        public Criteria andTeachAddressLike(String value) {
            addCriterion("teach_address like", value, "teachAddress");
            return (Criteria) this;
        }

        public Criteria andTeachAddressNotLike(String value) {
            addCriterion("teach_address not like", value, "teachAddress");
            return (Criteria) this;
        }

        public Criteria andTeachAddressIn(List<String> values) {
            addCriterion("teach_address in", values, "teachAddress");
            return (Criteria) this;
        }

        public Criteria andTeachAddressNotIn(List<String> values) {
            addCriterion("teach_address not in", values, "teachAddress");
            return (Criteria) this;
        }

        public Criteria andTeachAddressBetween(String value1, String value2) {
            addCriterion("teach_address between", value1, value2, "teachAddress");
            return (Criteria) this;
        }

        public Criteria andTeachAddressNotBetween(String value1, String value2) {
            addCriterion("teach_address not between", value1, value2, "teachAddress");
            return (Criteria) this;
        }

        public Criteria andTeachPhoneIsNull() {
            addCriterion("teach_phone is null");
            return (Criteria) this;
        }

        public Criteria andTeachPhoneIsNotNull() {
            addCriterion("teach_phone is not null");
            return (Criteria) this;
        }

        public Criteria andTeachPhoneEqualTo(Integer value) {
            addCriterion("teach_phone =", value, "teachPhone");
            return (Criteria) this;
        }

        public Criteria andTeachPhoneNotEqualTo(Integer value) {
            addCriterion("teach_phone <>", value, "teachPhone");
            return (Criteria) this;
        }

        public Criteria andTeachPhoneGreaterThan(Integer value) {
            addCriterion("teach_phone >", value, "teachPhone");
            return (Criteria) this;
        }

        public Criteria andTeachPhoneGreaterThanOrEqualTo(Integer value) {
            addCriterion("teach_phone >=", value, "teachPhone");
            return (Criteria) this;
        }

        public Criteria andTeachPhoneLessThan(Integer value) {
            addCriterion("teach_phone <", value, "teachPhone");
            return (Criteria) this;
        }

        public Criteria andTeachPhoneLessThanOrEqualTo(Integer value) {
            addCriterion("teach_phone <=", value, "teachPhone");
            return (Criteria) this;
        }

        public Criteria andTeachPhoneIn(List<Integer> values) {
            addCriterion("teach_phone in", values, "teachPhone");
            return (Criteria) this;
        }

        public Criteria andTeachPhoneNotIn(List<Integer> values) {
            addCriterion("teach_phone not in", values, "teachPhone");
            return (Criteria) this;
        }

        public Criteria andTeachPhoneBetween(Integer value1, Integer value2) {
            addCriterion("teach_phone between", value1, value2, "teachPhone");
            return (Criteria) this;
        }

        public Criteria andTeachPhoneNotBetween(Integer value1, Integer value2) {
            addCriterion("teach_phone not between", value1, value2, "teachPhone");
            return (Criteria) this;
        }

        public Criteria andTeachMaritalStateIsNull() {
            addCriterion("teach_marital_state is null");
            return (Criteria) this;
        }

        public Criteria andTeachMaritalStateIsNotNull() {
            addCriterion("teach_marital_state is not null");
            return (Criteria) this;
        }

        public Criteria andTeachMaritalStateEqualTo(Boolean value) {
            addCriterion("teach_marital_state =", value, "teachMaritalState");
            return (Criteria) this;
        }

        public Criteria andTeachMaritalStateNotEqualTo(Boolean value) {
            addCriterion("teach_marital_state <>", value, "teachMaritalState");
            return (Criteria) this;
        }

        public Criteria andTeachMaritalStateGreaterThan(Boolean value) {
            addCriterion("teach_marital_state >", value, "teachMaritalState");
            return (Criteria) this;
        }

        public Criteria andTeachMaritalStateGreaterThanOrEqualTo(Boolean value) {
            addCriterion("teach_marital_state >=", value, "teachMaritalState");
            return (Criteria) this;
        }

        public Criteria andTeachMaritalStateLessThan(Boolean value) {
            addCriterion("teach_marital_state <", value, "teachMaritalState");
            return (Criteria) this;
        }

        public Criteria andTeachMaritalStateLessThanOrEqualTo(Boolean value) {
            addCriterion("teach_marital_state <=", value, "teachMaritalState");
            return (Criteria) this;
        }

        public Criteria andTeachMaritalStateIn(List<Boolean> values) {
            addCriterion("teach_marital_state in", values, "teachMaritalState");
            return (Criteria) this;
        }

        public Criteria andTeachMaritalStateNotIn(List<Boolean> values) {
            addCriterion("teach_marital_state not in", values, "teachMaritalState");
            return (Criteria) this;
        }

        public Criteria andTeachMaritalStateBetween(Boolean value1, Boolean value2) {
            addCriterion("teach_marital_state between", value1, value2, "teachMaritalState");
            return (Criteria) this;
        }

        public Criteria andTeachMaritalStateNotBetween(Boolean value1, Boolean value2) {
            addCriterion("teach_marital_state not between", value1, value2, "teachMaritalState");
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