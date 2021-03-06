/*
 * Copyright (c) 2009 Dave Ray <daveray@gmail.com>
 */
package org.jsoar.kernel.commands;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.jsoar.kernel.Agent;
import org.jsoar.kernel.SoarException;
import org.jsoar.kernel.tracing.Printer;
import org.jsoar.util.commands.SoarCommand;
import org.jsoar.util.commands.SoarCommandContext;
import org.jsoar.util.properties.PropertyKey;
import org.jsoar.util.properties.PropertyManager;

/**
 * Implementation of the "properties" command. Prints out all property values
 * 
 * @author ray
 */
public final class PropertiesCommand implements SoarCommand
{
    private final Agent agent;

    public PropertiesCommand(Agent agent)
    {
        this.agent = agent;
    }

    @Override
    public String execute(SoarCommandContext commandContext, String[] args) throws SoarException
    {
        final Printer p = agent.getPrinter();
        
        p.startNewLine();
        final PropertyManager properties = agent.getProperties();
        final List<PropertyKey<?>> keys = properties.getKeys();
        Collections.sort(keys, new Comparator<PropertyKey<?>>(){

            @Override
            public int compare(PropertyKey<?> a, PropertyKey<?> b)
            {
                return a.getName().compareTo(b.getName());
            }});
        for(PropertyKey<?> key : keys)
        {
            p.print("%30s = %s%s\n", key.getName(), properties.get(key), key.isReadonly() ? " [RO]" : "");
        }
        return "";
    }
}