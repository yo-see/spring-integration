package com.arbs.jobs.sample;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableBatchProcessing
	public class SampleJob extends DefaultBatchConfigurer {
	
	private static final String JOB_NAME = "sampleJob2";
	
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	private Step step;
			
	@Bean
	public Job job() {
		log.info("====> Start sampleJob");
		return jobBuilderFactory.get(JOB_NAME)
							.start(step)
							.build();
	}
	
	
}
