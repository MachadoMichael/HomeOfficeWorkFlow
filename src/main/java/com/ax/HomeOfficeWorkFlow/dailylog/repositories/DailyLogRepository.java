package com.ax.HomeOfficeWorkFlow.dailylog.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ax.HomeOfficeWorkFlow.dailylog.entities.DailyLog;
import com.ax.HomeOfficeWorkFlow.employee.entities.Cpf;

@Repository
public interface DailyLogRepository extends JpaRepository<DailyLog, UUID> {
  public List<DailyLog> findByCpf(Cpf cpf);
}
