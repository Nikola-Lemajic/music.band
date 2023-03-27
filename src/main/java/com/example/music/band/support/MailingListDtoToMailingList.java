package com.example.music.band.support;

import com.example.music.band.dto.MailingListDto;
import com.example.music.band.model.MailingList;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class MailingListDtoToMailingList implements Converter<MailingListDto, MailingList> {

    @Override
    public MailingList convert(MailingListDto mailingListDto) {

        MailingList mailingList = new MailingList();

        mailingList.setName(mailingListDto.getName());
        mailingList.setCountry(mailingListDto.getCountry());
        mailingList.setEmail(mailingListDto.getEmail());

        return mailingList;

    }
}
