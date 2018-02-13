/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package fixtures.xml.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.util.List;

/**
 * A slide in a slideshow.
 */
@JacksonXmlRootElement(localName = "Slide")
public final class Slide {
    /**
     * The type property.
     */
    @JacksonXmlProperty(localName = "type", isAttribute = true)
    private String type;

    /**
     * The title property.
     */
    @JsonProperty(value = "title")
    private String title;

    /**
     * The items property.
     */
    @JsonProperty("item")
    private List<String> items;

    /**
     * Get the type value.
     *
     * @return the type value.
     */
    public String type() {
        return this.type;
    }

    /**
     * Set the type value.
     *
     * @param type the type value to set.
     * @return the Slide object itself.
     */
    public Slide withType(String type) {
        this.type = type;
        return this;
    }

    /**
     * Get the title value.
     *
     * @return the title value.
     */
    public String title() {
        return this.title;
    }

    /**
     * Set the title value.
     *
     * @param title the title value to set.
     * @return the Slide object itself.
     */
    public Slide withTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * Get the items value.
     *
     * @return the items value.
     */
    public List<String> items() {
        return this.items;
    }

    /**
     * Set the items value.
     *
     * @param items the items value to set.
     * @return the Slide object itself.
     */
    public Slide withItems(List<String> items) {
        this.items = items;
        return this;
    }
}
