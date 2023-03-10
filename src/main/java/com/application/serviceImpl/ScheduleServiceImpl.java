package com.application.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.exception.ResourceNotFoundException;
import com.application.model.Schedule;
import com.application.repository.ScheduleRepository;
import com.application.service.ScheduleService;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Autowired
    public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public Schedule createSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    @Override
    public Schedule getScheduleById(Long id) {
        return scheduleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Schedule not found with id " + id));
    }

    @Override
    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    @Override
    public List<Schedule> getSchedulesByDoctorId(Long doctorId) {
        return scheduleRepository.findByDoctorId(doctorId);
    }

    @Override
    public void deleteSchedule(Long id) {
        scheduleRepository.deleteById(id);
    }

	@Override
	public Schedule addSchedule(Schedule schedule) {
		// TODO Auto-generated method stub
		return null;
	}

	
		 @Override
		    public Schedule updateSchedule(Long scheduleId, Schedule updatedSchedule) {
		        Schedule existingSchedule = scheduleRepository.findById(scheduleId)
		                .orElseThrow(() -> new ResourceNotFoundException("Schedule not found with id " + scheduleId));

		        existingSchedule.setDoctor(updatedSchedule.getDoctor());
		        existingSchedule.setDayOfWeek(updatedSchedule.getDayOfWeek());
		        existingSchedule.setStartTime(updatedSchedule.getStartTime());
		        existingSchedule.setEndTime(updatedSchedule.getEndTime());

		        return scheduleRepository.save(existingSchedule);
		    }

		
	

	
}

