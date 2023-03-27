package com.example.music.band.support;

import com.example.music.band.dto.MusicRecordDto;
import com.example.music.band.model.MusicRecord;
import com.example.music.band.service.MusicRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class MusicRecordDtoToMusicRecord implements Converter<MusicRecordDto, MusicRecord> {

    @Override
    public MusicRecord convert(MusicRecordDto musicRecordDto) {

        MusicRecord musicRecord = new MusicRecord();

        musicRecord.setName(musicRecordDto.getName());
        musicRecord.setArtist(musicRecordDto.getArtist());
        musicRecord.setReleaseYear(musicRecordDto.getReleaseYear());
        musicRecord.setRecordLabel(musicRecordDto.getRecordLabel());

        return musicRecord;
    }
}
