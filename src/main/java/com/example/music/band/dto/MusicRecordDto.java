package com.example.music.band.dto;

import jakarta.validation.constraints.NotNull;

import java.time.Year;

public class MusicRecordDto {

    private Long id;

    @NotNull
    private String name;

    @NotNull
    private Year releaseYear;

    @NotNull
    private String artist;

    @NotNull
    private String recordLabel;

    public MusicRecordDto() {
    }

    public MusicRecordDto(Long id, String name, Year year, String artist, String recordLabel) {
        this.id = id;
        this.name = name;
        this.releaseYear = year;
        this.artist = artist;
        this.recordLabel = recordLabel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Year getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Year releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getRecordLabel() {
        return recordLabel;
    }

    public void setRecordLabel(String recordLabel) {
        this.recordLabel = recordLabel;
    }
}
