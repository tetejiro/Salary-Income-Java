package com.java.salary_income.infrastructure.mapper;

import com.java.salary_income.domain.entity.SalaryInfoEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CalculateMapper {

    @Select("""
        SELECT
            YEAR, MONTH, SALARY, COSTS
        FROM
            SALARY_INFO
    """)
    List<SalaryInfoEntity.SalaryInfo> get();

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
