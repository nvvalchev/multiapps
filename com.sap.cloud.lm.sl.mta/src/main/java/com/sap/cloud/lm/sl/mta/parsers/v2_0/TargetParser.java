package com.sap.cloud.lm.sl.mta.parsers.v2_0;

import static com.sap.cloud.lm.sl.mta.handlers.v2_0.Schemas.PLATFORM;

import java.util.List;
import java.util.Map;

import com.sap.cloud.lm.sl.common.ParsingException;
import com.sap.cloud.lm.sl.common.util.ListUtil;
import com.sap.cloud.lm.sl.mta.model.v2_0.TargetModuleType;
import com.sap.cloud.lm.sl.mta.model.v2_0.TargetResourceType;
import com.sap.cloud.lm.sl.mta.model.v2_0.Target;
import com.sap.cloud.lm.sl.mta.model.v2_0.Target.Builder;
import com.sap.cloud.lm.sl.mta.schema.MapElement;

public class TargetParser extends com.sap.cloud.lm.sl.mta.parsers.v1_0.TargetParser {

    public static final String PARAMETERS = "parameters";

    public TargetParser(Map<String, Object> source) {
        super(PLATFORM, source);
    }

    protected TargetParser(MapElement schema, Map<String, Object> source) {
        super(schema, source);
    }

    @Override
    public Target parse() throws ParsingException {
        Builder builder = new Builder();
        builder.setName(getName());
        builder.setDescription(getDescription());
        builder.setType(getType());
        builder.setModuleTypes2_0(getModuleTypes2_0());
        builder.setResourceTypes2_0(getResourceTypes2_0());
        builder.setParameters(getParameters());
        return builder.build();
    }

    protected Map<String, Object> getParameters() {
        return getMapElement(PARAMETERS);
    }

    @Override
    protected PlatformModuleTypeParser getModuleTypeParser(Map<String, Object> source) {
        return new PlatformModuleTypeParser(source);
    }

    @Override
    protected PlatformResourceTypeParser getResourceTypeParser(Map<String, Object> source) {
        return new PlatformResourceTypeParser(source);
    }

    protected List<TargetModuleType> getModuleTypes2_0() throws ParsingException {
        return ListUtil.cast(getModuleTypes1_0());
    }

    protected List<TargetResourceType> getResourceTypes2_0() throws ParsingException {
        return ListUtil.cast(getResourceTypes1_0());
    }

}
