package org.example.repository;

import org.example.entity.MeetingRoomEntity;
import org.example.entity.ReservationEntity;
import org.example.entity.User;
import org.example.entity.UserEntity;
import org.example.port.UserRepository;
import org.example.utils.HibernateSession;
import org.hibernate.Session;

public class UserEntityRepositoryImpl implements UserRepository {
    private UserEntityRepository userEntityRepository;

    public UserEntityRepositoryImpl() {
        userEntityRepository = new UserEntityRepository();
    }

    @Override
    public boolean create(User user) {
        Session session = HibernateSession.getSessionFactory().openSession();
        userEntityRepository.setSession(session);
        session.beginTransaction();
        try {
            UserEntity userEntity = UserEntity.builder().usersEnum(user.getUsersEnum())
                            .lastName(user.getLastName())
                    .firstName(user.getFirstName())
            .build();
            session.getTransaction().commit();
            user.setId(userEntity.getIdUser());
            return true;

        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        }
    }
}
