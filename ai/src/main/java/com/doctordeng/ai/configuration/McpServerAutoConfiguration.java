package com.doctordeng.ai.configuration;

import com.doctordeng.ai.service.ApplicationService;
import com.doctordeng.ai.service.MathService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.modelcontextprotocol.server.McpServerFeatures;
import io.modelcontextprotocol.spec.McpSchema;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.function.FunctionToolCallback;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.MimeTypeUtils;

import java.util.Collections;
import java.util.List;

/**
 * MCP Server 配置信息.
 *
 * @author denghuajie
 * @version 1.0.0
 * @date 2025/5/16 17:16
 */
@Configuration
@Slf4j
public class McpServerAutoConfiguration {

    @Resource
    private ApplicationService applicationService;

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
			.description("将文本英文字母全部变为大写")
			.build();
	}

    @Bean
    public List<McpServerFeatures.SyncResourceSpecification> mcpSyncResources() {
        var systemInfoResource = new McpSchema.Resource("http://127.0.0.1:8080", "systemInfo", "获取系统信息", MimeTypeUtils.APPLICATION_JSON_VALUE, new McpSchema.Annotations(Collections.singletonList(McpSchema.Role.USER), 0.0));
        var resourceSpecification = new McpServerFeatures.SyncResourceSpecification(systemInfoResource, (exchange, request) -> {
            try {
                var systemInfo = applicationService.getSystemInfo();
                String jsonContent = new ObjectMapper().writeValueAsString(systemInfo);
                return new McpSchema.ReadResourceResult(
                        List.of(new McpSchema.TextResourceContents(request.uri(), MimeTypeUtils.APPLICATION_JSON_VALUE, jsonContent)));
            }
            catch (Exception e) {
                log.info("[MCP] 获取当前系统信息错误", e);
                throw new RuntimeException("Failed to generate system info", e);
            }
        });
        return List.of(resourceSpecification);
    }

    @Bean
    public List<McpServerFeatures.SyncPromptSpecification> mcpSyncPrompts() {
        var prompt = new McpSchema.Prompt("greeting", "A friendly greeting prompt",
            List.of(new McpSchema.PromptArgument("name", "The name to greet", true)));

        var promptSpecification = new McpServerFeatures.SyncPromptSpecification(prompt, (exchange, getPromptRequest) -> {
            String nameArgument = (String) getPromptRequest.arguments().get("name");
            if (nameArgument == null) { nameArgument = "friend"; }
            var userMessage = new McpSchema.PromptMessage(McpSchema.Role.USER, new McpSchema.TextContent("Hello " + nameArgument + "! How can I assist you today?"));
            return new McpSchema.GetPromptResult("A personalized greeting message", List.of(userMessage));
        });

        return List.of(promptSpecification);
    }

    public record TextInput(String input) {
	}

}
