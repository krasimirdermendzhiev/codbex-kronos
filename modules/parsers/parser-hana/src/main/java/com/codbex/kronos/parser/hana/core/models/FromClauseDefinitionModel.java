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
package com.codbex.kronos.parser.hana.core.models;

import java.util.ArrayList;
import java.util.List;

public class FromClauseDefinitionModel {

  private List<JoinClauseDefinitionModel> joinClauses;

  private List<TableReferenceModel> tableReferences = new ArrayList<>();

  public FromClauseDefinitionModel() {
    this.joinClauses = new ArrayList<>();
  }

  public List<JoinClauseDefinitionModel> getJoinClauses() {
    return joinClauses;
  }

  public void addJoinClause(JoinClauseDefinitionModel joinClause) {
    this.joinClauses.add(joinClause);
  }

  public List<TableReferenceModel> getTableReferences() {
    return tableReferences;
  }

  public void addTableReference(TableReferenceModel tableReference) {
    this.tableReferences.add(tableReference);
  }
}
