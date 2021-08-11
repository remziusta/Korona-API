package com.covid.dataprocessing;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.covid.model.CovidDaily;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

	private final String[] FIELD_NAMES = new String[] { "ID", "DATE", "PNEUMONIA_RATE", "TOTAL_CASE",
			"TOTAL_CASE_IN_TODAY", "TOTAL_DEAD", "TOTAL_DEAD_IN_TODAY", "TOTAL_ILL_IN_TODAY",
			"TOTAL_PATIENT_RECOVERING", "TOTAL_RECOVERING_IN_TODAY", "TOTAL_SERIOUSLY_ILL", "TOTAL_TEST",
			"TOTAL_TEST_IN_TODAY"

	};

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Bean
	public DataProcessor processor() {
		return new DataProcessor();
	}

	@Bean
	public FlatFileItemReader<DailyInput> reader() {
		return new FlatFileItemReaderBuilder<DailyInput>().name("personItemReader")
				.resource(new ClassPathResource("Korona.csv")).delimited().names(FIELD_NAMES)
				.fieldSetMapper(new BeanWrapperFieldSetMapper<DailyInput>() {
					{
						setTargetType(DailyInput.class);
					}
				}).build();
	}

	@Bean
	public JdbcBatchItemWriter<CovidDaily> writer(DataSource dataSource) {
		return new JdbcBatchItemWriterBuilder<CovidDaily>()
				.itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
				.sql("INSERT INTO covid_daily (ID,DATE,PNEUMONIA_RATE,TOTAL_CASE,TOTAL_CASE_IN_TODAY,TOTAL_DEAD,TOTAL_DEAD_IN_TODAY,TOTAL_ILL_IN_TODAY,TOTAL_PATIENT_RECOVERING,TOTAL_RECOVERING_IN_TODAY,TOTAL_SERIOUSLY_ILL,TOTAL_TEST,TOTAL_TEST_IN_TODAY)"
						+ " VALUES(:ID,:DATE,:PNEUMONIA_RATE,:TOTAL_CASE,:TOTAL_CASE_IN_TODAY,:TOTAL_DEAD,:TOTAL_DEAD_IN_TODAY,:TOTAL_ILL_IN_TODAY,:TOTAL_PATIENT_RECOVERING,:TOTAL_RECOVERING_IN_TODAY,:TOTAL_SERIOUSLY_ILL,:TOTAL_TEST,:TOTAL_TEST_IN_TODAY)")
				.dataSource(dataSource).build();
	}

	@Bean
	public Job importUserJob(JobCompletionNotificationListener listener, Step step1) {
		return jobBuilderFactory.get("importUserJob")
				.incrementer(new RunIdIncrementer())
				.listener(listener)
				.flow(step1)
				.end()
				.build();
	}

	@Bean
	public Step step1(JdbcBatchItemWriter<CovidDaily> writer) {
		return stepBuilderFactory.get("step1").
				<DailyInput, CovidDaily>chunk(10)
				.reader(reader())
				.processor(processor())
				.writer(writer)
				.build();
	}
}
