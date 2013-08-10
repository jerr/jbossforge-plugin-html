/*
 * Copyright 2013 Jeremie Lagarde.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.jboss.forge.html.plugins;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.inject.Inject;

import org.jboss.forge.html.resources.HTMLElementResource;
import org.jboss.forge.html.resources.HTMLResource;
import org.jboss.forge.resources.Resource;
import org.jboss.forge.shell.ShellColor;
import org.jboss.forge.shell.plugins.Alias;
import org.jboss.forge.shell.plugins.Current;
import org.jboss.forge.shell.plugins.DefaultCommand;
import org.jboss.forge.shell.plugins.Help;
import org.jboss.forge.shell.plugins.Option;
import org.jboss.forge.shell.plugins.PipeOut;
import org.jboss.forge.shell.plugins.Plugin;
import org.jboss.forge.shell.plugins.RequiresResource;
import org.jboss.forge.shell.plugins.Topic;

/**
 * @author Jeremie Lagarde
 * 
 */
@Alias("ls")
@RequiresResource(HTMLResource.class)
@Topic("File & Resources")
@Help("Prints the contents current html file")
public class LsHTMLPlugin implements Plugin
{

   @Inject
   @Current
   private HTMLResource html;

   @DefaultCommand
   public void run(
            @Option(flagOnly = true, name = "all", shortName = "a", required = false) final boolean showAll,
            @Option(flagOnly = true, name = "list", shortName = "l", required = false) final boolean list,
            @Option(description = "path", defaultValue = ".") final Resource<?>[] paths,
            final PipeOut out) throws IOException
   {
      if (showAll)
      {
         InputStream stream = html.getResourceInputStream();
         StringBuilder buf = new StringBuilder();

         int c;
         while ((c = stream.read()) != -1)
         {
            buf.append((char) c);
         }
         out.println(buf.toString());
      }
      else
      {

         out.println();
         out.println(out.renderColor(ShellColor.RED, "[elements] "));
         List<Resource<?>> children = html.listResources();
         for (Resource<?> child : children)
         {
            if (child instanceof HTMLElementResource)
            {
               HTMLElementResource resource = (HTMLElementResource) child;
               out.println(out.renderColor(ShellColor.BLUE, resource.getName()));
            }

         }

         out.println();
      }
   }
}
