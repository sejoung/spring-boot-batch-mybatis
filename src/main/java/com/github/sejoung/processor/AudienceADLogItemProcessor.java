package com.github.sejoung.processor;

import org.springframework.batch.item.ItemProcessor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AudienceADLogItemProcessor implements ItemProcessor<String,String> {
    
    @Override
    public String process(String item) throws Exception {
        
        return "";
    }

}
