-- SELECT * 
-- from UserInfo
-- -- WHERE uid = 'A01' or cname = '李大媽'
-- -- WHERE uid = 'A01' and password = '12345'
-- -- WHERE uid = 'A01' or uid = 'A02'
-- -- WHERE uid in ('A01', 'A02')
-- -- WHERE uid not in ('A01', 'A02')
-- -- WHERE uid <> 'A01' and uid <> 'A02'
-- -- where cname like '王%'
-- where cname <> '王大明' or cname is null

-- SELECT *
-- FROM UserInfo,Live,House
-- WHERE UserInfo.uid = Live.uid AND Live.hid = House.hid

-- SELECT *
-- FROM UserInfo left outer JOIN Live
--             on UserInfo.uid = Live.uid

--          left outer JOIN House
--             on Live.hid = House.hid
-- WHERE cname = '朱小妹'

-- SELECT *
-- from UserInfo, House

-- SELECT Bill.tel, SUM(fee) as sum_fee,address
-- FROM Bill, Phone, House
-- WHERE Bill.tel = Phone.tel AND Phone.hid = House.hid
-- GROUP BY Bill.tel, address

-- SELECT Bill.tel, SUM(fee) as sum_fee, address
-- FROM Bill, House
-- WHERE Bill.hid = House.hid
-- GROUP BY Bill.tel, address


-- 查詢每支電話的帳單金額總和並列出裝機地址（若無帳單顯示 0、若無地址顯示 '無地址'）
-- SELECT
-- 	Phone.tel,
-- 	ISNULL(SUM(Bill.fee), 0) AS sum_fee,
-- 	COALESCE(House.address, N'無地址') AS address
-- FROM Phone
-- LEFT OUTER JOIN Bill ON Phone.tel = Bill.tel
-- LEFT OUTER JOIN House ON Phone.hid = House.hid
-- GROUP BY Phone.tel, COALESCE(House.address, N'無地址')
-- ORDER BY Phone.tel;

-- SELECT left(cname,1) as a
-- FROM UserInfo
-- WHERE cname <> '' and cname is NOT NULL

-- SELECT tel, count(*)
-- from  Bill
-- GROUP by tel

-- SELECT a, count(*)
-- from  (
--     SELECT left(cname,1) as a
--     FROM UserInfo
--     WHERE cname <> '' and cname is NOT NULL
-- ) as x
-- GROUP by a

-- -- select 沒有房子的人數 / 全部多少人

-- select (
--     select count(*) from (
--         SELECT
--             u.uid,
--             u.cname,
--             COUNT(l.hid) AS house_count
--         FROM AddressBook.dbo.UserInfo AS u
--         LEFT OUTER JOIN AddressBook.dbo.Live AS l
--             ON u.uid = l.uid
--         GROUP BY
--             u.uid,
--             u.cname
--     ) as x
--     where house_count = 0    
-- ) / cast((
--     select count(*) from UserInfo
-- ) as float)

-- SELECT 空屋數 / 房屋總數 



-- SELECT (
--     select COUNT(*)
--     from Live RIGHT JOIN House on Live.hid = House.hid
--     where Live.hid is NULL
-- ) / (
--     SELECT CAST(COUNT(*) as float) FROM House
-- )

-- 查詢：找出每支電話帳單金額總和最少的資料（含無帳單顯示 0、無地址顯示 '無地址'）
-- SELECT TOP 1 WITH TIES
--     Phone.tel,
--     ISNULL(SUM(Bill.fee), 0) AS sum_fee,
--     COALESCE(House.address, N'無地址') AS address
-- FROM Phone
--     LEFT OUTER JOIN Bill
--     ON Phone.tel = Bill.tel
--     LEFT OUTER JOIN House
--     ON Phone.hid = House.hid
-- GROUP BY
--     Phone.tel,
--     COALESCE(House.address, N'無地址')
-- ORDER BY
--     sum_fee ASC;

-- SELECT*
-- from Bill
-- where fee = (
--     select MAX(fee)
--     from Bill
-- )

-- SELECT *
-- FROM(
--     select Phone.tel,
--     ISNULL(SUM(Bill.fee), 0) AS total_fee
-- FROM Phone
--     LEFT OUTER JOIN Bill
--     ON Phone.tel = Bill.tel
-- GROUP BY
--     Phone.tel
-- ) as x
-- WHERE total_fee >= 1000


-- SELECT 
--     Phone.tel,
--     ISNULL(SUM(Bill.fee), 0) AS total_fee
-- FROM 
--     Phone
--     LEFT OUTER JOIN Bill ON Phone.tel = Bill.tel
-- GROUP BY
--     Phone.tel
-- HAVING ISNULL(SUM(Bill.fee), 0) >= 1000
-- ORDER BY
--     total_fee ASC
-- for json path, INCLUDE_NULL_VALUES

-- CREATE view vw_電話清單 as
-- SELECT distinct tel
-- from Bill
-- UNION ALL
-- SELECT '4444'
-- UNION ALL
-- SELECT '4444'

-- SELECT * from vw_電話清單

-- INSERT INTO UserInfo VALUES('B01','David' ,null ,null)

-- INSERT INTO UserInfo (uid,cname)VALUES('B02','Betty')

-- insert into House (address) values ('花蓮市月眉路1號')

-- SELECT *
-- from UserInfo

-- UPDATE UserInfo set password 

-- SELECT GETDATE()
-- SELECT SYSDATETIME()
-- SELECT SYSDATETIMEOFFSET()

-- select *,FORMAT(year,dd,'yyyy年M月帳單')
-- FROM Bill

--錯誤的寫法
-- select *,FORMAT(DATEADD(year,-1911,dd),'yyyy年M月帳單')
-- FROM Bill

-- select quarter ,sum(sum_fee) as sum_fee
-- from(
-- select DATEPART(QUARTER,dd) as quarter ,sum(fee) as sum_fee
-- FROM Bill
-- where YEAR(dd) = 2019
-- GROUP BY DATEPART(QUARTER,dd)
-- union all select 1,0
-- union all select 2,0
-- union all select 3,0
-- union all select 4,0
-- ) as tmp
-- group by quarter
-- order by quarter

-- select DATETRUNC(YEAR,dd), sum(fee)
-- from Bill
-- GROUP BY DATETRUNC(YEAR,dd)

-- SELECT YEAR(dd), sum(fee)
-- FROM Bill
-- GROUP BY YEAR(dd)

-- SELECT DATEDIFF(SECOND, '1970/1/1', getutcdate())
-- SELECT DATEADD(SECOND, 1764554218, '1970/1/1')


-- DROP TRIGGER IF EXISTS insertUserInfo
-- GO
-- create TRIGGER insertUserInfo
-- ON UserInfo
-- AFTER INSERT
-- AS
-- BEGIN
--     INSERT into Log(body)
--     SELECT CONCAT(
--         '新增使用者,uid：',
--         uid,
--         '，姓名：',
--         ISNULL(cname,'跳過未輸入')
--     )
--     FROM inserted
-- END

-- INSERT INTO UserInfo (uid,cname) VALUES('X01','David')
-- SELECT* FROM UserInfo
-- SELECT* FROM Log
-- DELETE FROM UserInfo WHERE uid = 'X01'



-- DROP TRIGGER IF EXISTS updateUserInfo
-- GO
-- create TRIGGER updateUserInfoUserInfo
-- ON UserInfo
-- AFTER UPDATE
-- AS
-- BEGIN
--     DECLARE @old_uid NVARCHAR(20)
--     DECLARE @old_cname NVARCHAR(50)
--     DECLARE @new_uid NVARCHAR(20)
--     DECLARE @new_cname NVARCHAR(50)

--     SELECT @old_uid = uid,@old_cname = cname FROM deleted
--     SELECT @new_uid = uid,@new_cname = cname FROM inserted


--     INSERT into Log(body)
--     SELECT CONCAT(
--         '新增使用者,uid：',
--         uid,
--         '，姓名：',
--         ISNULL(cname,'跳過未輸入')
--     )
--     FROM inserted
-- END


-- DROP TRIGGER IF EXISTS updat_UserInfo
-- GO
-- CREATE TRIGGER updat_UserInfo
-- ON UserInfo
-- AFTER UPDATE
-- AS
-- BEGIN
--     IF UPDATE(password) and (select count(*) from inserted)>1
--     BEGIN
--         ROLLBACK
--         RAISERROR('不可一次修改兩筆以上密碼',16,1)
--     END
-- END


-- UPDATE UserInfo SET password = '1234' WHERE uid = 'A01'

-- SELECT * FROM UserInfo

-- disable trigger all on UserInfo

-- DECLARE @a INT
-- DECLARE @b INT

-- set @a = 5
-- set @b = 10

-- SELECT @a + @b as answer

-- DECLARE @n INT
-- DECLARE @uid NVARCHAR(20)
-- DECLARE @pwd NVARCHAR(64)
-- set @uid = 'A01'
-- set @pwd = '123
-- 4'

-- SELECT @n = COUNT(*) from UserInfo
-- WHERE uid = @uid AND password = @pwd
-- IF @n = 1
-- BEGIN
--     SELECT '登入成功' as result
-- END
-- ELSE
-- BEGIN
--     SELECT '登入失敗' as result
-- END


-- DECLARE @n INT = 1
-- WHILE @n <= 10
-- BEGIN
--     if @n =2
--    BEGIN
--         set @n = @n + 1
--         CONTINUE
--     END

--     if @n = 5 
--         BREAK
--     PRINT (@n)
--     set @n = @n + 1
-- end



-- DECLARE @n INT = 1
-- DECLARE @uid NVARCHAR(10)
-- DECLARE @cname NVARCHAR(10) ='王'
-- DECLARE @tmp NVARCHAR(10)

-- WHILE @n <= 1000
-- BEGIN
--     set @tmp = RIGHT(concat('000',@n),4)
--     set @uid = concat('Z',@tmp)
--     set @cname = concat('王',@tmp)
--     INSERT INTO UserInfo (uid,cname) VALUES(@uid,@cname)
--     set @n = @n + 1
-- end

-- SELECT * from UserInfo
-- WHERE uid LIKE 'Z%'



-- INSERT INTO UserInfo(uid) VALUES('B13')
-- print(@@ERROR)

-- begin TRY
--     INSERT INTO UserInfo(uid) VALUES('B13')
--     SELECT '註冊成功' as result
-- end TRY
-- begin CATCH
--     SELECT '帳號重複，請換一個帳號' as result
-- end CATCH

-- exec sumByQuarter @year = 2019

-- CREATE FUNCTION myadd(@a int, @b int) RETURNS INT
-- AS
-- BEGIN
--     DECLARE @ans INT
--     set @ans = @a + @b
--     RETURN @ans
-- END

-- SELECT dbo.myadd(5,3) as result


-- CREATE FUNCTION getSumByQuarter(@year int)
-- RETURNS TABLE
-- AS

-- RETURN select quarter , sum(sum_fee) as sum_fee
-- from(
--                                                                                                                 select DATEPART(QUARTER,dd) as quarter , sum(fee) as sum_fee
--         FROM Bill
--         where YEAR(dd) = @year
--         GROUP BY DATEPART(QUARTER,dd)
--     union all
--         select 1, 0
--     union all
--         select 2, 0
--     union all
--         select 3, 0
--     union all
--         select 4, 0
--     ) as tmp
-- group by quarter

-- SELECT * 
-- from getSumByQuarter(2019)
-- order by quarter

-- BEGIN
--     declare c cursor for SELECT uid,birthday 
--     from UserInfo 
--     where uid like 'A%' and password is null and birthday is not NULL for UPDATE
--     DECLARE @uid nvarchar(20)
--     DECLARE @birthday DATETIME2
--     DECLARE @password NVARCHAR(64)

--     OPEN c
--     fetch c into @uid, @birthday
--     WHILE @@FETCH_STATUS = 0
--     BEGIN
--         set @password = right(@uid, 2) + format(@birthday,'MMdd')
--         -- UPDATE UserInfo set password = @password where uid = @uid
--         UPDATE UserInfo set password where CURRENT
--         FETCH c into @uid, @birthday
--     END
--     close c
--     DEALLOCATE c
-- END

-- SELECT * FROM UserInfo



-- BEGIN TRAN
--     begin try
--        UPDATE UserInfo set password = '5678' where uid = 'A01'
--        INSERT into UserInfo (uid) VALUES ('D02')
--        SELECT 'success' as result
--        COMMIT
--     end TRY
--     begin catch
--        SELECT 'error' as result
--        ROLLBACK
--       -- ROLLBACK
--       -- COMMIT
--     END catch

-- SELECT * from UserInfo where uid = 'A01'

drop proc if exists buy1
GO
create proc buy1
AS
BEGIN
    DECLARE @quantity INT
    BEGIN TRAN
    UPDATE Product set quantity = quantity -1 where pid = 1
    select @quantity = quantity
    from Product
    where pid = 1
    WAITFOR delay '0:0:10'
    if @quantity < 0
    BEGIN
        SELECT '賣完了' as result
        ROLLBACK
    END
    ELSE
    BEGIN
        SELECT '賣出去一個' as result
        COMMIT
    END
END



drop proc if exists buy2
GO
create proc buy2
AS
BEGIN
    DECLARE @quantity INT
    BEGIN TRAN
        select @quantity = quantity
        from Product
        WITH(Xlock) where pid = 1
        WAITFOR delay '0:0:10'
    if @quantity > 0
    BEGIN
        SELECT '賣出去一個' as result
        UPDATE Product set quantity = quantity -1 where pid = 1
    END
    ELSE
    BEGIN
        SELECT '賣完了' as result
    END
    COMMIT
END