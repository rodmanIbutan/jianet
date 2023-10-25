package com.zyh.jianet.contorller;

import com.zyh.jianet.entity.Appointment;
import com.zyh.jianet.entity.Status;
import com.zyh.jianet.service.AppointmentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "appointment")
public class AppointmentController {
    final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }
    @PostMapping(value = "/create")
    @ResponseBody
    public Status<Integer> createAppointment(@RequestBody Appointment appointment,@RequestHeader("token") String Token) {
        return appointmentService.createAppointment(appointment,Token);
    }
    @GetMapping(value = "/getByUserId")
    @ResponseBody
    public Status<List<Appointment>> getAppointmentsByUserId(@RequestHeader("token") String token) {
        return appointmentService.getAppointmentsByUserId(token);
    }
    @GetMapping(value = "/getById")
    @ResponseBody
    public Status<Appointment> getAppointmentById(@RequestParam Integer id,@RequestHeader("token") String token) {
        return appointmentService.getAppointmentById(id,token);
    }
    @GetMapping(value = "/delete")
    @ResponseBody
    public Status<Integer> deleteAppointment(@RequestParam Integer id,@RequestHeader("token") String token) {
        return appointmentService.deleteAppointment(id,token);
    }
}
