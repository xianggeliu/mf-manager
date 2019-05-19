package com.imf.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MfTeacherExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MfTeacherExample() {
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

        public Criteria andTeachNameIsNull() {
            addCriterion("teach_name is null");
            return (Criteria) this;
        }

        public Criteria andTeachNameIsNotNull() {
            addCriterion("teach_name is not null");
            return (Criteria) this;
        }

        public Criteria andTeachNameEqualTo(String value) {
            addCriterion("teach_name =", value, "teachName");
            return (Criteria) this;
        }

        public Criteria andTeachNameNotEqualTo(String value) {
            addCriterion("teach_name <>", value, "teachName");
            return (Criteria) this;
        }

        public Criteria andTeachNameGreaterThan(String value) {
            addCriterion("teach_name >", value, "teachName");
            return (Criteria) this;
        }

        public Criteria andTeachNameGreaterThanOrEqualTo(String value) {
            addCriterion("teach_name >=", value, "teachName");
            return (Criteria) this;
        }

        public Criteria andTeachNameLessThan(String value) {
            addCriterion("teach_name <", value, "teachName");
            return (Criteria) this;
        }

        public Criteria andTeachNameLessThanOrEqualTo(String value) {
            addCriterion("teach_name <=", value, "teachName");
            return (Criteria) this;
        }

        public Criteria andTeachNameLike(String value) {
            addCriterion("teach_name like", value, "teachName");
            return (Criteria) this;
        }

        public Criteria andTeachNameNotLike(String value) {
            addCriterion("teach_name not like", value, "teachName");
            return (Criteria) this;
        }

        public Criteria andTeachNameIn(List<String> values) {
            addCriterion("teach_name in", values, "teachName");
            return (Criteria) this;
        }

        public Criteria andTeachNameNotIn(List<String> values) {
            addCriterion("teach_name not in", values, "teachName");
            return (Criteria) this;
        }

        public Criteria andTeachNameBetween(String value1, String value2) {
            addCriterion("teach_name between", value1, value2, "teachName");
            return (Criteria) this;
        }

        public Criteria andTeachNameNotBetween(String value1, String value2) {
            addCriterion("teach_name not between", value1, value2, "teachName");
            return (Criteria) this;
        }

        public Criteria andTeachGenderIsNull() {
            addCriterion("teach_gender is null");
            return (Criteria) this;
        }

        public Criteria andTeachGenderIsNotNull() {
            addCriterion("teach_gender is not null");
            return (Criteria) this;
        }

        public Criteria andTeachGenderEqualTo(Boolean value) {
            addCriterion("teach_gender =", value, "teachGender");
            return (Criteria) this;
        }

        public Criteria andTeachGenderNotEqualTo(Boolean value) {
            addCriterion("teach_gender <>", value, "teachGender");
            return (Criteria) this;
        }

        public Criteria andTeachGenderGreaterThan(Boolean value) {
            addCriterion("teach_gender >", value, "teachGender");
            return (Criteria) this;
        }

        public Criteria andTeachGenderGreaterThanOrEqualTo(Boolean value) {
            addCriterion("teach_gender >=", value, "teachGender");
            return (Criteria) this;
        }

        public Criteria andTeachGenderLessThan(Boolean value) {
            addCriterion("teach_gender <", value, "teachGender");
            return (Criteria) this;
        }

        public Criteria andTeachGenderLessThanOrEqualTo(Boolean value) {
            addCriterion("teach_gender <=", value, "teachGender");
            return (Criteria) this;
        }

        public Criteria andTeachGenderIn(List<Boolean> values) {
            addCriterion("teach_gender in", values, "teachGender");
            return (Criteria) this;
        }

        public Criteria andTeachGenderNotIn(List<Boolean> values) {
            addCriterion("teach_gender not in", values, "teachGender");
            return (Criteria) this;
        }

        public Criteria andTeachGenderBetween(Boolean value1, Boolean value2) {
            addCriterion("teach_gender between", value1, value2, "teachGender");
            return (Criteria) this;
        }

        public Criteria andTeachGenderNotBetween(Boolean value1, Boolean value2) {
            addCriterion("teach_gender not between", value1, value2, "teachGender");
            return (Criteria) this;
        }

        public Criteria andTeachImgUrlIsNull() {
            addCriterion("teach_img_url is null");
            return (Criteria) this;
        }

        public Criteria andTeachImgUrlIsNotNull() {
            addCriterion("teach_img_url is not null");
            return (Criteria) this;
        }

        public Criteria andTeachImgUrlEqualTo(String value) {
            addCriterion("teach_img_url =", value, "teachImgUrl");
            return (Criteria) this;
        }

        public Criteria andTeachImgUrlNotEqualTo(String value) {
            addCriterion("teach_img_url <>", value, "teachImgUrl");
            return (Criteria) this;
        }

        public Criteria andTeachImgUrlGreaterThan(String value) {
            addCriterion("teach_img_url >", value, "teachImgUrl");
            return (Criteria) this;
        }

        public Criteria andTeachImgUrlGreaterThanOrEqualTo(String value) {
            addCriterion("teach_img_url >=", value, "teachImgUrl");
            return (Criteria) this;
        }

        public Criteria andTeachImgUrlLessThan(String value) {
            addCriterion("teach_img_url <", value, "teachImgUrl");
            return (Criteria) this;
        }

        public Criteria andTeachImgUrlLessThanOrEqualTo(String value) {
            addCriterion("teach_img_url <=", value, "teachImgUrl");
            return (Criteria) this;
        }

        public Criteria andTeachImgUrlLike(String value) {
            addCriterion("teach_img_url like", value, "teachImgUrl");
            return (Criteria) this;
        }

        public Criteria andTeachImgUrlNotLike(String value) {
            addCriterion("teach_img_url not like", value, "teachImgUrl");
            return (Criteria) this;
        }

        public Criteria andTeachImgUrlIn(List<String> values) {
            addCriterion("teach_img_url in", values, "teachImgUrl");
            return (Criteria) this;
        }

        public Criteria andTeachImgUrlNotIn(List<String> values) {
            addCriterion("teach_img_url not in", values, "teachImgUrl");
            return (Criteria) this;
        }

        public Criteria andTeachImgUrlBetween(String value1, String value2) {
            addCriterion("teach_img_url between", value1, value2, "teachImgUrl");
            return (Criteria) this;
        }

        public Criteria andTeachImgUrlNotBetween(String value1, String value2) {
            addCriterion("teach_img_url not between", value1, value2, "teachImgUrl");
            return (Criteria) this;
        }

        public Criteria andTeachAgeIsNull() {
            addCriterion("teach_age is null");
            return (Criteria) this;
        }

        public Criteria andTeachAgeIsNotNull() {
            addCriterion("teach_age is not null");
            return (Criteria) this;
        }

        public Criteria andTeachAgeEqualTo(Byte value) {
            addCriterion("teach_age =", value, "teachAge");
            return (Criteria) this;
        }

        public Criteria andTeachAgeNotEqualTo(Byte value) {
            addCriterion("teach_age <>", value, "teachAge");
            return (Criteria) this;
        }

        public Criteria andTeachAgeGreaterThan(Byte value) {
            addCriterion("teach_age >", value, "teachAge");
            return (Criteria) this;
        }

        public Criteria andTeachAgeGreaterThanOrEqualTo(Byte value) {
            addCriterion("teach_age >=", value, "teachAge");
            return (Criteria) this;
        }

        public Criteria andTeachAgeLessThan(Byte value) {
            addCriterion("teach_age <", value, "teachAge");
            return (Criteria) this;
        }

        public Criteria andTeachAgeLessThanOrEqualTo(Byte value) {
            addCriterion("teach_age <=", value, "teachAge");
            return (Criteria) this;
        }

        public Criteria andTeachAgeIn(List<Byte> values) {
            addCriterion("teach_age in", values, "teachAge");
            return (Criteria) this;
        }

        public Criteria andTeachAgeNotIn(List<Byte> values) {
            addCriterion("teach_age not in", values, "teachAge");
            return (Criteria) this;
        }

        public Criteria andTeachAgeBetween(Byte value1, Byte value2) {
            addCriterion("teach_age between", value1, value2, "teachAge");
            return (Criteria) this;
        }

        public Criteria andTeachAgeNotBetween(Byte value1, Byte value2) {
            addCriterion("teach_age not between", value1, value2, "teachAge");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andEditTimeIsNull() {
            addCriterion("edit_time is null");
            return (Criteria) this;
        }

        public Criteria andEditTimeIsNotNull() {
            addCriterion("edit_time is not null");
            return (Criteria) this;
        }

        public Criteria andEditTimeEqualTo(Date value) {
            addCriterion("edit_time =", value, "editTime");
            return (Criteria) this;
        }

        public Criteria andEditTimeNotEqualTo(Date value) {
            addCriterion("edit_time <>", value, "editTime");
            return (Criteria) this;
        }

        public Criteria andEditTimeGreaterThan(Date value) {
            addCriterion("edit_time >", value, "editTime");
            return (Criteria) this;
        }

        public Criteria andEditTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("edit_time >=", value, "editTime");
            return (Criteria) this;
        }

        public Criteria andEditTimeLessThan(Date value) {
            addCriterion("edit_time <", value, "editTime");
            return (Criteria) this;
        }

        public Criteria andEditTimeLessThanOrEqualTo(Date value) {
            addCriterion("edit_time <=", value, "editTime");
            return (Criteria) this;
        }

        public Criteria andEditTimeIn(List<Date> values) {
            addCriterion("edit_time in", values, "editTime");
            return (Criteria) this;
        }

        public Criteria andEditTimeNotIn(List<Date> values) {
            addCriterion("edit_time not in", values, "editTime");
            return (Criteria) this;
        }

        public Criteria andEditTimeBetween(Date value1, Date value2) {
            addCriterion("edit_time between", value1, value2, "editTime");
            return (Criteria) this;
        }

        public Criteria andEditTimeNotBetween(Date value1, Date value2) {
            addCriterion("edit_time not between", value1, value2, "editTime");
            return (Criteria) this;
        }

        public Criteria andTeachStateIsNull() {
            addCriterion("teach_state is null");
            return (Criteria) this;
        }

        public Criteria andTeachStateIsNotNull() {
            addCriterion("teach_state is not null");
            return (Criteria) this;
        }

        public Criteria andTeachStateEqualTo(Boolean value) {
            addCriterion("teach_state =", value, "teachState");
            return (Criteria) this;
        }

        public Criteria andTeachStateNotEqualTo(Boolean value) {
            addCriterion("teach_state <>", value, "teachState");
            return (Criteria) this;
        }

        public Criteria andTeachStateGreaterThan(Boolean value) {
            addCriterion("teach_state >", value, "teachState");
            return (Criteria) this;
        }

        public Criteria andTeachStateGreaterThanOrEqualTo(Boolean value) {
            addCriterion("teach_state >=", value, "teachState");
            return (Criteria) this;
        }

        public Criteria andTeachStateLessThan(Boolean value) {
            addCriterion("teach_state <", value, "teachState");
            return (Criteria) this;
        }

        public Criteria andTeachStateLessThanOrEqualTo(Boolean value) {
            addCriterion("teach_state <=", value, "teachState");
            return (Criteria) this;
        }

        public Criteria andTeachStateIn(List<Boolean> values) {
            addCriterion("teach_state in", values, "teachState");
            return (Criteria) this;
        }

        public Criteria andTeachStateNotIn(List<Boolean> values) {
            addCriterion("teach_state not in", values, "teachState");
            return (Criteria) this;
        }

        public Criteria andTeachStateBetween(Boolean value1, Boolean value2) {
            addCriterion("teach_state between", value1, value2, "teachState");
            return (Criteria) this;
        }

        public Criteria andTeachStateNotBetween(Boolean value1, Boolean value2) {
            addCriterion("teach_state not between", value1, value2, "teachState");
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