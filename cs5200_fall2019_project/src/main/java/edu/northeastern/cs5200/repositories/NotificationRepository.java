package edu.northeastern.cs5200.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.northeastern.cs5200.models.Notification;

public interface NotificationRepository extends CrudRepository<Notification, Integer>{

}