package com.pass.passbatch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@EnableBatchProcessing
@SpringBootApplication
public class PassBatchApplication {

	@Autowired
	private final JobBuilderFactory jobBuilderFactory;  // job을 만들 수 있는 빌더(job을 만들고 step 만들기)

	@Autowired
	private final StepBuilderFactory stepBuilderFactory; // step을 만들 수 있는 빌더

	public PassBatchApplication(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
		this.jobBuilderFactory = jobBuilderFactory;
		this.stepBuilderFactory = stepBuilderFactory;
	}

	@Bean  // 빌더가 준비되어 있으니 이제부터 step 선언 가능 : tasklet 으로 간단히 구성
	public Step passStep() {
		return this.stepBuilderFactory.get("passStep")
				// tasklet의 구현체를 사용하면 내부에 간단한 내용만 채우면 사용 가능
				.tasklet(new Tasklet() {
					@Override
					public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
						System.out.println("Execute PassStep");
						return RepeatStatus.FINISHED;  // 종료시에 대한 표현
					}
				}).build();
	}

	@Bean
	public Job passJob() {
		return this.jobBuilderFactory.get("passJob")
				.start(passStep())
				.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(PassBatchApplication.class, args);
	}

}
