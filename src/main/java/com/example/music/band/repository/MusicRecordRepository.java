package com.example.music.band.repository;

import com.example.music.band.model.MusicRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicRecordRepository extends JpaRepository<MusicRecord, Long> {

}
