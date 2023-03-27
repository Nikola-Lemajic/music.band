package com.example.music.band.support;

import com.example.music.band.dto.MailingListDto;
import com.example.music.band.model.MailingList;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class MailingListToMailingListDto implements Converter<MailingList, MailingListDto> {

    @Override
    public MailingListDto convert(MailingList mailingList) {

        MailingListDto mailingListDto = new MailingListDto();

        mailingListDto.setId(mailingList.getId());
        mailingListDto.setName(mailingList.getName());
        mailingListDto.setCountry(mailingList.getCountry());
        mailingListDto.setEmail(mailingList.getEmail());

        return mailingListDto;
    }
}
