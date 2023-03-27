package com.example.music.band.support;


import com.example.music.band.dto.MusicRecordDto;
import com.example.music.band.model.MusicRecord;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class MusicRecordToMusicRecordDto implements Converter<MusicRecord, MusicRecordDto> {

    @Override
    public MusicRecordDto convert(MusicRecord musicRecord) {

        MusicRecordDto musicRecordDto = new MusicRecordDto();

        musicRecordDto.setId(musicRecord.getId());
        musicRecordDto.setName(musicRecord.getName());
        musicRecordDto.setReleaseYear(musicRecord.getReleaseYear());
        musicRecordDto.setArtist(musicRecord.getArtist());
        musicRecordDto.setRecordLabel(musicRecord.getRecordLabel());

        return musicRecordDto;

    }
}
