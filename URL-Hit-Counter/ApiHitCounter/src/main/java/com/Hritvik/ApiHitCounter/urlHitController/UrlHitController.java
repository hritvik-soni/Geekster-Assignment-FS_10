package com.Hritvik.ApiHitCounter.urlHitController;


import com.Hritvik.ApiHitCounter.urlHitService.UrlHitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("api/v1/visitor-count-app")

public class UrlHitController {
    @Autowired
    UrlHitService urlHitService;

    @GetMapping("count")
    public int getUrlHitCount(){
        return urlHitService.countHitInc();
    }

    @GetMapping("username/{myUserName}/count")
    public String  getUrlHitCountWithUsername(@PathVariable String myUserName){

        Integer getUrlHitCounts = urlHitService.getHitCounts(myUserName);

        String str ="\u201CcountHit\u201C" +":"+ getUrlHitCounts;

        return "{\n \u201Cusername\u201C" +":"+"\u201C" + myUserName + "\u201C" + ", \n " + str +"\n}";


    }
}
