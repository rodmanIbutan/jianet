package com.zyh.jianet.service.Impl;

import com.zyh.jianet.entity.Appointment;
import com.zyh.jianet.entity.Status;
import com.zyh.jianet.mapper.AppointmentMapper;
import com.zyh.jianet.service.AppointmentService;
import com.zyh.jianet.until.JwtUntil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    final static int MAX_APPOINTMENT = 9999;
    final AppointmentMapper appointmentMapper;

    public AppointmentServiceImpl(AppointmentMapper appointmentMapper) {
        this.appointmentMapper = appointmentMapper;
    }

    @Override
    public Status<List<Appointment>> getAppointmentsByUserId(String token) {
        String number = JwtUntil.parseJWT(token).get("number", String.class);
        return new Status<List<Appointment>>(true, "查询成功", appointmentMapper.selectAppointmentsByUserId(number));
    }

    @Override
    public Status<Appointment> getAppointmentById(Integer id, String token) {
        return new Status<Appointment>(true, "查询成功", appointmentMapper.selectAppointmentById(id));
    }

    @Override
    public Status<Integer> createAppointment(Appointment appointment, String Token) {
        // TODO: 2023/10/25 禁止重复预约
        int count = appointmentMapper.selectAppointmentCountByTime(appointment);
        if (count >= MAX_APPOINTMENT) {
            return new Status<>(false, "预约已满", null);
        }
        String number = JwtUntil.parseJWT(Token).get("number", String.class);
        appointment.setUserNumber(number);
        appointment.setStatus(0);
        return new Status<>(true, "预约成功", appointmentMapper.insertAppointment(appointment));
    }

    @Override
    public Status<Integer> deleteAppointment(Integer id, String token) {
        int res = appointmentMapper.deleteAppointment(id);
        if (res!=1){
            return new Status<>(false,"删除失败",null);
        }
        return new Status<>(true,"删除成功",null);
    }
}
