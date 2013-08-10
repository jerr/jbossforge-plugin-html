/*
 * Copyright 2013 Jeremie Lagarde.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.jboss.forge.html.resources;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

import org.jboss.forge.parser.HTMLParser;
import org.jboss.forge.parser.ParserException;
import org.jboss.forge.parser.html.HTMLDocument;
import org.jboss.forge.parser.html.HTMLElement;
import org.jboss.forge.parser.html.HTMLNode;
import org.jboss.forge.project.services.ResourceFactory;
import org.jboss.forge.resources.FileResource;
import org.jboss.forge.resources.Resource;
import org.jboss.forge.resources.ResourceFlag;
import org.jboss.forge.resources.ResourceHandles;


/**
 * @author Jeremie Lagarde
 * 
 */
@ResourceHandles("*.html")
public class HTMLResource extends FileResource<HTMLResource>
{

   @Inject
   public HTMLResource(ResourceFactory factory)
   {
      super(factory, null);
   }

   public HTMLResource(ResourceFactory factory, File file)
   {
      super(factory, file);
      setFlag(ResourceFlag.ProjectSourceFile);
   }

   @Override
   public Resource<File> createFrom(File file)
   {
      return new HTMLResource(getResourceFactory(), file);
   }

   @Override
   protected List<Resource<?>> doListResources()
   {
      try
      {
         List<Resource<?>> list = new LinkedList<Resource<?>>();

         for (HTMLNode node : getHTMLDocument().getChildren())
         {
            if (node instanceof HTMLElement)
            {
               list.add(new HTMLElementResource(this, (HTMLElement) node));
            }
            else
            {
               list.add(new HTMLNodeResource(this, node));
            }
         }

         return list;
      }
      catch (ParserException e)
      {
         return Collections.emptyList();
      }
      catch (FileNotFoundException e)
      {
         return Collections.emptyList();
      }

   }

   public HTMLDocument getHTMLDocument() throws FileNotFoundException
   {
      return HTMLParser.parse(file);
   }

}
