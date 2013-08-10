/*
 * Copyright 2013 Jeremie Lagarde.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.jboss.forge.html.plugins;

import static org.junit.Assert.assertTrue;

import org.jboss.forge.shell.Shell;
import org.jboss.forge.test.AbstractShellTest;
import org.junit.Test;

/**
 * @author Jeremie Lagarde
 * 
 */
public class LsHTMLPluginTest extends AbstractShellTest
{

   @Test
   public void testShouldBeAbleToLsHTMLFile() throws Exception
   {
      Shell shell = getShell();
      shell.execute("cd src/test/resources");
      shell.execute("cd index.html");

      shell.execute("ls");

      String out = getOutput();
      assertTrue(out.contains("[elements]"));
   }
}
