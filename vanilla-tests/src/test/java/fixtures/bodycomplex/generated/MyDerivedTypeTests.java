// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package fixtures.bodycomplex.generated;

import com.azure.core.util.BinaryData;
import fixtures.bodycomplex.models.MyDerivedType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public final class MyDerivedTypeTests {
    @Test
    public void testDeserialize() {
        MyDerivedType model =
                BinaryData.fromString(
                                "{\"kind\":\"Kind1\",\"propD1\":\"gphuticndvka\",\"propB1\":\"wyiftyhxhur\",\"helper\":{\"propBH1\":\"ftyxolniw\"}}")
                        .toObject(MyDerivedType.class);
        Assertions.assertEquals("wyiftyhxhur", model.getPropB1());
        Assertions.assertEquals("ftyxolniw", model.getPropBH1());
        Assertions.assertEquals("gphuticndvka", model.getPropD1());
    }

    @Test
    public void testSerialize() {
        MyDerivedType model =
                new MyDerivedType().setPropB1("wyiftyhxhur").setPropBH1("ftyxolniw").setPropD1("gphuticndvka");
        model = BinaryData.fromObject(model).toObject(MyDerivedType.class);
        Assertions.assertEquals("wyiftyhxhur", model.getPropB1());
        Assertions.assertEquals("ftyxolniw", model.getPropBH1());
        Assertions.assertEquals("gphuticndvka", model.getPropD1());
    }
}
