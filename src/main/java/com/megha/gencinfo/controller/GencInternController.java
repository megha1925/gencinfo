package com.megha.gencinfo.controller;

import com.megha.gencinfo.model.GencIntern;
import com.megha.gencinfo.model.GencInternDTO;
import com.megha.gencinfo.service.GencInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin
public class GencInternController {

    @Autowired
    private GencInfoServiceImpl gencInfoServiceImpl;

    //get all the List of Genc
    @GetMapping("/interns")
    public ResponseEntity<List<GencIntern>> getAllGencInternsInfo(){
        return new ResponseEntity<>(gencInfoServiceImpl.getAllInternsInfo() , HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addGencInterns(@RequestBody GencInternDTO gencIntern){
        return new ResponseEntity<>(gencInfoServiceImpl.addGencInternsInfo(gencIntern) , HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public  ResponseEntity<String> updateGencInterns(@RequestBody GencIntern gencIntern){
        return new ResponseEntity<>(gencInfoServiceImpl.updateGencInfo(gencIntern) , HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public String deleteIntern(@PathVariable("id") long id)
    {
        return gencInfoServiceImpl.deleteGencInfo(id);
    }
}
