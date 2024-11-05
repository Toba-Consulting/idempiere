/***********************************************************************
 * This file is part of iDempiere ERP Open Source                      *
 * http://www.idempiere.org                                            *
 *                                                                     *
 * Copyright (C) Contributors                                          *
 *                                                                     *
 * This program is free software; you can redistribute it and/or       *
 * modify it under the terms of the GNU General Public License         *
 * as published by the Free Software Foundation; either version 2      *
 * of the License, or (at your option) any later version.              *
 *                                                                     *
 * This program is distributed in the hope that it will be useful,     *
 * but WITHOUT ANY WARRANTY; without even the implied warranty of      *
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the        *
 * GNU General Public License for more details.                        *
 *                                                                     *
 * You should have received a copy of the GNU General Public License   *
 * along with this program; if not, write to the Free Software         *
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,          *
 * MA 02110-1301, USA.                                                 *
 *                                                                     *
 * Contributors:                                                       *
 * - hengsin                         								   *
 **********************************************************************/
package org.adempiere.base.callout;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;

import org.adempiere.base.IColumnCallout;
import org.adempiere.base.annotation.Callout;
import org.compiere.model.CalloutEngine;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.MDocType;
import org.compiere.model.MInventoryLine;
import org.compiere.model.MUOM;
import org.compiere.model.MUOMConversion;
import org.compiere.util.Env;

/**
 * 
 * @author hengsin
 *
 */
@Callout(tableName = MInventoryLine.Table_Name, 
	columnName = {MInventoryLine.COLUMNNAME_QtyEntered, MInventoryLine.COLUMNNAME_C_UOM_ID, MInventoryLine.COLUMNNAME_QtyMiscReceipt})
public class TCS_CalloutInventory extends CalloutEngine implements IColumnCallout {

	private final Map<String, IColumnCallout> calloutMap = new HashMap<String, IColumnCallout>();
	
	{
		calloutMap.put(MInventoryLine.COLUMNNAME_QtyEntered, 
				(ctx, windowNo, mTab, mField, value, oldValue) -> qty(ctx, windowNo, mTab, mField, value));
		calloutMap.put(MInventoryLine.COLUMNNAME_QtyMiscReceipt, 
				(ctx, windowNo, mTab, mField, value, oldValue) -> qtyMiscReceipt(ctx, windowNo, mTab, mField, value));
		calloutMap.put(MInventoryLine.COLUMNNAME_C_UOM_ID, 
				(ctx, windowNo, mTab, mField, value, oldValue) -> qty(ctx, windowNo, mTab, mField));
		calloutMap.put(MInventoryLine.COLUMNNAME_C_UOM_ID, 
				(ctx, windowNo, mTab, mField, value, oldValue) -> qtyMiscReceipt(ctx, windowNo, mTab, mField));
	}
	
	@Override
	public String start(Properties ctx, int windowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		IColumnCallout callout = calloutMap.get(mField.getColumnName());
		return callout != null ? callout.start(ctx, windowNo, mTab, mField, value, oldValue) : "";
	}
	
	/**
	 * This is the code from CalloutInventory in Taowi 1.0 / iDempiere Core V3.
	 * This is new method with the name qty. It should be specific for Internal Use Inventory.
	 * The objective is to support MultiUOM in Inventory Line.
	 * This callout begins with get the essential needs, such as Product and Document Type.
	 * DocumentType will be very needed for determine if it is Internal Use Inventory or not.
	 * If product is not filled, then QtyInternalUse will be filled by QtyEntered
	 * If UOM changed in DocumentType Internal Use, then UOM will be the C_UOM_To_ID.
	 * Then, QtyEntered will be revalidate for the Scale and Precision based on C_UOM_To_ID.
	 * Then, the UOM Conversion method applied for the Product, C_UOM_To_ID, and for QtyEntered and saved to the variable MovementQty.
	 * Then, if the MovementQty and QtyEntered are same then there is no conversion, but still QtyInternalUse will be filled with this MovementQty.
	 * If QtyEntered changed, it will do the same logic like if UOM changed.
	 * @trigger: QtyEntered, C_UOM_ID
	 * @set: QtyEntered, QtyInternalUse
	 * @note: QtyEntered && C_UOM_ID(migration script -> this is custom column)
	 * @param ctx
	 * @param WindowNo
	 * @param mTab
	 * @param mField
	 * @param value
	 * @return
	 */
	public String qty(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value) {
		
		if (isCalloutActive() || value == null)
			return "";

		int M_Product_ID = Env.getContextAsInt(ctx, WindowNo, mTab.getTabNo(), "M_Product_ID");
		
		//	@win add support multiUOM
		int C_DocType_ID = Env.getContextAsInt(ctx, WindowNo, "C_DocType_ID");
		boolean isInternalUse = false;
		MDocType docType = MDocType.get(ctx, C_DocType_ID);
		
		if (docType.getDocSubTypeInv().equals(MDocType.DOCSUBTYPEINV_InternalUseInventory)) {
			isInternalUse = true;
		}
		
		BigDecimal MovementQty = Env.ZERO;
		BigDecimal QtyEntered = Env.ZERO;

		//	No Product
		if (M_Product_ID == 0)
		{
			QtyEntered = (BigDecimal)mTab.getValue("QtyEntered");
			mTab.setValue(MInventoryLine.COLUMNNAME_QtyInternalUse, QtyEntered);
		}
		
		//	UOM Changed - convert from Entered -> Product
		else if (mField.getColumnName().equals("C_UOM_ID") && isInternalUse)
		{
			int C_UOM_To_ID = ((Integer)value).intValue();
			QtyEntered = (BigDecimal)mTab.getValue("QtyEntered");
			BigDecimal QtyEntered1 = QtyEntered.setScale(MUOM.getPrecision(ctx, C_UOM_To_ID), RoundingMode.HALF_UP);
			if (QtyEntered.compareTo(QtyEntered1) != 0)
			{
				if (log.isLoggable(Level.FINE)) log.fine("Corrected QtyEntered Scale UOM=" + C_UOM_To_ID
					+ "; QtyEntered=" + QtyEntered + "->" + QtyEntered1);
				QtyEntered = QtyEntered1;
				mTab.setValue("QtyEntered", QtyEntered);
			}
			
			MovementQty = MUOMConversion.convertProductFrom (ctx, M_Product_ID,
				C_UOM_To_ID, QtyEntered);
			if (MovementQty == null)
				MovementQty = QtyEntered;
			
			boolean conversion = QtyEntered.compareTo(MovementQty) != 0;
			if (log.isLoggable(Level.FINE)) log.fine("UOM=" + C_UOM_To_ID
				+ ", QtyEntered=" + QtyEntered
				+ " -> " + conversion
				+ " QtyInternalUse=" + MovementQty);
			Env.setContext(ctx, WindowNo, "UOMConversion", conversion ? "Y" : "N");
			mTab.setValue(MInventoryLine.COLUMNNAME_QtyInternalUse, MovementQty);
		}
		
		//	No UOM defined
		else if (Env.getContextAsInt(ctx, WindowNo, mTab.getTabNo(), "C_UOM_ID") == 0)
		{
			QtyEntered = (BigDecimal)mTab.getValue("QtyEntered");
			mTab.setValue(MInventoryLine.COLUMNNAME_QtyInternalUse, QtyEntered);
		}
		
		//	QtyEntered changed - calculate MovementQty
		else if (mField.getColumnName().equals("QtyEntered"))
		{
			int C_UOM_To_ID = Env.getContextAsInt(ctx, WindowNo, mTab.getTabNo(), "C_UOM_ID");
			QtyEntered = (BigDecimal)value;
			BigDecimal QtyEntered1 = QtyEntered.setScale(MUOM.getPrecision(ctx, C_UOM_To_ID), RoundingMode.HALF_UP);
			if (QtyEntered.compareTo(QtyEntered1) != 0)
			{
				if (log.isLoggable(Level.FINE)) log.fine("Corrected QtyEntered Scale UOM=" + C_UOM_To_ID
					+ "; QtyEntered=" + QtyEntered + "->" + QtyEntered1);
				QtyEntered = QtyEntered1;
				mTab.setValue("QtyEntered", QtyEntered);
			}
			MovementQty = MUOMConversion.convertProductFrom (ctx, M_Product_ID,
				C_UOM_To_ID, QtyEntered);
			if (MovementQty == null)
				MovementQty = QtyEntered;
			boolean conversion = QtyEntered.compareTo(MovementQty) != 0;
			if (log.isLoggable(Level.FINE)) log.fine("UOM=" + C_UOM_To_ID
				+ ", QtyEntered=" + QtyEntered
				+ " -> " + conversion
				+ " QtyInternalUse=" + MovementQty);
			Env.setContext(ctx, WindowNo, "UOMConversion", conversion ? "Y" : "N");
			mTab.setValue(MInventoryLine.COLUMNNAME_QtyInternalUse, MovementQty);
		}
		
		return "";
	} //  qty

	/**
	 * This is the code from CalloutInventory in Taowi 1.0 / iDempiere Core V3.
	 * This is new method with the name qtyMiscReceipt. It should be specific for Misc Receipt.
	 * The objective is to support MultiUOM in Inventory Line and it is similar like method qty (above), but QtyEntered here is QtyMiscReceipt.
	 * This callout begins with get the essential needs, such as Product and Document Type.
	 * DocumentType will be very needed for determine if it is Misc Receipt or not.
	 * If product is not filled, then QtyInternalUse will be filled by QtyMiscReceipt that negated.
	 * If UOM changed in DocumentType Misc Receipt, then UOM will be the C_UOM_To_ID.
	 * Then, QtyMiscReceipt will be revalidate for the Scale and Precision based on C_UOM_To_ID.
	 * Then, the UOM Conversion method applied for the Product, C_UOM_To_ID, and for QtyMiscReceipt and saved to the variable MovementQty.
	 * Then, if the MovementQty and QtyMiscReceipt are same then there is no conversion, but still QtyInternalUse will be filled with this MovementQty that negated.
	 * If QtyMiscReceipt changed, it will do the same logic like if UOM changed.
	 * @trigger: QtyMiscReceipt, C_UOM_ID
	 * @set: QtyMiscReceipt, QtyInternalUse
	 * @note: QtyMiscReceipt && C_UOM_ID(migration script -> this is custom column)
	 * @param ctx
	 * @param WindowNo
	 * @param mTab
	 * @param mField
	 * @param value
	 * @return
	 */
	public String qtyMiscReceipt(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value) {
		
		if (isCalloutActive() || value == null)
			return "";

		int M_Product_ID = Env.getContextAsInt(ctx, WindowNo, mTab.getTabNo(), "M_Product_ID");
		
		//	@win add support multiUOM
		BigDecimal MovementQty = Env.ZERO;
		BigDecimal QtyMiscReceipt = Env.ZERO;
		
		int C_DocType_ID = Env.getContextAsInt(ctx, WindowNo, "C_DocType_ID");
		boolean isMiscReceipt = false;
		MDocType docType = MDocType.get(ctx, C_DocType_ID);

		if (docType.getDocSubTypeInv().equals(MDocType.DOCSUBTYPEINV_MiscReceipt)) {
			isMiscReceipt = true;
		}
		
		//	No Product
		if (M_Product_ID == 0)
		{
			QtyMiscReceipt = (BigDecimal)mTab.getValue("QtyMiscReceipt");
			mTab.setValue(MInventoryLine.COLUMNNAME_QtyInternalUse, QtyMiscReceipt.negate());
		}
		
		//	UOM Changed - convert from Entered -> Product
		else if (mField.getColumnName().equals("C_UOM_ID") && isMiscReceipt)
		{
			int C_UOM_To_ID = ((Integer)value).intValue();
			QtyMiscReceipt = (BigDecimal)mTab.getValue("QtyMiscReceipt");
			BigDecimal QtyMiscReceipt1 = QtyMiscReceipt.setScale(MUOM.getPrecision(ctx, C_UOM_To_ID), RoundingMode.HALF_UP);
			if (QtyMiscReceipt.compareTo(QtyMiscReceipt1) != 0)
			{
				if (log.isLoggable(Level.FINE)) log.fine("Corrected QtyEntered Scale UOM=" + C_UOM_To_ID
					+ "; QtyEntered=" + QtyMiscReceipt + "->" + QtyMiscReceipt1);
				QtyMiscReceipt = QtyMiscReceipt1;
				mTab.setValue("QtyMiscReceipt", QtyMiscReceipt);
			}
			
			MovementQty = MUOMConversion.convertProductFrom (ctx, M_Product_ID,
				C_UOM_To_ID, QtyMiscReceipt);
			if (MovementQty == null)
				MovementQty = QtyMiscReceipt;
			
			boolean conversion = QtyMiscReceipt.compareTo(MovementQty) != 0;
			if (log.isLoggable(Level.FINE)) log.fine("UOM=" + C_UOM_To_ID
				+ ", QtyEntered=" + QtyMiscReceipt
				+ " -> " + conversion
				+ " QtyInternalUse=" + MovementQty);
			Env.setContext(ctx, WindowNo, "UOMConversion", conversion ? "Y" : "N");
			mTab.setValue(MInventoryLine.COLUMNNAME_QtyInternalUse, MovementQty.negate());
		}
		
		//	No UOM defined
		else if (Env.getContextAsInt(ctx, WindowNo, mTab.getTabNo(), "C_UOM_ID") == 0)
		{
			QtyMiscReceipt = (BigDecimal)mTab.getValue("QtyMiscReceipt");
			mTab.setValue(MInventoryLine.COLUMNNAME_QtyInternalUse, QtyMiscReceipt.negate());
		}
		
		//	QtyEntered changed - calculate MovementQty
		else if (mField.getColumnName().equals("QtyMiscReceipt"))
		{
			int C_UOM_To_ID = Env.getContextAsInt(ctx, WindowNo, mTab.getTabNo(), "C_UOM_ID");
			QtyMiscReceipt = (BigDecimal)value;
			BigDecimal QtyMiscReceipt1 = QtyMiscReceipt.setScale(MUOM.getPrecision(ctx, C_UOM_To_ID), RoundingMode.HALF_UP);
			if (QtyMiscReceipt.compareTo(QtyMiscReceipt1) != 0)
			{
				if (log.isLoggable(Level.FINE)) log.fine("Corrected QtyEntered Scale UOM=" + C_UOM_To_ID
					+ "; QtyEntered=" + QtyMiscReceipt + "->" + QtyMiscReceipt1);
				QtyMiscReceipt = QtyMiscReceipt1;
				mTab.setValue("QtyMiscReceipt", QtyMiscReceipt);
			}
			MovementQty = MUOMConversion.convertProductFrom (ctx, M_Product_ID,
				C_UOM_To_ID, QtyMiscReceipt);
			if (MovementQty == null)
				MovementQty = QtyMiscReceipt;
			boolean conversion = QtyMiscReceipt.compareTo(MovementQty) != 0;
			if (log.isLoggable(Level.FINE)) log.fine("UOM=" + C_UOM_To_ID
				+ ", QtyEntered=" + QtyMiscReceipt
				+ " -> " + conversion
				+ " QtyInternalUse=" + MovementQty);
			Env.setContext(ctx, WindowNo, "UOMConversion", conversion ? "Y" : "N");
			mTab.setValue(MInventoryLine.COLUMNNAME_QtyInternalUse, MovementQty.negate());
		}

		return "";
	}
}
