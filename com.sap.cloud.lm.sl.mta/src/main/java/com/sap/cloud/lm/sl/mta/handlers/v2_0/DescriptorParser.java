package com.sap.cloud.lm.sl.mta.handlers.v2_0;

import java.io.InputStream;
import java.util.Map;

import com.sap.cloud.lm.sl.common.ParsingException;
import com.sap.cloud.lm.sl.mta.model.v2_0.DeploymentDescriptor;
import com.sap.cloud.lm.sl.mta.model.v2_0.ExtensionDescriptor;
import com.sap.cloud.lm.sl.mta.parsers.v2_0.DeploymentDescriptorParser;
import com.sap.cloud.lm.sl.mta.parsers.v2_0.ExtensionDescriptorParser;
import com.sap.cloud.lm.sl.mta.schema.SchemaValidator;

public class DescriptorParser extends com.sap.cloud.lm.sl.mta.handlers.v1_0.DescriptorParser {

    public DescriptorParser() {
        super(new SchemaValidator(Schemas.MTAD), new SchemaValidator(Schemas.MTAEXT));
    }

    protected DescriptorParser(SchemaValidator mtadValidator, SchemaValidator mtaextValidator) {
        super(mtadValidator, mtaextValidator);
    }

    @Override
    public ExtensionDescriptor parseExtensionDescriptorYaml(InputStream yaml) throws ParsingException {
        return (ExtensionDescriptor) super.parseExtensionDescriptorYaml(yaml);
    }

    @Override
    public ExtensionDescriptor parseExtensionDescriptorYaml(String yaml) throws ParsingException {
        return (ExtensionDescriptor) super.parseExtensionDescriptorYaml(yaml);
    }

    @Override
    protected ExtensionDescriptorParser getExtensionDescriptorParser(Map<String, Object> map) {
        return new com.sap.cloud.lm.sl.mta.parsers.v2_0.ExtensionDescriptorParser(map);
    }

    @Override
    public DeploymentDescriptor parseDeploymentDescriptorYaml(InputStream yaml) throws ParsingException {
        return (DeploymentDescriptor) super.parseDeploymentDescriptorYaml(yaml);
    }

    @Override
    public DeploymentDescriptor parseDeploymentDescriptorYaml(String yaml) throws ParsingException {
        return (DeploymentDescriptor) super.parseDeploymentDescriptorYaml(yaml);
    }

    @Override
    protected DeploymentDescriptorParser getDeploymentDescriptorParser(Map<String, Object> map) {
        return new com.sap.cloud.lm.sl.mta.parsers.v2_0.DeploymentDescriptorParser(map);
    }

}
