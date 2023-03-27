package com.example.music.band.service.impl;

import com.example.music.band.model.MusicRecord;
import com.example.music.band.repository.MusicRecordRepository;
import com.example.music.band.service.MusicRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JpaMusicRecordService implements MusicRecordService {

    private final MusicRecordRepository musicRecordRepository;

    @Autowired
    public JpaMusicRecordService (MusicRecordRepository musicRecordRepository){
        this.musicRecordRepository = musicRecordRepository;
    }

    @Override
    public Optional<MusicRecord> findOne(Long id) {
        return musicRecordRepository.findById(id);
    }

    @Override
    public MusicRecord save(MusicRecord musicRecord) {
        return musicRecordRepository.save(musicRecord);
    }
}
