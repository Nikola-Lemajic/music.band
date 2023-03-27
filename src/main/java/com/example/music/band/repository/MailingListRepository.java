package com.example.music.band.repository;

import com.example.music.band.model.MailingList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MailingListRepository extends JpaRepository<MailingList, Long> {

}
