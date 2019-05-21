package com.arbs.jobs.sample;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.batch.MyBatisBatchItemWriter;
import org.mybatis.spring.batch.MyBatisPagingItemReader;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class SampleStep {
	private static final String STEP_NAME = "sampleStep2";
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Step step() {
		return stepBuilderFactory.get(STEP_NAME)
							.<String, String> chunk(1)
							.reader(sampleItemReader())
							.processor(sampleItemProcessor())
							.writer(sampleItemWriter())
							.build();
	}
	
	@Bean
	public ItemReader<String> sampleItemReader() {
		log.info("=====> itemReader");
		MyBatisPagingItemReader<String> reader = new MyBatisPagingItemReader<String>();
		reader.setSqlSessionFactory(sqlSessionFactory);
		reader.setQueryId("com.arbs.monitoring.main.mapper.MonitoringListMapper.testQuery");
		return reader;	
	}
	
	@Bean
	public ItemProcessor<String, String> sampleItemProcessor() {
		log.info("=====> ItemProcessor");
		return null;
	}
	
	@Bean
	public ItemWriter<String> sampleItemWriter() {
		log.info("======> ItemWriter");
		MyBatisBatchItemWriter<String> writer = new MyBatisBatchItemWriter<String>();
        writer.setSqlSessionFactory(sqlSessionFactory);
        writer.setStatementId("com.arbs.monitoring.main.mapper.MonitoringListMapper.testInsert");
        return writer;
	}
}
