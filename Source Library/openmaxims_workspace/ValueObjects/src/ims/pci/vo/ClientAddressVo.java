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

package ims.pci.vo;


public class ClientAddressVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ClientAddressVo()
	{
	}
	public ClientAddressVo(ims.pci.vo.beans.ClientAddressVoBean bean)
	{
		this.personaddress = bean.getPersonAddress() == null ? null : bean.getPersonAddress().buildVo();
		this.communitycare = bean.getCommunityCare() == null ? null : bean.getCommunityCare().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.pci.vo.beans.ClientAddressVoBean bean)
	{
		this.personaddress = bean.getPersonAddress() == null ? null : bean.getPersonAddress().buildVo(map);
		this.communitycare = bean.getCommunityCare() == null ? null : bean.getCommunityCare().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.pci.vo.beans.ClientAddressVoBean bean = null;
		if(map != null)
			bean = (ims.pci.vo.beans.ClientAddressVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.pci.vo.beans.ClientAddressVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getPersonAddressIsNotNull()
	{
		return this.personaddress != null;
	}
	public ims.core.vo.PersonAddress getPersonAddress()
	{
		return this.personaddress;
	}
	public void setPersonAddress(ims.core.vo.PersonAddress value)
	{
		this.isValidated = false;
		this.personaddress = value;
	}
	public boolean getCommunityCareIsNotNull()
	{
		return this.communitycare != null;
	}
	public ims.pci.vo.CommunityCareVo getCommunityCare()
	{
		return this.communitycare;
	}
	public void setCommunityCare(ims.pci.vo.CommunityCareVo value)
	{
		this.isValidated = false;
		this.communitycare = value;
	}
	public final String getIItemText()
	{
		return toString();
	}
	public final Integer getBoId() 
	{
		return null;
	}
	public final String getBoClassName()
	{
		return null;
	}
	public boolean equals(Object obj)
	{
		if(obj == null)
			return false;
		if(!(obj instanceof ClientAddressVo))
			return false;
		ClientAddressVo compareObj = (ClientAddressVo)obj;
		if(this.getPersonAddress() == null && compareObj.getPersonAddress() != null)
			return false;
		if(this.getPersonAddress() != null && compareObj.getPersonAddress() == null)
			return false;
		if(this.getPersonAddress() != null && compareObj.getPersonAddress() != null)
			return this.getPersonAddress().equals(compareObj.getPersonAddress());
		return super.equals(obj);
	}
	public boolean isValidated()
	{
		if(this.isBusy)
			return true;
		this.isBusy = true;
	
		if(!this.isValidated)
		{
			this.isBusy = false;
			return false;
		}
		if(this.personaddress != null)
		{
			if(!this.personaddress.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.communitycare != null)
		{
			if(!this.communitycare.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		this.isBusy = false;
		return true;
	}
	public String[] validate()
	{
		return validate(null);
	}
	public String[] validate(String[] existingErrors)
	{
		if(this.isBusy)
			return null;
		this.isBusy = true;
	
		java.util.ArrayList<String> listOfErrors = new java.util.ArrayList<String>();
		if(existingErrors != null)
		{
			for(int x = 0; x < existingErrors.length; x++)
			{
				listOfErrors.add(existingErrors[x]);
			}
		}
		if(this.personaddress != null)
		{
			String[] listOfOtherErrors = this.personaddress.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.communitycare != null)
		{
			String[] listOfOtherErrors = this.communitycare.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		int errorCount = listOfErrors.size();
		if(errorCount == 0)
		{
			this.isBusy = false;
			this.isValidated = true;
			return null;
		}
		String[] result = new String[errorCount];
		for(int x = 0; x < errorCount; x++)
			result[x] = (String)listOfErrors.get(x);
		this.isBusy = false;
		this.isValidated = false;
		return result;
	}
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		ClientAddressVo clone = new ClientAddressVo();
		
		if(this.personaddress == null)
			clone.personaddress = null;
		else
			clone.personaddress = (ims.core.vo.PersonAddress)this.personaddress.clone();
		if(this.communitycare == null)
			clone.communitycare = null;
		else
			clone.communitycare = (ims.pci.vo.CommunityCareVo)this.communitycare.clone();
		clone.isValidated = this.isValidated;
		
		this.isBusy = false;
		return clone;
	}
	public int compareTo(Object obj)
	{
		return compareTo(obj, true);
	}
	public int compareTo(Object obj, boolean caseInsensitive)
	{
		if (obj == null)
		{
			return -1;
		}
		if(caseInsensitive); // this is to avoid eclipse warning only.
		if (!(ClientAddressVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ClientAddressVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		ClientAddressVo compareObj = (ClientAddressVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getPersonAddress() == null && compareObj.getPersonAddress() != null)
				return -1;
			if(this.getPersonAddress() != null && compareObj.getPersonAddress() == null)
				return 1;
			if(this.getPersonAddress() != null && compareObj.getPersonAddress() != null)
				retVal = this.getPersonAddress().compareTo(compareObj.getPersonAddress());
		}
		return retVal;
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.personaddress != null)
			count++;
		if(this.communitycare != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected ims.core.vo.PersonAddress personaddress;
	protected ims.pci.vo.CommunityCareVo communitycare;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
