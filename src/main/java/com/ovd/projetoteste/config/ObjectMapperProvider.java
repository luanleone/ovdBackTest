package com.ovd.projetoteste.config;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

import javax.ws.rs.ext.ContextResolver;

class ObjectMapperProvider implements ContextResolver<ObjectMapper> {
    private final ObjectMapper defaultObjectMapper;

    public ObjectMapperProvider() {
        defaultObjectMapper = createDefaultMapper();
    }

    @Override
    public ObjectMapper getContext(Class<?> type) {
        return defaultObjectMapper;
    }

    private static ObjectMapper createDefaultMapper() {
        final ObjectMapper result = new ObjectMapper();
        //result.configure(Feature.INDENT_OUTPUT, true);
        result.getSerializationConfig().withSerializationInclusion(Inclusion.NON_NULL);

        result.disable(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);
        result.disable(SerializationConfig.Feature.WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS);
        result.enable(DeserializationConfig.Feature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        return result;
    }
}
