package cn.young.manager.pojo;

import java.util.ArrayList;
import java.util.List;

public class CourseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CourseExample() {
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

        public Criteria andCidIsNull() {
            addCriterion("cid is null");
            return (Criteria) this;
        }

        public Criteria andCidIsNotNull() {
            addCriterion("cid is not null");
            return (Criteria) this;
        }

        public Criteria andCidEqualTo(Long value) {
            addCriterion("cid =", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotEqualTo(Long value) {
            addCriterion("cid <>", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThan(Long value) {
            addCriterion("cid >", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThanOrEqualTo(Long value) {
            addCriterion("cid >=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThan(Long value) {
            addCriterion("cid <", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThanOrEqualTo(Long value) {
            addCriterion("cid <=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidIn(List<Long> values) {
            addCriterion("cid in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotIn(List<Long> values) {
            addCriterion("cid not in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidBetween(Long value1, Long value2) {
            addCriterion("cid between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotBetween(Long value1, Long value2) {
            addCriterion("cid not between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andSchNameIsNull() {
            addCriterion("sch_name is null");
            return (Criteria) this;
        }

        public Criteria andSchNameIsNotNull() {
            addCriterion("sch_name is not null");
            return (Criteria) this;
        }

        public Criteria andSchNameEqualTo(String value) {
            addCriterion("sch_name =", value, "schName");
            return (Criteria) this;
        }

        public Criteria andSchNameNotEqualTo(String value) {
            addCriterion("sch_name <>", value, "schName");
            return (Criteria) this;
        }

        public Criteria andSchNameGreaterThan(String value) {
            addCriterion("sch_name >", value, "schName");
            return (Criteria) this;
        }

        public Criteria andSchNameGreaterThanOrEqualTo(String value) {
            addCriterion("sch_name >=", value, "schName");
            return (Criteria) this;
        }

        public Criteria andSchNameLessThan(String value) {
            addCriterion("sch_name <", value, "schName");
            return (Criteria) this;
        }

        public Criteria andSchNameLessThanOrEqualTo(String value) {
            addCriterion("sch_name <=", value, "schName");
            return (Criteria) this;
        }

        public Criteria andSchNameLike(String value) {
            addCriterion("sch_name like", value, "schName");
            return (Criteria) this;
        }

        public Criteria andSchNameNotLike(String value) {
            addCriterion("sch_name not like", value, "schName");
            return (Criteria) this;
        }

        public Criteria andSchNameIn(List<String> values) {
            addCriterion("sch_name in", values, "schName");
            return (Criteria) this;
        }

        public Criteria andSchNameNotIn(List<String> values) {
            addCriterion("sch_name not in", values, "schName");
            return (Criteria) this;
        }

        public Criteria andSchNameBetween(String value1, String value2) {
            addCriterion("sch_name between", value1, value2, "schName");
            return (Criteria) this;
        }

        public Criteria andSchNameNotBetween(String value1, String value2) {
            addCriterion("sch_name not between", value1, value2, "schName");
            return (Criteria) this;
        }

        public Criteria andCourseCodeIsNull() {
            addCriterion("course_code is null");
            return (Criteria) this;
        }

        public Criteria andCourseCodeIsNotNull() {
            addCriterion("course_code is not null");
            return (Criteria) this;
        }

        public Criteria andCourseCodeEqualTo(String value) {
            addCriterion("course_code =", value, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeNotEqualTo(String value) {
            addCriterion("course_code <>", value, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeGreaterThan(String value) {
            addCriterion("course_code >", value, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeGreaterThanOrEqualTo(String value) {
            addCriterion("course_code >=", value, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeLessThan(String value) {
            addCriterion("course_code <", value, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeLessThanOrEqualTo(String value) {
            addCriterion("course_code <=", value, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeLike(String value) {
            addCriterion("course_code like", value, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeNotLike(String value) {
            addCriterion("course_code not like", value, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeIn(List<String> values) {
            addCriterion("course_code in", values, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeNotIn(List<String> values) {
            addCriterion("course_code not in", values, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeBetween(String value1, String value2) {
            addCriterion("course_code between", value1, value2, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeNotBetween(String value1, String value2) {
            addCriterion("course_code not between", value1, value2, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseNameIsNull() {
            addCriterion("course_name is null");
            return (Criteria) this;
        }

        public Criteria andCourseNameIsNotNull() {
            addCriterion("course_name is not null");
            return (Criteria) this;
        }

        public Criteria andCourseNameEqualTo(String value) {
            addCriterion("course_name =", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotEqualTo(String value) {
            addCriterion("course_name <>", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameGreaterThan(String value) {
            addCriterion("course_name >", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameGreaterThanOrEqualTo(String value) {
            addCriterion("course_name >=", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLessThan(String value) {
            addCriterion("course_name <", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLessThanOrEqualTo(String value) {
            addCriterion("course_name <=", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLike(String value) {
            addCriterion("course_name like", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotLike(String value) {
            addCriterion("course_name not like", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameIn(List<String> values) {
            addCriterion("course_name in", values, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotIn(List<String> values) {
            addCriterion("course_name not in", values, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameBetween(String value1, String value2) {
            addCriterion("course_name between", value1, value2, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotBetween(String value1, String value2) {
            addCriterion("course_name not between", value1, value2, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseInfoIsNull() {
            addCriterion("course_info is null");
            return (Criteria) this;
        }

        public Criteria andCourseInfoIsNotNull() {
            addCriterion("course_info is not null");
            return (Criteria) this;
        }

        public Criteria andCourseInfoEqualTo(String value) {
            addCriterion("course_info =", value, "courseInfo");
            return (Criteria) this;
        }

        public Criteria andCourseInfoNotEqualTo(String value) {
            addCriterion("course_info <>", value, "courseInfo");
            return (Criteria) this;
        }

        public Criteria andCourseInfoGreaterThan(String value) {
            addCriterion("course_info >", value, "courseInfo");
            return (Criteria) this;
        }

        public Criteria andCourseInfoGreaterThanOrEqualTo(String value) {
            addCriterion("course_info >=", value, "courseInfo");
            return (Criteria) this;
        }

        public Criteria andCourseInfoLessThan(String value) {
            addCriterion("course_info <", value, "courseInfo");
            return (Criteria) this;
        }

        public Criteria andCourseInfoLessThanOrEqualTo(String value) {
            addCriterion("course_info <=", value, "courseInfo");
            return (Criteria) this;
        }

        public Criteria andCourseInfoLike(String value) {
            addCriterion("course_info like", value, "courseInfo");
            return (Criteria) this;
        }

        public Criteria andCourseInfoNotLike(String value) {
            addCriterion("course_info not like", value, "courseInfo");
            return (Criteria) this;
        }

        public Criteria andCourseInfoIn(List<String> values) {
            addCriterion("course_info in", values, "courseInfo");
            return (Criteria) this;
        }

        public Criteria andCourseInfoNotIn(List<String> values) {
            addCriterion("course_info not in", values, "courseInfo");
            return (Criteria) this;
        }

        public Criteria andCourseInfoBetween(String value1, String value2) {
            addCriterion("course_info between", value1, value2, "courseInfo");
            return (Criteria) this;
        }

        public Criteria andCourseInfoNotBetween(String value1, String value2) {
            addCriterion("course_info not between", value1, value2, "courseInfo");
            return (Criteria) this;
        }

        public Criteria andCourseSelectnumIsNull() {
            addCriterion("course_selectnum is null");
            return (Criteria) this;
        }

        public Criteria andCourseSelectnumIsNotNull() {
            addCriterion("course_selectnum is not null");
            return (Criteria) this;
        }

        public Criteria andCourseSelectnumEqualTo(Integer value) {
            addCriterion("course_selectnum =", value, "courseSelectnum");
            return (Criteria) this;
        }

        public Criteria andCourseSelectnumNotEqualTo(Integer value) {
            addCriterion("course_selectnum <>", value, "courseSelectnum");
            return (Criteria) this;
        }

        public Criteria andCourseSelectnumGreaterThan(Integer value) {
            addCriterion("course_selectnum >", value, "courseSelectnum");
            return (Criteria) this;
        }

        public Criteria andCourseSelectnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("course_selectnum >=", value, "courseSelectnum");
            return (Criteria) this;
        }

        public Criteria andCourseSelectnumLessThan(Integer value) {
            addCriterion("course_selectnum <", value, "courseSelectnum");
            return (Criteria) this;
        }

        public Criteria andCourseSelectnumLessThanOrEqualTo(Integer value) {
            addCriterion("course_selectnum <=", value, "courseSelectnum");
            return (Criteria) this;
        }

        public Criteria andCourseSelectnumIn(List<Integer> values) {
            addCriterion("course_selectnum in", values, "courseSelectnum");
            return (Criteria) this;
        }

        public Criteria andCourseSelectnumNotIn(List<Integer> values) {
            addCriterion("course_selectnum not in", values, "courseSelectnum");
            return (Criteria) this;
        }

        public Criteria andCourseSelectnumBetween(Integer value1, Integer value2) {
            addCriterion("course_selectnum between", value1, value2, "courseSelectnum");
            return (Criteria) this;
        }

        public Criteria andCourseSelectnumNotBetween(Integer value1, Integer value2) {
            addCriterion("course_selectnum not between", value1, value2, "courseSelectnum");
            return (Criteria) this;
        }

        public Criteria andCourseTotalnumIsNull() {
            addCriterion("course_totalnum is null");
            return (Criteria) this;
        }

        public Criteria andCourseTotalnumIsNotNull() {
            addCriterion("course_totalnum is not null");
            return (Criteria) this;
        }

        public Criteria andCourseTotalnumEqualTo(Integer value) {
            addCriterion("course_totalnum =", value, "courseTotalnum");
            return (Criteria) this;
        }

        public Criteria andCourseTotalnumNotEqualTo(Integer value) {
            addCriterion("course_totalnum <>", value, "courseTotalnum");
            return (Criteria) this;
        }

        public Criteria andCourseTotalnumGreaterThan(Integer value) {
            addCriterion("course_totalnum >", value, "courseTotalnum");
            return (Criteria) this;
        }

        public Criteria andCourseTotalnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("course_totalnum >=", value, "courseTotalnum");
            return (Criteria) this;
        }

        public Criteria andCourseTotalnumLessThan(Integer value) {
            addCriterion("course_totalnum <", value, "courseTotalnum");
            return (Criteria) this;
        }

        public Criteria andCourseTotalnumLessThanOrEqualTo(Integer value) {
            addCriterion("course_totalnum <=", value, "courseTotalnum");
            return (Criteria) this;
        }

        public Criteria andCourseTotalnumIn(List<Integer> values) {
            addCriterion("course_totalnum in", values, "courseTotalnum");
            return (Criteria) this;
        }

        public Criteria andCourseTotalnumNotIn(List<Integer> values) {
            addCriterion("course_totalnum not in", values, "courseTotalnum");
            return (Criteria) this;
        }

        public Criteria andCourseTotalnumBetween(Integer value1, Integer value2) {
            addCriterion("course_totalnum between", value1, value2, "courseTotalnum");
            return (Criteria) this;
        }

        public Criteria andCourseTotalnumNotBetween(Integer value1, Integer value2) {
            addCriterion("course_totalnum not between", value1, value2, "courseTotalnum");
            return (Criteria) this;
        }

        public Criteria andCourseRemarkIsNull() {
            addCriterion("course_remark is null");
            return (Criteria) this;
        }

        public Criteria andCourseRemarkIsNotNull() {
            addCriterion("course_remark is not null");
            return (Criteria) this;
        }

        public Criteria andCourseRemarkEqualTo(String value) {
            addCriterion("course_remark =", value, "courseRemark");
            return (Criteria) this;
        }

        public Criteria andCourseRemarkNotEqualTo(String value) {
            addCriterion("course_remark <>", value, "courseRemark");
            return (Criteria) this;
        }

        public Criteria andCourseRemarkGreaterThan(String value) {
            addCriterion("course_remark >", value, "courseRemark");
            return (Criteria) this;
        }

        public Criteria andCourseRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("course_remark >=", value, "courseRemark");
            return (Criteria) this;
        }

        public Criteria andCourseRemarkLessThan(String value) {
            addCriterion("course_remark <", value, "courseRemark");
            return (Criteria) this;
        }

        public Criteria andCourseRemarkLessThanOrEqualTo(String value) {
            addCriterion("course_remark <=", value, "courseRemark");
            return (Criteria) this;
        }

        public Criteria andCourseRemarkLike(String value) {
            addCriterion("course_remark like", value, "courseRemark");
            return (Criteria) this;
        }

        public Criteria andCourseRemarkNotLike(String value) {
            addCriterion("course_remark not like", value, "courseRemark");
            return (Criteria) this;
        }

        public Criteria andCourseRemarkIn(List<String> values) {
            addCriterion("course_remark in", values, "courseRemark");
            return (Criteria) this;
        }

        public Criteria andCourseRemarkNotIn(List<String> values) {
            addCriterion("course_remark not in", values, "courseRemark");
            return (Criteria) this;
        }

        public Criteria andCourseRemarkBetween(String value1, String value2) {
            addCriterion("course_remark between", value1, value2, "courseRemark");
            return (Criteria) this;
        }

        public Criteria andCourseRemarkNotBetween(String value1, String value2) {
            addCriterion("course_remark not between", value1, value2, "courseRemark");
            return (Criteria) this;
        }

        public Criteria andCourseDesIsNull() {
            addCriterion("course_des is null");
            return (Criteria) this;
        }

        public Criteria andCourseDesIsNotNull() {
            addCriterion("course_des is not null");
            return (Criteria) this;
        }

        public Criteria andCourseDesEqualTo(String value) {
            addCriterion("course_des =", value, "courseDes");
            return (Criteria) this;
        }

        public Criteria andCourseDesNotEqualTo(String value) {
            addCriterion("course_des <>", value, "courseDes");
            return (Criteria) this;
        }

        public Criteria andCourseDesGreaterThan(String value) {
            addCriterion("course_des >", value, "courseDes");
            return (Criteria) this;
        }

        public Criteria andCourseDesGreaterThanOrEqualTo(String value) {
            addCriterion("course_des >=", value, "courseDes");
            return (Criteria) this;
        }

        public Criteria andCourseDesLessThan(String value) {
            addCriterion("course_des <", value, "courseDes");
            return (Criteria) this;
        }

        public Criteria andCourseDesLessThanOrEqualTo(String value) {
            addCriterion("course_des <=", value, "courseDes");
            return (Criteria) this;
        }

        public Criteria andCourseDesLike(String value) {
            addCriterion("course_des like", value, "courseDes");
            return (Criteria) this;
        }

        public Criteria andCourseDesNotLike(String value) {
            addCriterion("course_des not like", value, "courseDes");
            return (Criteria) this;
        }

        public Criteria andCourseDesIn(List<String> values) {
            addCriterion("course_des in", values, "courseDes");
            return (Criteria) this;
        }

        public Criteria andCourseDesNotIn(List<String> values) {
            addCriterion("course_des not in", values, "courseDes");
            return (Criteria) this;
        }

        public Criteria andCourseDesBetween(String value1, String value2) {
            addCriterion("course_des between", value1, value2, "courseDes");
            return (Criteria) this;
        }

        public Criteria andCourseDesNotBetween(String value1, String value2) {
            addCriterion("course_des not between", value1, value2, "courseDes");
            return (Criteria) this;
        }

        public Criteria andCourseImageIsNull() {
            addCriterion("course_image is null");
            return (Criteria) this;
        }

        public Criteria andCourseImageIsNotNull() {
            addCriterion("course_image is not null");
            return (Criteria) this;
        }

        public Criteria andCourseImageEqualTo(String value) {
            addCriterion("course_image =", value, "courseImage");
            return (Criteria) this;
        }

        public Criteria andCourseImageNotEqualTo(String value) {
            addCriterion("course_image <>", value, "courseImage");
            return (Criteria) this;
        }

        public Criteria andCourseImageGreaterThan(String value) {
            addCriterion("course_image >", value, "courseImage");
            return (Criteria) this;
        }

        public Criteria andCourseImageGreaterThanOrEqualTo(String value) {
            addCriterion("course_image >=", value, "courseImage");
            return (Criteria) this;
        }

        public Criteria andCourseImageLessThan(String value) {
            addCriterion("course_image <", value, "courseImage");
            return (Criteria) this;
        }

        public Criteria andCourseImageLessThanOrEqualTo(String value) {
            addCriterion("course_image <=", value, "courseImage");
            return (Criteria) this;
        }

        public Criteria andCourseImageLike(String value) {
            addCriterion("course_image like", value, "courseImage");
            return (Criteria) this;
        }

        public Criteria andCourseImageNotLike(String value) {
            addCriterion("course_image not like", value, "courseImage");
            return (Criteria) this;
        }

        public Criteria andCourseImageIn(List<String> values) {
            addCriterion("course_image in", values, "courseImage");
            return (Criteria) this;
        }

        public Criteria andCourseImageNotIn(List<String> values) {
            addCriterion("course_image not in", values, "courseImage");
            return (Criteria) this;
        }

        public Criteria andCourseImageBetween(String value1, String value2) {
            addCriterion("course_image between", value1, value2, "courseImage");
            return (Criteria) this;
        }

        public Criteria andCourseImageNotBetween(String value1, String value2) {
            addCriterion("course_image not between", value1, value2, "courseImage");
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