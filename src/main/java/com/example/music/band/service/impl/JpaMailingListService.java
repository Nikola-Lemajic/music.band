package com.example.music.band.service.impl;

import com.example.music.band.dto.MailingListDto;
import com.example.music.band.model.MailingList;
import com.example.music.band.repository.MailingListRepository;
import com.example.music.band.service.MailingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JpaMailingListService implements MailingListService {

    private final MailingListRepository mailingListRepository;

    @Autowired
    public JpaMailingListService (MailingListRepository mailingListRepository){
        this.mailingListRepository = mailingListRepository;
    }

    @Override
    public Optional<MailingList> findOne(Long id) {
        return mailingListRepository.findById(id);
    }

    @Override
    public MailingList save(MailingList mailingList) {
        return mailingListRepository.save(mailingList);
    }

    @Override
    public MailingList update(MailingListDto mailingListDto) {

        return mailingListRepository.findById(mailingListDto.getId())
                .map(mailingList -> {
                    mailingList.setName(mailingListDto.getName());
                    mailingList.setCountry(mailingListDto.getCountry());
                    mailingList.setEmail(mailingListDto.getEmail());
                    return mailingListRepository.save(mailingList);
                }).orElseThrow();
    }

    @Override
    public void delete(Long id) {
         mailingListRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id){
        return mailingListRepository.existsById(id);
    }

}
