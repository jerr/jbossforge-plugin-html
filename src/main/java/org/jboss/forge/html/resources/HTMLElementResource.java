/*
 * Copyright 2013 Jeremie Lagarde.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.jboss.forge.html.resources;

import java.util.Collections;
import java.util.List;

import org.jboss.forge.parser.html.HTMLElement;
import org.jboss.forge.resources.Resource;

/**
 * @author Jeremie Lagarde
 * 
 */
public class HTMLElementResource extends HTMLNodeResource<HTMLElement>
{

   protected HTMLElementResource(Resource<?> parent, HTMLElement node)
   {
      super(parent, node);
   }

   @Override
   protected List<Resource<?>> doListResources()
   {
      return Collections.emptyList();
   }

}
