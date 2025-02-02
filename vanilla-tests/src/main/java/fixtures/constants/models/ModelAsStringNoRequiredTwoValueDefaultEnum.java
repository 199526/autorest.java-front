// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package fixtures.constants.models;

import com.azure.core.util.ExpandableStringEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Collection;

/** Defines values for ModelAsStringNoRequiredTwoValueDefaultEnum. */
public final class ModelAsStringNoRequiredTwoValueDefaultEnum
        extends ExpandableStringEnum<ModelAsStringNoRequiredTwoValueDefaultEnum> {
    /** Static value value1 for ModelAsStringNoRequiredTwoValueDefaultEnum. */
    public static final ModelAsStringNoRequiredTwoValueDefaultEnum VALUE1 = fromString("value1");

    /** Static value value2 for ModelAsStringNoRequiredTwoValueDefaultEnum. */
    public static final ModelAsStringNoRequiredTwoValueDefaultEnum VALUE2 = fromString("value2");

    /**
     * Creates or finds a ModelAsStringNoRequiredTwoValueDefaultEnum from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding ModelAsStringNoRequiredTwoValueDefaultEnum.
     */
    @JsonCreator
    public static ModelAsStringNoRequiredTwoValueDefaultEnum fromString(String name) {
        return fromString(name, ModelAsStringNoRequiredTwoValueDefaultEnum.class);
    }

    /**
     * Gets known ModelAsStringNoRequiredTwoValueDefaultEnum values.
     *
     * @return known ModelAsStringNoRequiredTwoValueDefaultEnum values.
     */
    public static Collection<ModelAsStringNoRequiredTwoValueDefaultEnum> values() {
        return values(ModelAsStringNoRequiredTwoValueDefaultEnum.class);
    }
}
