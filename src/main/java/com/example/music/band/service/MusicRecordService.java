package com.example.music.band.service;

import com.example.music.band.model.MusicRecord;

import java.util.Optional;

public interface MusicRecordService {

    Optional<MusicRecord> findOne(Long id);

    MusicRecord save(MusicRecord musicRecord);

}
