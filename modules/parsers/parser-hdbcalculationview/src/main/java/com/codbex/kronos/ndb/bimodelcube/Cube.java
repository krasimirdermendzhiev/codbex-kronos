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
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.11.26 at 10:54:28 AM EET 
//


package com.codbex.kronos.ndb.bimodelcube;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.codbex.kronos.ndb.bimodeldatafoundation.DeploymentType;
import com.codbex.kronos.ndb.bimodeldatafoundation.InformationModel;


/**
 * A cube (aka analytic view) is a multidimensional View construct to support OLAP type queries to the data base
 * Constraints:
 * 1. unit attribute exists only for measures of type amount and quantity
 * 2. logical joins are only allowed between compatible data types
 * 3. AggegationType count is not supported for restricted measures
 * 4. A currencyUnitAttribute a fixed currency/unit and a currency conversion must not be assigned to
 * a restricted measure (there it is always inherited from the base measure)
 * for more constraints see also df:DataFoundation
 *
 *
 * <p>Java class for Cube complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Cube"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.sap.com/ndb/BiModelDataFoundation.ecore}InformationModel"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="privateMeasureGroup" type="{http://www.sap.com/ndb/BiModelCube.ecore}MeasureGroup"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="deploymentType" type="{http://www.sap.com/ndb/BiModelDataFoundation.ecore}DeploymentType" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Cube", propOrder = {
    "privateMeasureGroup"
})
public class Cube
    extends InformationModel {

  @XmlElement(required = true)
  protected MeasureGroup privateMeasureGroup;
  @XmlAttribute(name = "deploymentType")
  protected DeploymentType deploymentType;

  /**
   * Gets the value of the privateMeasureGroup property.
   *
   * @return possible object is
   * {@link MeasureGroup }
   */
  public MeasureGroup getPrivateMeasureGroup() {
    return privateMeasureGroup;
  }

  /**
   * Sets the value of the privateMeasureGroup property.
   *
   * @param value allowed object is
   *              {@link MeasureGroup }
   */
  public void setPrivateMeasureGroup(MeasureGroup value) {
    this.privateMeasureGroup = value;
  }

  /**
   * Gets the value of the deploymentType property.
   *
   * @return possible object is
   * {@link DeploymentType }
   */
  public DeploymentType getDeploymentType() {
    return deploymentType;
  }

  /**
   * Sets the value of the deploymentType property.
   *
   * @param value allowed object is
   *              {@link DeploymentType }
   */
  public void setDeploymentType(DeploymentType value) {
    this.deploymentType = value;
  }

}
