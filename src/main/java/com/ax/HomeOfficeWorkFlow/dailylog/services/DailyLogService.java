package com.ax.HomeOfficeWorkFlow.dailylog.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.ax.HomeOfficeWorkFlow.dailylog.entities.DailyLog;
import com.ax.HomeOfficeWorkFlow.employee.entities.Cpf;

@Service
public interface DailyLogService {

  public List<DailyLog> findAll();

  public List<DailyLog> findByCpf(Cpf cpf);

  public Optional<DailyLog> findById(UUID id);

  public DailyLog save(DailyLog dailyLog);

  public void delete(DailyLog dailyLog);
}
