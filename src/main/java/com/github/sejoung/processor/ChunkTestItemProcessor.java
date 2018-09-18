package com.github.sejoung.processor;

import org.springframework.batch.item.ItemProcessor;

import com.github.sejoung.model.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ChunkTestItemProcessor implements ItemProcessor<Test,Test> {
    
    @Override
    public Test process(Test item) throws Exception {
        log.debug(item.toString());
        return item;
    }

}
