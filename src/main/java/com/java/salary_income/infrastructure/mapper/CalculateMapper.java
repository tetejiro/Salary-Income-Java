package com.java.salary_income.infrastructure.mapper;

import com.java.salary_income.domain.entity.SalaryInfoEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface CalculateMapper {

    @Select("""
        SELECT
            SUM(gross_pay)
        FROM
            SALARY_INFO
        WHERE
            YEAR = #{year}
    """)
    Integer getYearSalary(int year);

    @Select("""
        SELECT
            year,
            month,
            gross_pay,
            deduction
        FROM
            SALARY_INFO
        WHERE
            year = #{year}
        AND
            MONTH = #{month}
    """)
    SalaryInfoEntity.Content getMonthSalary(int year, int month);

    @Insert("""
        <script>
            INSERT INTO
                SALARY_INFO (year, month, gross_pay, deduction)
            VALUES
                <foreach collection="contents" item="info" open="(" separator="),(" close=")">
                    #{info.year}, #{info.month}, #{info.grossPay}, #{info.deduction}
                </foreach>
        </script>
    """)
    void post(List<SalaryInfoEntity.Content> contents);

    @Update("""
        UPDATE
            salary_info
        SET
            year = #{year},
            month = #{month},
            gross_pay = #{grossPay},
            deduction = #{deduction}
    """)
    int update(int year, int month, int grossPay, int deduction);
}
