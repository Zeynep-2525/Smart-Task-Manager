package com.example.smarttaskmanager.scheduler;

import com.example.smarttaskmanager.model.Task;
import com.example.smarttaskmanager.repository.TaskRepository;
import com.example.smarttaskmanager.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReminderScheduler {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private EmailService emailService;

    @Scheduled(cron = "0 0 9 * * ?") // Her gün saat 9:00
    public void sendPriorityTaskReminders() {
        List<Task> priorityTasks = taskRepository.findByPriorityTrueAndCompletedFalse();
        for (Task task : priorityTasks) {
            String subject = " Görev Hatırlatma: " + task.getTitle();
            String body = "Tamamlanmamış öncelikli göreviniz var: " + task.getDescription();
            emailService.sendEmail("kullanici@mail.com", subject, body); // burayı kullanıcı emailiyle dinamik yapacağız ileride
        }
    }
}


