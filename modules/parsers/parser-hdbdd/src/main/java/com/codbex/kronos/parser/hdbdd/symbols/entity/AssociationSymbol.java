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
package com.codbex.kronos.parser.hdbdd.symbols.entity;

import java.util.ArrayList;
import java.util.List;

import com.codbex.kronos.parser.hdbdd.symbols.context.Scope;
import com.codbex.kronos.parser.hdbdd.symbols.type.field.FieldSymbol;

public class AssociationSymbol extends FieldSymbol {

  private CardinalityEnum cardinality;
  private EntitySymbol target;
  private List<EntityElementSymbol> foreignKeys = new ArrayList<>();
  private boolean isManaged;
  private boolean isKey;
  private boolean isNotNull;

  public AssociationSymbol(String name) {
    super(name);
  }

  public AssociationSymbol(String name, Scope scope) {
    super(name, scope);
  }

  public CardinalityEnum getCardinality() {
    return cardinality;
  }

  public void setCardinality(CardinalityEnum cardinality) {
    this.cardinality = cardinality;
  }

  public List<EntityElementSymbol> getForeignKeys() {
    return foreignKeys;
  }

  public void setForeignKeys(List<EntityElementSymbol> foreignKeys) {
    this.foreignKeys = foreignKeys;
  }

  public EntitySymbol getTarget() {
    return target;
  }

  public void setTarget(EntitySymbol target) {
    this.target = target;
  }

  public void addForeignKey(EntityElementSymbol elementSymbol) {
    this.foreignKeys.add(elementSymbol);
  }

  public boolean isManaged() {
    return isManaged;
  }

  public void setManaged(boolean managed) {
    isManaged = managed;
  }

  public boolean isNotNull() {
    return isNotNull;
  }

  public void setNotNull(boolean notNull) {
    isNotNull = notNull;
  }

  public boolean isKey() {
    return isKey;
  }

  public void setKey(boolean key) {
    isKey = key;
  }
}