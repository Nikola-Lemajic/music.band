package com.example.music.band.model;

import jakarta.persistence.*;

import java.time.Year;
import java.util.Objects;

@Entity
public class MusicRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Year releaseYear;

    @Column(nullable = false)
    private String artist;

    @Column(nullable = false)
    private String recordLabel;

    public MusicRecord() {
    }

    public MusicRecord(Long id, String name, Year year, String artist, String recordLabel) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MusicRecord)) return false;
        MusicRecord that = (MusicRecord) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(releaseYear, that.releaseYear) &&
                Objects.equals(artist, that.artist) &&
                Objects.equals(recordLabel, that.recordLabel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, releaseYear, artist, recordLabel);
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + releaseYear +
                ", artist='" + artist + '\'' +
                ", recordLabel='" + recordLabel + '\'' +
                '}';
    }
}
