package com.navinfo.dongfeng.terminal.comm.kafka.serializers;

import kafka.serializer.Encoder;
import kafka.utils.VerifiableProperties;

public class KafkaJsonEncoder<T> extends KafkaJsonSerializer<T> implements Encoder<T>
{
    
    public KafkaJsonEncoder(VerifiableProperties props)
    {
        configure(new KafkaJsonSerializerConfig(props.props()));
    }
    
    @Override
    public byte[] toBytes(T val)
    {
        return serialize(null, val);
    }
}
