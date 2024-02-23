package org.example.exerci3_revision.service;

import org.springframework.stereotype.Service;

@Service
public class EmailService {

    public void sendEmailToFollowers(Long tvSerieId, String message) {
        System.out.println("Envoie email aux followers pour la série avec id " + tvSerieId + ": " + message);
    }
}
