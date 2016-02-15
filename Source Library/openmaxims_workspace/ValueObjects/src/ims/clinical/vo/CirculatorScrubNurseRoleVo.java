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

package ims.clinical.vo;

/**
 * Linked to clinical.CirculatorScrubNurseRole business object (ID: 1072100133).
 */
public class CirculatorScrubNurseRoleVo extends ims.clinical.vo.CirculatorScrubNurseRoleRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public CirculatorScrubNurseRoleVo()
	{
	}
	public CirculatorScrubNurseRoleVo(Integer id, int version)
	{
		super(id, version);
	}
	public CirculatorScrubNurseRoleVo(ims.clinical.vo.beans.CirculatorScrubNurseRoleVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.nurse = bean.getNurse() == null ? null : bean.getNurse().buildVo();
		this.circulatorscrubnurserole = bean.getCirculatorScrubNurseRole() == null ? null : ims.clinical.vo.lookups.CirculatorScrubNurseRole.buildLookup(bean.getCirculatorScrubNurseRole());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.CirculatorScrubNurseRoleVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.nurse = bean.getNurse() == null ? null : bean.getNurse().buildVo(map);
		this.circulatorscrubnurserole = bean.getCirculatorScrubNurseRole() == null ? null : ims.clinical.vo.lookups.CirculatorScrubNurseRole.buildLookup(bean.getCirculatorScrubNurseRole());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.CirculatorScrubNurseRoleVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.CirculatorScrubNurseRoleVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.CirculatorScrubNurseRoleVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public Object getFieldValueByFieldName(String fieldName)
	{
		if(fieldName == null)
			throw new ims.framework.exceptions.CodingRuntimeException("Invalid field name");
		fieldName = fieldName.toUpperCase();
		if(fieldName.equals("NURSE"))
			return getNurse();
		if(fieldName.equals("CIRCULATORSCRUBNURSEROLE"))
			return getCirculatorScrubNurseRole();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getNurseIsNotNull()
	{
		return this.nurse != null;
	}
	public ims.core.vo.NurseLiteVo getNurse()
	{
		return this.nurse;
	}
	public void setNurse(ims.core.vo.NurseLiteVo value)
	{
		this.isValidated = false;
		this.nurse = value;
	}
	public boolean getCirculatorScrubNurseRoleIsNotNull()
	{
		return this.circulatorscrubnurserole != null;
	}
	public ims.clinical.vo.lookups.CirculatorScrubNurseRole getCirculatorScrubNurseRole()
	{
		return this.circulatorscrubnurserole;
	}
	public void setCirculatorScrubNurseRole(ims.clinical.vo.lookups.CirculatorScrubNurseRole value)
	{
		this.isValidated = false;
		this.circulatorscrubnurserole = value;
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
		if(this.nurse == null)
			listOfErrors.add("Nurse is mandatory");
		if(this.circulatorscrubnurserole == null)
			listOfErrors.add("Circulator/Scrub Nurse Role is mandatory");
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
	public void clearIDAndVersion()
	{
		this.id = null;
		this.version = 0;
	}
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		CirculatorScrubNurseRoleVo clone = new CirculatorScrubNurseRoleVo(this.id, this.version);
		
		if(this.nurse == null)
			clone.nurse = null;
		else
			clone.nurse = (ims.core.vo.NurseLiteVo)this.nurse.clone();
		if(this.circulatorscrubnurserole == null)
			clone.circulatorscrubnurserole = null;
		else
			clone.circulatorscrubnurserole = (ims.clinical.vo.lookups.CirculatorScrubNurseRole)this.circulatorscrubnurserole.clone();
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
		if (!(CirculatorScrubNurseRoleVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A CirculatorScrubNurseRoleVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((CirculatorScrubNurseRoleVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((CirculatorScrubNurseRoleVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.nurse != null)
			count++;
		if(this.circulatorscrubnurserole != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected ims.core.vo.NurseLiteVo nurse;
	protected ims.clinical.vo.lookups.CirculatorScrubNurseRole circulatorscrubnurserole;
	private boolean isValidated = false;
	private boolean isBusy = false;
}