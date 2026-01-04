create PROC sumByQuarter
    @year INT
AS
BEGIN
    select quarter , sum(sum_fee) as sum_fee
    from(
                                                                                            select DATEPART(QUARTER,dd) as quarter , sum(fee) as sum_fee
            FROM Bill
            where YEAR(dd) = @year
            GROUP BY DATEPART(QUARTER,dd)
        union all
            select 1, 0
        union all
            select 2, 0
        union all
            select 3, 0
        union all
            select 4, 0
    ) as tmp
    group by quarter
    order by quarter
END
