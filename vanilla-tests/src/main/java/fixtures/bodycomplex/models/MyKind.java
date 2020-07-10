package fixtures.bodycomplex.models;

import com.azure.core.util.ExpandableStringEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Collection;

/** Defines values for MyKind. */
public final class MyKind extends ExpandableStringEnum<MyKind> {
    /** Static value Kind1 for MyKind. */
    public static final MyKind KIND1 = fromString("Kind1");

    /**
     * Creates or finds a MyKind from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding MyKind.
     */
    @JsonCreator
    public static MyKind fromString(String name) {
        return fromString(name, MyKind.class);
    }

    /** @return known MyKind values. */
    public static Collection<MyKind> values() {
        return values(MyKind.class);
    }
}
