package com.example.smarttaskmanager.service;

import com.example.smarttaskmanager.model.Task;
import com.example.smarttaskmanager.repository.TaskRepository;
import com.example.smarttaskmanager.util.PDFHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReportService {

    @Autowired
    private TaskRepository taskRepository;

    public void createDailyReport() {
        LocalDate today = LocalDate.now();
        List<Task> completedTasks = taskRepository.findByCompletedDate(today);
        PDFHelper.generateDailyReport(completedTasks, today);
    }
}
