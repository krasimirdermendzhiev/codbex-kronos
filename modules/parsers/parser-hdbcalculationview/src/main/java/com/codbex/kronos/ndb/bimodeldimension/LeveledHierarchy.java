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


package com.codbex.kronos.ndb.bimodeldimension;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.codbex.kronos.ndb.basemodelbase.NodeStyle;


/**
 * <p>Java class for LeveledHierarchy complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="LeveledHierarchy"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.sap.com/ndb/BiModelDimension.ecore}Hierarchy"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="levels" type="{http://www.sap.com/ndb/BiModelDimension.ecore}Levels"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="nodeStyle" type="{http://www.sap.com/ndb/BaseModelBase.ecore}NodeStyle" /&gt;
 *       &lt;attribute name="stepParentNodeID" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LeveledHierarchy", propOrder = {
    "levels"
})
public class LeveledHierarchy
    extends Hierarchy {

  @XmlElement(required = true)
  protected Levels levels;
  @XmlAttribute(name = "nodeStyle")
  protected NodeStyle nodeStyle;
  @XmlAttribute(name = "stepParentNodeID")
  protected String stepParentNodeID;

  /**
   * Gets the value of the levels property.
   *
   * @return possible object is
   * {@link Levels }
   */
  public Levels getLevels() {
    return levels;
  }

  /**
   * Sets the value of the levels property.
   *
   * @param value allowed object is
   *              {@link Levels }
   */
  public void setLevels(Levels value) {
    this.levels = value;
  }

  /**
   * Gets the value of the nodeStyle property.
   *
   * @return possible object is
   * {@link NodeStyle }
   */
  public NodeStyle getNodeStyle() {
    return nodeStyle;
  }

  /**
   * Sets the value of the nodeStyle property.
   *
   * @param value allowed object is
   *              {@link NodeStyle }
   */
  public void setNodeStyle(NodeStyle value) {
    this.nodeStyle = value;
  }

  /**
   * Gets the value of the stepParentNodeID property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getStepParentNodeID() {
    return stepParentNodeID;
  }

  /**
   * Sets the value of the stepParentNodeID property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setStepParentNodeID(String value) {
    this.stepParentNodeID = value;
  }

}
