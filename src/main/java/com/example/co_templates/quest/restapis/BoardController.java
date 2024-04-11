package com.example.co_templates.quest.restapis;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.co_templates.quest.services.BoardService;

public class BoardController {

    @Autowired
    BoardService boardService;

    @GetMapping("/q/r/board/mixed/{pageNumber}/{pk_id}")
    public ResponseEntity<HashMap<String, Object>> mixed(@PathVariable Integer pageNumber, @PathVariable Integer pkId) {
        HashMap<String,Object> resultMap = new HashMap<>();
        resultMap = boardService.mixed(pageNumber, pkId);

        HashMap<String,Object> requestParams = new HashMap<>();
        requestParams.put("pageNumber", pageNumber);
        requestParams.put("pk_id",pkId);
        resultMap.put("requestParams",requestParams);
        return ResponseEntity.ok().body(resultMap);
    }


    @GetMapping("/q/r/board/list/{pageNumber}")
    public ResponseEntity<List<HashMap<String, Object>>> list(@PathVariable Integer pageNumber) {
        List<HashMap<String, Object>> itemList = boardService.list(pageNumber);
        return ResponseEntity.ok().body(itemList);
    }

    @GetMapping("/q/r/board/view/{pk_id}")
    public ResponseEntity<HashMap<String, Object>> view(@PathVariable("pk_id") Integer pkId) {
        HashMap<String, Object> itemDetails = boardService.view(pkId);
        return ResponseEntity.ok().body(itemDetails);
    }

    @DeleteMapping("/q/r/board/delete/{pk_id}")
    public ResponseEntity<Integer> delete(@PathVariable("pk_id") Integer pkId) {
        int result = boardService.delete(pkId);
        return ResponseEntity.ok().body(result);
    }

    @PostMapping("/q/r/board/insert/{title}/{contents}")
    public ResponseEntity<Integer> insert(@PathVariable("title") String title, @PathVariable("contents") String contents) {
        int result = boardService.insert(title, contents);
        return ResponseEntity.ok().body(result);
    }
}
