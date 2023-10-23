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
        int id = JwtUntil.parseJWT(token).get("id", Integer.class);
        return new Status<List<Appointment>>(true, "查询成功", appointmentMapper.selectAppointmentsByUserId(id));
    }

    @Override
    public Status<Appointment> getAppointmentById(Integer id) {
        return new Status<Appointment>(true, "查询成功", appointmentMapper.selectAppointmentById(id));
    }

    @Override
    public Status<Integer> createAppointment(Appointment appointment, String Token) {
        int count = appointmentMapper.selectAppointmentCountByTime(appointment);
        if (count >= MAX_APPOINTMENT) {
            return new Status<>(false, "预约已满", null);
        }
        int id = JwtUntil.parseJWT(Token).get("id", Integer.class);
        appointment.setUserId(id);
        appointment.setStatus(0);
        return new Status<>(true, "预约成功", appointmentMapper.insertAppointment(appointment));
    }

}
