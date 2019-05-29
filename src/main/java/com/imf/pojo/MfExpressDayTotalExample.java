package com.imf.pojo;

import java.util.ArrayList;
import java.util.List;

public class MfExpressDayTotalExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MfExpressDayTotalExample() {
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

        public Criteria andIntoTotalIsNull() {
            addCriterion("into_total is null");
            return (Criteria) this;
        }

        public Criteria andIntoTotalIsNotNull() {
            addCriterion("into_total is not null");
            return (Criteria) this;
        }

        public Criteria andIntoTotalEqualTo(Integer value) {
            addCriterion("into_total =", value, "intoTotal");
            return (Criteria) this;
        }

        public Criteria andIntoTotalNotEqualTo(Integer value) {
            addCriterion("into_total <>", value, "intoTotal");
            return (Criteria) this;
        }

        public Criteria andIntoTotalGreaterThan(Integer value) {
            addCriterion("into_total >", value, "intoTotal");
            return (Criteria) this;
        }

        public Criteria andIntoTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("into_total >=", value, "intoTotal");
            return (Criteria) this;
        }

        public Criteria andIntoTotalLessThan(Integer value) {
            addCriterion("into_total <", value, "intoTotal");
            return (Criteria) this;
        }

        public Criteria andIntoTotalLessThanOrEqualTo(Integer value) {
            addCriterion("into_total <=", value, "intoTotal");
            return (Criteria) this;
        }

        public Criteria andIntoTotalIn(List<Integer> values) {
            addCriterion("into_total in", values, "intoTotal");
            return (Criteria) this;
        }

        public Criteria andIntoTotalNotIn(List<Integer> values) {
            addCriterion("into_total not in", values, "intoTotal");
            return (Criteria) this;
        }

        public Criteria andIntoTotalBetween(Integer value1, Integer value2) {
            addCriterion("into_total between", value1, value2, "intoTotal");
            return (Criteria) this;
        }

        public Criteria andIntoTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("into_total not between", value1, value2, "intoTotal");
            return (Criteria) this;
        }

        public Criteria andOutTotalIsNull() {
            addCriterion("out_total is null");
            return (Criteria) this;
        }

        public Criteria andOutTotalIsNotNull() {
            addCriterion("out_total is not null");
            return (Criteria) this;
        }

        public Criteria andOutTotalEqualTo(Integer value) {
            addCriterion("out_total =", value, "outTotal");
            return (Criteria) this;
        }

        public Criteria andOutTotalNotEqualTo(Integer value) {
            addCriterion("out_total <>", value, "outTotal");
            return (Criteria) this;
        }

        public Criteria andOutTotalGreaterThan(Integer value) {
            addCriterion("out_total >", value, "outTotal");
            return (Criteria) this;
        }

        public Criteria andOutTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("out_total >=", value, "outTotal");
            return (Criteria) this;
        }

        public Criteria andOutTotalLessThan(Integer value) {
            addCriterion("out_total <", value, "outTotal");
            return (Criteria) this;
        }

        public Criteria andOutTotalLessThanOrEqualTo(Integer value) {
            addCriterion("out_total <=", value, "outTotal");
            return (Criteria) this;
        }

        public Criteria andOutTotalIn(List<Integer> values) {
            addCriterion("out_total in", values, "outTotal");
            return (Criteria) this;
        }

        public Criteria andOutTotalNotIn(List<Integer> values) {
            addCriterion("out_total not in", values, "outTotal");
            return (Criteria) this;
        }

        public Criteria andOutTotalBetween(Integer value1, Integer value2) {
            addCriterion("out_total between", value1, value2, "outTotal");
            return (Criteria) this;
        }

        public Criteria andOutTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("out_total not between", value1, value2, "outTotal");
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