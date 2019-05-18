package com.imf.pojo;

import java.util.ArrayList;
import java.util.List;

public class MfStudentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MfStudentExample() {
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

        public Criteria andStuUuidEqualTo(Integer value) {
            addCriterion("stu_uuid =", value, "stuUuid");
            return (Criteria) this;
        }

        public Criteria andStuUuidNotEqualTo(Integer value) {
            addCriterion("stu_uuid <>", value, "stuUuid");
            return (Criteria) this;
        }

        public Criteria andStuUuidGreaterThan(Integer value) {
            addCriterion("stu_uuid >", value, "stuUuid");
            return (Criteria) this;
        }

        public Criteria andStuUuidGreaterThanOrEqualTo(Integer value) {
            addCriterion("stu_uuid >=", value, "stuUuid");
            return (Criteria) this;
        }

        public Criteria andStuUuidLessThan(Integer value) {
            addCriterion("stu_uuid <", value, "stuUuid");
            return (Criteria) this;
        }

        public Criteria andStuUuidLessThanOrEqualTo(Integer value) {
            addCriterion("stu_uuid <=", value, "stuUuid");
            return (Criteria) this;
        }

        public Criteria andStuUuidIn(List<Integer> values) {
            addCriterion("stu_uuid in", values, "stuUuid");
            return (Criteria) this;
        }

        public Criteria andStuUuidNotIn(List<Integer> values) {
            addCriterion("stu_uuid not in", values, "stuUuid");
            return (Criteria) this;
        }

        public Criteria andStuUuidBetween(Integer value1, Integer value2) {
            addCriterion("stu_uuid between", value1, value2, "stuUuid");
            return (Criteria) this;
        }

        public Criteria andStuUuidNotBetween(Integer value1, Integer value2) {
            addCriterion("stu_uuid not between", value1, value2, "stuUuid");
            return (Criteria) this;
        }

        public Criteria andStuNameIsNull() {
            addCriterion("stu_name is null");
            return (Criteria) this;
        }

        public Criteria andStuNameIsNotNull() {
            addCriterion("stu_name is not null");
            return (Criteria) this;
        }

        public Criteria andStuNameEqualTo(String value) {
            addCriterion("stu_name =", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameNotEqualTo(String value) {
            addCriterion("stu_name <>", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameGreaterThan(String value) {
            addCriterion("stu_name >", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameGreaterThanOrEqualTo(String value) {
            addCriterion("stu_name >=", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameLessThan(String value) {
            addCriterion("stu_name <", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameLessThanOrEqualTo(String value) {
            addCriterion("stu_name <=", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameLike(String value) {
            addCriterion("stu_name like", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameNotLike(String value) {
            addCriterion("stu_name not like", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameIn(List<String> values) {
            addCriterion("stu_name in", values, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameNotIn(List<String> values) {
            addCriterion("stu_name not in", values, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameBetween(String value1, String value2) {
            addCriterion("stu_name between", value1, value2, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameNotBetween(String value1, String value2) {
            addCriterion("stu_name not between", value1, value2, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuAgeIsNull() {
            addCriterion("stu_age is null");
            return (Criteria) this;
        }

        public Criteria andStuAgeIsNotNull() {
            addCriterion("stu_age is not null");
            return (Criteria) this;
        }

        public Criteria andStuAgeEqualTo(Byte value) {
            addCriterion("stu_age =", value, "stuAge");
            return (Criteria) this;
        }

        public Criteria andStuAgeNotEqualTo(Byte value) {
            addCriterion("stu_age <>", value, "stuAge");
            return (Criteria) this;
        }

        public Criteria andStuAgeGreaterThan(Byte value) {
            addCriterion("stu_age >", value, "stuAge");
            return (Criteria) this;
        }

        public Criteria andStuAgeGreaterThanOrEqualTo(Byte value) {
            addCriterion("stu_age >=", value, "stuAge");
            return (Criteria) this;
        }

        public Criteria andStuAgeLessThan(Byte value) {
            addCriterion("stu_age <", value, "stuAge");
            return (Criteria) this;
        }

        public Criteria andStuAgeLessThanOrEqualTo(Byte value) {
            addCriterion("stu_age <=", value, "stuAge");
            return (Criteria) this;
        }

        public Criteria andStuAgeIn(List<Byte> values) {
            addCriterion("stu_age in", values, "stuAge");
            return (Criteria) this;
        }

        public Criteria andStuAgeNotIn(List<Byte> values) {
            addCriterion("stu_age not in", values, "stuAge");
            return (Criteria) this;
        }

        public Criteria andStuAgeBetween(Byte value1, Byte value2) {
            addCriterion("stu_age between", value1, value2, "stuAge");
            return (Criteria) this;
        }

        public Criteria andStuAgeNotBetween(Byte value1, Byte value2) {
            addCriterion("stu_age not between", value1, value2, "stuAge");
            return (Criteria) this;
        }

        public Criteria andStuGenderIsNull() {
            addCriterion("stu_gender is null");
            return (Criteria) this;
        }

        public Criteria andStuGenderIsNotNull() {
            addCriterion("stu_gender is not null");
            return (Criteria) this;
        }

        public Criteria andStuGenderEqualTo(Byte value) {
            addCriterion("stu_gender =", value, "stuGender");
            return (Criteria) this;
        }

        public Criteria andStuGenderNotEqualTo(Byte value) {
            addCriterion("stu_gender <>", value, "stuGender");
            return (Criteria) this;
        }

        public Criteria andStuGenderGreaterThan(Byte value) {
            addCriterion("stu_gender >", value, "stuGender");
            return (Criteria) this;
        }

        public Criteria andStuGenderGreaterThanOrEqualTo(Byte value) {
            addCriterion("stu_gender >=", value, "stuGender");
            return (Criteria) this;
        }

        public Criteria andStuGenderLessThan(Byte value) {
            addCriterion("stu_gender <", value, "stuGender");
            return (Criteria) this;
        }

        public Criteria andStuGenderLessThanOrEqualTo(Byte value) {
            addCriterion("stu_gender <=", value, "stuGender");
            return (Criteria) this;
        }

        public Criteria andStuGenderIn(List<Byte> values) {
            addCriterion("stu_gender in", values, "stuGender");
            return (Criteria) this;
        }

        public Criteria andStuGenderNotIn(List<Byte> values) {
            addCriterion("stu_gender not in", values, "stuGender");
            return (Criteria) this;
        }

        public Criteria andStuGenderBetween(Byte value1, Byte value2) {
            addCriterion("stu_gender between", value1, value2, "stuGender");
            return (Criteria) this;
        }

        public Criteria andStuGenderNotBetween(Byte value1, Byte value2) {
            addCriterion("stu_gender not between", value1, value2, "stuGender");
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

        public Criteria andStuPhoneNumEqualTo(Integer value) {
            addCriterion("stu_phone_num =", value, "stuPhoneNum");
            return (Criteria) this;
        }

        public Criteria andStuPhoneNumNotEqualTo(Integer value) {
            addCriterion("stu_phone_num <>", value, "stuPhoneNum");
            return (Criteria) this;
        }

        public Criteria andStuPhoneNumGreaterThan(Integer value) {
            addCriterion("stu_phone_num >", value, "stuPhoneNum");
            return (Criteria) this;
        }

        public Criteria andStuPhoneNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("stu_phone_num >=", value, "stuPhoneNum");
            return (Criteria) this;
        }

        public Criteria andStuPhoneNumLessThan(Integer value) {
            addCriterion("stu_phone_num <", value, "stuPhoneNum");
            return (Criteria) this;
        }

        public Criteria andStuPhoneNumLessThanOrEqualTo(Integer value) {
            addCriterion("stu_phone_num <=", value, "stuPhoneNum");
            return (Criteria) this;
        }

        public Criteria andStuPhoneNumIn(List<Integer> values) {
            addCriterion("stu_phone_num in", values, "stuPhoneNum");
            return (Criteria) this;
        }

        public Criteria andStuPhoneNumNotIn(List<Integer> values) {
            addCriterion("stu_phone_num not in", values, "stuPhoneNum");
            return (Criteria) this;
        }

        public Criteria andStuPhoneNumBetween(Integer value1, Integer value2) {
            addCriterion("stu_phone_num between", value1, value2, "stuPhoneNum");
            return (Criteria) this;
        }

        public Criteria andStuPhoneNumNotBetween(Integer value1, Integer value2) {
            addCriterion("stu_phone_num not between", value1, value2, "stuPhoneNum");
            return (Criteria) this;
        }

        public Criteria andStuImgUrlIsNull() {
            addCriterion("stu_img_url is null");
            return (Criteria) this;
        }

        public Criteria andStuImgUrlIsNotNull() {
            addCriterion("stu_img_url is not null");
            return (Criteria) this;
        }

        public Criteria andStuImgUrlEqualTo(String value) {
            addCriterion("stu_img_url =", value, "stuImgUrl");
            return (Criteria) this;
        }

        public Criteria andStuImgUrlNotEqualTo(String value) {
            addCriterion("stu_img_url <>", value, "stuImgUrl");
            return (Criteria) this;
        }

        public Criteria andStuImgUrlGreaterThan(String value) {
            addCriterion("stu_img_url >", value, "stuImgUrl");
            return (Criteria) this;
        }

        public Criteria andStuImgUrlGreaterThanOrEqualTo(String value) {
            addCriterion("stu_img_url >=", value, "stuImgUrl");
            return (Criteria) this;
        }

        public Criteria andStuImgUrlLessThan(String value) {
            addCriterion("stu_img_url <", value, "stuImgUrl");
            return (Criteria) this;
        }

        public Criteria andStuImgUrlLessThanOrEqualTo(String value) {
            addCriterion("stu_img_url <=", value, "stuImgUrl");
            return (Criteria) this;
        }

        public Criteria andStuImgUrlLike(String value) {
            addCriterion("stu_img_url like", value, "stuImgUrl");
            return (Criteria) this;
        }

        public Criteria andStuImgUrlNotLike(String value) {
            addCriterion("stu_img_url not like", value, "stuImgUrl");
            return (Criteria) this;
        }

        public Criteria andStuImgUrlIn(List<String> values) {
            addCriterion("stu_img_url in", values, "stuImgUrl");
            return (Criteria) this;
        }

        public Criteria andStuImgUrlNotIn(List<String> values) {
            addCriterion("stu_img_url not in", values, "stuImgUrl");
            return (Criteria) this;
        }

        public Criteria andStuImgUrlBetween(String value1, String value2) {
            addCriterion("stu_img_url between", value1, value2, "stuImgUrl");
            return (Criteria) this;
        }

        public Criteria andStuImgUrlNotBetween(String value1, String value2) {
            addCriterion("stu_img_url not between", value1, value2, "stuImgUrl");
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