package com.doctordeng.ai.configuration;

import com.doctordeng.ai.service.MathService;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.function.FunctionToolCallback;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MCP Server 配置信息.
 *
 * @author denghuajie
 * @version 1.0.0
 * @date 2025/5/16 17:16
 */
@Configuration
public class McpServerAutoConfiguration {

	@Bean
	public ToolCallbackProvider mathTools(MathService mathService) {
		return MethodToolCallbackProvider.builder()
                .toolObjects(mathService)
                .build();
	}

	@Bean
	public ToolCallback toUpperCase() {
		return FunctionToolCallback.builder("toUpperCase", (TextInput input) -> input.input().toUpperCase())
			.inputType(TextInput.class)
			.description("Put the text to upper case")
			.build();
	}

    public record TextInput(String input) {
	}

}
