/******************************************************************************
 * Product: iDempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2012 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
package org.compiere.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import org.compiere.util.KeyNamePair;

/** Generated Interface for C_RfQResponseLine
 *  @author iDempiere (generated) 
 *  @version Release 11
 */
public interface I_C_RfQResponseLine 
{

    /** TableName=C_RfQResponseLine */
    public static final String Table_Name = "C_RfQResponseLine";

    /** AD_Table_ID=673 */
    public static final int Table_ID = 673;

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 1 - Org 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(1);

    /** Load Meta Data */

    /** Column name AD_Client_ID */
    public static final String COLUMNNAME_AD_Client_ID = "AD_Client_ID";

	/** Get Tenant.
	  * Tenant for this installation.
	  */
	public int getAD_Client_ID();

    /** Column name AD_Org_ID */
    public static final String COLUMNNAME_AD_Org_ID = "AD_Org_ID";

	/** Set Organization.
	  * Organizational entity within tenant
	  */
	public void setAD_Org_ID (int AD_Org_ID);

	/** Get Organization.
	  * Organizational entity within tenant
	  */
	public int getAD_Org_ID();

    /** Column name Created */
    public static final String COLUMNNAME_Created = "Created";

	/** Get Created.
	  * Date this record was created
	  */
	public Timestamp getCreated();

    /** Column name CreatedBy */
    public static final String COLUMNNAME_CreatedBy = "CreatedBy";

	/** Get Created By.
	  * User who created this records
	  */
	public int getCreatedBy();

    /** Column name C_RfQLine_ID */
    public static final String COLUMNNAME_C_RfQLine_ID = "C_RfQLine_ID";

	/** Set RfQ Line.
	  * Request for Quotation Line
	  */
	public void setC_RfQLine_ID (int C_RfQLine_ID);

	/** Get RfQ Line.
	  * Request for Quotation Line
	  */
	public int getC_RfQLine_ID();

	public org.compiere.model.I_C_RfQLine getC_RfQLine() throws RuntimeException;

    /** Column name C_RfQResponse_ID */
    public static final String COLUMNNAME_C_RfQResponse_ID = "C_RfQResponse_ID";

	/** Set RfQ Response.
	  * Request for Quotation Response from a potential Vendor
	  */
	public void setC_RfQResponse_ID (int C_RfQResponse_ID);

	/** Get RfQ Response.
	  * Request for Quotation Response from a potential Vendor
	  */
	public int getC_RfQResponse_ID();

	public org.compiere.model.I_C_RfQResponse getC_RfQResponse() throws RuntimeException;

    /** Column name C_RfQResponseLine_ID */
    public static final String COLUMNNAME_C_RfQResponseLine_ID = "C_RfQResponseLine_ID";

	/** Set RfQ Response Line.
	  * Request for Quotation Response Line
	  */
	public void setC_RfQResponseLine_ID (int C_RfQResponseLine_ID);

	/** Get RfQ Response Line.
	  * Request for Quotation Response Line
	  */
	public int getC_RfQResponseLine_ID();

    /** Column name C_RfQResponseLine_UU */
    public static final String COLUMNNAME_C_RfQResponseLine_UU = "C_RfQResponseLine_UU";

	/** Set C_RfQResponseLine_UU	  */
	public void setC_RfQResponseLine_UU (String C_RfQResponseLine_UU);

	/** Get C_RfQResponseLine_UU	  */
	public String getC_RfQResponseLine_UU();

    /** Column name DateWorkComplete */
    public static final String COLUMNNAME_DateWorkComplete = "DateWorkComplete";

	/** Set Work Complete.
	  * Date when work is (planned to be) complete
	  */
	public void setDateWorkComplete (Timestamp DateWorkComplete);

	/** Get Work Complete.
	  * Date when work is (planned to be) complete
	  */
	public Timestamp getDateWorkComplete();

    /** Column name DateWorkStart */
    public static final String COLUMNNAME_DateWorkStart = "DateWorkStart";

	/** Set Work Start.
	  * Date when work is (planned to be) started
	  */
	public void setDateWorkStart (Timestamp DateWorkStart);

	/** Get Work Start.
	  * Date when work is (planned to be) started
	  */
	public Timestamp getDateWorkStart();

    /** Column name DeliveryDays */
    public static final String COLUMNNAME_DeliveryDays = "DeliveryDays";

	/** Set Delivery Days.
	  * Number of Days (planned) until Delivery
	  */
	public void setDeliveryDays (int DeliveryDays);

	/** Get Delivery Days.
	  * Number of Days (planned) until Delivery
	  */
	public int getDeliveryDays();

    /** Column name Description */
    public static final String COLUMNNAME_Description = "Description";

	/** Set Description.
	  * Optional short description of the record
	  */
	public void setDescription (String Description);

	/** Get Description.
	  * Optional short description of the record
	  */
	public String getDescription();

    /** Column name Help */
    public static final String COLUMNNAME_Help = "Help";

	/** Set Comment/Help.
	  * Comment or Hint
	  */
	public void setHelp (String Help);

	/** Get Comment/Help.
	  * Comment or Hint
	  */
	public String getHelp();

    /** Column name IsActive */
    public static final String COLUMNNAME_IsActive = "IsActive";

	/** Set Active.
	  * The record is active in the system
	  */
	public void setIsActive (boolean IsActive);

	/** Get Active.
	  * The record is active in the system
	  */
	public boolean isActive();

    /** Column name IsSelectedWinner */
    public static final String COLUMNNAME_IsSelectedWinner = "IsSelectedWinner";

	/** Set Selected Winner.
	  * The response is the selected winner
	  */
	public void setIsSelectedWinner (boolean IsSelectedWinner);

	/** Get Selected Winner.
	  * The response is the selected winner
	  */
	public boolean isSelectedWinner();

    /** Column name IsSelfService */
    public static final String COLUMNNAME_IsSelfService = "IsSelfService";

	/** Set Self-Service.
	  * This is a Self-Service entry or this entry can be changed via Self-Service
	  */
	public void setIsSelfService (boolean IsSelfService);

	/** Get Self-Service.
	  * This is a Self-Service entry or this entry can be changed via Self-Service
	  */
	public boolean isSelfService();

    /** Column name Updated */
    public static final String COLUMNNAME_Updated = "Updated";

	/** Get Updated.
	  * Date this record was updated
	  */
	public Timestamp getUpdated();

    /** Column name UpdatedBy */
    public static final String COLUMNNAME_UpdatedBy = "UpdatedBy";

	/** Get Updated By.
	  * User who updated this records
	  */
	public int getUpdatedBy();
	
	/** Column name BasePrice */
    public static final String COLUMNNAME_BasePrice = "BasePrice";

	/** Set Base Price	  */
	public void setBasePrice (BigDecimal BasePrice);
	 
							   

	/** Get Base Price	  */
	public BigDecimal getBasePrice();

    /** Column name C_Charge_ID */
    public static final String COLUMNNAME_C_Charge_ID = "C_Charge_ID";

	/** Set Charge.
	  * Additional document charges
	  */
	public void setC_Charge_ID (int C_Charge_ID);

	/** Get Charge.
	  * Additional document charges
	  */
	public int getC_Charge_ID();

	public org.compiere.model.I_C_Charge getC_Charge() throws RuntimeException;
	
	/** Column name C_UOM_ID */
    public static final String COLUMNNAME_C_UOM_ID = "C_UOM_ID";

	/** Set UOM.
	  * Unit of Measure
	  */
	public void setC_UOM_ID (int C_UOM_ID);

	/** Get UOM.
	  * Unit of Measure
	  */
	public int getC_UOM_ID();

	public org.compiere.model.I_C_UOM getC_UOM() throws RuntimeException;
	
	/** Column name FaktorKondisi */
    public static final String COLUMNNAME_FaktorKondisi = "FaktorKondisi";

	/** Set Faktor Kondisi	  */
	public void setFaktorKondisi (BigDecimal FaktorKondisi);

	/** Get Faktor Kondisi	  */
	public BigDecimal getFaktorKondisi();
	
	/** Column name IsDescription */
    public static final String COLUMNNAME_IsDescription = "IsDescription";

	/** Set Description Only.
	  * if true, the line is just description and no transaction
	  */
	public void setIsDescription (boolean IsDescription);

	/** Get Description Only.
	  * if true, the line is just description and no transaction
	  */
	public boolean isDescription();
	
	/** Column name LineNo */
    public static final String COLUMNNAME_LineNo = "LineNo";

	/** Set Line.
	  * Line No
	  */
	public void setLineNo (int LineNo);

	/** Get Line.
	  * Line No
	  */
	public int getLineNo();
	
	/** Column name M_Product_ID */
    public static final String COLUMNNAME_M_Product_ID = "M_Product_ID";

	/** Set Product.
	  * Product, Service, Item
	  */
	public void setM_Product_ID (int M_Product_ID);

	/** Get Product.
	  * Product, Service, Item
	  */
	public int getM_Product_ID();

	public org.compiere.model.I_M_Product getM_Product() throws RuntimeException;

    /** Column name Price */
    public static final String COLUMNNAME_Price = "Price";

	/** Set Price.
	  * Price
	  */
	public void setPrice (BigDecimal Price);

	/** Get Price.
	  * Price
	  */
	public BigDecimal getPrice();

    /** Column name PriceActual */
    public static final String COLUMNNAME_PriceActual = "PriceActual";

	/** Set Unit Price.
	  * Actual Price 
	  */
	public void setPriceActual (BigDecimal PriceActual);

	/** Get Unit Price.
	  * Actual Price 
	  */
	public BigDecimal getPriceActual();

    /** Column name PriceKondisi */
    public static final String COLUMNNAME_PriceKondisi = "PriceKondisi";

	/** Set Price (Faktor Kondisi)	  */
	public void setPriceKondisi (BigDecimal PriceKondisi);

	/** Get Price (Faktor Kondisi)	  */
	public BigDecimal getPriceKondisi();

    /** Column name PriceStd */
    public static final String COLUMNNAME_PriceStd = "PriceStd";

	/** Set Standard Price.
	  * Standard Price
	  */
	public void setPriceStd (BigDecimal PriceStd);

	/** Get Standard Price.
	  * Standard Price
	  */
	public BigDecimal getPriceStd();

    /** Column name Processed */
    public static final String COLUMNNAME_Processed = "Processed";

	/** Set Processed.
	  * The document has been processed
	  */
	public void setProcessed (boolean Processed);

	/** Get Processed.
	  * The document has been processed
	  */
	public boolean isProcessed();
	
	/** Column name Qty */
    public static final String COLUMNNAME_Qty = "Qty";

	/** Set Quantity.
	  * Quantity
	  */
	public void setQty (BigDecimal Qty);

	/** Get Quantity.
	  * Quantity
	  */
	public BigDecimal getQty();
}
