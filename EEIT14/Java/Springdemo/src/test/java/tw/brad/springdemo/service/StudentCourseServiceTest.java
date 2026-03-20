package tw.brad.springdemo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import tw.brad.springdemo.dto.CancelResponseDTO;
import tw.brad.springdemo.dto.PackageResponseDTO;
import tw.brad.springdemo.entity.Bookings;
import tw.brad.springdemo.entity.Courses;
import tw.brad.springdemo.entity.Orders;
import tw.brad.springdemo.entity.Users;
import tw.brad.springdemo.repo.BookingsRepo;
import tw.brad.springdemo.repo.CoursesRepo;
import tw.brad.springdemo.repo.OrdersRepo;
import tw.brad.springdemo.repo.UsersRepo;
import tw.brad.springdemo.repo.WalletLogsRepo;

@ExtendWith(MockitoExtension.class)
class StudentCourseServiceTest {

    @InjectMocks
    private StudentCourseService service;

    @Mock
    private WalletLogsRepo walletLogsRepo;

    @Mock
    private UsersRepo usersRepo;

    @Mock
    private OrdersRepo ordersRepo;

    @Mock
    private BookingsRepo bookingsRepo;

    @Mock
    private CoursesRepo coursesRepo;

    @Test
    void buyCourse_success_shouldUpdateWalletsAndCreateOrder() {
        Users student = new Users();
        student.setId(1L);
        student.setWallet(1_000L);

        Users tutor = new Users();
        tutor.setId(2L);
        tutor.setWallet(100L);

        Courses course = new Courses();
        course.setId(10L);
        course.setName("Math");
        course.setPrice(100);
        course.setIsActive((byte) 1);
        course.setTutor(tutor);

        when(usersRepo.findById(1L)).thenReturn(Optional.of(student));
        when(coursesRepo.findById(10L)).thenReturn(Optional.of(course));
        when(usersRepo.save(any())).thenAnswer(i -> i.getArgument(0));
        when(ordersRepo.save(any())).thenAnswer(i -> {
            Orders order = i.getArgument(0);
            order.setId(999L);
            return order;
        });
        when(walletLogsRepo.save(any())).thenAnswer(i -> i.getArgument(0));

        PackageResponseDTO result = service.Buycourse(1L, 10L, 2);

        assertThat(result).isNotNull();
        assertThat(result.orderId()).isEqualTo(999L);
        assertThat(result.courseName()).isEqualTo("Math");
        assertThat(result.totalLessons()).isEqualTo(2);
        assertThat(result.usedLessons()).isEqualTo(0);

        // Wallet changes
        assertThat(student.getWallet()).isEqualTo(800L);
        assertThat(tutor.getWallet()).isEqualTo(300L);

        verify(ordersRepo, times(1)).save(any());
        verify(walletLogsRepo, times(2)).save(any());
    }

    @Test
    void buyCourse_insufficientBalance_shouldThrow() {
        Users student = new Users();
        student.setId(1L);
        student.setWallet(100L);

        Courses course = new Courses();
        course.setId(10L);
        course.setPrice(100);
        course.setIsActive((byte) 1);
        course.setTutor(new Users());

        when(usersRepo.findById(1L)).thenReturn(Optional.of(student));
        when(coursesRepo.findById(10L)).thenReturn(Optional.of(course));

        assertThatThrownBy(() -> service.Buycourse(1L, 10L, 2))
            .isInstanceOf(RuntimeException.class)
            .hasMessageContaining("錢包餘額不足");
    }

    @Test
    void cancelBooking_futureBooking_shouldReturnSuccessAndDecrementUsedLesson() {
        Users student = new Users();
        student.setId(1L);

        Users tutor = new Users();
        tutor.setId(2L);

        Orders order = new Orders();
        order.setId(10L);
        order.setUser(student);
        order.setLessonCount(5);
        order.setLessonUsed(2);

        Bookings booking = new Bookings();
        booking.setId(100L);
        booking.setStudent(student);
        booking.setTutor(tutor);
        booking.setOrder(order);
        booking.setDate(LocalDate.now().plusDays(2));
        booking.setHour((byte) 10);
        booking.setStatus((byte) 1);

        when(bookingsRepo.findByIdAndStudent_Id(100L, 1L)).thenReturn(Optional.of(booking));
        when(bookingsRepo.save(any())).thenAnswer(i -> i.getArgument(0));
        when(ordersRepo.save(any())).thenAnswer(i -> i.getArgument(0));

        CancelResponseDTO response = service.cancelBooking(100L, 1L);

        assertThat(response.success()).isTrue();
        assertThat(response.message()).contains("取消成功");
        assertThat(order.getLessonUsed()).isEqualTo(1);
        verify(bookingsRepo, times(1)).save(any());
        verify(ordersRepo, times(1)).save(any());
    }

    @Test
    void cancelBooking_notScheduled_shouldReturnFailureMessage() {
        Users student = new Users();
        student.setId(1L);

        Orders order = new Orders();
        order.setId(10L);
        order.setUser(student);
        order.setLessonCount(5);
        order.setLessonUsed(1);

        Bookings booking = new Bookings();
        booking.setId(100L);
        booking.setStudent(student);
        booking.setOrder(order);
        booking.setDate(LocalDate.now().plusDays(2));
        booking.setHour((byte) 10);
        booking.setStatus((byte) 2); // already completed

        when(bookingsRepo.findByIdAndStudent_Id(100L, 1L)).thenReturn(Optional.of(booking));

        CancelResponseDTO response = service.cancelBooking(100L, 1L);

        assertThat(response.success()).isFalse();
        assertThat(response.message()).contains("僅排程中的課程可申請取消");
    }
}
