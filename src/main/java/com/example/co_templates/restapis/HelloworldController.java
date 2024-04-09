package com.example.co_templates.restapis;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class HelloworldController {
    // /helloWorldResponseList/1/10/1
    @GetMapping("/helloWorldResponseList/{currentPage}/{perPage}/{SN}") //변수 3개, 
    public ResponseEntity<Object> helloWorldResponseList(@PathVariable String currentPage, @PathVariable String perPage, @PathVariable String SN) {
                                                        // 변수선언 -> uri에서 동일한것을 찾는다. GetMapping 변수와 매칭
        // "spm_row": 471, "SN": 1, "CMPNM": "로이유통", "RDNMADR": null
        // "spm_row": 571, "SN": 2, "CMPNM": "의료유통", "RDNMADR": 3
        ArrayList arrayList = new ArrayList<>();
        HashMap resultMap = new HashMap<>();

        resultMap.put("spm_row", 471);
        resultMap.put("SN", 1);
        resultMap.put("CMPNM", "로이유통");
        resultMap.put("RDNMADR", null);

        arrayList.add(resultMap);

        resultMap = new HashMap<>();
        resultMap.put("spm_row", 571);
        resultMap.put("SN", 2);
        resultMap.put("CMPNM", "의료유통");
        resultMap.put("RDNMADR", 3);

        arrayList.add(resultMap);

        return ResponseEntity.ok().body(arrayList); // 네트웍으로 return 한다. 네트웍 통신을 위한 최접점 class 
    }

    @GetMapping("/helloWorldResponseWithException/{companyId}")
    public ResponseEntity<Object> helloWorldResponseWithException(@PathVariable String companyId){
        try {
            int result = 5 / 0;
            return ResponseEntity.ok().body(null);    
        } catch (Exception e) {
            // TODO: handle exception
            String errorMessage = "Error : " + e.getMessage();
            return ResponseEntity.badRequest().body(errorMessage);
        }
        
    }
}
