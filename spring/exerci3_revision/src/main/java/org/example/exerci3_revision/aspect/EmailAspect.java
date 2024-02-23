package org.example.exerci3_revision.aspect;


import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.example.exerci3_revision.entity.Season;
import org.example.exerci3_revision.entity.TVSerie;
import org.example.exerci3_revision.service.EmailService;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class EmailAspect {

    private final EmailService emailService;

    public EmailAspect(EmailService emailService) {
        this.emailService = emailService;
    }

    @Pointcut("execution(* org.example.exerci3_revision.service.TVSerieService.addSeason(..)) && args(tvSerieId, season)")
    public void seasonAdded(Long tvSerieId, Season season) {}

    @AfterReturning(pointcut = "seasonAdded(tvSerieId, season)", returning = "tvSerie")
    public void notifyFollowers(Long tvSerieId, Season season, TVSerie tvSerie) {
        String message = "Une nouvelle saison a été ajoutée à la série TV : " + tvSerie.getName();
        emailService.sendEmailToFollowers(tvSerieId, message);
    }

}
