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

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.codbex.kronos.parser.hdbdd.symbols.Symbol;
import com.codbex.kronos.parser.hdbdd.symbols.context.Scope;

public class EntitySymbol extends Symbol implements Scope {
    private Map<String, Symbol> elements;

  public EntitySymbol(Symbol symbol) {
    super(symbol);
    elements = new LinkedHashMap<>();
  }

  public EntitySymbol(String name, Scope scope) {
        super(name, scope);
        elements = new LinkedHashMap<>();
    }

    @Override
    public Scope getEnclosingScope() {
        return this.getScope();
    }

    @Override
    public void define(Symbol sym) {
        elements.put(sym.getName(), sym);
    }

    @Override
    public Symbol resolve(String name) {
        return elements.get(name);
    }

    @Override
    public boolean isDuplicateName(String id) {
        return elements.containsKey(id);
    }

    public List<EntityElementSymbol> getKeys() {
        return elements.values().stream()
                .filter(e -> e instanceof EntityElementSymbol)
                .map(e -> (EntityElementSymbol) e)
                .filter(EntityElementSymbol::isKey)
                .collect(Collectors.toList());
    }

  public List<EntityElementSymbol> getElements() {
    return elements.values().stream()
        .filter(e -> e instanceof EntityElementSymbol)
        .map(e -> (EntityElementSymbol) e)
        .collect(Collectors.toList());
  }

  public List<AssociationSymbol> getAssociations() {
    return elements.values().stream()
        .filter(e -> e instanceof AssociationSymbol)
        .map(e -> (AssociationSymbol) e)
        .collect(Collectors.toList());
  }
}
