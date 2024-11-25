package calculator.model;

import calculator.constants.DelimiterConstants;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Custom {

    private final HashSet<String> customSet;

    public Custom() {
        this.customSet = new HashSet<>();
        initializeDefaultCustomSet();
    }

    private void initializeDefaultCustomSet() {
        customSet.add(DelimiterConstants.INITIAL_CUSTOM_COLON.getMessage());
        customSet.add(DelimiterConstants.INITIAL_CUSTOM_COMMA.getMessage());
    }

    public void addCustomSet(String customData) {
        customSet.add(customData);
    }

    public Set<String> getCustomSet() {
        return Collections.unmodifiableSet(customSet);
    }

    public void resetCustomSet() {
        customSet.clear();
        initializeDefaultCustomSet();
    }
}
