package com.eroluzun.carrentalsystem.api;
import com.eroluzun.carrentalsystem.dto.CustOrderDto;
import com.eroluzun.carrentalsystem.service.impl.CustOrderServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/custorder")
public class CustOrderController {

    private final CustOrderServiceImpl custOrderServiceImpl;

    public CustOrderController(CustOrderServiceImpl custOrderServiceImpl){

        this.custOrderServiceImpl = custOrderServiceImpl;
    }

    @GetMapping("/{custOrderId}")
    public ResponseEntity<CustOrderDto> getByCustOrderId(@PathVariable(value = "custOrderId",required = true) Long custOrderId){

        CustOrderDto custOrderDto = custOrderServiceImpl.getByCustOrderId(custOrderId);
        return ResponseEntity.ok(custOrderDto);
    }

    @PostMapping
    public ResponseEntity<CustOrderDto> createCustOrder(@Valid @RequestBody CustOrderDto custOrder){

        return ResponseEntity.ok(custOrderServiceImpl.save(custOrder));
    }

    @PutMapping("/{custOrderId}")
    public ResponseEntity<CustOrderDto> updateCustOrder (@PathVariable(value = "custOrderId",required = true) Long custOrderId,
                                                         @Valid @RequestBody CustOrderDto custOrder){

        return ResponseEntity.ok(custOrderServiceImpl.update(custOrderId,custOrder));

    }

    @DeleteMapping("/{custOrderId}")
    public ResponseEntity<Boolean> delete (@PathVariable(value = "custOrderId",required = true) Long custOrderId){

        return ResponseEntity.ok(custOrderServiceImpl.delete(custOrderId));
    }

}
