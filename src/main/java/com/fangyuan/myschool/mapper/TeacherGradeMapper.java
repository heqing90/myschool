package com.fangyuan.myschool.mapper;

import com.fangyuan.myschool.model.TeacherGrade;
import com.fangyuan.myschool.model.TeacherGradeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TeacherGradeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher_grade
     *
     * @mbggenerated
     */
    int countByExample(TeacherGradeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher_grade
     *
     * @mbggenerated
     */
    int deleteByExample(TeacherGradeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher_grade
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher_grade
     *
     * @mbggenerated
     */
    int insert(TeacherGrade record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher_grade
     *
     * @mbggenerated
     */
    int insertSelective(TeacherGrade record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher_grade
     *
     * @mbggenerated
     */
    List<TeacherGrade> selectByExampleWithRowbounds(TeacherGradeExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher_grade
     *
     * @mbggenerated
     */
    List<TeacherGrade> selectByExample(TeacherGradeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher_grade
     *
     * @mbggenerated
     */
    TeacherGrade selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher_grade
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") TeacherGrade record, @Param("example") TeacherGradeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher_grade
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") TeacherGrade record, @Param("example") TeacherGradeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher_grade
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(TeacherGrade record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher_grade
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(TeacherGrade record);
}