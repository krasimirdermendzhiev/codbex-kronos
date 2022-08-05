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
package com.codbex.kronos.hdb.ds.service.manager;

import com.codbex.kronos.hdb.ds.api.DataStructuresException;
import com.codbex.kronos.hdb.ds.model.DataStructureModel;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import javax.naming.OperationNotSupportedException;


public interface IDataStructureManager<T extends DataStructureModel> {

  Map<String, T> getDataStructureModels();

  void synchronizeRuntimeMetadata(T tableModel) throws DataStructuresException;

  boolean createDataStructure(Connection connection, T tableModel) throws SQLException;

  boolean dropDataStructure(Connection connection, T tableModel) throws SQLException;

  boolean updateDataStructure(Connection connection, T tableModel)
      throws SQLException, OperationNotSupportedException;

  List<String> getDataStructureSynchronized();

  String getDataStructureType();

  void cleanup() throws DataStructuresException;

  void clearCache();

  void synchronizeParsedByRootMetadata(T tableModel) throws DataStructuresException;

  boolean existsArtifactMetadata(T tableModel) throws DataStructuresException;
}
