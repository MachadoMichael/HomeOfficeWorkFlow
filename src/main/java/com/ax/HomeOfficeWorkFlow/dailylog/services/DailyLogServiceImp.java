package com.ax.HomeOfficeWorkFlow.dailylog.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ax.HomeOfficeWorkFlow.dailylog.entities.DailyLog;
import com.ax.HomeOfficeWorkFlow.dailylog.repositories.DailyLogRepository;
import com.ax.HomeOfficeWorkFlow.employee.entities.Cpf;

@Repository
public class DailyLogServiceImp implements DailyLogService {
  @Autowired
  DailyLogRepository dailyLogRepository;

  public List<DailyLog> findAll() {
    return dailyLogRepository.findAll();
  }

  public List<DailyLog> findByCpf(Cpf cpf) {
    return dailyLogRepository.findByCpf(cpf);
  }

  public Optional<DailyLog> findById(UUID id) {
    return dailyLogRepository.findById(id);
  }

  public DailyLog save(DailyLog dailyLog) {
    return dailyLogRepository.save(dailyLog);
  }

  public void delete(DailyLog dailyLog) {
    dailyLogRepository.delete(dailyLog);
  }
}
