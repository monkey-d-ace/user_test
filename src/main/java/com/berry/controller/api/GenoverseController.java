package com.berry.controller.api;

import com.berry.model.ClinGen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GenoverseController {
    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/api/genoverse/ClinGen")
    public List<ClinGen> clinGens(@RequestParam("start") int start, @RequestParam("end") int end, @RequestParam("chr") String chr) {
        return mongoTemplate.find(new Query(Criteria.where("chr").is("chr" + chr)).addCriteria(Criteria.where("start").lte(end)).addCriteria(Criteria.where("end").gte(start)), ClinGen.class);
    }
}
