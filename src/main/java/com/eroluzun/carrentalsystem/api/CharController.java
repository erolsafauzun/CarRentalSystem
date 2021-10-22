package com.eroluzun.carrentalsystem.api;
import com.eroluzun.carrentalsystem.dto.GnlCharDto;
import com.eroluzun.carrentalsystem.service.impl.CharServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/gnlchar")
@Api(value = "Char APIs")
public class CharController {

    private final CharServiceImpl charServiceImpl;

    public CharController(CharServiceImpl charServiceImpl){

        this.charServiceImpl = charServiceImpl;
    }

    @GetMapping("/{gnlCharId}")
    @ApiOperation(value = "Get By Id Operation", response = GnlCharDto.class)
    public ResponseEntity<GnlCharDto> getByGnlCharId(@PathVariable(value = "gnlCharId",required = true) Long gnlCharId){

        GnlCharDto gnlCharDto = charServiceImpl.getByGnlCharId(gnlCharId);
        return ResponseEntity.ok(gnlCharDto);
    }

    @PostMapping
    @ApiOperation(value = "Create Operation", response = GnlCharDto.class)
    public ResponseEntity<GnlCharDto> createChar(@Valid @RequestBody GnlCharDto gnlChar){

        return ResponseEntity.ok(charServiceImpl.save(gnlChar));
    }

    @PutMapping("/{gnlCharId}")
    @ApiOperation(value = "Update Operation", response = GnlCharDto.class)
    public ResponseEntity<GnlCharDto> updateChar(@PathVariable(value = "gnlCharId",required = true) Long gnlCharId,
                                                 @Valid @RequestBody GnlCharDto gnlChar){

        return ResponseEntity.ok(charServiceImpl.update(gnlCharId, gnlChar));
    }


    @DeleteMapping("/{gnlCharId}")
    @ApiOperation(value = "Delete Operation", response = Boolean.class)
    public ResponseEntity<Boolean> delete (@PathVariable(value = "gnlCharId",required = true) Long gnlCharId){

        return ResponseEntity.ok(charServiceImpl.delete(gnlCharId));
    }

}
