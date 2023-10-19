package com.zyh.jianet.service;

import com.zyh.jianet.entity.Appointment;
import com.zyh.jianet.entity.Status;

import java.util.List;

public interface AppointmentService {
    Status<List<Appointment>> getAppointmentsByUserId(String Token);
    Status<Appointment> getAppointmentById(Integer id);
    Status<Integer> createAppointment(Appointment appointment,String Token);
}
