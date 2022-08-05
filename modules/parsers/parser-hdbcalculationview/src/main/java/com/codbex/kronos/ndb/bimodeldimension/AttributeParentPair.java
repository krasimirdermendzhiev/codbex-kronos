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

import com.codbex.kronos.ndb.bimodelconversion.Parameterization;


/**
 * <p>Java class for AttributeParentPair complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="AttributeParentPair"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="rootNode" type="{http://www.sap.com/ndb/BiModelConversion.ecore}Parameterization" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="attribute" use="required" type="{http://www.sap.com/ndb/RepositoryModelResource.ecore}AlphanumericName" /&gt;
 *       &lt;attribute name="parentAttribute" use="required" type="{http://www.sap.com/ndb/RepositoryModelResource.ecore}AlphanumericName" /&gt;
 *       &lt;attribute name="stepParentNodeID" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AttributeParentPair", propOrder = {
    "rootNode"
})
public class AttributeParentPair {

  protected Parameterization rootNode;
  @XmlAttribute(name = "attribute", required = true)
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  protected String attribute;
  @XmlAttribute(name = "parentAttribute", required = true)
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  protected String parentAttribute;
  @XmlAttribute(name = "stepParentNodeID")
  protected String stepParentNodeID;

  /**
   * Gets the value of the rootNode property.
   *
   * @return possible object is
   * {@link Parameterization }
   */
  public Parameterization getRootNode() {
    return rootNode;
  }

  /**
   * Sets the value of the rootNode property.
   *
   * @param value allowed object is
   *              {@link Parameterization }
   */
  public void setRootNode(Parameterization value) {
    this.rootNode = value;
  }

  /**
   * Gets the value of the attribute property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getAttribute() {
    return attribute;
  }

  /**
   * Sets the value of the attribute property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setAttribute(String value) {
    this.attribute = value;
  }

  /**
   * Gets the value of the parentAttribute property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getParentAttribute() {
    return parentAttribute;
  }

  /**
   * Sets the value of the parentAttribute property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setParentAttribute(String value) {
    this.parentAttribute = value;
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
