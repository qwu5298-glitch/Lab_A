CREATE PROC login
    @uid NVARCHAR(20),
    @pwd NVARCHAR(64)
AS
BEGIN

    DECLARE @n INT

    SELECT @n = COUNT(*)
    from UserInfo
    WHERE uid = @uid AND password = @pwd
    IF @n = 1
    BEGIN
        SELECT '登入成功' as result
    END
    ELSE
    BEGIN
        SELECT '登入失敗' as result
    END
END