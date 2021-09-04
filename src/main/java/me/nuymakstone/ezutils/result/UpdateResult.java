package me.nuymakstone.ezutils.result;

/*
 * #%L
 * EzUtils
 * %%
 * Copyright (C) 2010 - 2015 EzUtils
 * %%
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * #L%
 */

/**
 * Represents a result from an update check from DBO.
 *
 * @author nuymakstone
 */
public class UpdateResult {

    /**
     * The type of the result.
     */
    private final ResultType type;

    /**
     * The current version of the plugin.
     */
    private final String currentVersion;

    /**
     * The latest version of the plugin.
     */
    private final String latestVersion;

    /**
     * Represents the type of the result.
     */
    public enum ResultType {
        INVALID_PLUGIN, NOT_INSTALLED, OUT_OF_DATE, UP_TO_DATE
    }

    /**
     * Construct the object with no versions.
     *
     * @param type the type of the result.
     */
    public UpdateResult(ResultType type) {
        this(type, null, null);
    }

    /**
     * Construct the object with only the current version.
     *
     * @param type the type of the result.
     * @param currentVersion the current version.
     */
    public UpdateResult(ResultType type, String currentVersion) {
        this(type, currentVersion, null);
    }

    /**
     * Construct the object.
     *
     * @param type           the type of the result.
     * @param currentVersion the current version of the plugin.
     * @param latestVersion  the latest version of the plugin.
     */
    public UpdateResult(ResultType type, String currentVersion, String latestVersion) {
        this.type = type;
        this.currentVersion = currentVersion;
        this.latestVersion = latestVersion;
    }

    /**
     * Get the type of the result.
     *
     * @return the type of the result.
     */
    public ResultType getType() {
        return type;
    }

    /**
     * Get the current version of the plugin.
     *
     * @return the current version of the plugin.
     */
    public String getCurrentVersion() {
        return currentVersion;
    }

    /**
     * Get the latest version of the plugin.
     *
     * @return the latest version of the plugin.
     */
    public String getLatestVersion() {
        return latestVersion;
    }

}