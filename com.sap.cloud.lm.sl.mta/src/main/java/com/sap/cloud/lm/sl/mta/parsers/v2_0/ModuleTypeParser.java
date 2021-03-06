package com.sap.cloud.lm.sl.mta.parsers.v2_0;

import static com.sap.cloud.lm.sl.mta.handlers.v2_0.Schemas.MODULE_TYPE;

import java.util.Map;

import com.sap.cloud.lm.sl.common.ParsingException;
import com.sap.cloud.lm.sl.mta.model.v2_0.PlatformModuleType;
import com.sap.cloud.lm.sl.mta.model.v2_0.PlatformModuleType.Builder;
import com.sap.cloud.lm.sl.mta.schema.MapElement;

public class ModuleTypeParser extends com.sap.cloud.lm.sl.mta.parsers.v1_0.ModuleTypeParser {

    public static final String PARAMETERS = "parameters";

    public ModuleTypeParser(Map<String, Object> source) {
        super(MODULE_TYPE, source);
    }

    protected ModuleTypeParser(MapElement schema, Map<String, Object> source) {
        super(schema, source);
    }

    @Override
    public PlatformModuleType parse() throws ParsingException {
        Builder builder = new Builder();
        builder.setName(getName());
        builder.setDeployer(getDeployer());
        builder.setProperties(getProperties());
        builder.setParameters(getParameters());
        return builder.build();
    }

    protected Map<String, Object> getParameters() {
        return getMapElement(PARAMETERS);
    }

}
