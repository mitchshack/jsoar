/*
 * (c) 2008  Dave Ray
 *
 * Created on Aug 22, 2008
 */
package org.jsoar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import org.apache.log4j.BasicConfigurator;
import org.jsoar.kernel.Agent;
import org.jsoar.kernel.Production;
import org.jsoar.kernel.ProductionType;
import org.jsoar.kernel.VariableGenerator;
import org.jsoar.kernel.parser.Lexer;
import org.jsoar.kernel.parser.Parser;
import org.jsoar.kernel.symbols.SymbolFactory;
import org.jsoar.kernel.tracing.Printer;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 * @author ray
 */
public class JSoarTest
{
    protected SymbolFactory syms;
    protected VariableGenerator varGen;
    
    @Before
    public void setUp() throws Exception
    {
        this.syms = new SymbolFactory();
        this.varGen = new VariableGenerator(this.syms);
    }
    
    @BeforeClass
    public static void configureLogging()
    {
        BasicConfigurator.configure();
    }
    
    @AfterClass
    public static void unconfigureLogging()
    {
        BasicConfigurator.resetConfiguration();
    }
    
    protected Parser createParser(String input) throws IOException
    {
        Lexer lexer = new Lexer(new StringReader(input));
        
        Parser parser = new Parser(new VariableGenerator(syms), lexer);
        lexer.getNextLexeme();
        return parser;
    }

    public static void verifyProduction(Agent agent, String name, ProductionType type, String body)
    {
        Production j = agent.getProduction(name);
        assertNotNull(j);
        assertEquals(type, j.type);
        StringWriter writer = new StringWriter();
        j.print_production(agent.rete, new Printer(writer, false), false);
        assertEquals(body, writer.toString());
        
    }

}
