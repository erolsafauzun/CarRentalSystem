package com.eroluzun.carrentalsystem.api;
import com.eroluzun.carrentalsystem.dto.OptionDto;
import com.eroluzun.carrentalsystem.service.impl.OptionServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/option")
public class OptionController {

    private final OptionServiceImpl optionServiceImpl;

    public OptionController(OptionServiceImpl optionServiceImpl){

        this.optionServiceImpl = optionServiceImpl;
    }

    @GetMapping("/{optionId}")
    public ResponseEntity<OptionDto> getByOptionId (@PathVariable(value = "optionId", required = true) Long optionId){

        OptionDto optionDto = optionServiceImpl.getByOptionId(optionId);
        return ResponseEntity.ok(optionDto);
    }

    @PostMapping
    public ResponseEntity<OptionDto> createOption (@Valid @RequestBody OptionDto option){

        return ResponseEntity.ok(optionServiceImpl.save(option));
    }

    @PutMapping("/{optionId}")
    public ResponseEntity<OptionDto> updateOption (@PathVariable(value = "optionId", required = true) Long optionId,
                                                   @Valid @RequestBody OptionDto option){

        return ResponseEntity.ok(optionServiceImpl.update(optionId, option));

    }

    @DeleteMapping("/{optionId}")
    public ResponseEntity<Boolean> delete (@PathVariable(value = "optionId", required = true) Long optionId){

        return ResponseEntity.ok(optionServiceImpl.delete(optionId));
    }
}
