package com.sap.cloud.lm.sl.mta.parsers.v3_0;

import static com.sap.cloud.lm.sl.mta.handlers.v3_0.Schemas.RESOURCE_TYPE;

import java.util.Map;

import com.sap.cloud.lm.sl.common.ParsingException;
import com.sap.cloud.lm.sl.mta.model.v3_0.PlatformResourceType;
import com.sap.cloud.lm.sl.mta.model.v3_0.PlatformResourceType.Builder;
import com.sap.cloud.lm.sl.mta.schema.MapElement;

public class ResourceTypeParser extends com.sap.cloud.lm.sl.mta.parsers.v2_0.ResourceTypeParser {

    public ResourceTypeParser(Map<String, Object> source) {
        super(RESOURCE_TYPE, source);
    }

    protected ResourceTypeParser(MapElement schema, Map<String, Object> source) {
        super(schema, source);
    }

    @Override
    public PlatformResourceType parse() throws ParsingException {
        Builder builder = new Builder();
        builder.setName(getName());
        builder.setResourceManager(getResourceManager());
        builder.setParameters(getParameters());
        return builder.build();
    }

}
