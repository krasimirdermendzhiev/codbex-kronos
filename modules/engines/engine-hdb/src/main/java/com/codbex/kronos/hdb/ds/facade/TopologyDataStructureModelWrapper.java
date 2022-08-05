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
package com.codbex.kronos.hdb.ds.facade;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.eclipse.dirigible.commons.api.topology.ITopologicallyDepletable;
import org.eclipse.dirigible.commons.api.topology.ITopologicallySortable;
import org.eclipse.dirigible.core.scheduler.api.AbstractSynchronizationArtefactType;
import org.eclipse.dirigible.core.scheduler.api.ISynchronizerArtefactType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codbex.kronos.hdb.ds.model.DataStructureDependencyModel;
import com.codbex.kronos.hdb.ds.model.DataStructureModel;
import com.codbex.kronos.hdb.ds.service.manager.IDataStructureManager;
import com.codbex.kronos.hdb.ds.synchronizer.DataStructuresSynchronizer;

public class TopologyDataStructureModelWrapper<T extends DataStructureModel> implements ITopologicallySortable, ITopologicallyDepletable {

    private static final Logger logger = LoggerFactory.getLogger(TopologyDataStructureModelWrapper.class);
    private static final DataStructuresSynchronizer DATA_STRUCTURES_SYNCHRONIZER = new DataStructuresSynchronizer();
    private final AbstractSynchronizationArtefactType artefactType;

    private final IDataStructureManager<T> modelManager;
    private final T model;
    private final Connection connection;
    private final Map<String, TopologyDataStructureModelWrapper> wrappers;

    public TopologyDataStructureModelWrapper(Connection connection, IDataStructureManager<T> modelManager, T model, AbstractSynchronizationArtefactType artefactType,
        Map<String, TopologyDataStructureModelWrapper> wrappers) {
        this.connection = connection;
        this.modelManager = modelManager;
        this.model = model;
        this.artefactType = artefactType;
        this.wrappers = wrappers;
        this.wrappers.put(getId(), this);
    }

    public DataStructureModel getModel() {
        return model;
    }

    public AbstractSynchronizationArtefactType getArtefactType() {
        return artefactType;
    }

    @Override
    public String getId() {
        return this.model.getName();
    }

    @Override
    public List<ITopologicallySortable> getDependencies() {
        List<ITopologicallySortable> dependencies = new ArrayList<ITopologicallySortable>();
        for (DataStructureDependencyModel dependency : this.model.getDependencies()) {
            String dependencyName = dependency.getName();
            if (!wrappers.containsKey(dependencyName)) {
                logger.warn("Dependency is not present in this cycle: " + dependencyName);
            } else {
                dependencies.add(wrappers.get(dependencyName));
            }
        }
        return dependencies;
    }

    @Override
    public boolean complete(String flow) {
        try {
            return modelManager.createDataStructure(connection, model);
        } catch (SQLException e) {
            logger.warn("Failed on trying to complete the artefact: " + e.getMessage(), e);
            return false;
        }
    }

    public void applyArtefactState(String artefactName, String artefactLocation, AbstractSynchronizationArtefactType type, ISynchronizerArtefactType.ArtefactState state, String message) {
        DATA_STRUCTURES_SYNCHRONIZER.applyArtefactState(artefactName, artefactLocation, type, state, message);
    }

}
