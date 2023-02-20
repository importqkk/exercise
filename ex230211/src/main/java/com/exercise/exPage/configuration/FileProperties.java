package com.exercise.exPage.configuration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "custom.fileupload")
public class FileProperties {

	private String path;
	
}
