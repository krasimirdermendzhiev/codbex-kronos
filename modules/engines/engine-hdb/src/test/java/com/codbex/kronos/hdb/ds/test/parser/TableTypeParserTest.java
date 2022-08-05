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
package com.codbex.kronos.hdb.ds.test.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.codbex.kronos.exceptions.ArtifactParserException;
import com.codbex.kronos.hdb.ds.api.DataStructuresException;
import com.codbex.kronos.hdb.ds.model.DBContentType;
import com.codbex.kronos.hdb.ds.model.DataStructureModelFactory;
import com.codbex.kronos.hdb.ds.model.DataStructureParametersModel;
import com.codbex.kronos.hdb.ds.model.hdbtable.DataStructureHDBTableColumnModel;
import com.codbex.kronos.hdb.ds.model.hdbtabletype.DataStructureHDBTableTypeModel;
import com.codbex.kronos.hdb.ds.parser.hdbtabletype.HDBTableTypeParser;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import org.apache.commons.io.IOUtils;
import org.eclipse.dirigible.core.test.AbstractDirigibleTest;
import org.junit.Test;

public class TableTypeParserTest extends AbstractDirigibleTest {

  @Test
  public void parse_WhenStructureDefinitionIsCorrect_ModelShouldBeSet() throws Exception {
    InputStream in = TableTypeParserTest.class.getResourceAsStream("/ParsingHDBStructure.hdbstructure");
    String contents = IOUtils.toString(in, StandardCharsets.UTF_8);
    DataStructureHDBTableTypeModel model = DataStructureModelFactory.parseTableType("/ParsingHDBStructure.hdbstructure", contents);

    assertEquals(4, model.getColumns().size());
    assertEquals("ParsingHDBStructure", model.getName());
    assertEquals("DBADMIN", model.getSchema());
    assertEquals("/ParsingHDBStructure.hdbstructure", model.getLocation());
    assertEquals("HDBTABLETYPE", model.getType());
    assertEquals(false, model.isPublicProp());
    assertNotNull(model.getCreatedBy());
    assertNotNull(model.getCreatedAt());
    assertEquals(DBContentType.XS_CLASSIC, model.getDBContentType());
    assertEquals(contents, model.getRawContent());

    DataStructureHDBTableColumnModel scenarioId = model.getColumns().get(0);
    assertEquals("SCENARIO_ID", scenarioId.getName());
    assertEquals("VARCHAR", scenarioId.getType());
    assertEquals("32", scenarioId.getLength());
    assertFalse(scenarioId.isNullable());
    assertTrue(scenarioId.isPrimaryKey());
  }

  @Test(expected = IllegalStateException.class)
  public void parse_WhenPKIsWrong_shouldThrowException()
      throws DataStructuresException, ArtifactParserException, IOException {
    HDBTableTypeParser parser = new HDBTableTypeParser();

    String content = "table.schemaName = \"DBADMIN\";\n" +
        "table.columns = [\n" +
        "\t{ name = \"SCENARIO_ID\";\tsqlType = VARCHAR;},\n" +
        "\t{ name = \"PERIOD_ID\";\t\tsqlType = DECIMAL;}\n" +
        "];\n" +
        "table.primaryKey.pkcolumns = [\"SCENARIO_ID_WRONG\", \"PERIOD_ID\"];";
    DataStructureParametersModel parametersModel =
        new DataStructureParametersModel(null, "/temp.hdbstructure", content, null);
    parser.parse(parametersModel);
  }

  @Test
  public void parse_WhenHanaXSAdvancedContent_ModelShouldBeSet() throws Exception {
    String content = "TYPE \"CUSTOMERS_STRUCTURE\" AS TABLE ( \"CATEGORY_ID\" INTEGER , \"NAME\" VARCHAR (255) , \"TYPES\" VARCHAR (220) NOT NULL PRIMARY KEY)";
    DataStructureHDBTableTypeModel model = DataStructureModelFactory.parseTableType("/test.hdbstructure", content);
    assertEquals(DBContentType.OTHERS, model.getDBContentType());
    assertEquals(content, model.getRawContent());
  }

}
