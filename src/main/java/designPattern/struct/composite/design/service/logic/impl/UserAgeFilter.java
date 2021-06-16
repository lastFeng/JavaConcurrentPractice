package designPattern.struct.composite.design.service.logic.impl;

import designPattern.struct.composite.design.service.logic.BaseLogic;

import java.util.Map;

public class UserAgeFilter extends BaseLogic {
    @Override
    public String matterValue(Long treeId, String useId, Map<String, String> decisionMatter) {
        return decisionMatter.get("age");
    }
}
