package com.eroluzun.carrentalsystem.api;
import com.eroluzun.carrentalsystem.dto.GnlCharValDto;
import com.eroluzun.carrentalsystem.service.impl.CharValServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/gnlcharval")
public class CharValController {

    private CharValServiceImpl charValServiceImpl;

    public CharValController(CharValServiceImpl charValServiceImpl){

        this.charValServiceImpl = charValServiceImpl;
    }

    @GetMapping("/{gnlCharValId}")
    public ResponseEntity<GnlCharValDto> getByGnlCharValId (@PathVariable(value = "gnlCharValId",required = true) Long gnlCharValId){

        GnlCharValDto gnlCharValDto = charValServiceImpl.getByGnlCharValId(gnlCharValId);
            return new ResponseEntity<>(gnlCharValDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GnlCharValDto> createGnlCharVal(@Valid @RequestBody GnlCharValDto gnlCharVal){

        return ResponseEntity.ok(charValServiceImpl.save(gnlCharVal));
    }

    @PutMapping("/{gnlCharValId}")
    public ResponseEntity<GnlCharValDto> updateGnlCharVal (@PathVariable(value = "gnlCharValId",required = true) Long gnlCharValId,
                                                           @Valid @RequestBody GnlCharValDto gnlCharVal){

        return ResponseEntity.ok(charValServiceImpl.update(gnlCharValId, gnlCharVal));
    }

    @DeleteMapping("/{gnlCharValId}")
    public  ResponseEntity<Boolean> delete (@PathVariable(value = "gnlCharValId",required = true) Long gnlCharValId){

        return ResponseEntity.ok(charValServiceImpl.delete(gnlCharValId));
    }

}
