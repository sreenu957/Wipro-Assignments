package com.learning.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.learning.dto.NotificationRequest;
import com.learning.dto.NotificationResponse;
import com.learning.exception.ResourceNotFoundException;
import com.learning.model.Notification;
import com.learning.repository.NotificationRepository;
import com.learning.service.NotificationService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService{
	
	private final NotificationRepository repository;
    private final ModelMapper mapper;

    @Override
    public NotificationResponse createNotification(NotificationRequest request) {
        Notification notification = Notification.builder()
                .userId(request.getUserId())
                .title(request.getTitle())
                .message(request.getMessage())
                .read(false)
                .build();

        return mapper.map(repository.save(notification), NotificationResponse.class);
    }

    @Override
    public List<NotificationResponse> getNotificationsByUser(Long userId) {
        return repository.findByUserId(userId)
                .stream()
                .map(n -> mapper.map(n, NotificationResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public NotificationResponse markAsRead(Long notificationId) {
        Notification notification = repository.findById(notificationId)
                .orElseThrow(() -> new ResourceNotFoundException("Notification not found"));
        notification.setRead(true);
        return mapper.map(repository.save(notification), NotificationResponse.class);
    }

    @Override
    public void deleteNotification(Long notificationId) {
        if (!repository.existsById(notificationId)) {
            throw new ResourceNotFoundException("Notification not found");
        }
        repository.deleteById(notificationId);
    }

    @Override
    public List<NotificationResponse> getAllNotifications() {
        return repository.findAll()
                .stream()
                .map(n -> mapper.map(n, NotificationResponse.class))
                .collect(Collectors.toList());
    }

}
