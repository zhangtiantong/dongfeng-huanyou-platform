package com.navinfo.dongfeng.terminal.comm.kafka.serializers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class KafkaJsonSerializer<T> implements Serializer<T>
{
    
    private ObjectMapper objectMapper;
    
    public KafkaJsonSerializer()
    {
        
    }
    
    @Override
    public void configure(Map<String, ?> config, boolean isKey)
    {
        configure(new KafkaJsonSerializerConfig(config));
    }
    
    protected void configure(KafkaJsonSerializerConfig config)
    {
        boolean prettyPrint = config.getBoolean(KafkaJsonSerializerConfig.JSON_INDENT_OUTPUT);
        this.objectMapper = new ObjectMapper();
        this.objectMapper.configure(SerializationFeature.INDENT_OUTPUT, prettyPrint);
    }
    
    @Override
    public byte[] serialize(String topic, T data)
    {
        if (data == null)
            return null;
        
        try
        {
            return objectMapper.writeValueAsBytes(data);
        }
        catch (Exception e)
        {
            throw new SerializationException("Error serializing JSON message", e);
        }
    }
    
    @Override
    public void close()
    {
    }
    
}
