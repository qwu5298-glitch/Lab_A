-- EXEC sp_EnrollCourse @StudentID='D001',@CourseID='18'
-- EXEC sp_GetAvailableCourses
EXEC sp_GetStudentEnrollments 'D001'
-- EXEC sp_UserLogin @StudentID='D001',@CourseID='18'
-- EXEC sp_WithdrawCourse @StudentID='D001',@CourseID='18'

course 選課明細表
Credits 學分數
