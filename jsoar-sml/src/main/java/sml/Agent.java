/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.35
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package sml;

import java.util.List;

import sml.connection.Connection;
import sml.connection.ErrorCode;

public class Agent extends ClientErrors
{
    protected final WorkingMemory m_WorkingMemory = new WorkingMemory();
    protected final Kernel m_Kernel;
    protected final String m_Name;
    
    protected final ListMap<smlRunEventId, RunEventHandlerPlusData> m_RunEventMap = ListMap.newInstance();
    protected final ListMap<smlProductionEventId, ProductionEventHandlerPlusData>  m_ProductionEventMap = ListMap.newInstance();
    protected final ListMap<smlPrintEventId, PrintEventHandlerPlusData>            m_PrintEventMap = ListMap.newInstance();
    protected final ListMap<smlXMLEventId, XMLEventHandlerPlusData>                m_XMLEventMap = ListMap.newInstance();
    protected final ListMap<String, OutputEventHandlerPlusData>               m_OutputEventMap = ListMap.newInstance();
    protected final ListMap<smlWorkingMemoryEventId, OutputNotificationHandlerPlusData>    m_OutputNotificationMap = ListMap.newInstance();
    
    // Used to generate unique IDs for callbacks
    protected int     m_CallbackIDCounter ;

    // Used to generate unique IDs for visited values when walking graph
    protected int m_VisitedCounter ;

    // Internally we register a print callback and store its id here.
    protected int     m_XMLCallback ;

    // When true, if a wme is updated to the same value as before we "blink" the wme by removing
    // the old wme and adding a new one, causing rules to rematch in Soar.
    protected boolean    m_BlinkIfNoChange ;
    
    public synchronized void delete()
    {
        super.delete();
    }

    /**
     * @param kernel
     * @param agentName
     */
    Agent(Kernel kernel, String agentName)
    {
        m_Kernel = kernel ;
        m_Name   = agentName ;
        m_CallbackIDCounter = 0 ;
        m_VisitedCounter = 0 ;
        m_XMLCallback = -1 ;
        m_BlinkIfNoChange = true ;

        m_WorkingMemory.SetAgent(this) ;

        ClearError() ;
    }

    public interface RunEventInterface
    {
        public void runEventHandler(int eventID, Object data, Agent agent, int phase);
    }

    public interface ProductionEventInterface
    {
        public void productionEventHandler(int eventID, Object data, Agent agent, String prodName, String instantiation);
    }

    public interface PrintEventInterface
    {
        public void printEventHandler(int eventID, Object data, Agent agent, String message);
    }

    public interface xmlEventInterface
    {
        public void xmlEventHandler(int eventID, Object data, Agent agent, ClientXML xml);
    }

    public interface OutputEventInterface
    {
        public void outputEventHandler(Object data, String agentName, String attributeName, WMElement pWmeAdded);
    }

    public interface OutputNotificationInterface
    {
        public void outputNotificationHandler(Object data, Agent agent);
    }

    public int RegisterForRunEvent(smlRunEventId id, RunEventInterface handlerObject, Object callbackData)
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public int RegisterForProductionEvent(smlProductionEventId id, ProductionEventInterface handlerObject,
            Object callbackData)
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public int RegisterForPrintEvent(smlPrintEventId id, PrintEventInterface handlerObject, Object callbackData)
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public int RegisterForPrintEvent(smlPrintEventId id, PrintEventInterface handlerObject, Object callbackData,
            boolean ignoreOwnEchos)
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public int RegisterForXMLEvent(smlXMLEventId id, xmlEventInterface handlerObject, Object callbackData)
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public int RegisterForOutputNotification(OutputNotificationInterface handlerObject, Object callbackData)
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public boolean UnregisterForOutputNotification(int callbackReturnValue)
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public boolean UnregisterForRunEvent(int callbackReturnValue)
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public boolean UnregisterForProductionEvent(int callbackReturnValue)
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public boolean UnregisterForPrintEvent(int callbackReturnValue)
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public boolean UnregisterForXMLEvent(int callbackReturnValue)
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public int AddOutputHandler(String attributeName, OutputEventInterface handlerObject, Object callbackData)
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public boolean RemoveOutputHandler(int callbackReturnValue)
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public String GetAgentName()
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public Kernel GetKernel()
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public int GenerateNewVisitedCounter()
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public boolean LoadProductions(String pFilename, boolean echoResults)
    {
        // gSKI's LoadProductions command doesn't support all of the command line commands we need,
        // so we'll send this through the command line processor instead by creating a "source" command.
        StringBuilder cmd = new StringBuilder();
        cmd.append("source ");
        if (pFilename.length() > 0 && (pFilename.charAt(0) == '\"') && (pFilename.charAt(pFilename.length() - 1) == '\"'))
        {
            cmd.append(pFilename);
        } else {
            cmd.append('\"');
            cmd.append(pFilename);
            cmd.append('\"');
        }

        // Execute the source command
        final String pResult = ExecuteCommandLine(cmd.toString(), echoResults) ;

        final boolean ok = GetLastCommandLineResult() ;

        if (ok)
            ClearError() ;
        else
            SetDetailedError(ErrorCode.kDetailedError, pResult) ;

        return ok ;
    }

    public boolean LoadProductions(String pFilename)
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public Identifier GetInputLink()
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public Identifier GetILink()
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public Identifier GetOutputLink()
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public StringElement CreateStringWME(Identifier parent, String pAttribute, String pValue)
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public IntElement CreateIntWME(Identifier parent, String pAttribute, int value)
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public FloatElement CreateFloatWME(Identifier parent, String pAttribute, double value)
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public Identifier CreateIdWME(Identifier parent, String pAttribute)
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public Identifier CreateSharedIdWME(Identifier parent, String pAttribute, Identifier pSharedValue)
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public void Update(StringElement pWME, String pValue)
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public void Update(IntElement pWME, int value)
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public void Update(FloatElement pWME, double value)
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public void SetBlinkIfNoChange(boolean state)
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public boolean IsBlinkIfNoChange()
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public boolean DestroyWME(WMElement pWME)
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public String InitSoar()
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public int GetNumberOutputLinkChanges()
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public WMElement GetOutputLinkChange(int index)
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public boolean IsOutputLinkChangeAdd(int index)
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public void ClearOutputLinkChanges()
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public int GetNumberCommands()
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public boolean Commands()
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public Identifier GetCommand(int index)
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public boolean Commit()
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public boolean IsCommitRequired()
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public String RunSelf(long numberSteps, smlRunStepSize stepSize)
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public String RunSelf(long numberSteps)
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public String RunSelfForever()
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public String RunSelfTilOutput()
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public boolean WasAgentOnRunList()
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public smlRunResult GetResultOfLastRun()
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public String StopSelf()
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public void Refresh()
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public smlPhase GetCurrentPhase()
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public int GetDecisionCycleCounter()
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public smlRunState GetRunState()
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public String ExecuteCommandLine(String pCommandLine, boolean echoResults, boolean noFilter)
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public String ExecuteCommandLine(String pCommandLine, boolean echoResults)
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public String ExecuteCommandLine(String pCommandLine)
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public boolean ExecuteCommandLineXML(String pCommandLine, ClientAnalyzedXML pResponse)
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public boolean GetLastCommandLineResult()
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public boolean IsProductionLoaded(String pProductionName)
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public boolean SynchronizeInputLink()
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public boolean SynchronizeOutputLink()
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    /**
     * @return
     */
    WorkingMemory GetWM()
    {
        return m_WorkingMemory;
    }

    /**
     * 
     */
    void FireOutputNotification()
    {
        final smlWorkingMemoryEventId id = smlWorkingMemoryEventId.smlEVENT_OUTPUT_PHASE_CALLBACK ;

        // Look up the handler(s) from the map
        final List<OutputNotificationHandlerPlusData> pHandlers = m_OutputNotificationMap.getList(id) ;

        if (pHandlers == null)
            return ;

        // Go through the list of event handlers calling each in turn
        for (OutputNotificationHandlerPlusData handlerWithData : pHandlers)
        {
            OutputNotificationInterface handler = handlerWithData.m_Handler ;
            Object pUserData = handlerWithData.m_UserData ;

            // Call the handler
            handler.outputNotificationHandler(pUserData, this) ;
        }
    }

    /**
     * @return
     */
    boolean IsRegisteredForOutputEvent()
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    /**
     * @param wme
     */
    void ReceivedOutputEvent(WMElement wme)
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    /**
     * @return
     */
    Connection GetConnection()
    {
        return m_Kernel.m_Connection;
    }

    /**
     * @return
     */
    boolean IsAutoCommitEnabled()
    {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * @param msg
     * @param response
     */
    public void ReceivedOutput(AnalyzeXML pIncoming, ElementXML pResponse)
    {
        m_WorkingMemory.ReceivedOutput(pIncoming, pResponse);
    }

    /**
     * @param msg
     * @param response
     */
    public void ReceivedEvent(AnalyzeXML pIncoming, ElementXML pResponse)
    {
        final String pEventName = pIncoming.GetArgString(sml_Names.getKParamEventID()) ;

        // This event had no event id field
        if (pEventName == null)
        {
            return ;
        }

        // Go from the string form of the event back to the integer ID
        final int id = GetKernel().m_pEventMap.ConvertToEvent(pEventName) ;

        if (sml.IsRunEventID(id))
        {
            ReceivedRunEvent(smlRunEventId.swigToEnum(id), pIncoming, pResponse) ;
        } else if (sml.IsProductionEventID(id))
        {
            ReceivedProductionEvent(smlProductionEventId.swigToEnum(id), pIncoming, pResponse) ;
        } else if (sml.IsPrintEventID(id))
        {
            ReceivedPrintEvent(smlPrintEventId.swigToEnum(id), pIncoming, pResponse) ;
        } else if (sml.IsXMLEventID(id))
        {
            ReceivedXMLEvent(smlXMLEventId.swigToEnum(id), pIncoming, pResponse) ;
        }    
    }
    
    void ReceivedRunEvent(smlRunEventId id, AnalyzeXML pIncoming, ElementXML pResponse)
    {
        smlPhase phase = smlPhase.swigToEnum(pIncoming.GetArgInt(sml_Names.getKParamPhase(), -1));

        // Look up the handler(s) from the map
        List<RunEventHandlerPlusData> pHandlers = m_RunEventMap.getList(id) ;

        if (pHandlers == null)
            return ;

        // Go through the list of event handlers calling each in turn
        for (RunEventHandlerPlusData handlerWithData : pHandlers)
        {
            RunEventInterface handler = handlerWithData.m_Handler ;
            Object pUserData = handlerWithData.m_UserData ;

            // Call the handler
            handler.runEventHandler(id.swigValue(), pUserData, this, phase.swigValue()) ;
        }
    }
    
    void ReceivedPrintEvent(smlPrintEventId id, AnalyzeXML pIncoming, ElementXML pResponse)
    {
        final String pMessage = pIncoming.GetArgString(sml_Names.getKParamMessage()) ;

        // This argument is only present on echo messages.
        final boolean self = pIncoming.GetArgBool(sml_Names.getKParamSelf(), false) ;

        // Look up the handler(s) from the map
        List<PrintEventHandlerPlusData> pHandlers = m_PrintEventMap.getList(id) ;

        if (pHandlers == null)
            return ;

        // Go through the list of event handlers calling each in turn
        for (PrintEventHandlerPlusData handlerPlus : pHandlers)
        {
            final PrintEventInterface handler = handlerPlus.m_Handler ;
            final boolean ignoreOwnEchos = handlerPlus.m_IgnoreOwnEchos ;

            // If this is an echo event triggered by a command issued by ourselves ignore it.
            if (id == smlPrintEventId.smlEVENT_ECHO && ignoreOwnEchos && self)
                continue ;

            Object pUserData = handlerPlus.m_UserData ;

            // Call the handler
            handler.printEventHandler(id.swigValue(), pUserData, this, pMessage) ;
        }
    }
    
    void ReceivedProductionEvent(smlProductionEventId id, AnalyzeXML pIncoming, ElementXML pResponse)
    {
        final String pProductionName = pIncoming.GetArgString(sml_Names.getKParamName()) ;
        final String pInstance = null ; // gSKI defines this but doesn't support it yet.

        // Look up the handler(s) from the map
        final List<ProductionEventHandlerPlusData> pHandlers = m_ProductionEventMap.getList(id) ;

        if (pHandlers == null)
            return ;

        // Go through the list of event handlers calling each in turn
        for (ProductionEventHandlerPlusData handlerPlus : pHandlers)
        {
            ProductionEventInterface handler = handlerPlus.m_Handler ;
            Object pUserData = handlerPlus.m_UserData ;

            // Call the handler
            handler.productionEventHandler(id.swigValue(), pUserData, this, pProductionName, pInstance) ;
        }
    } 
    
    void ReceivedXMLEvent(smlXMLEventId id, AnalyzeXML pIncoming, ElementXML pResponse)
    {
        // Retrieve the original message
        ElementXML pXMLMessage = new ElementXML(pIncoming.m_hRootObject /*TODO ??*/) ;

        // Need to record our new reference to this handle.
        //pXMLMessage->AddRefOnHandle() ;

        // NOTE: This object needs to stay in scope for as long as we're calling clients
        // and then when it is deleted it will delete pXMLMessage.
        ClientXML clientXML = new ClientXML(pXMLMessage) ;

        // Look up the handler(s) from the map
        final List<XMLEventHandlerPlusData> pHandlers = m_XMLEventMap.getList(id) ;

        if (pHandlers == null)
            return ;

        // Go through the list of event handlers calling each in turn
        for (XMLEventHandlerPlusData handlerPlus : pHandlers)
        {
            Agent.xmlEventInterface handler = handlerPlus.m_Handler ;

            Object pUserData = handlerPlus.m_UserData ;

            // Call the handler
            handler.xmlEventHandler(id.swigValue(), pUserData, this, clientXML);
        }
    }    
    
    /**
     * @param smlEVENT_XML_TRACE_OUTPUT
     * @param incomingMsg
     * @param response
     */
    void ReceivedXMLTraceEvent(smlXMLEventId smlEVENT_XML_TRACE_OUTPUT, ElementXML incomingMsg, ElementXML response)
    {
        // TODO implement ReceivedXMLTraceEvent
        throw new UnsupportedOperationException();
    }

}