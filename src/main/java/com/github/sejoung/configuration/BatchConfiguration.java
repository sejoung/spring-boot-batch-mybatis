package com.github.sejoung.configuration;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.sejoung.Incrementer.CurrentTimeIncrementer;
import com.github.sejoung.dao.ADao;
import com.github.sejoung.dao.BDao;
import com.github.sejoung.listener.ChunkExecutionListener;
import com.github.sejoung.listener.JobCompletionNotificationListener;
import com.github.sejoung.listener.StepExecutionNotificationListener;

import lombok.extern.slf4j.Slf4j;

/**
 * @author kim se joung
 *
 */
@Slf4j
@Configuration
public class BatchConfiguration extends DefaultBatchConfigurer {
/*

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    public ADao aDao;

    @Autowired
    public BDao bDao;
*/

    /* (non-Javadoc)
     * @see org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer#setDataSource(javax.sql.DataSource)
     * 
     * 스프링 배치에서 배치 정보를 저장하는 DB를 사용하지 않을려고 데이터 소스를 set 하는 부분을 주석 처리함
     * 
     */
    @Override
    public void setDataSource(DataSource dataSource) {
    }

    @Bean
    public StepExecutionNotificationListener stepExecutionListener() {
        return new StepExecutionNotificationListener();
    }

    @Bean
    public ChunkExecutionListener chunkListener() {
        return new ChunkExecutionListener();
    }

    @Bean
    public JobCompletionNotificationListener jobExecutionListener() {
        return new JobCompletionNotificationListener();
    }
    /*
    @Bean
    public Job importUserJob(JobCompletionNotificationListener listener, Step step1, Step step2) {
        return jobBuilderFactory.get("testJob").incrementer(new CurrentTimeIncrementer()).listener(listener).flow(step1).next(step2).end().build();
    }
    
    @Bean
    public Step step1(Tasklet tasklet1) {
        return stepBuilderFactory.get("step1").tasklet(tasklet1).build();
    }
    
    @Bean
    public Step step2(Tasklet tasklet2) {
        return stepBuilderFactory.get("step2").tasklet(tasklet2).build();
    }
    
   
    @Bean
    public Tasklet tasklet1() {
        return (contribution, chunkContext)->{
            Map<String, String> data = new HashMap<String, String>();
            aDao.selectTest(data).forEach((test)->{
                log.debug("adb "+test.toString());
            });
            
            return RepeatStatus.FINISHED;
        };
    }
    
    
    @Bean
    public Tasklet tasklet2() {
        return (contribution, chunkContext)->{
            Map<String, String> data = new HashMap<String, String>();
            bDao.selectTest(data).forEach((test)->{
                log.debug("bdb "+test.toString());
            });
            
            return RepeatStatus.FINISHED;
        };
    }
    */
}
