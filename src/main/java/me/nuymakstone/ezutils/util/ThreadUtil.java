package me.nuymakstone.ezutils.util;

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

import me.nuymakstone.ezutils.EzUtils;

import org.bukkit.Bukkit;

/**
 * Utility class for threading.
 *
 * @author nuymakstone
 */
public class ThreadUtil {

    /**
     * Run a task in a separate thread.
     *
     * @param runnable the task.
     */
    public static void async(Runnable runnable) {
        Bukkit.getScheduler().runTaskAsynchronously(EzUtils.getInstance(), runnable);
    }

    /**
     * Run a task in the main thread.
     *
     * @param runnable the task.
     */
    public static void sync(Runnable runnable) {
        Bukkit.getScheduler().runTask(EzUtils.getInstance(), runnable);
    }

}
