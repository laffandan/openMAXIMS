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

package ims.core.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class PersonHealthActCategory extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public PersonHealthActCategory()
	{
		super();
	}
	public PersonHealthActCategory(int id)
	{
		super(id, "", true);
	}
	public PersonHealthActCategory(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public PersonHealthActCategory(int id, String text, boolean active, PersonHealthActCategory parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public PersonHealthActCategory(int id, String text, boolean active, PersonHealthActCategory parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public PersonHealthActCategory(int id, String text, boolean active, PersonHealthActCategory parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static PersonHealthActCategory buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new PersonHealthActCategory(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (PersonHealthActCategory)super.getParentInstance();
	}
	public PersonHealthActCategory getParent()
	{
		return (PersonHealthActCategory)super.getParentInstance();
	}
	public void setParent(PersonHealthActCategory parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		PersonHealthActCategory[] typedChildren = new PersonHealthActCategory[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (PersonHealthActCategory)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof PersonHealthActCategory)
		{
			super.addChild((PersonHealthActCategory)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof PersonHealthActCategory)
		{
			super.removeChild((PersonHealthActCategory)child);
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
		PersonHealthActCategoryCollection result = new PersonHealthActCategoryCollection();
		result.add(MEDICAL_CARD);
		result.add(NO_MEDICAL_CARD);
		result.add(UNKNOWN);
		result.add(EUVISITOR);
		return result;
	}
	public static PersonHealthActCategory[] getNegativeInstances()
	{
		PersonHealthActCategory[] instances = new PersonHealthActCategory[4];
		instances[0] = MEDICAL_CARD;
		instances[1] = NO_MEDICAL_CARD;
		instances[2] = UNKNOWN;
		instances[3] = EUVISITOR;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[4];
		negativeInstances[0] = "MEDICAL_CARD";
		negativeInstances[1] = "NO_MEDICAL_CARD";
		negativeInstances[2] = "UNKNOWN";
		negativeInstances[3] = "EUVISITOR";
		return negativeInstances;
	}
	public static PersonHealthActCategory getNegativeInstance(String name)
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
	public static PersonHealthActCategory getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		PersonHealthActCategory[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 791;
	public static final PersonHealthActCategory MEDICAL_CARD = new PersonHealthActCategory(-31, "Category 1", true, null, null, Color.Black);
	public static final PersonHealthActCategory NO_MEDICAL_CARD = new PersonHealthActCategory(-154, "Category 2", true, null, null, Color.Black);
	public static final PersonHealthActCategory UNKNOWN = new PersonHealthActCategory(-50, "Category 0", true, null, null, Color.Black);
	public static final PersonHealthActCategory EUVISITOR = new PersonHealthActCategory(-2537, "EU Visitor", true, null, null, Color.Default);
}
