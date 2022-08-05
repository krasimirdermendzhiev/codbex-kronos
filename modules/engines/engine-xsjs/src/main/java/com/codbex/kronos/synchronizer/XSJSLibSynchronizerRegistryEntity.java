/*
 * Copyright (c) 2022 codbex or an codbex affiliate company and contributors
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * SPDX-FileCopyrightText: 2022 codbex or an codbex affiliate company and contributors
 * SPDX-License-Identifier: EPL-2.0
 */
package com.codbex.kronos.synchronizer;

import org.eclipse.dirigible.repository.api.ICollection;
import org.eclipse.dirigible.repository.api.IEntity;
import org.eclipse.dirigible.repository.api.IRepository;
import org.eclipse.dirigible.repository.api.IResource;

public class XSJSLibSynchronizerRegistryEntity {
  private static final String XSJSLIB_FILE_EXTENSION = ".xsjslib";

  private final IRepository repository;
  private boolean isCollection = false;
  private IEntity entity = null;

  public XSJSLibSynchronizerRegistryEntity(String registryPath, IRepository repository) {
    this(registryPath, repository,false);
  }

  public XSJSLibSynchronizerRegistryEntity(String registryPath, IRepository repository, boolean resolveWithCollectionFirst) {
    this.repository = repository;

    if(resolveWithCollectionFirst) {
      resolveWithCollectionFirst(registryPath);
    } else {
      resolveWithResourceFirst(registryPath);
    }
  }

  private void resolveWithResourceFirst(String registryPath) {
    IResource resource = repository.getResource(registryPath);

    if(resource.exists()) {
      if(registryPath.endsWith(XSJSLIB_FILE_EXTENSION)) {
        entity = resource;
        isCollection = false;
      }
    }
    else {
      ICollection collection = repository.getCollection(registryPath);

      if(collection.exists()) {
        entity = collection;
        isCollection = true;
      }
    }
  }

  private void resolveWithCollectionFirst(String registryPath) {
    ICollection collection = repository.getCollection(registryPath);

    if(collection.exists()) {
      entity = collection;
      isCollection = true;
    }
    else {
      IResource resource = repository.getResource(registryPath);

      if(resource.exists()) {
        if(registryPath.endsWith(XSJSLIB_FILE_EXTENSION)) {
          entity = resource;
          isCollection =false;
        }
      }
    }
  }

  public boolean isCollection() {
    return isCollection;
  }

  public boolean isSynchronizable() {
    return entity != null;
  }

  public IEntity getEntity() {
    return entity;
  }
}
