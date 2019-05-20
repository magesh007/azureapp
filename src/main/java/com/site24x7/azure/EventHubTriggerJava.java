package com.site24x7.azure;

import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;
import java.util.*;

/**
 * Azure Functions with Event Hub trigger.
 */
public class EventHubTriggerJava {
    /**
     * This function will be invoked when an event is received from Event Hub.
     */
    @FunctionName("EventHubTriggerJava")
    public void run(
        @EventHubTrigger(name = "message", eventHubName = "insights-operational-logs", connection = "AzureEventHubConnectionString", consumerGroup = "$Default", cardinality = Cardinality.MANY) List<String> message,
        final ExecutionContext context
    ) {
        context.getLogger().info("Java Event Hub trigger function executed.");
        context.getLogger().info("logTypeConfig="+System.getProperty("logTypeConfig"));
        context.getLogger().info("AzureEventHubConnectionString="+System.getProperty("AzureEventHubConnectionString"));
        context.getLogger().info("Length:" + message.size());
        message.forEach(singleMessage -> context.getLogger().info(singleMessage));
    }
}
