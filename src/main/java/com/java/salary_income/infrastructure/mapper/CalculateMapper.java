package com.java.salary_income.infrastructure.mapper;

import com.java.salary_income.domain.entity.SalaryInfoEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface CalculateMapper {

    @Update("""
        UPDATE
            SALARY_INFO
        SET
            month = #{month},
            amount = #{amount}
        WHERE
            userId = #{userId}
    """)
    int update(int month, int amount, int userId);

    @Select("""
        SELECT
            YEAR, MONTH, SALARY, COSTS
        FROM
            SALARY_INFO
    """)
    List<SalaryInfoEntity.SalaryInfo> get();

    @Select("""
        SELECT
            *
        FROM
            SALARY_INFO
        WHERE
            MONTH = #{month}
    """)
    SalaryInfoEntity.SalaryInfo getTest(int month);

    @Insert("""
        <script>
            INSERT INTO
                SALARY_INFO (YEAR, MONTH, SALARY, COSTS)
            VALUES
                <foreach item="info" index="salaryInfo.month" collection="list" open="(" separator="),(" close=")">
                    #{info.year}, #{info.month}, #{info.salary}, #{info.costs}
                </foreach>
        </script>
    """)
    void post(List<SalaryInfoEntity.SalaryInfo> salaryInfo);
}
