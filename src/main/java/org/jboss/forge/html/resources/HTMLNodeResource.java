/*
 * Copyright 2013 Jeremie Lagarde.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.jboss.forge.html.resources;

import java.util.Collections;
import java.util.List;

import org.jboss.forge.parser.html.HTMLNode;
import org.jboss.forge.resources.Resource;
import org.jboss.forge.resources.VirtualResource;


/**
 * @author Jeremie Lagarde
 * 
 */
public class HTMLNodeResource<T extends HTMLNode> extends VirtualResource<T>
{

   private final T node;

   protected HTMLNodeResource(Resource<?> parent, T node)
   {
      super(parent);
      this.node = node;
   }

   @Override
   public boolean delete() throws UnsupportedOperationException
   {
      // TODO Auto-generated method stub
      return false;
   }

   @Override
   public boolean delete(boolean recursive) throws UnsupportedOperationException
   {
      // TODO Auto-generated method stub
      return false;
   }

   @Override
   public String getName()
   {
      return node.getName();
   }

   @Override
   public T getUnderlyingResourceObject()
   {
      return node;
   }

   @Override
   protected List<Resource<?>> doListResources()
   {
      return Collections.emptyList();
   }

   @Override
   public String toString()
   {
      return node.toString();
   }
}
