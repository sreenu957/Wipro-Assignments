package com.learning.service;

import java.util.List;

import com.learning.dto.NotificationRequest;
import com.learning.dto.NotificationResponse;

public interface NotificationService {
	
	NotificationResponse createNotification(NotificationRequest request);

    List<NotificationResponse> getNotificationsByUser(Long userId);

    NotificationResponse markAsRead(Long notificationId);

    void deleteNotification(Long notificationId);

    List<NotificationResponse> getAllNotifications();

}
