//#############################################################################
//#                                                                           #
//#  Copyright (C) <2014>  <IMS MAXIMS>                                       #
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
//#############################################################################
//#EOH
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.generalmedical.vo;

/**
 * Linked to core.clinical.EpworthSleepAssessment business object (ID: 1003100055).
 */
public class EpworthSleepAssessmentVo extends ims.core.clinical.vo.EpworthSleepAssessmentRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public EpworthSleepAssessmentVo()
	{
	}
	public EpworthSleepAssessmentVo(Integer id, int version)
	{
		super(id, version);
	}
	public EpworthSleepAssessmentVo(ims.generalmedical.vo.beans.EpworthSleepAssessmentVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.chanceofsleep = bean.getChanceOfSleep() == null ? null : ims.spinalinjuries.vo.lookups.SleepEpworthChanceOfSleep.buildLookup(bean.getChanceOfSleep());
		this.sleepscore = bean.getSleepScore() == null ? null : ims.spinalinjuries.vo.lookups.SleepEpworthScore.buildLookup(bean.getSleepScore());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.generalmedical.vo.beans.EpworthSleepAssessmentVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.chanceofsleep = bean.getChanceOfSleep() == null ? null : ims.spinalinjuries.vo.lookups.SleepEpworthChanceOfSleep.buildLookup(bean.getChanceOfSleep());
		this.sleepscore = bean.getSleepScore() == null ? null : ims.spinalinjuries.vo.lookups.SleepEpworthScore.buildLookup(bean.getSleepScore());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.generalmedical.vo.beans.EpworthSleepAssessmentVoBean bean = null;
		if(map != null)
			bean = (ims.generalmedical.vo.beans.EpworthSleepAssessmentVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.generalmedical.vo.beans.EpworthSleepAssessmentVoBean();
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
		if(fieldName.equals("CHANCEOFSLEEP"))
			return getChanceOfSleep();
		if(fieldName.equals("SLEEPSCORE"))
			return getSleepScore();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getChanceOfSleepIsNotNull()
	{
		return this.chanceofsleep != null;
	}
	public ims.spinalinjuries.vo.lookups.SleepEpworthChanceOfSleep getChanceOfSleep()
	{
		return this.chanceofsleep;
	}
	public void setChanceOfSleep(ims.spinalinjuries.vo.lookups.SleepEpworthChanceOfSleep value)
	{
		this.isValidated = false;
		this.chanceofsleep = value;
	}
	public boolean getSleepScoreIsNotNull()
	{
		return this.sleepscore != null;
	}
	public ims.spinalinjuries.vo.lookups.SleepEpworthScore getSleepScore()
	{
		return this.sleepscore;
	}
	public void setSleepScore(ims.spinalinjuries.vo.lookups.SleepEpworthScore value)
	{
		this.isValidated = false;
		this.sleepscore = value;
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
	
		EpworthSleepAssessmentVo clone = new EpworthSleepAssessmentVo(this.id, this.version);
		
		if(this.chanceofsleep == null)
			clone.chanceofsleep = null;
		else
			clone.chanceofsleep = (ims.spinalinjuries.vo.lookups.SleepEpworthChanceOfSleep)this.chanceofsleep.clone();
		if(this.sleepscore == null)
			clone.sleepscore = null;
		else
			clone.sleepscore = (ims.spinalinjuries.vo.lookups.SleepEpworthScore)this.sleepscore.clone();
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
		if (!(EpworthSleepAssessmentVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A EpworthSleepAssessmentVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		EpworthSleepAssessmentVo compareObj = (EpworthSleepAssessmentVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_EpworthSleepAssessment() == null && compareObj.getID_EpworthSleepAssessment() != null)
				return -1;
			if(this.getID_EpworthSleepAssessment() != null && compareObj.getID_EpworthSleepAssessment() == null)
				return 1;
			if(this.getID_EpworthSleepAssessment() != null && compareObj.getID_EpworthSleepAssessment() != null)
				retVal = this.getID_EpworthSleepAssessment().compareTo(compareObj.getID_EpworthSleepAssessment());
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
		if(this.chanceofsleep != null)
			count++;
		if(this.sleepscore != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected ims.spinalinjuries.vo.lookups.SleepEpworthChanceOfSleep chanceofsleep;
	protected ims.spinalinjuries.vo.lookups.SleepEpworthScore sleepscore;
	private boolean isValidated = false;
	private boolean isBusy = false;
}