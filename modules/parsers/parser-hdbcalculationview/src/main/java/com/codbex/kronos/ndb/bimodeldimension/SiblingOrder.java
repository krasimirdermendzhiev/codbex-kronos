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
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.codbex.kronos.ndb.basemodelbase.SortDirection;


/**
 * Defines the order of one attribute
 *
 *
 * <p>Java class for SiblingOrder complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="SiblingOrder"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="byAttribute" use="required" type="{http://www.sap.com/ndb/RepositoryModelResource.ecore}Identifier" /&gt;
 *       &lt;attribute name="direction" type="{http://www.sap.com/ndb/BaseModelBase.ecore}SortDirection" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SiblingOrder")
public class SiblingOrder {

  @XmlAttribute(name = "byAttribute", required = true)
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  protected String byAttribute;
  @XmlAttribute(name = "direction")
  protected SortDirection direction;

  /**
   * Gets the value of the byAttribute property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getByAttribute() {
    return byAttribute;
  }

  /**
   * Sets the value of the byAttribute property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setByAttribute(String value) {
    this.byAttribute = value;
  }

  /**
   * Gets the value of the direction property.
   *
   * @return possible object is
   * {@link SortDirection }
   */
  public SortDirection getDirection() {
    return direction;
  }

  /**
   * Sets the value of the direction property.
   *
   * @param value allowed object is
   *              {@link SortDirection }
   */
  public void setDirection(SortDirection value) {
    this.direction = value;
  }

}
