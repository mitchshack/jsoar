/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.35
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package sml;

import sml.Agent.OutputNotificationInterface;

public class OutputNotificationHandlerPlusData extends EventHandlerPlusData {
    OutputNotificationInterface m_Handler;

/*
  private long swigCPtr;

  protected OutputNotificationHandlerPlusData(long cPtr, boolean cMemoryOwn) {
    super(smlJNI.SWIGOutputNotificationHandlerPlusDataUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(OutputNotificationHandlerPlusData obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

*/
  public synchronized void delete() {
      /*
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      smlJNI.delete_OutputNotificationHandlerPlusData(swigCPtr);
    }
    swigCPtr = 0;
    */
    super.delete();
  }

  public void setM_Handler(SWIGTYPE_p_f_p_void_p_sml__Agent__void value) {
      throw new UnsupportedOperationException("Not implemented");
  }

  public SWIGTYPE_p_f_p_void_p_sml__Agent__void getM_Handler() {
      throw new UnsupportedOperationException("Not implemented");
  }

  public OutputNotificationHandlerPlusData() {
      throw new UnsupportedOperationException("Not implemented");
  }

  public OutputNotificationHandlerPlusData(int eventID, SWIGTYPE_p_f_p_void_p_sml__Agent__void handler, SWIGTYPE_p_void userData, int callbackID) {
      throw new UnsupportedOperationException("Not implemented");
  }

}
