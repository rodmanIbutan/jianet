package com.zyh.jianet.mapper;

import com.zyh.jianet.entity.Appointment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface AppointmentMapper {
    List<Appointment> selectAppointmentsByUserId(@Param("userNumber") String number);
    Appointment selectAppointmentById(@Param("id") Integer id);
    Integer insertAppointment(Appointment appointment);
    Integer updateAppointment(Appointment appointment);
    Integer deleteAppointment(@Param("id") Integer id);
    int selectAppointmentCountByTime(Appointment appointment);
}
