package com.example.smarttaskmanager.scheduler;

import com.example.smarttaskmanager.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ReportScheduler {

    @Autowired
    private ReportService reportService;

    // Her akşam saat 20:00'de çalışır
    @Scheduled(cron = "0 0 20 * * ?")
    public void generateDailyReport() {
        reportService.createDailyReport();
    }
}
