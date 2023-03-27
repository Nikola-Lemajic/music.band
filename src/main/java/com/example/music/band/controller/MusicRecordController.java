package com.example.music.band.controller;

import com.example.music.band.dto.MusicRecordDto;
import com.example.music.band.model.MusicRecord;
import com.example.music.band.service.MusicRecordService;
import com.example.music.band.support.MusicRecordDtoToMusicRecord;
import com.example.music.band.support.MusicRecordToMusicRecordDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/record", produces = MediaType.APPLICATION_JSON_VALUE)
public class MusicRecordController {

    private final MusicRecordService musicRecordService;

    private final MusicRecordToMusicRecordDto toMusicRecordDto;

    private final MusicRecordDtoToMusicRecord toMusicRecord;

    @Autowired
    public MusicRecordController(
            MusicRecordService musicRecordService,
            MusicRecordToMusicRecordDto toMusicRecordDto,
            MusicRecordDtoToMusicRecord toMusicRecord
    ){
        this.musicRecordService = musicRecordService;
        this.toMusicRecordDto = toMusicRecordDto;
        this.toMusicRecord = toMusicRecord;
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<MusicRecordDto> getOne(@PathVariable Long id) {

        return musicRecordService.findOne(id)
                .map(musicRecord -> new ResponseEntity<>(toMusicRecordDto.convert(musicRecord), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MusicRecordDto> create(@RequestBody MusicRecordDto musicRecordDto) {

        if (musicRecordDto.getId() != null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        MusicRecord musicRecord = toMusicRecord.convert(musicRecordDto);
        MusicRecord savedMusicRecord = musicRecordService.save(musicRecord);

        return new ResponseEntity<>(toMusicRecordDto.convert(savedMusicRecord), HttpStatus.OK);

    }
}
