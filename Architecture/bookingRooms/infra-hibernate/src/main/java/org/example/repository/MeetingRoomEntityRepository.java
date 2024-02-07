package org.example.repository;

import java.util.List;

public class MeetingRoomEntityRepository extends BaseEntityRepository<MeetingRoomEntityRepository> {
    @Override
    MeetingRoomEntityRepository findById(Long id) {
        return session.get(MeetingRoomEntityRepository.class,id);
    }

    @Override
    List<MeetingRoomEntityRepository> findAll() {
        return session.createQuery("from MeetingRoomEntity ", MeetingRoomEntityRepository.class).list();
    }
}
