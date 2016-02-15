//#############################################################################
//#                                                                           #
//#  Copyright (C) <2015>  <IMS MAXIMS>                                       #
//#                                                                           #
//#  This program is free software: you can redistribute it and/or modify     #
//#  it under the terms of the GNU Affero General Public License as           #
//#  published by the Free Software Foundation, either version 3 of the       #
//#  License, or (at your option) any later version.                          # 
//#                                                                           #
//#  This program is distributed in the hope that it will be useful,          #
//#  but WITHOUT ANY WARRANTY; without even the implied warranty of           #
//#  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the            #
//#  GNU Affero General Public License for more details.                      #
//#                                                                           #
//#  You should have received a copy of the GNU Affero General Public License #
//#  along with this program.  If not, see <http://www.gnu.org/licenses/>.    #
//#                                                                           #
//#  IMS MAXIMS provides absolutely NO GUARANTEE OF THE CLINICAL SAFTEY of    #
//#  this program.  Users of this software do so entirely at their own risk.  #
//#  IMS MAXIMS only ensures the Clinical Safety of unaltered run-time        #
//#  software that it builds, deploys and maintains.                          #
//#                                                                           #
//#############################################################################
//#EOH
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5589.25814)
// Copyright (C) 1995-2015 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.scheduling.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class Rule28DayStatus extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public Rule28DayStatus()
	{
		super();
	}
	public Rule28DayStatus(int id)
	{
		super(id, "", true);
	}
	public Rule28DayStatus(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public Rule28DayStatus(int id, String text, boolean active, Rule28DayStatus parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public Rule28DayStatus(int id, String text, boolean active, Rule28DayStatus parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public Rule28DayStatus(int id, String text, boolean active, Rule28DayStatus parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static Rule28DayStatus buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new Rule28DayStatus(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (Rule28DayStatus)super.getParentInstance();
	}
	public Rule28DayStatus getParent()
	{
		return (Rule28DayStatus)super.getParentInstance();
	}
	public void setParent(Rule28DayStatus parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		Rule28DayStatus[] typedChildren = new Rule28DayStatus[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (Rule28DayStatus)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof Rule28DayStatus)
		{
			super.addChild((Rule28DayStatus)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof Rule28DayStatus)
		{
			super.removeChild((Rule28DayStatus)child);
		}
		return super.getChildInstances().size();
	}
	public Image getExpandedImage()
	{
		return super.getImage();
	}
	public Image getCollapsedImage()
	{
		return super.getImage();
	}
	public static ims.framework.IItemCollection getNegativeInstancesAsIItemCollection()
	{
		Rule28DayStatusCollection result = new Rule28DayStatusCollection();
		result.add(ACTIVE);
		result.add(REASONABLE_OFFER_DECLINED);
		result.add(BREACHED);
		result.add(OFFER_ACCEPTED);
		result.add(CANCELLED_BY_PATIENT);
		result.add(CANCELLED_FOR_CLINICAL_REASON);
		result.add(DEFERRED_FOR_CLINICAL_REASON);
		return result;
	}
	public static Rule28DayStatus[] getNegativeInstances()
	{
		Rule28DayStatus[] instances = new Rule28DayStatus[7];
		instances[0] = ACTIVE;
		instances[1] = REASONABLE_OFFER_DECLINED;
		instances[2] = BREACHED;
		instances[3] = OFFER_ACCEPTED;
		instances[4] = CANCELLED_BY_PATIENT;
		instances[5] = CANCELLED_FOR_CLINICAL_REASON;
		instances[6] = DEFERRED_FOR_CLINICAL_REASON;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[7];
		negativeInstances[0] = "ACTIVE";
		negativeInstances[1] = "REASONABLE_OFFER_DECLINED";
		negativeInstances[2] = "BREACHED";
		negativeInstances[3] = "OFFER_ACCEPTED";
		negativeInstances[4] = "CANCELLED_BY_PATIENT";
		negativeInstances[5] = "CANCELLED_FOR_CLINICAL_REASON";
		negativeInstances[6] = "DEFERRED_FOR_CLINICAL_REASON";
		return negativeInstances;
	}
	public static Rule28DayStatus getNegativeInstance(String name)
	{
		if(name == null)
			return null;
		String[] negativeInstances = getNegativeInstanceNames();
		for (int i = 0; i < negativeInstances.length; i++)
		{
			if(negativeInstances[i].equals(name))
				return getNegativeInstances()[i];
		}
		return null;
	}
	public static Rule28DayStatus getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		Rule28DayStatus[] negativeInstances = getNegativeInstances();
		for (int i = 0; i < negativeInstances.length; i++)
		{
			if(negativeInstances[i].getID() == id)
				return negativeInstances[i];
		}
		return null;
	}
	public int getTypeId()
	{
		return TYPE_ID;
	}
	public static final int TYPE_ID = 1141041;
	public static final Rule28DayStatus ACTIVE = new Rule28DayStatus(-3338, "Active", true, null, null, Color.Default);
	public static final Rule28DayStatus REASONABLE_OFFER_DECLINED = new Rule28DayStatus(-3339, "Reasonable Offer Declined", true, null, null, Color.Default);
	public static final Rule28DayStatus BREACHED = new Rule28DayStatus(-3340, "Breached", true, null, null, Color.Default);
	public static final Rule28DayStatus OFFER_ACCEPTED = new Rule28DayStatus(-3341, "Offer Accepted", true, null, null, Color.Default);
	public static final Rule28DayStatus CANCELLED_BY_PATIENT = new Rule28DayStatus(-3342, "Cancelled by Patient", true, null, null, Color.Default);
	public static final Rule28DayStatus CANCELLED_FOR_CLINICAL_REASON = new Rule28DayStatus(-3343, "Cancelled for Clinical Reason", true, null, null, Color.Default);
	public static final Rule28DayStatus DEFERRED_FOR_CLINICAL_REASON = new Rule28DayStatus(-3353, "Deferred for Clinical Reason", true, null, null, Color.Default);
}