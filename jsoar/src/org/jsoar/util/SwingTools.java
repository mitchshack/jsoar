/*
 * Copyright (c) 2008  Dave Ray <daveray@gmail.com>
 *
 * Created on Dec 14, 2008
 */
package org.jsoar.util;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;

/**
 * @author ray
 */
public class SwingTools
{
    /**
     * Add undo/redo support to a text component. Undo is bound to "ctrl-z",
     * redo to "ctrl-y".
     * 
     * @param textcomp The text component.
     */
    public static void addUndoSupport(JTextComponent textcomp)
    {
        // Based on http://www.exampledepot.com/egs/javax.swing.undo/UndoText.html
        final UndoManager undo = new UndoManager();
        Document doc = textcomp.getDocument();
        
        // Listen for undo and redo events
        doc.addUndoableEditListener(new UndoableEditListener() {
            public void undoableEditHappened(UndoableEditEvent evt) {
                undo.addEdit(evt.getEdit());
            }
        });
        
        // Create an undo action and add it to the text component
        textcomp.getActionMap().put("Undo",
            new AbstractAction("Undo") {
                private static final long serialVersionUID = -1616574389415095169L;

                public void actionPerformed(ActionEvent evt) {
                    try {
                        if (undo.canUndo()) {
                            undo.undo();
                        }
                    } catch (CannotUndoException e) {
                    }
                }
           });
        
        // Bind the undo action to ctl-Z
        textcomp.getInputMap().put(KeyStroke.getKeyStroke("control Z"), "Undo");
        
        // Create a redo action and add it to the text component
        textcomp.getActionMap().put("Redo",
            new AbstractAction("Redo") {
                private static final long serialVersionUID = 58635276936990330L;

                public void actionPerformed(ActionEvent evt) {
                    try {
                        if (undo.canRedo()) {
                            undo.redo();
                        }
                    } catch (CannotRedoException e) {
                    }
                }
            });
        
        // Bind the redo action to ctl-Y
        textcomp.getInputMap().put(KeyStroke.getKeyStroke("control Y"), "Redo");

        
    }
}
