package com.ax.HomeOfficeWorkFlow.dailylog.controllers;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ax.HomeOfficeWorkFlow.dailylog.dtos.NewDailyLogDTO;
import com.ax.HomeOfficeWorkFlow.dailylog.entities.DailyLog;
import com.ax.HomeOfficeWorkFlow.dailylog.services.DailyLogService;
import com.ax.HomeOfficeWorkFlow.employee.entities.Cpf;

@RestController
@RequestMapping("logs")
public class DailyLogController {
  @Autowired
  DailyLogService dailyLogService;

  @GetMapping()
  public ResponseEntity<Object> findAll() {
    try {
      return ResponseEntity.status(HttpStatus.FOUND).body(dailyLogService.findAll());
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Anyone log found");
    }
  }

  @GetMapping("{cpf}")
  public ResponseEntity<Object> findByCpf(@PathVariable(value = "cpf") Cpf cpf) {
    try {
      return ResponseEntity.status(HttpStatus.FOUND).body(dailyLogService.findByCpf(cpf));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Anyone log found with this cpf");
    }
  }

  @GetMapping("/findOne/{id}")
  public ResponseEntity<Object> findById(@PathVariable(value = "id") UUID id) {
    try {
      return ResponseEntity.status(HttpStatus.FOUND).body(dailyLogService.findById(id));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Log not found.");
    }
  }

  @PostMapping
  public ResponseEntity<Object> save(@RequestBody NewDailyLogDTO newDailyLogDTO) {
    try {
      DailyLog dailyLog = new DailyLog(newDailyLogDTO.cpf(), newDailyLogDTO.company());
      return ResponseEntity.status(HttpStatus.CREATED).body(dailyLogService.save(dailyLog));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Please check your request");
    }
  }

  @DeleteMapping("{id}")
  public ResponseEntity<Object> delete(@PathVariable(value = "id") UUID id) {
    try {
      Optional<DailyLog> selectedDailyLog = dailyLogService.findById(id);
      if(selectedDailyLog.isPresent()){
        DailyLog dailyLog = (DailyLog) dailyLogService.findByCpf(selectedDailyLog.get().getCpf()).stream()
                .filter(log -> log.getId().equals(id));
        dailyLogService.delete(dailyLog);
      }
      return ResponseEntity.status(HttpStatus.OK).body("Log deleted with success.");

    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cpf not found");
    }
  }
}
