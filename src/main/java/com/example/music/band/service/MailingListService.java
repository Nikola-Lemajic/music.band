package com.example.music.band.service;

import com.example.music.band.dto.MailingListDto;
import com.example.music.band.model.Event;
import com.example.music.band.model.MailingList;

import java.util.List;
import java.util.Optional;

public interface MailingListService {

    Optional<MailingList> findOne(Long id);

    MailingList save(MailingList mailingList);

    MailingList update(MailingListDto mailingListDto);

    void delete(Long id);

    boolean existsById(Long id);

}
