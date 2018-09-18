package com.github.sejoung.configuration;

import org.mybatis.spring.batch.MyBatisBatchItemWriter;
import org.mybatis.spring.batch.MyBatisPagingItemReader;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.sejoung.Incrementer.CurrentTimeIncrementer;
import com.github.sejoung.listener.JobCompletionNotificationListener;
import com.github.sejoung.processor.ChunkTestItemProcessor;

/**
 * @author kim se joung
 *
 */
@Configuration
public class ChunkBatchConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean("mySqlBatchProcess")
    @StepScope
    public ChunkTestItemProcessor mySqlBatchProcess() {
        return new ChunkTestItemProcessor();
    }

    @Bean
    public Job importUserJob(JobCompletionNotificationListener listener, Step stepChunk1) {
        return jobBuilderFactory.get("testChunkJob").incrementer(new CurrentTimeIncrementer()).listener(listener).flow(stepChunk1).end().build();
    }

    @Bean
    public Step stepChunk1(@Qualifier("myBatisPagingItemReader") MyBatisPagingItemReader myBatisPagingItemReader, @Qualifier("mySqlBatchProcess") ChunkTestItemProcessor mySqlBatchProcess, @Qualifier("myBatisBatchItemWriter") MyBatisBatchItemWriter myBatisBatchItemWriter) {
        return stepBuilderFactory.get("stepChunk1").chunk(1).reader(myBatisPagingItemReader).processor(mySqlBatchProcess).writer(myBatisBatchItemWriter).build();
    }
}
