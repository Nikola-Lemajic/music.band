package com.example.music.band.controller;

import com.example.music.band.dto.MailingListDto;
import com.example.music.band.model.MailingList;
import com.example.music.band.service.MailingListService;
import com.example.music.band.support.MailingListDtoToMailingList;
import com.example.music.band.support.MailingListToMailingListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/api/mailingList", produces = MediaType.APPLICATION_JSON_VALUE)
public class MailingListController {

    private final MailingListService mailingListService;

    private final MailingListToMailingListDto toMailingListDto;

    private final MailingListDtoToMailingList toMailingList;

    @Autowired
    public MailingListController(
            MailingListService mailingListService,
            MailingListToMailingListDto toMailingListDto,
            MailingListDtoToMailingList toMailingList
    ) {
        this.mailingListService = mailingListService;
        this.toMailingListDto = toMailingListDto;
        this.toMailingList = toMailingList;
    }


    @GetMapping("/getOne/{id}")
    public ResponseEntity<MailingListDto> getOne(@PathVariable Long id) {

        return mailingListService.findOne(id)
                .map(mailingList -> new ResponseEntity<>(toMailingListDto.convert(mailingList), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MailingListDto> create(@RequestBody MailingListDto mailingListDto) {

        if (mailingListDto.getId() != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        MailingList mailingList = toMailingList.convert(mailingListDto);
        MailingList savedMailingList = mailingListService.save(mailingList);

        return new ResponseEntity<>(toMailingListDto.convert(savedMailingList), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MailingListDto> update(@PathVariable Long id, @RequestBody MailingListDto mailingListDto) {

        if (!id.equals(mailingListDto.getId()) || !mailingListService.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            MailingList mailingList = mailingListService.update(mailingListDto);
            return new ResponseEntity<>(toMailingListDto.convert(mailingList), HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        if (!mailingListService.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        mailingListService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
