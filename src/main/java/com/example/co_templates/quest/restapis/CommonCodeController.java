package com.example.co_templates.quest.restapis;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class CommonCodeController {

    @GetMapping("/commonCode/list/{num}")
    public ResponseEntity<Object> commonCodeList(@PathVariable String num){

        ArrayList arrayList = new ArrayList<>();
        HashMap resultMap = new HashMap<>();

        resultMap.put("PK_ID",1);
        resultMap.put("FK_ID",1);
        resultMap.put("NAME","hongglidong");

        arrayList.add(resultMap);

        return ResponseEntity.ok().body(arrayList);
    }

    @GetMapping("/commonCode/view/{pk_id}/{fk_id}/{name}")
    public ResponseEntity<Object> commonCodeView(@PathVariable String pk_id, @PathVariable String fk_id, @PathVariable String name){

        HashMap resultMap = new HashMap<>();

        resultMap.put("PK_ID",1);
        resultMap.put("FK_ID",1);
        resultMap.put("NAME","hongglidong");

        return ResponseEntity.ok().body(resultMap);
    }

    
}
